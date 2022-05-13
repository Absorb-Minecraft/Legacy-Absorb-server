package org.absorb.net;

import net.kyori.adventure.text.Component;
import org.absorb.entity.WorldEntity;
import org.absorb.entity.living.human.ChatMode;
import org.absorb.entity.living.human.Gamemode;
import org.absorb.entity.living.human.Gamemodes;
import org.absorb.entity.living.human.Human;
import org.absorb.entity.living.human.tab.PlayerTab;
import org.absorb.entity.living.human.tab.PlayerTabBuilder;
import org.absorb.inventory.entity.player.PlayerInventory;
import org.absorb.net.packet.PacketState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Locale;
import java.util.Optional;
import java.util.UUID;

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

    private static final int NETTY_MAX_CAP = 2000;

    public Client(@NotNull Socket socket) throws IOException {
        this.lastPacketSent = LocalDateTime.now();
        this.socket = socket;
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
        Component displayName = Component.text(this.username);
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
        StackTraceElement trace = Thread.currentThread().getStackTrace()[2];
        String[] className = trace.getClassName().split("\\.");
        System.out.println("Writing: " + Arrays.toString(buffer.array()));
        System.out.println("\t> " + new String(buffer.array()));
        System.out.println("\t>>" + className[className.length - 1]);
        if (buffer.limit() <= NETTY_MAX_CAP) {
            this.socket.getOutputStream().write(buffer.array());
            this.socket.getOutputStream().flush();
            return;
        }
        int index = 0;
        byte[] array = buffer.array();
        while (index >= array.length) {
            byte[] reduced;
            if (array.length > (index + NETTY_MAX_CAP)) {
                reduced = Arrays.copyOfRange(array, index, array.length);
            } else {
                reduced = Arrays.copyOfRange(array, index, index + NETTY_MAX_CAP);
            }
            this.socket.getOutputStream().write(reduced);
            this.socket.getOutputStream().flush();
            index = index + reduced.length;
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


}
