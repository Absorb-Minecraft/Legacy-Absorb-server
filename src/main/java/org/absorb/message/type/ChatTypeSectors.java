package org.absorb.message.type;

import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public enum ChatTypeSectors implements ChatTypeSector {

    CHAT_TYPE_TEXT("Chat", new String[]{"chat", "type", "text"}, ChatParameter.SENDER, ChatParameter.CONTENT),
    CHAT_TYPE_TEXT_NARRATE("Narration",
                           new String[]{"chat", "type", "text", "narrate"},
                           ChatParameter.SENDER,
                           ChatParameter.CONTENT),
    CHAT_TYPE_ANNOUNCEMENT("Chat",
                           new String[]{"chat", "type", "announcement"},
                           ChatParameter.SENDER,
                           ChatParameter.CONTENT),
    COMMANDS_MESSAGE_DISPLAY_INCOMING("Chat",
                                      new String[]{"commands", "message", "display", "incoming"},
                                      NamedTextColor.GRAY,
                                      TextDecoration.ITALIC,
                                      ChatParameter.SENDER,
                                      ChatParameter.CONTENT);
    

    private final @NotNull String name;
    private final @NotNull String[] translationKey;
    private final @NotNull ChatParameter[] parameters;
    private final @Nullable NamedTextColor textColour;
    private final @Nullable TextDecoration decoration;

    ChatTypeSectors(String name, String[] key, ChatParameter... parameters) {
        this(name, key, null, null, parameters);
    }

    ChatTypeSectors(@NotNull String name, @NotNull String[] key, @Nullable NamedTextColor colour,
                    @Nullable TextDecoration decoration, @NotNull ChatParameter... parameters) {
        this.name = name;
        this.parameters = parameters;
        this.translationKey = key;
        this.textColour = colour;
        this.decoration = decoration;
    }

    @Override
    public ChatParameter[] getParameters() {
        return this.parameters;
    }

    @Override
    public String[] getTranslationKey() {
        return this.translationKey;
    }

    @Override
    public String getSectorName() {
        return this.name;
    }

    @Override
    public Optional<NamedTextColor> getTextColour() {
        return Optional.ofNullable(this.textColour);
    }

    @Override
    public Optional<TextDecoration> getTextStyle() {
        return Optional.ofNullable(this.decoration);
    }
}
