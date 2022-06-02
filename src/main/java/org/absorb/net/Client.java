package org.absorb.net;

import net.kyori.adventure.text.Component;
import org.absorb.AbsorbManagers;
import org.absorb.entity.WorldEntity;
import org.absorb.entity.living.human.ChatMode;
import org.absorb.entity.living.human.Gamemode;
import org.absorb.entity.living.human.Gamemodes;
import org.absorb.entity.living.human.Human;
import org.absorb.entity.living.human.tab.PlayerTab;
import org.absorb.entity.living.human.tab.PlayerTabBuilder;
import org.absorb.inventory.entity.player.PlayerInventory;
import org.absorb.net.packet.PacketState;
import org.absorb.net.packet.play.disconnect.OutgoingCloseConnectionPacketBuilder;
import org.absorb.threaded.SimpleDataPoint;
import org.absorb.threaded.ThreadedDataPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
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

public class Client {

    private @NotNull PacketState state = PacketState.HANDSHAKE;
    private @Nullable String username;
    private @Nullable UUID uuid;
    private @NotNull LocalDateTime lastPacketSent;
    private final @NotNull Socket socket;
    private @Nullable WorldEntity entity;
    private final @NotNull PlayerInventory inventory = new PlayerInventory();
    private @Nullable Locale locale;
    private byte viewDistance;
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

    public @NotNull Vector3d getLocation() {
        return this.lastPosition==null ? new Vector3d(0, 0, 0):this.lastPosition;
    }

    public void setLocation(@NotNull Vector3d location) {
        this.lastPosition = location;
        this.getEntity().setPosition(location);
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

    public @NotNull PlayerInventory getInventory() {
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
        new OutgoingCloseConnectionPacketBuilder().setUsingPlay(this.state==PacketState.PLAY).setMessage(component).build().writeToAsync(this);
    }


}
