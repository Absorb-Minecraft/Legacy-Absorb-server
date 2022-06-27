package org.absorb.net;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.absorb.AbsorbManagers;
import org.absorb.command.CommandSender;
import org.absorb.entity.WorldEntity;
import org.absorb.entity.living.human.ChatMode;
import org.absorb.entity.living.human.Gamemode;
import org.absorb.entity.living.human.Gamemodes;
import org.absorb.entity.living.human.Human;
import org.absorb.entity.living.human.tab.PlayerTab;
import org.absorb.entity.living.human.tab.PlayerTabBuilder;
import org.absorb.inventory.Inventory;
import org.absorb.inventory.entity.client.ClientInventory;
import org.absorb.message.MessagePosition;
import org.absorb.net.packet.PacketState;
import org.absorb.net.packet.play.chunk.OutgoingChunkUpdatePacketBuilder;
import org.absorb.net.packet.play.client.disconnect.OutgoingCloseConnectionPacketBuilder;
import org.absorb.net.packet.play.message.chat.OutgoingChatMessagePacketBuilder;
import org.absorb.threaded.SimpleDataPoint;
import org.absorb.threaded.ThreadedDataPoint;
import org.absorb.world.AbsorbWorld;
import org.absorb.world.area.AbsorbChunk;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.math.vector.Vector2i;
import org.spongepowered.math.vector.Vector3d;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.LinkedTransferQueue;
import java.util.stream.Collectors;

public class Client implements CommandSender {

    private @NotNull PacketState state = PacketState.HANDSHAKE;
    private @Nullable String username;
    private @Nullable UUID uuid;
    private @NotNull LocalDateTime lastPacketSent;
    private final @NotNull Socket socket;
    private @Nullable WorldEntity entity;
    private final @NotNull ClientInventory inventory = new ClientInventory();
    private @Nullable Inventory openInventory;
    private @Nullable Locale locale;
    private byte viewDistance = 2;
    private @NotNull ChatMode chatMode = ChatMode.HIDDEN;
    private boolean colouredChatMessages;
    private boolean hiddenToList;
    private int lastKnownPing;
    private final Collection<Integer> teleportIds = new LinkedTransferQueue<>();
    private final Collection<ThreadedDataPoint<Integer, Integer>> pings = new LinkedBlockingQueue<>();
    private PlayingState playingState = PlayingState.AWAITING;
    private @Nullable Vector3d lastPosition;

    private static final int NETTY_MAX_CAP = 1500;

    public Client(@NotNull Socket socket) throws IOException {
        this.lastPacketSent = LocalDateTime.now();
        this.socket = socket;
    }

    public Optional<Inventory> getOpenInventory() {
        return Optional.ofNullable(this.openInventory);
    }

    public void requestInventoryClose() {
        this.requestInventoryClose(true);
    }

    public void requestInventoryClose(boolean send) {
        this.openInventory = null;
    }

    public void updateChunks() {
        updateChunks(this.getViewingChunks());
    }

