package org.absorb.world.biome.sound;

import org.absorb.utils.Identifiable;
import org.jetbrains.annotations.NotNull;

public enum BiomeSounds implements BiomeSound {
    AMBIENT_CAVE("Ambient Cave", Identifiable.MINECRAFT_HOST, "ambient.cave"),
    AMBIENT_CRIMSON_FOREST_MOOD("Ambient Crimson Forest Mood", Identifiable.MINECRAFT_HOST, "ambient.crimson_forest" +
            ".mood"),
    AMBIENT_SOAL_SAND_VALLEY_MOOD("Ambient Soal Sand Valley Mood", Identifiable.MINECRAFT_HOST, "ambient" +
            ".soul_sand_valley.mood"),
    AMBIENT_BASALT_DELTAS_MOOD("Ambient basalt deltas mood", Identifiable.MINECRAFT_HOST, "ambient.basalt_deltas.mood"),
    AMBIENT_BASALT_DELTAS_LOOP("Ambient basalt deltas loop", Identifiable.MINECRAFT_HOST, "ambient.basalt_deltas.loop"),
    AMBIENT_BASALT_DELTAS_ADDITIONS("Ambient basalt deltas additions", Identifiable.MINECRAFT_HOST, "ambient" +
            ".basalt_deltas.additions"),
    BASALT_DELTAS("Ambient Basalt", Identifiable.MINECRAFT_HOST, "music.nether.basalt_deltas"),

    OVERWORLD_MEADOW("Overworld Meadow", Identifiable.MINECRAFT_HOST, "music.overworld.meadow"),
    OVERWORLD_GROVE("Overworld Grove", Identifiable.MINECRAFT_HOST, "music.overworld.grove"),
    OVERWORLD_SNOWY_SLOPES("Overworld Snowy Slopes", Identifiable.MINECRAFT_HOST, "music.overworld.snowy_slopes"),
    OVERWORLD_FROZEN_PEAKS("Overworld Frozen Peeks", Identifiable.MINECRAFT_HOST, "music.overworld.frozen_peaks"),
    OVERWORLD_JAGGED_PEAKS("Overworld Jagged peaks", Identifiable.MINECRAFT_HOST, "music.overworld.jagged_peaks"),
    OVERWORLD_STONY_PEAKS("Overworld Stony Peaks", Identifiable.MINECRAFT_HOST, "music.overworld.stony_peaks"),
    OVERWORLD_DRIPSTONE_CAVES("Overworld dripstone caves", Identifiable.MINECRAFT_HOST, "music.overworld" +
            ".dripstone_caves"),
    OVERWORLD_LUSH_CAVES("Overworld Lush Caves", Identifiable.MINECRAFT_HOST, "music.overworld.lush_caves"),
    NETHER_WASTES("Nether Wastes", Identifiable.MINECRAFT_HOST, "music.nether.nether_wastes"),
    NETHER_WASTES_LOOP("Nether Wastes Loop", Identifiable.MINECRAFT_HOST, "ambient.nether_wastes.loop"),
    NETHER_WASTES_ADDITIONS("Nether Wastes Additions", Identifiable.MINECRAFT_HOST, "ambient.nether_wastes.additions"),
    AMBIENT_NETHER_WASTES_MOOD("Nether Wastes Mood", Identifiable.MINECRAFT_HOST, "ambient.nether_wastes.mood"),
    NETHER_WARPED_FOREST("Nether Warped Forest", Identifiable.MINECRAFT_HOST, "music.nether.warped_forest"),
    AMBIENT_WARPED_FOREST_LOOP("Nether Warped Forest Loop", Identifiable.MINECRAFT_HOST, "ambient.warped_forest.loop"),
    AMBIENT_WARPED_FOREST_ADDITIONS("Nether Warped Forest Additions", Identifiable.MINECRAFT_HOST, "ambient" +
            ".warped_forest.additions"),
    AMBIENT_WARPED_FOREST_MOOD("nether warped forest mood", Identifiable.MINECRAFT_HOST, "ambient.warped_forest.mood"),
    NETHER_CRIMSON_FOREST("Nether Crimson Forest", Identifiable.MINECRAFT_HOST, "music.nether.crimson_forest"),
    AMBIENT_CRIMSON_FOREST_LOOP("Crimson Forest Loop", Identifiable.MINECRAFT_HOST, "ambient.crimson_forest.loop"),
    AMBIENT_CRIMSON_FOREST_ADDITIONS("Crimson Forest Additions", Identifiable.MINECRAFT_HOST, "ambient" +
            ".crimson_forest.additions"),
    SOUL_SAND_VALLEY("Soul Sand Valley", Identifiable.MINECRAFT_HOST, "music.nether.soul_sand_valley"),
    SOUL_SAND_VALLEY_LOOP("Soul Sand Valley Loop", Identifiable.MINECRAFT_HOST, "ambient.soul_sand_valley.loop"),
    SOUL_SAND_VALLEY_ADDITIONS("Soul Sand Valley Additions", Identifiable.MINECRAFT_HOST,
            "ambient.soul_sand_valley.additions");


    private final @NotNull String name;
    private final @NotNull String key;
    private final @NotNull String host;

    BiomeSounds(@NotNull String name, @NotNull String host, @NotNull String key) {
        this.host = host;
        this.name = name;
        this.key = key;
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
        return this.host;
    }
}
