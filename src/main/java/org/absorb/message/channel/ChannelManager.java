package org.absorb.message.channel;

import org.absorb.message.channel.defaults.DefaultChatChannel;
import org.jetbrains.annotations.NotNull;

public class ChannelManager {

    private @NotNull ChatChannel chatMessage = new DefaultChatChannel();

    public @NotNull ChatChannel getChatChannel() {
        return this.chatMessage;
    }

    public void setChatChannel(@NotNull ChatChannel channel) {
        this.chatMessage = channel;
    }
}