    public void updateChunks(Iterable<Vector2i> collection) {
        AbsorbWorld world = this.getEntity().getWorld();
//will be threaded when its working
        /*collection.forEach(chunkPos -> new Thread(() -> {
            AbsorbChunk chunk = world.generateChunk(chunkPos);
            chunk.generateParts();
            chunk.getParts().stream().forEach(part -> {
                while (part.isEmpty()) {

                }
                Set<ChunkSection> sections = Collections.singleton(part.asSection());
                new OutgoingChunkUpdatePacketBuilder().setChunkPart(part).setTrustLightOnEdge(false).addChunkSections(sections).build().writeToAsync(this);
            });
        }).run());*/

        collection.forEach(chunkPos -> {
            AbsorbChunk chunk = world.generateChunk(chunkPos);
            chunk.generateParts();

            try {
                new OutgoingChunkUpdatePacketBuilder()
                        .setChunk(chunk)
                        .setTrustLightOnEdge(true)
                        .addParts(chunk.getParts())
                        .build()
                        .writeTo(this);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        /*Vector2i chunkPos = collection.iterator().next();
        AbsorbChunk chunk = world.generateChunk(chunkPos);
        chunk.generateParts();

        new OutgoingChunkUpdatePacketBuilder()
                .setChunk(chunk)
                .setTrustLightOnEdge(false)
                .addParts(chunk.getParts())
                .build()
                .writeToAsync(this);*/


        /*Vector2i chunkPos = collection.iterator().next();
        AbsorbChunk chunk = world.generateChunk(chunkPos);
        chunk.generateParts();
        ChunkPart part = chunk.generatePartWithHeight(this.getEntity().getPosition().floorY());
        while (part.isEmpty()) {

        }
        Set<ChunkSection> sections = Collections.singleton(part.asSection());
        new OutgoingChunkUpdatePacketBuilder().setChunkPart(part).setTrustLightOnEdge(false).addChunkSections
        (sections).build().writeToAsync(this);*/

    }

    public Collection<Vector2i> getViewingChunks() {
        Vector2i currentChunk = this.getEntity().getLocation().getChunkPosition();
        /*Collection<Vector2i> collection = new HashSet<>();
        byte viewDistance = this.getViewDistance();
        int maxX = currentChunk.x() + viewDistance;
        int minX = currentChunk.x() - viewDistance;
        int maxZ = currentChunk.y() + viewDistance;
        int minZ = currentChunk.y() - viewDistance;
        for (int x = minX; x < maxX; x++) {
            for (int z = minZ; z < maxZ; z++) {
                collection.add(new Vector2i(x, z));
            }
        }
        return collection;*/
        return Collections.singleton(currentChunk);
    }

    public int getPingId() {
        return this.pings.parallelStream().mapToInt(ThreadedDataPoint::getValue).sum();
    }

    public void addPingId(int id) {
        this.pings.add(new SimpleDataPoint<>(id));
    }

    public void receivedPingId(int id) {
        Optional<ThreadedDataPoint<Integer, Integer>> opPing = this.pings.parallelStream().filter(ping -> ping.getValue()==id).findFirst();
        if (opPing.isEmpty()) {
            return;
        }
        Set<ThreadedDataPoint<Integer, Integer>> toRemove =
                this.pings.parallelStream().filter(ping -> ping.getTime().isBefore(opPing.get().getTime())).collect(Collectors.toSet());

        LocalDateTime now = LocalDateTime.now();
        this.lastKnownPing = now.getNano() - opPing.get().getTime().getNano();

        this.pings.removeAll(toRemove);
        this.pings.remove(opPing.get());

    }

    public PlayingState getPlayingState() {
        return this.playingState;
    }

    public Client setPlayingState(PlayingState playingState) {
        this.playingState = playingState;
        return this;
    }

    public Collection<Integer> getTeleportIds() {
        return Collections.unmodifiableCollection(this.teleportIds);
    }

    public int newTeleportId() {
        return this.teleportIds.stream().mapToInt((f) -> f).sum();
    }

    public void registerTeleportId(int id) {
        this.teleportIds.add(id);
    }

    public void confirmTeleport(int id) {
        if (!this.teleportIds.remove(id)) {
            throw new IllegalStateException("Teleport id of '" + id + "' could not be confirmed: known ids to be " +
                    "confirmed: " + this.teleportIds);
        }
    }

    public @NotNull WorldEntity getEntity() {
        if (this.entity==null) {
            throw new RuntimeException("Packet has not been sent to create the entity yet");
        }
        return this.entity;
    }

    public void setEntity(@NotNull WorldEntity entity) {
        this.entity = entity;
    }

    public @NotNull PlayerTab createTab() {
        if (this.username==null) {
            throw new RuntimeException("Username has no value, something is out of order");
        }
        Gamemode mode = Gamemodes.CREATIVE;
        Component displayName = null;
        WorldEntity entity = this.getEntity();
        if (entity.getEntity() instanceof Human human) {
            mode = human.getGamemode();
            Optional<Component> opTabName = human.getTabName();
            if (opTabName.isPresent()) {
                displayName = opTabName.get();
            }
        }

        return new PlayerTabBuilder()
                .setUuid(this.uuid)
                .setPing(this.lastKnownPing)
                .setGameMode(mode)
                .setDisplayName(displayName)
                .setName(this.username)
                .build();
    }

    public int getLastKnownPing() {
        return this.lastKnownPing;
    }

    public @NotNull Client setLastKnownPing(int lastKnownPing) {
        this.lastKnownPing = lastKnownPing;
        return this;
    }

    public @NotNull Locale getLocale() {
        if (this.locale==null) {
            throw new RuntimeException("Packet has not been sent yet to know this");
        }
        return this.locale;
    }

    public @NotNull Client setLocale(@NotNull Locale locale) {
        this.locale = locale;
        return this;
    }

    public byte getViewDistance() {
        return this.viewDistance;
    }

    public @NotNull Client setViewDistance(byte viewDistance) {
        this.viewDistance = viewDistance;
        return this;
    }

    public @NotNull ChatMode getChatMode() {
        return this.chatMode;
    }

    public @NotNull Client setChatMode(@NotNull ChatMode chatMode) {
        this.chatMode = chatMode;
        return this;
    }

    public boolean isColouredChatMessages() {
        return this.colouredChatMessages;
    }

    public Client setColouredChatMessages(boolean colouredChatMessages) {
        this.colouredChatMessages = colouredChatMessages;
        return this;
    }

    public boolean isHiddenToList() {
        return this.hiddenToList;
    }

    public Client setHiddenToList(boolean hiddenToList) {
        this.hiddenToList = hiddenToList;
        return this;
    }

    public @NotNull ClientInventory getInventory() {
        return this.inventory;
    }

    public @NotNull UUID getUuid() {
        if (this.uuid==null) {
            throw new RuntimeException("Packet has not been sent yet to know this");
        }
        return this.uuid;
    }


    public Client setUuid(@NotNull UUID uuid) {
        if (this.uuid!=null) {
            throw new RuntimeException("Cannot change the UUID once set");
        }
        this.uuid = uuid;
        return this;
    }

    public @NotNull Socket getSocket() {
        return this.socket;
    }

    public @NotNull LocalDateTime getLastPacketSentTime() {
        return this.lastPacketSent;
    }

    public void setLastPacketSentTime(@NotNull LocalDateTime time) {
        this.lastPacketSent = time;
    }

    public @NotNull SocketAddress getAddress() {
        return this.socket.getRemoteSocketAddress();
    }

    public void write(ByteBuffer buffer) throws IOException {
        try {
            if (buffer.limit() <= NETTY_MAX_CAP) {
                this.socket.getOutputStream().write(buffer.array());
                this.socket.getOutputStream().flush();
                return;
            }
            int index = 0;
            byte[] array = buffer.array();
            while (index < array.length) {
                byte[] reduced;
                if (array.length < (index + NETTY_MAX_CAP)) {
                    reduced = Arrays.copyOfRange(array, index, array.length);
                } else {
                    reduced = Arrays.copyOfRange(array, index, index + NETTY_MAX_CAP);
                }
                this.socket.getOutputStream().write(reduced);
                this.socket.getOutputStream().flush();
                index = index + reduced.length;
            }
        } catch (SocketException ignored) {

        }
    }

    public @NotNull PacketState getState() {
        return this.state;
    }

    public void setState(@NotNull PacketState state) {
        this.state = state;
    }

    public @NotNull String getUsername() {
        if (this.username==null) {
            throw new RuntimeException("Packet has not been sent to know this");
        }
        return this.username;
    }

    public void setUsername(@NotNull String username) {
        this.username = username;
    }

    public void disconnect() {
        AbsorbManagers.getNetManager().unregister(this);
    }

    public void disconnect(@NotNull Component component) {
        try {
            new OutgoingCloseConnectionPacketBuilder().setUsingPlay(this.state==PacketState.PLAY).setMessage(component).build().writeTo(this);
        } catch (IOException e) {
            AbsorbManagers.getConsole().sendMessage(Component.text("Failed to disconnect forcing disconnect: ").color(TextColor.color(255, 0, 0)).append(Component.text(this.getUsername())));
            e.printStackTrace();
        }
        AbsorbManagers.getNetManager().unregister(this);

    }


    @Override
    public void sendMessage(@Nullable UUID uuid, @NotNull Component component) {
        new OutgoingChatMessagePacketBuilder().setMessage(component).setPosition(MessagePosition.CHAT).setFrom(uuid).build().writeToAsync(this);
    }
}
