package org.absorb.command.node.parser.suggestion;

import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

public enum SuggestionTypes implements Identifiable {

    ASK_SERVER("Ask server", "ask_server"),
    ALL_RECIPES("All Recipes", "all_recipes"),
    ALL_SOUNDS("All Sounds", "available_sounds"),
    ALL_BIOMES("All Biomes", "available_biomes"),
    SPAWNABLE_ENTITIES("Spawnable entities", "summonable_entities");

    private final @NotNull String name;
    private final @NotNull String key;

    SuggestionTypes(@NotNull String name, @NotNull String key){
        this.key = key;
        this.name = name;
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    @Override
    public @NotNull String getKey() {
        return this.key;
    }

    @Override
    public @NotNull String getHost() {
        return Identifiable.MINECRAFT_HOST;
    }
}
