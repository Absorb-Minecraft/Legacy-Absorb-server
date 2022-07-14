package org.absorb.inventory.item;

import org.absorb.inventory.item.data.StackDataKeys;
import org.absorb.register.registry.BuilderRegister;
import org.absorb.utils.Identifiable;

import java.util.function.Function;

@SuppressWarnings("unused")
public abstract class ItemTypes {

    public static final BuilderRegister<ItemType> ACACIA_BOAT = gen("Acacia Boat",
                                                                    "acacia_boat",
                                                                    builder -> builder
                                                                            .setNetworkId(706)
                                                                            .setStackSize(1));
    public static final BuilderRegister<ItemType> ACACIA_BUTTON = gen("Acacia Button",
                                                                      "acacia_button",
                                                                      builder -> builder.setNetworkId(638));
    public static final BuilderRegister<ItemType> ACACIA_DOOR = gen("Acacia Door",
                                                                    "acacia_door",
                                                                    builder -> builder.setNetworkId(661));
    public static final BuilderRegister<ItemType> ACACIA_FENCE = gen("Acacia Fence",
                                                                     "acacia_fence",
                                                                     builder -> builder.setNetworkId(272));
    public static final BuilderRegister<ItemType> ACACIA_FENCE_GATE = gen("Acacia Fence Gate",
                                                                          "acacia_fence_gate",
                                                                          builder -> builder.setNetworkId(680));
    public static final BuilderRegister<ItemType> ACACIA_LEAVES = gen("Acacia Leaves",
                                                                      "acacia_leaves",
                                                                      builder -> builder.setNetworkId(146));
    public static final BuilderRegister<ItemType> ACACIA_LOG = gen("Acacia Log",
                                                                   "acacia_log",
                                                                   builder -> builder.setNetworkId(108));
    public static final BuilderRegister<ItemType> ACACIA_PLANKS = gen("Acacia Planks",
                                                                      "acacia_planks",
                                                                      builder -> builder.setNetworkId(27));
    public static final BuilderRegister<ItemType> ACACIA_PRESSURE_PLATE = gen("Acacia Pressure Plate",
                                                                              "acacia_pressure_plate",
                                                                              builder -> builder.setNetworkId(651));
    public static final BuilderRegister<ItemType> ACACIA_SAPLING = gen("Acacia Sapling",
                                                                       "acacia_sapling",
                                                                       builder -> builder.setNetworkId(36));
    public static final BuilderRegister<ItemType> ACACIA_SIGN = gen("Acacia Sign",
                                                                    "acacia_sign",
                                                                    builder -> builder
                                                                            .setNetworkId(808)
                                                                            .setStackSize(16));
    public static final BuilderRegister<ItemType> ACACIA_SLAB = gen("Acacia Slab",
                                                                    "acacia_slab",
                                                                    builder -> builder.setNetworkId(218));
    public static final BuilderRegister<ItemType> ACACIA_STAIRS = gen("Acacia Stairs",
                                                                      "acacia_stairs",
                                                                      builder -> builder.setNetworkId(342));
    public static final BuilderRegister<ItemType> ACACIA_TRAPDOOR = gen("Acacia Trapdoor",
                                                                        "acacia_trapdoor",
                                                                        builder -> builder.setNetworkId(671));
    public static final BuilderRegister<ItemType> ACACIA_WOOD = gen("Acacia Wood",
                                                                    "acacia_wood",
                                                                    builder -> builder.setNetworkId(137));
    public static final BuilderRegister<ItemType> ACTIVATOR_RAIL = gen("Activator Rail",
                                                                       "activator_rail",
                                                                       builder -> builder.setNetworkId(688));
    public static final BuilderRegister<ItemType> AIR = gen("Air", "air", builder -> builder.setNetworkId(0));
    public static final BuilderRegister<ItemType> ALLIUM = gen("Allium",
                                                               "allium",
                                                               builder -> builder.setNetworkId(186));
    public static final BuilderRegister<ItemType> AMETHYST_BLOCK = gen("Block of Amethyst",
                                                                       "amethyst_block",
                                                                       builder -> builder.setNetworkId(66));
    public static final BuilderRegister<ItemType> AMETHYST_CLUSTER = gen("Amethyst Cluster",
                                                                         "amethyst_cluster",
                                                                         builder -> builder.setNetworkId(1145));
    public static final BuilderRegister<ItemType> AMETHYST_SHARD = gen("Amethyst Shard",
                                                                       "amethyst_shard",
                                                                       builder -> builder.setNetworkId(726));
    public static final BuilderRegister<ItemType> ANCIENT_DEBRIS = gen("Ancient Debris",
                                                                       "ancient_debris",
                                                                       builder -> builder.setNetworkId(61));
    public static final BuilderRegister<ItemType> ANDESITE = gen("Andesite",
                                                                 "andesite",
                                                                 builder -> builder.setNetworkId(6));
    public static final BuilderRegister<ItemType> ANDESITE_SLAB = gen("Andesite Slab",
                                                                      "andesite_slab",
                                                                      builder -> builder.setNetworkId(599));
    public static final BuilderRegister<ItemType> ANDESITE_STAIRS = gen("Andesite Stairs",
                                                                        "andesite_stairs",
                                                                        builder -> builder.setNetworkId(582));
    public static final BuilderRegister<ItemType> ANDESITE_WALL = gen("Andesite Wall",
                                                                      "andesite_wall",
                                                                      builder -> builder.setNetworkId(359));
    public static final BuilderRegister<ItemType> ANVIL = gen("Anvil", "anvil", builder -> builder.setNetworkId(371));
    public static final BuilderRegister<ItemType> APPLE = gen("Apple", "apple", builder -> builder.setNetworkId(717));
    public static final BuilderRegister<ItemType> ARMOR_STAND = gen("Armor Stand",
                                                                    "armor_stand",
                                                                    builder -> builder
                                                                            .setNetworkId(1015)
                                                                            .setStackSize(16));
    public static final BuilderRegister<ItemType> ARROW = gen("Arrow", "arrow", builder -> builder.setNetworkId(719));
    public static final BuilderRegister<ItemType> AXOLOTL_BUCKET = gen("Bucket of Axolotl",
                                                                       "axolotl_bucket",
                                                                       builder -> builder
                                                                               .setNetworkId(824)
                                                                               .setStackSize(1));
    public static final BuilderRegister<ItemType> AXOLOTL_SPAWN_EGG = gen("Axolotl Spawn Egg",
                                                                          "axolotl_spawn_egg",
                                                                          builder -> builder.setNetworkId(913));
    public static final BuilderRegister<ItemType> AZALEA = gen("Azalea",
                                                               "azalea",
                                                               builder -> builder.setNetworkId(162));
    public static final BuilderRegister<ItemType> AZALEA_LEAVES = gen("Azalea Leaves",
                                                                      "azalea_leaves",
                                                                      builder -> builder.setNetworkId(149));
    public static final BuilderRegister<ItemType> AZURE_BLUET = gen("Azure Bluet",
                                                                    "azure_bluet",
                                                                    builder -> builder.setNetworkId(187));
    public static final BuilderRegister<ItemType> BAKED_POTATO = gen("Baked Potato",
                                                                     "baked_potato",
                                                                     builder -> builder.setNetworkId(992));
    public static final BuilderRegister<ItemType> BAMBOO = gen("Bamboo",
                                                               "bamboo",
                                                               builder -> builder.setNetworkId(213));
    public static final BuilderRegister<ItemType> BARREL = gen("Barrel",
                                                               "barrel",
                                                               builder -> builder.setNetworkId(1089));
    public static final BuilderRegister<ItemType> BARRIER = gen("Barrier",
                                                                "barrier",
                                                                builder -> builder.setNetworkId(395));
    public static final BuilderRegister<ItemType> BASALT = gen("Basalt",
                                                               "basalt",
                                                               builder -> builder.setNetworkId(283));
    public static final BuilderRegister<ItemType> BAT_SPAWN_EGG = gen("Bat Spawn Egg",
                                                                      "bat_spawn_egg",
                                                                      builder -> builder.setNetworkId(914));
    public static final BuilderRegister<ItemType> BEACON = gen("Beacon",
                                                               "beacon",
                                                               builder -> builder.setNetworkId(348));
    public static final BuilderRegister<ItemType> BEDROCK = gen("Bedrock",
                                                                "bedrock",
                                                                builder -> builder.setNetworkId(39));
    public static final BuilderRegister<ItemType> BEEF = gen("Raw Beef", "beef", builder -> builder.setNetworkId(892));
    public static final BuilderRegister<ItemType> BEEHIVE = gen("Beehive",
                                                                "beehive",
                                                                builder -> builder.setNetworkId(1107));
    public static final BuilderRegister<ItemType> BEETROOT = gen("Beetroot",
                                                                 "beetroot",
                                                                 builder -> builder.setNetworkId(1044));
    public static final BuilderRegister<ItemType> BEETROOT_SEEDS = gen("Beetroot Seeds",
                                                                       "beetroot_seeds",
                                                                       builder -> builder.setNetworkId(1045));
    public static final BuilderRegister<ItemType> BEETROOT_SOUP = gen("Beetroot Soup",
                                                                      "beetroot_soup",
                                                                      builder -> builder
                                                                              .setNetworkId(1046)
                                                                              .setStackSize(1));
    public static final BuilderRegister<ItemType> BEE_NEST = gen("Bee Nest",
                                                                 "bee_nest",
                                                                 builder -> builder.setNetworkId(1106));
    public static final BuilderRegister<ItemType> BEE_SPAWN_EGG = gen("Bee Spawn Egg",
                                                                      "bee_spawn_egg",
                                                                      builder -> builder.setNetworkId(915));
    public static final BuilderRegister<ItemType> BELL = gen("Bell", "bell", builder -> builder.setNetworkId(1097));
    public static final BuilderRegister<ItemType> BIG_DRIPLEAF = gen("Big Dripleaf",
                                                                     "big_dripleaf",
                                                                     builder -> builder.setNetworkId(211));
    public static final BuilderRegister<ItemType> BIRCH_BOAT = gen("Birch Boat",
                                                                   "birch_boat",
                                                                   builder -> builder
                                                                           .setNetworkId(702)
                                                                           .setStackSize(1));
    public static final BuilderRegister<ItemType> BIRCH_BUTTON = gen("Birch Button",
                                                                     "birch_button",
                                                                     builder -> builder.setNetworkId(636));
    public static final BuilderRegister<ItemType> BIRCH_DOOR = gen("Birch Door",
                                                                   "birch_door",
                                                                   builder -> builder.setNetworkId(659));
    public static final BuilderRegister<ItemType> BIRCH_FENCE = gen("Birch Fence",
                                                                    "birch_fence",
                                                                    builder -> builder.setNetworkId(270));
    public static final BuilderRegister<ItemType> BIRCH_FENCE_GATE = gen("Birch Fence Gate",
                                                                         "birch_fence_gate",
                                                                         builder -> builder.setNetworkId(678));
    public static final BuilderRegister<ItemType> BIRCH_LEAVES = gen("Birch Leaves",
                                                                     "birch_leaves",
                                                                     builder -> builder.setNetworkId(144));
    public static final BuilderRegister<ItemType> BIRCH_LOG = gen("Birch Log",
                                                                  "birch_log",
                                                                  builder -> builder.setNetworkId(106));
    public static final BuilderRegister<ItemType> BIRCH_PLANKS = gen("Birch Planks",
                                                                     "birch_planks",
                                                                     builder -> builder.setNetworkId(25));
    public static final BuilderRegister<ItemType> BIRCH_PRESSURE_PLATE = gen("Birch Pressure Plate",
                                                                             "birch_pressure_plate",
                                                                             builder -> builder.setNetworkId(649));
    public static final BuilderRegister<ItemType> BIRCH_SAPLING = gen("Birch Sapling",
                                                                      "birch_sapling",
                                                                      builder -> builder.setNetworkId(34));
    public static final BuilderRegister<ItemType> BIRCH_SIGN = gen("Birch Sign",
                                                                   "birch_sign",
                                                                   builder -> builder
                                                                           .setNetworkId(806)
                                                                           .setStackSize(16));
    public static final BuilderRegister<ItemType> BIRCH_SLAB = gen("Birch Slab",
                                                                   "birch_slab",
                                                                   builder -> builder.setNetworkId(216));
    public static final BuilderRegister<ItemType> BIRCH_STAIRS = gen("Birch Stairs",
                                                                     "birch_stairs",
                                                                     builder -> builder.setNetworkId(340));
    public static final BuilderRegister<ItemType> BIRCH_TRAPDOOR = gen("Birch Trapdoor",
                                                                       "birch_trapdoor",
                                                                       builder -> builder.setNetworkId(669));
    public static final BuilderRegister<ItemType> BIRCH_WOOD = gen("Birch Wood",
                                                                   "birch_wood",
                                                                   builder -> builder.setNetworkId(135));
    public static final BuilderRegister<ItemType> BLACKSTONE = gen("Blackstone",
                                                                   "blackstone",
                                                                   builder -> builder.setNetworkId(1112));
    public static final BuilderRegister<ItemType> BLACKSTONE_SLAB = gen("Blackstone Slab",
                                                                        "blackstone_slab",
                                                                        builder -> builder.setNetworkId(1113));
    public static final BuilderRegister<ItemType> BLACKSTONE_STAIRS = gen("Blackstone Stairs",
                                                                          "blackstone_stairs",
                                                                          builder -> builder.setNetworkId(1114));
    public static final BuilderRegister<ItemType> BLACKSTONE_WALL = gen("Blackstone Wall",
                                                                        "blackstone_wall",
                                                                        builder -> builder.setNetworkId(364));
    public static final BuilderRegister<ItemType> BLACK_BANNER = gen("Black Banner",
                                                                     "black_banner",
                                                                     builder -> builder
                                                                             .setNetworkId(1040)
                                                                             .setStackSize(16));
    public static final BuilderRegister<ItemType> BLACK_BED = gen("Black Bed",
                                                                  "black_bed",
                                                                  builder -> builder.setNetworkId(884).setStackSize(1));
    public static final BuilderRegister<ItemType> BLACK_CANDLE = gen("Black Candle",
                                                                     "black_candle",
                                                                     builder -> builder.setNetworkId(1141));
    public static final BuilderRegister<ItemType> BLACK_CARPET = gen("Black Carpet",
                                                                     "black_carpet",
                                                                     builder -> builder.setNetworkId(413));
    public static final BuilderRegister<ItemType> BLACK_CONCRETE = gen("Black Concrete",
                                                                       "black_concrete",
                                                                       builder -> builder.setNetworkId(522));
    public static final BuilderRegister<ItemType> BLACK_CONCRETE_POWDER = gen("Black Concrete Powder",
                                                                              "black_concrete_powder",
                                                                              builder -> builder.setNetworkId(538));
    public static final BuilderRegister<ItemType> BLACK_DYE = gen("Black Dye",
                                                                  "black_dye",
                                                                  builder -> builder.setNetworkId(864));
    public static final BuilderRegister<ItemType> BLACK_GLAZED_TERRACOTTA = gen("Black Glazed Terracotta",
                                                                                "black_glazed_terracotta",
                                                                                builder -> builder.setNetworkId(506));
    public static final BuilderRegister<ItemType> BLACK_SHULKER_BOX = gen("Black Shulker Box",
                                                                          "black_shulker_box",
                                                                          builder -> builder
                                                                                  .setNetworkId(490)
                                                                                  .setStackSize(1));
    public static final BuilderRegister<ItemType> BLACK_STAINED_GLASS = gen("Black Stained Glass",
                                                                            "black_stained_glass",
                                                                            builder -> builder.setNetworkId(438));
    public static final BuilderRegister<ItemType> BLACK_STAINED_GLASS_PANE = gen("Black Stained Glass Pane",
                                                                                 "black_stained_glass_pane",
                                                                                 builder -> builder.setNetworkId(454));
    public static final BuilderRegister<ItemType> BLACK_TERRACOTTA = gen("Black Terracotta",
                                                                         "black_terracotta",
                                                                         builder -> builder.setNetworkId(394));
    public static final BuilderRegister<ItemType> BLACK_WOOL = gen("Black Wool",
                                                                   "black_wool",
                                                                   builder -> builder.setNetworkId(182));
    public static final BuilderRegister<ItemType> BLAST_FURNACE = gen("Blast Furnace",
                                                                      "blast_furnace",
                                                                      builder -> builder.setNetworkId(1091));
    public static final BuilderRegister<ItemType> BLAZE_POWDER = gen("Blaze Powder",
                                                                     "blaze_powder",
                                                                     builder -> builder.setNetworkId(906));
    public static final BuilderRegister<ItemType> BLAZE_ROD = gen("Blaze Rod",
                                                                  "blaze_rod",
                                                                  builder -> builder.setNetworkId(898));
    public static final BuilderRegister<ItemType> BLAZE_SPAWN_EGG = gen("Blaze Spawn Egg",
                                                                        "blaze_spawn_egg",
                                                                        builder -> builder.setNetworkId(916));
    public static final BuilderRegister<ItemType> BLUE_BANNER = gen("Blue Banner",
                                                                    "blue_banner",
                                                                    builder -> builder
                                                                            .setNetworkId(1036)
                                                                            .setStackSize(16));
    public static final BuilderRegister<ItemType> BLUE_BED = gen("Blue Bed",
                                                                 "blue_bed",
                                                                 builder -> builder.setNetworkId(880).setStackSize(1));
    public static final BuilderRegister<ItemType> BLUE_CANDLE = gen("Blue Candle",
                                                                    "blue_candle",
                                                                    builder -> builder.setNetworkId(1137));
    public static final BuilderRegister<ItemType> BLUE_CARPET = gen("Blue Carpet",
                                                                    "blue_carpet",
                                                                    builder -> builder.setNetworkId(409));
    public static final BuilderRegister<ItemType> BLUE_CONCRETE = gen("Blue Concrete",
                                                                      "blue_concrete",
                                                                      builder -> builder.setNetworkId(518));
    public static final BuilderRegister<ItemType> BLUE_CONCRETE_POWDER = gen("Blue Concrete Powder",
                                                                             "blue_concrete_powder",
                                                                             builder -> builder.setNetworkId(534));
    public static final BuilderRegister<ItemType> BLUE_DYE = gen("Blue Dye",
                                                                 "blue_dye",
                                                                 builder -> builder.setNetworkId(860));
    public static final BuilderRegister<ItemType> BLUE_GLAZED_TERRACOTTA = gen("Blue Glazed Terracotta",
                                                                               "blue_glazed_terracotta",
                                                                               builder -> builder.setNetworkId(502));
    public static final BuilderRegister<ItemType> BLUE_ICE = gen("Blue Ice",
                                                                 "blue_ice",
                                                                 builder -> builder.setNetworkId(570));
    public static final BuilderRegister<ItemType> BLUE_ORCHID = gen("Blue Orchid",
                                                                    "blue_orchid",
                                                                    builder -> builder.setNetworkId(185));
    public static final BuilderRegister<ItemType> BLUE_SHULKER_BOX = gen("Blue Shulker Box",
                                                                         "blue_shulker_box",
                                                                         builder -> builder
                                                                                 .setNetworkId(486)
                                                                                 .setStackSize(1));
    public static final BuilderRegister<ItemType> BLUE_STAINED_GLASS = gen("Blue Stained Glass",
                                                                           "blue_stained_glass",
                                                                           builder -> builder.setNetworkId(434));
    public static final BuilderRegister<ItemType> BLUE_STAINED_GLASS_PANE = gen("Blue Stained Glass Pane",
                                                                                "blue_stained_glass_pane",
                                                                                builder -> builder.setNetworkId(450));
    public static final BuilderRegister<ItemType> BLUE_TERRACOTTA = gen("Blue Terracotta",
                                                                        "blue_terracotta",
                                                                        builder -> builder.setNetworkId(390));
    public static final BuilderRegister<ItemType> BLUE_WOOL = gen("Blue Wool",
                                                                  "blue_wool",
                                                                  builder -> builder.setNetworkId(178));
    public static final BuilderRegister<ItemType> BONE = gen("Bone", "bone", builder -> builder.setNetworkId(866));
    public static final BuilderRegister<ItemType> BONE_BLOCK = gen("Bone Block",
                                                                   "bone_block",
                                                                   builder -> builder.setNetworkId(472));
    public static final BuilderRegister<ItemType> BONE_MEAL = gen("Bone Meal",
                                                                  "bone_meal",
                                                                  builder -> builder.setNetworkId(865));
    public static final BuilderRegister<ItemType> BOOK = gen("Book", "book", builder -> builder.setNetworkId(830));
    public static final BuilderRegister<ItemType> BOOKSHELF = gen("Bookshelf",
                                                                  "bookshelf",
                                                                  builder -> builder.setNetworkId(245));
    public static final BuilderRegister<ItemType> BOW = gen("Bow", "bow", builder -> builder.setNetworkId(718));
    public static final BuilderRegister<ItemType> BOWL = gen("Bowl", "bowl", builder -> builder.setNetworkId(766));
    public static final BuilderRegister<ItemType> BRAIN_CORAL = gen("Brain Coral",
                                                                    "brain_coral",
                                                                    builder -> builder.setNetworkId(551));
    public static final BuilderRegister<ItemType> BRAIN_CORAL_BLOCK = gen("Brain Coral Block",
                                                                          "brain_coral_block",
                                                                          builder -> builder.setNetworkId(546));
    public static final BuilderRegister<ItemType> BRAIN_CORAL_FAN = gen("Brain Coral Fan",
                                                                        "brain_coral_fan",
                                                                        builder -> builder.setNetworkId(561));
    public static final BuilderRegister<ItemType> BREAD = gen("Bread", "bread", builder -> builder.setNetworkId(773));
    public static final BuilderRegister<ItemType> BREWING_STAND = gen("Brewing Stand",
                                                                      "brewing_stand",
                                                                      builder -> builder.setNetworkId(908));
    public static final BuilderRegister<ItemType> BRICK = gen("Brick", "brick", builder -> builder.setNetworkId(826));
    public static final BuilderRegister<ItemType> BRICKS = gen("Bricks",
                                                               "bricks",
                                                               builder -> builder.setNetworkId(244));
    public static final BuilderRegister<ItemType> BRICK_SLAB = gen("Brick Slab",
                                                                   "brick_slab",
                                                                   builder -> builder.setNetworkId(229));
    public static final BuilderRegister<ItemType> BRICK_STAIRS = gen("Brick Stairs",
                                                                     "brick_stairs",
                                                                     builder -> builder.setNetworkId(316));
    public static final BuilderRegister<ItemType> BRICK_WALL = gen("Brick Wall",
                                                                   "brick_wall",
                                                                   builder -> builder.setNetworkId(351));
    public static final BuilderRegister<ItemType> BROWN_BANNER = gen("Brown Banner",
                                                                     "brown_banner",
                                                                     builder -> builder
                                                                             .setNetworkId(1037)
                                                                             .setStackSize(16));
    public static final BuilderRegister<ItemType> BROWN_BED = gen("Brown Bed",
                                                                  "brown_bed",
                                                                  builder -> builder.setNetworkId(881).setStackSize(1));
    public static final BuilderRegister<ItemType> BROWN_CANDLE = gen("Brown Candle",
                                                                     "brown_candle",
                                                                     builder -> builder.setNetworkId(1138));
    public static final BuilderRegister<ItemType> BROWN_CARPET = gen("Brown Carpet",
                                                                     "brown_carpet",
                                                                     builder -> builder.setNetworkId(410));
    public static final BuilderRegister<ItemType> BROWN_CONCRETE = gen("Brown Concrete",
                                                                       "brown_concrete",
                                                                       builder -> builder.setNetworkId(519));
    public static final BuilderRegister<ItemType> BROWN_CONCRETE_POWDER = gen("Brown Concrete Powder",
                                                                              "brown_concrete_powder",
                                                                              builder -> builder.setNetworkId(535));
    public static final BuilderRegister<ItemType> BROWN_DYE = gen("Brown Dye",
                                                                  "brown_dye",
                                                                  builder -> builder.setNetworkId(861));
    public static final BuilderRegister<ItemType> BROWN_GLAZED_TERRACOTTA = gen("Brown Glazed Terracotta",
                                                                                "brown_glazed_terracotta",
                                                                                builder -> builder.setNetworkId(503));
    public static final BuilderRegister<ItemType> BROWN_MUSHROOM = gen("Brown Mushroom",
                                                                       "brown_mushroom",
                                                                       builder -> builder.setNetworkId(197));
    public static final BuilderRegister<ItemType> BROWN_MUSHROOM_BLOCK = gen("Brown Mushroom Block",
                                                                             "brown_mushroom_block",
                                                                             builder -> builder.setNetworkId(307));
    public static final BuilderRegister<ItemType> BROWN_SHULKER_BOX = gen("Brown Shulker Box",
                                                                          "brown_shulker_box",
                                                                          builder -> builder
                                                                                  .setNetworkId(487)
                                                                                  .setStackSize(1));
    public static final BuilderRegister<ItemType> BROWN_STAINED_GLASS = gen("Brown Stained Glass",
                                                                            "brown_stained_glass",
                                                                            builder -> builder.setNetworkId(435));
    public static final BuilderRegister<ItemType> BROWN_STAINED_GLASS_PANE = gen("Brown Stained Glass Pane",
                                                                                 "brown_stained_glass_pane",
                                                                                 builder -> builder.setNetworkId(451));
    public static final BuilderRegister<ItemType> BROWN_TERRACOTTA = gen("Brown Terracotta",
                                                                         "brown_terracotta",
                                                                         builder -> builder.setNetworkId(391));
    public static final BuilderRegister<ItemType> BROWN_WOOL = gen("Brown Wool",
                                                                   "brown_wool",
                                                                   builder -> builder.setNetworkId(179));
    public static final BuilderRegister<ItemType> BUBBLE_CORAL = gen("Bubble Coral",
                                                                     "bubble_coral",
                                                                     builder -> builder.setNetworkId(552));
    public static final BuilderRegister<ItemType> BUBBLE_CORAL_BLOCK = gen("Bubble Coral Block",
                                                                           "bubble_coral_block",
                                                                           builder -> builder.setNetworkId(547));
    public static final BuilderRegister<ItemType> BUBBLE_CORAL_FAN = gen("Bubble Coral Fan",
                                                                         "bubble_coral_fan",
                                                                         builder -> builder.setNetworkId(562));
    public static final BuilderRegister<ItemType> BUCKET = gen("Bucket",
                                                               "bucket",
                                                               builder -> builder.setNetworkId(813).setStackSize(16));
    public static final BuilderRegister<ItemType> BUDDING_AMETHYST = gen("Budding Amethyst",
                                                                         "budding_amethyst",
                                                                         builder -> builder.setNetworkId(67));
    public static final BuilderRegister<ItemType> BUNDLE = gen("Bundle",
                                                               "bundle",
                                                               builder -> builder.setNetworkId(835).setStackSize(1));
    public static final BuilderRegister<ItemType> CACTUS = gen("Cactus",
                                                               "cactus",
                                                               builder -> builder.setNetworkId(265));
    public static final BuilderRegister<ItemType> CAKE = gen("Cake",
                                                             "cake",
                                                             builder -> builder.setNetworkId(868).setStackSize(1));
    public static final BuilderRegister<ItemType> CALCITE = gen("Calcite",
                                                                "calcite",
                                                                builder -> builder.setNetworkId(11));
    public static final BuilderRegister<ItemType> CAMPFIRE = gen("Campfire",
                                                                 "campfire",
                                                                 builder -> builder.setNetworkId(1102));
    public static final BuilderRegister<ItemType> CANDLE = gen("Candle",
                                                               "candle",
                                                               builder -> builder.setNetworkId(1125));
    public static final BuilderRegister<ItemType> CARROT = gen("Carrot",
                                                               "carrot",
                                                               builder -> builder.setNetworkId(990));
    public static final BuilderRegister<ItemType> CARROT_ON_A_STICK = gen("Carrot on a Stick",
                                                                          "carrot_on_a_stick",
                                                                          builder -> builder.setNetworkId(695));
    public static final BuilderRegister<ItemType> CARTOGRAPHY_TABLE = gen("Cartography Table",
                                                                          "cartography_table",
                                                                          builder -> builder.setNetworkId(1092));
    public static final BuilderRegister<ItemType> CARVED_PUMPKIN = gen("Carved Pumpkin",
                                                                       "carved_pumpkin",
                                                                       builder -> builder.setNetworkId(278));
    public static final BuilderRegister<ItemType> CAT_SPAWN_EGG = gen("Cat Spawn Egg",
                                                                      "cat_spawn_egg",
                                                                      builder -> builder.setNetworkId(917));
    public static final BuilderRegister<ItemType> CAULDRON = gen("Cauldron",
                                                                 "cauldron",
                                                                 builder -> builder.setNetworkId(909));
    public static final BuilderRegister<ItemType> CAVE_SPIDER_SPAWN_EGG = gen("Cave Spider Spawn Egg",
                                                                              "cave_spider_spawn_egg",
                                                                              builder -> builder.setNetworkId(918));
    public static final BuilderRegister<ItemType> CHAIN = gen("Chain", "chain", builder -> builder.setNetworkId(311));
    public static final BuilderRegister<ItemType> CHAINMAIL_BOOTS = gen("Chainmail Boots",
                                                                        "chainmail_boots",
                                                                        builder -> builder.setNetworkId(781));
    public static final BuilderRegister<ItemType> CHAINMAIL_CHESTPLATE = gen("Chainmail Chestplate",
                                                                             "chainmail_chestplate",
                                                                             builder -> builder.setNetworkId(779));
    public static final BuilderRegister<ItemType> CHAINMAIL_HELMET = gen("Chainmail Helmet",
                                                                         "chainmail_helmet",
                                                                         builder -> builder.setNetworkId(778));
    public static final BuilderRegister<ItemType> CHAINMAIL_LEGGINGS = gen("Chainmail Leggings",
                                                                           "chainmail_leggings",
                                                                           builder -> builder.setNetworkId(780));
    public static final BuilderRegister<ItemType> CHAIN_COMMAND_BLOCK = gen("Chain Command Block",
                                                                            "chain_command_block",
                                                                            builder -> builder.setNetworkId(467));
    public static final BuilderRegister<ItemType> CHARCOAL = gen("Charcoal",
                                                                 "charcoal",
                                                                 builder -> builder.setNetworkId(721));
    public static final BuilderRegister<ItemType> CHEST = gen("Chest", "chest", builder -> builder.setNetworkId(256));
    public static final BuilderRegister<ItemType> CHEST_MINECART = gen("Minecart with Chest",
                                                                       "chest_minecart",
                                                                       builder -> builder
                                                                               .setNetworkId(691)
                                                                               .setStackSize(1));
    public static final BuilderRegister<ItemType> CHICKEN = gen("Raw Chicken",
                                                                "chicken",
                                                                builder -> builder.setNetworkId(894));
    public static final BuilderRegister<ItemType> CHICKEN_SPAWN_EGG = gen("Chicken Spawn Egg",
                                                                          "chicken_spawn_egg",
                                                                          builder -> builder.setNetworkId(919));
    public static final BuilderRegister<ItemType> CHIPPED_ANVIL = gen("Chipped Anvil",
                                                                      "chipped_anvil",
                                                                      builder -> builder.setNetworkId(372));
    public static final BuilderRegister<ItemType> CHISELED_DEEPSLATE = gen("Chiseled Deepslate",
                                                                           "chiseled_deepslate",
                                                                           builder -> builder.setNetworkId(305));
    public static final BuilderRegister<ItemType> CHISELED_NETHER_BRICKS = gen("Chiseled Nether Bricks",
                                                                               "chiseled_nether_bricks",
                                                                               builder -> builder.setNetworkId(323));
    public static final BuilderRegister<ItemType> CHISELED_POLISHED_BLACKSTONE = gen("Chiseled Polished Blackstone",
                                                                                     "chiseled_polished_blackstone",
                                                                                     builder -> builder.setNetworkId(
                                                                                             1119));
    public static final BuilderRegister<ItemType> CHISELED_QUARTZ_BLOCK = gen("Chiseled Quartz Block",
                                                                              "chiseled_quartz_block",
                                                                              builder -> builder.setNetworkId(374));
    public static final BuilderRegister<ItemType> CHISELED_RED_SANDSTONE = gen("Chiseled Red Sandstone",
                                                                               "chiseled_red_sandstone",
                                                                               builder -> builder.setNetworkId(463));
    public static final BuilderRegister<ItemType> CHISELED_SANDSTONE = gen("Chiseled Sandstone",
                                                                           "chiseled_sandstone",
                                                                           builder -> builder.setNetworkId(157));
    public static final BuilderRegister<ItemType> CHISELED_STONE_BRICKS = gen("Chiseled Stone Bricks",
                                                                              "chiseled_stone_bricks",
                                                                              builder -> builder.setNetworkId(298));
    public static final BuilderRegister<ItemType> CHORUS_FLOWER = gen("Chorus Flower",
                                                                      "chorus_flower",
                                                                      builder -> builder.setNetworkId(251));
    public static final BuilderRegister<ItemType> CHORUS_FRUIT = gen("Chorus Fruit",
                                                                     "chorus_fruit",
                                                                     builder -> builder.setNetworkId(1042));
    public static final BuilderRegister<ItemType> CHORUS_PLANT = gen("Chorus Plant",
                                                                     "chorus_plant",
                                                                     builder -> builder.setNetworkId(250));
    public static final BuilderRegister<ItemType> CLAY = gen("Clay", "clay", builder -> builder.setNetworkId(266));
    public static final BuilderRegister<ItemType> CLAY_BALL = gen("Clay Ball",
                                                                  "clay_ball",
                                                                  builder -> builder.setNetworkId(827));
    public static final BuilderRegister<ItemType> CLOCK = gen("Clock", "clock", builder -> builder.setNetworkId(837));
    public static final BuilderRegister<ItemType> COAL = gen("Coal", "coal", builder -> builder.setNetworkId(720));
    public static final BuilderRegister<ItemType> COAL_BLOCK = gen("Block of Coal",
                                                                   "coal_block",
                                                                   builder -> builder.setNetworkId(62));
    public static final BuilderRegister<ItemType> COAL_ORE = gen("Coal Ore",
                                                                 "coal_ore",
                                                                 builder -> builder.setNetworkId(43));
    public static final BuilderRegister<ItemType> COARSE_DIRT = gen("Coarse Dirt",
                                                                    "coarse_dirt",
                                                                    builder -> builder.setNetworkId(16));
    public static final BuilderRegister<ItemType> COBBLED_DEEPSLATE = gen("Cobbled Deepslate",
                                                                          "cobbled_deepslate",
                                                                          builder -> builder.setNetworkId(9));
    public static final BuilderRegister<ItemType> COBBLED_DEEPSLATE_SLAB = gen("Cobbled Deepslate Slab",
                                                                               "cobbled_deepslate_slab",
                                                                               builder -> builder.setNetworkId(603));
    public static final BuilderRegister<ItemType> COBBLED_DEEPSLATE_STAIRS = gen("Cobbled Deepslate Stairs",
                                                                                 "cobbled_deepslate_stairs",
                                                                                 builder -> builder.setNetworkId(586));
    public static final BuilderRegister<ItemType> COBBLED_DEEPSLATE_WALL = gen("Cobbled Deepslate Wall",
                                                                               "cobbled_deepslate_wall",
                                                                               builder -> builder.setNetworkId(367));
    public static final BuilderRegister<ItemType> COBBLESTONE = gen("Cobblestone",
                                                                    "cobblestone",
                                                                    builder -> builder.setNetworkId(22));
    public static final BuilderRegister<ItemType> COBBLESTONE_SLAB = gen("Cobblestone Slab",
                                                                         "cobblestone_slab",
                                                                         builder -> builder.setNetworkId(228));
    public static final BuilderRegister<ItemType> COBBLESTONE_STAIRS = gen("Cobblestone Stairs",
                                                                           "cobblestone_stairs",
                                                                           builder -> builder.setNetworkId(261));
    public static final BuilderRegister<ItemType> COBBLESTONE_WALL = gen("Cobblestone Wall",
                                                                         "cobblestone_wall",
                                                                         builder -> builder.setNetworkId(349));
    public static final BuilderRegister<ItemType> COBWEB = gen("Cobweb",
                                                               "cobweb",
                                                               builder -> builder.setNetworkId(159));
    public static final BuilderRegister<ItemType> COCOA_BEANS = gen("Cocoa Beans",
                                                                    "cocoa_beans",
                                                                    builder -> builder.setNetworkId(848));
    public static final BuilderRegister<ItemType> COD = gen("Raw Cod", "cod", builder -> builder.setNetworkId(840));
    public static final BuilderRegister<ItemType> COD_BUCKET = gen("Bucket of Cod",
                                                                   "cod_bucket",
                                                                   builder -> builder
                                                                           .setNetworkId(822)
                                                                           .setStackSize(1));
    public static final BuilderRegister<ItemType> COD_SPAWN_EGG = gen("Cod Spawn Egg",
                                                                      "cod_spawn_egg",
                                                                      builder -> builder.setNetworkId(920));
    public static final BuilderRegister<ItemType> COMMAND_BLOCK = gen("Command Block",
                                                                      "command_block",
                                                                      builder -> builder.setNetworkId(347));
    public static final BuilderRegister<ItemType> COMMAND_BLOCK_MINECART = gen("Minecart with Command Block",
                                                                               "command_block_minecart",
                                                                               builder -> builder
                                                                                       .setNetworkId(1022)
                                                                                       .setStackSize(1));
    public static final BuilderRegister<ItemType> COMPARATOR = gen("Redstone Comparator",
                                                                   "comparator",
                                                                   builder -> builder.setNetworkId(612));
    public static final BuilderRegister<ItemType> COMPASS = gen("Compass",
                                                                "compass",
                                                                builder -> builder.setNetworkId(833));
    public static final BuilderRegister<ItemType> COMPOSTER = gen("Composter",
                                                                  "composter",
                                                                  builder -> builder.setNetworkId(1088));
    public static final BuilderRegister<ItemType> CONDUIT = gen("Conduit",
                                                                "conduit",
                                                                builder -> builder.setNetworkId(571));
    public static final BuilderRegister<ItemType> COOKED_BEEF = gen("Steak",
                                                                    "cooked_beef",
                                                                    builder -> builder.setNetworkId(893));
    public static final BuilderRegister<ItemType> COOKED_CHICKEN = gen("Cooked Chicken",
                                                                       "cooked_chicken",
                                                                       builder -> builder.setNetworkId(895));
    public static final BuilderRegister<ItemType> COOKED_COD = gen("Cooked Cod",
                                                                   "cooked_cod",
                                                                   builder -> builder.setNetworkId(844));
    public static final BuilderRegister<ItemType> COOKED_MUTTON = gen("Cooked Mutton",
                                                                      "cooked_mutton",
                                                                      builder -> builder.setNetworkId(1024));
    public static final BuilderRegister<ItemType> COOKED_PORKCHOP = gen("Cooked Porkchop",
                                                                        "cooked_porkchop",
                                                                        builder -> builder.setNetworkId(800));
    public static final BuilderRegister<ItemType> COOKED_RABBIT = gen("Cooked Rabbit",
                                                                      "cooked_rabbit",
                                                                      builder -> builder.setNetworkId(1011));
    public static final BuilderRegister<ItemType> COOKED_SALMON = gen("Cooked Salmon",
                                                                      "cooked_salmon",
                                                                      builder -> builder.setNetworkId(845));
    public static final BuilderRegister<ItemType> COOKIE = gen("Cookie",
                                                               "cookie",
                                                               builder -> builder.setNetworkId(885));
    public static final BuilderRegister<ItemType> COPPER_BLOCK = gen("Block of Copper",
                                                                     "copper_block",
                                                                     builder -> builder.setNetworkId(69));
    public static final BuilderRegister<ItemType> COPPER_INGOT = gen("Copper Ingot",
                                                                     "copper_ingot",
                                                                     builder -> builder.setNetworkId(730));
    public static final BuilderRegister<ItemType> COPPER_ORE = gen("Copper Ore",
                                                                   "copper_ore",
                                                                   builder -> builder.setNetworkId(47));
    public static final BuilderRegister<ItemType> CORNFLOWER = gen("Cornflower",
                                                                   "cornflower",
                                                                   builder -> builder.setNetworkId(193));
    public static final BuilderRegister<ItemType> COW_SPAWN_EGG = gen("Cow Spawn Egg",
                                                                      "cow_spawn_egg",
                                                                      builder -> builder.setNetworkId(921));
    public static final BuilderRegister<ItemType> CRACKED_DEEPSLATE_BRICKS = gen("Cracked Deepslate Bricks",
                                                                                 "cracked_deepslate_bricks",
                                                                                 builder -> builder.setNetworkId(302));
    public static final BuilderRegister<ItemType> CRACKED_DEEPSLATE_TILES = gen("Cracked Deepslate Tiles",
                                                                                "cracked_deepslate_tiles",
                                                                                builder -> builder.setNetworkId(304));
    public static final BuilderRegister<ItemType> CRACKED_NETHER_BRICKS = gen("Cracked Nether Bricks",
                                                                              "cracked_nether_bricks",
                                                                              builder -> builder.setNetworkId(322));
    public static final BuilderRegister<ItemType> CRACKED_POLISHED_BLACKSTONE_BRICKS = gen(
            "Cracked Polished Blackstone Bricks",
            "cracked_polished_blackstone_bricks",
            builder -> builder.setNetworkId(1123));
    public static final BuilderRegister<ItemType> CRACKED_STONE_BRICKS = gen("Cracked Stone Bricks",
                                                                             "cracked_stone_bricks",
                                                                             builder -> builder.setNetworkId(297));
    public static final BuilderRegister<ItemType> CRAFTING_TABLE = gen("Crafting Table",
                                                                       "crafting_table",
                                                                       builder -> builder.setNetworkId(257));
    public static final BuilderRegister<ItemType> CREEPER_BANNER_PATTERN = gen("Banner Pattern",
                                                                               "creeper_banner_pattern",
                                                                               builder -> builder
                                                                                       .setNetworkId(1082)
                                                                                       .setStackSize(1));
    public static final BuilderRegister<ItemType> CREEPER_HEAD = gen("Creeper Head",
                                                                     "creeper_head",
                                                                     builder -> builder.setNetworkId(1000));
    public static final BuilderRegister<ItemType> CREEPER_SPAWN_EGG = gen("Creeper Spawn Egg",
                                                                          "creeper_spawn_egg",
                                                                          builder -> builder.setNetworkId(922));
    public static final BuilderRegister<ItemType> CRIMSON_BUTTON = gen("Crimson Button",
                                                                       "crimson_button",
                                                                       builder -> builder.setNetworkId(641));
    public static final BuilderRegister<ItemType> CRIMSON_DOOR = gen("Crimson Door",
                                                                     "crimson_door",
                                                                     builder -> builder.setNetworkId(664));
    public static final BuilderRegister<ItemType> CRIMSON_FENCE = gen("Crimson Fence",
                                                                      "crimson_fence",
                                                                      builder -> builder.setNetworkId(275));
    public static final BuilderRegister<ItemType> CRIMSON_FENCE_GATE = gen("Crimson Fence Gate",
                                                                           "crimson_fence_gate",
                                                                           builder -> builder.setNetworkId(683));
    public static final BuilderRegister<ItemType> CRIMSON_FUNGUS = gen("Crimson Fungus",
                                                                       "crimson_fungus",
                                                                       builder -> builder.setNetworkId(199));
    public static final BuilderRegister<ItemType> CRIMSON_HYPHAE = gen("Crimson Hyphae",
                                                                       "crimson_hyphae",
                                                                       builder -> builder.setNetworkId(140));
    public static final BuilderRegister<ItemType> CRIMSON_NYLIUM = gen("Crimson Nylium",
                                                                       "crimson_nylium",
                                                                       builder -> builder.setNetworkId(20));
    public static final BuilderRegister<ItemType> CRIMSON_PLANKS = gen("Crimson Planks",
                                                                       "crimson_planks",
                                                                       builder -> builder.setNetworkId(30));
    public static final BuilderRegister<ItemType> CRIMSON_PRESSURE_PLATE = gen("Crimson Pressure Plate",
                                                                               "crimson_pressure_plate",
                                                                               builder -> builder.setNetworkId(654));
    public static final BuilderRegister<ItemType> CRIMSON_ROOTS = gen("Crimson Roots",
                                                                      "crimson_roots",
                                                                      builder -> builder.setNetworkId(201));
    public static final BuilderRegister<ItemType> CRIMSON_SIGN = gen("Crimson Sign",
                                                                     "crimson_sign",
                                                                     builder -> builder
                                                                             .setNetworkId(811)
                                                                             .setStackSize(16));
    public static final BuilderRegister<ItemType> CRIMSON_SLAB = gen("Crimson Slab",
                                                                     "crimson_slab",
                                                                     builder -> builder.setNetworkId(221));
    public static final BuilderRegister<ItemType> CRIMSON_STAIRS = gen("Crimson Stairs",
                                                                       "crimson_stairs",
                                                                       builder -> builder.setNetworkId(345));
    public static final BuilderRegister<ItemType> CRIMSON_STEM = gen("Crimson Stem",
                                                                     "crimson_stem",
                                                                     builder -> builder.setNetworkId(113));
    public static final BuilderRegister<ItemType> CRIMSON_TRAPDOOR = gen("Crimson Trapdoor",
                                                                         "crimson_trapdoor",
                                                                         builder -> builder.setNetworkId(674));
    public static final BuilderRegister<ItemType> CROSSBOW = gen("Crossbow",
                                                                 "crossbow",
                                                                 builder -> builder.setNetworkId(1078).setStackSize(1));
    public static final BuilderRegister<ItemType> CRYING_OBSIDIAN = gen("Crying Obsidian",
                                                                        "crying_obsidian",
                                                                        builder -> builder.setNetworkId(1111));
    public static final BuilderRegister<ItemType> CUT_COPPER = gen("Cut Copper",
                                                                   "cut_copper",
                                                                   builder -> builder.setNetworkId(76));
    public static final BuilderRegister<ItemType> CUT_COPPER_SLAB = gen("Cut Copper Slab",
                                                                        "cut_copper_slab",
                                                                        builder -> builder.setNetworkId(84));
    public static final BuilderRegister<ItemType> CUT_COPPER_STAIRS = gen("Cut Copper Stairs",
                                                                          "cut_copper_stairs",
                                                                          builder -> builder.setNetworkId(80));
    public static final BuilderRegister<ItemType> CUT_RED_SANDSTONE = gen("Cut Red Sandstone",
                                                                          "cut_red_sandstone",
                                                                          builder -> builder.setNetworkId(464));
    public static final BuilderRegister<ItemType> CUT_RED_SANDSTONE_SLAB = gen("Cut Red Sandstone Slab",
                                                                               "cut_red_sandstone_slab",
                                                                               builder -> builder.setNetworkId(235));
    public static final BuilderRegister<ItemType> CUT_SANDSTONE = gen("Cut Sandstone",
                                                                      "cut_sandstone",
                                                                      builder -> builder.setNetworkId(158));
    public static final BuilderRegister<ItemType> CUT_SANDSTONE_SLAB = gen("Cut Sandstone Slab",
                                                                           "cut_sandstone_slab",
                                                                           builder -> builder.setNetworkId(226));
    public static final BuilderRegister<ItemType> CYAN_BANNER = gen("Cyan Banner",
                                                                    "cyan_banner",
                                                                    builder -> builder
                                                                            .setNetworkId(1034)
                                                                            .setStackSize(16));
    public static final BuilderRegister<ItemType> CYAN_BED = gen("Cyan Bed",
                                                                 "cyan_bed",
                                                                 builder -> builder.setNetworkId(878).setStackSize(1));
    public static final BuilderRegister<ItemType> CYAN_CANDLE = gen("Cyan Candle",
                                                                    "cyan_candle",
                                                                    builder -> builder.setNetworkId(1135));
    public static final BuilderRegister<ItemType> CYAN_CARPET = gen("Cyan Carpet",
                                                                    "cyan_carpet",
                                                                    builder -> builder.setNetworkId(407));
    public static final BuilderRegister<ItemType> CYAN_CONCRETE = gen("Cyan Concrete",
                                                                      "cyan_concrete",
                                                                      builder -> builder.setNetworkId(516));
    public static final BuilderRegister<ItemType> CYAN_CONCRETE_POWDER = gen("Cyan Concrete Powder",
                                                                             "cyan_concrete_powder",
                                                                             builder -> builder.setNetworkId(532));
    public static final BuilderRegister<ItemType> CYAN_DYE = gen("Cyan Dye",
                                                                 "cyan_dye",
                                                                 builder -> builder.setNetworkId(858));
    public static final BuilderRegister<ItemType> CYAN_GLAZED_TERRACOTTA = gen("Cyan Glazed Terracotta",
                                                                               "cyan_glazed_terracotta",
                                                                               builder -> builder.setNetworkId(500));
    public static final BuilderRegister<ItemType> CYAN_SHULKER_BOX = gen("Cyan Shulker Box",
                                                                         "cyan_shulker_box",
                                                                         builder -> builder
                                                                                 .setNetworkId(484)
                                                                                 .setStackSize(1));
    public static final BuilderRegister<ItemType> CYAN_STAINED_GLASS = gen("Cyan Stained Glass",
                                                                           "cyan_stained_glass",
                                                                           builder -> builder.setNetworkId(432));
    public static final BuilderRegister<ItemType> CYAN_STAINED_GLASS_PANE = gen("Cyan Stained Glass Pane",
                                                                                "cyan_stained_glass_pane",
                                                                                builder -> builder.setNetworkId(448));
    public static final BuilderRegister<ItemType> CYAN_TERRACOTTA = gen("Cyan Terracotta",
                                                                        "cyan_terracotta",
                                                                        builder -> builder.setNetworkId(388));
    public static final BuilderRegister<ItemType> CYAN_WOOL = gen("Cyan Wool",
                                                                  "cyan_wool",
                                                                  builder -> builder.setNetworkId(176));
    public static final BuilderRegister<ItemType> DAMAGED_ANVIL = gen("Damaged Anvil",
                                                                      "damaged_anvil",
                                                                      builder -> builder.setNetworkId(373));
    public static final BuilderRegister<ItemType> DANDELION = gen("Dandelion",
                                                                  "dandelion",
                                                                  builder -> builder.setNetworkId(183));
    public static final BuilderRegister<ItemType> DARK_OAK_BOAT = gen("Dark Oak Boat",
                                                                      "dark_oak_boat",
                                                                      builder -> builder
                                                                              .setNetworkId(708)
                                                                              .setStackSize(1));
    public static final BuilderRegister<ItemType> DARK_OAK_BUTTON = gen("Dark Oak Button",
                                                                        "dark_oak_button",
                                                                        builder -> builder.setNetworkId(639));
    public static final BuilderRegister<ItemType> DARK_OAK_DOOR = gen("Dark Oak Door",
                                                                      "dark_oak_door",
                                                                      builder -> builder.setNetworkId(662));
    public static final BuilderRegister<ItemType> DARK_OAK_FENCE = gen("Dark Oak Fence",
                                                                       "dark_oak_fence",
                                                                       builder -> builder.setNetworkId(273));
    public static final BuilderRegister<ItemType> DARK_OAK_FENCE_GATE = gen("Dark Oak Fence Gate",
                                                                            "dark_oak_fence_gate",
                                                                            builder -> builder.setNetworkId(681));
    public static final BuilderRegister<ItemType> DARK_OAK_LEAVES = gen("Dark Oak Leaves",
                                                                        "dark_oak_leaves",
                                                                        builder -> builder.setNetworkId(147));
    public static final BuilderRegister<ItemType> DARK_OAK_LOG = gen("Dark Oak Log",
                                                                     "dark_oak_log",
                                                                     builder -> builder.setNetworkId(109));
    public static final BuilderRegister<ItemType> DARK_OAK_PLANKS = gen("Dark Oak Planks",
                                                                        "dark_oak_planks",
                                                                        builder -> builder.setNetworkId(28));
    public static final BuilderRegister<ItemType> DARK_OAK_PRESSURE_PLATE = gen("Dark Oak Pressure Plate",
                                                                                "dark_oak_pressure_plate",
                                                                                builder -> builder.setNetworkId(652));
    public static final BuilderRegister<ItemType> DARK_OAK_SAPLING = gen("Dark Oak Sapling",
                                                                         "dark_oak_sapling",
                                                                         builder -> builder.setNetworkId(37));
    public static final BuilderRegister<ItemType> DARK_OAK_SIGN = gen("Dark Oak Sign",
                                                                      "dark_oak_sign",
                                                                      builder -> builder
                                                                              .setNetworkId(809)
                                                                              .setStackSize(16));
    public static final BuilderRegister<ItemType> DARK_OAK_SLAB = gen("Dark Oak Slab",
                                                                      "dark_oak_slab",
                                                                      builder -> builder.setNetworkId(219));
    public static final BuilderRegister<ItemType> DARK_OAK_STAIRS = gen("Dark Oak Stairs",
                                                                        "dark_oak_stairs",
                                                                        builder -> builder.setNetworkId(343));
    public static final BuilderRegister<ItemType> DARK_OAK_TRAPDOOR = gen("Dark Oak Trapdoor",
                                                                          "dark_oak_trapdoor",
                                                                          builder -> builder.setNetworkId(672));
    public static final BuilderRegister<ItemType> DARK_OAK_WOOD = gen("Dark Oak Wood",
                                                                      "dark_oak_wood",
                                                                      builder -> builder.setNetworkId(138));
    public static final BuilderRegister<ItemType> DARK_PRISMARINE = gen("Dark Prismarine",
                                                                        "dark_prismarine",
                                                                        builder -> builder.setNetworkId(457));
    public static final BuilderRegister<ItemType> DARK_PRISMARINE_SLAB = gen("Dark Prismarine Slab",
                                                                             "dark_prismarine_slab",
                                                                             builder -> builder.setNetworkId(239));
    public static final BuilderRegister<ItemType> DARK_PRISMARINE_STAIRS = gen("Dark Prismarine Stairs",
                                                                               "dark_prismarine_stairs",
                                                                               builder -> builder.setNetworkId(460));
    public static final BuilderRegister<ItemType> DAYLIGHT_DETECTOR = gen("Daylight Detector",
                                                                          "daylight_detector",
                                                                          builder -> builder.setNetworkId(625));
    public static final BuilderRegister<ItemType> DEAD_BRAIN_CORAL = gen("Dead Brain Coral",
                                                                         "dead_brain_coral",
                                                                         builder -> builder.setNetworkId(555));
    public static final BuilderRegister<ItemType> DEAD_BRAIN_CORAL_BLOCK = gen("Dead Brain Coral Block",
                                                                               "dead_brain_coral_block",
                                                                               builder -> builder.setNetworkId(541));
    public static final BuilderRegister<ItemType> DEAD_BRAIN_CORAL_FAN = gen("Dead Brain Coral Fan",
                                                                             "dead_brain_coral_fan",
                                                                             builder -> builder.setNetworkId(566));
    public static final BuilderRegister<ItemType> DEAD_BUBBLE_CORAL = gen("Dead Bubble Coral",
                                                                          "dead_bubble_coral",
                                                                          builder -> builder.setNetworkId(556));
    public static final BuilderRegister<ItemType> DEAD_BUBBLE_CORAL_BLOCK = gen("Dead Bubble Coral Block",
                                                                                "dead_bubble_coral_block",
                                                                                builder -> builder.setNetworkId(542));
    public static final BuilderRegister<ItemType> DEAD_BUBBLE_CORAL_FAN = gen("Dead Bubble Coral Fan",
                                                                              "dead_bubble_coral_fan",
                                                                              builder -> builder.setNetworkId(567));
    public static final BuilderRegister<ItemType> DEAD_BUSH = gen("Dead Bush",
                                                                  "dead_bush",
                                                                  builder -> builder.setNetworkId(164));
    public static final BuilderRegister<ItemType> DEAD_FIRE_CORAL = gen("Dead Fire Coral",
                                                                        "dead_fire_coral",
                                                                        builder -> builder.setNetworkId(557));
    public static final BuilderRegister<ItemType> DEAD_FIRE_CORAL_BLOCK = gen("Dead Fire Coral Block",
                                                                              "dead_fire_coral_block",
                                                                              builder -> builder.setNetworkId(543));
    public static final BuilderRegister<ItemType> DEAD_FIRE_CORAL_FAN = gen("Dead Fire Coral Fan",
                                                                            "dead_fire_coral_fan",
                                                                            builder -> builder.setNetworkId(568));
    public static final BuilderRegister<ItemType> DEAD_HORN_CORAL = gen("Dead Horn Coral",
                                                                        "dead_horn_coral",
                                                                        builder -> builder.setNetworkId(558));
    public static final BuilderRegister<ItemType> DEAD_HORN_CORAL_BLOCK = gen("Dead Horn Coral Block",
                                                                              "dead_horn_coral_block",
                                                                              builder -> builder.setNetworkId(544));
    public static final BuilderRegister<ItemType> DEAD_HORN_CORAL_FAN = gen("Dead Horn Coral Fan",
                                                                            "dead_horn_coral_fan",
                                                                            builder -> builder.setNetworkId(569));
    public static final BuilderRegister<ItemType> DEAD_TUBE_CORAL = gen("Dead Tube Coral",
                                                                        "dead_tube_coral",
                                                                        builder -> builder.setNetworkId(559));
    public static final BuilderRegister<ItemType> DEAD_TUBE_CORAL_BLOCK = gen("Dead Tube Coral Block",
                                                                              "dead_tube_coral_block",
                                                                              builder -> builder.setNetworkId(540));
    public static final BuilderRegister<ItemType> DEAD_TUBE_CORAL_FAN = gen("Dead Tube Coral Fan",
                                                                            "dead_tube_coral_fan",
                                                                            builder -> builder.setNetworkId(565));
    public static final BuilderRegister<ItemType> DEBUG_STICK = gen("Debug Stick",
                                                                    "debug_stick",
                                                                    builder -> builder
                                                                            .setNetworkId(1057)
                                                                            .setStackSize(1));
    public static final BuilderRegister<ItemType> DEEPSLATE = gen("Deepslate",
                                                                  "deepslate",
                                                                  builder -> builder.setNetworkId(8));
    public static final BuilderRegister<ItemType> DEEPSLATE_BRICKS = gen("Deepslate Bricks",
                                                                         "deepslate_bricks",
                                                                         builder -> builder.setNetworkId(301));
    public static final BuilderRegister<ItemType> DEEPSLATE_BRICK_SLAB = gen("Deepslate Brick Slab",
                                                                             "deepslate_brick_slab",
                                                                             builder -> builder.setNetworkId(605));
    public static final BuilderRegister<ItemType> DEEPSLATE_BRICK_STAIRS = gen("Deepslate Brick Stairs",
                                                                               "deepslate_brick_stairs",
                                                                               builder -> builder.setNetworkId(588));
    public static final BuilderRegister<ItemType> DEEPSLATE_BRICK_WALL = gen("Deepslate Brick Wall",
                                                                             "deepslate_brick_wall",
                                                                             builder -> builder.setNetworkId(369));
    public static final BuilderRegister<ItemType> DEEPSLATE_COAL_ORE = gen("Deepslate Coal Ore",
                                                                           "deepslate_coal_ore",
                                                                           builder -> builder.setNetworkId(44));
    public static final BuilderRegister<ItemType> DEEPSLATE_COPPER_ORE = gen("Deepslate Copper Ore",
                                                                             "deepslate_copper_ore",
                                                                             builder -> builder.setNetworkId(48));
    public static final BuilderRegister<ItemType> DEEPSLATE_DIAMOND_ORE = gen("Deepslate Diamond Ore",
                                                                              "deepslate_diamond_ore",
                                                                              builder -> builder.setNetworkId(58));
    public static final BuilderRegister<ItemType> DEEPSLATE_EMERALD_ORE = gen("Deepslate Emerald Ore",
                                                                              "deepslate_emerald_ore",
                                                                              builder -> builder.setNetworkId(54));
    public static final BuilderRegister<ItemType> DEEPSLATE_GOLD_ORE = gen("Deepslate Gold Ore",
                                                                           "deepslate_gold_ore",
                                                                           builder -> builder.setNetworkId(50));
    public static final BuilderRegister<ItemType> DEEPSLATE_IRON_ORE = gen("Deepslate Iron Ore",
                                                                           "deepslate_iron_ore",
                                                                           builder -> builder.setNetworkId(46));
    public static final BuilderRegister<ItemType> DEEPSLATE_LAPIS_ORE = gen("Deepslate Lapis Lazuli Ore",
                                                                            "deepslate_lapis_ore",
                                                                            builder -> builder.setNetworkId(56));
    public static final BuilderRegister<ItemType> DEEPSLATE_REDSTONE_ORE = gen("Deepslate Redstone Ore",
                                                                               "deepslate_redstone_ore",
                                                                               builder -> builder.setNetworkId(52));
    public static final BuilderRegister<ItemType> DEEPSLATE_TILES = gen("Deepslate Tiles",
                                                                        "deepslate_tiles",
                                                                        builder -> builder.setNetworkId(303));
    public static final BuilderRegister<ItemType> DEEPSLATE_TILE_SLAB = gen("Deepslate Tile Slab",
                                                                            "deepslate_tile_slab",
                                                                            builder -> builder.setNetworkId(606));
    public static final BuilderRegister<ItemType> DEEPSLATE_TILE_STAIRS = gen("Deepslate Tile Stairs",
                                                                              "deepslate_tile_stairs",
                                                                              builder -> builder.setNetworkId(589));
    public static final BuilderRegister<ItemType> DEEPSLATE_TILE_WALL = gen("Deepslate Tile Wall",
                                                                            "deepslate_tile_wall",
                                                                            builder -> builder.setNetworkId(370));
    public static final BuilderRegister<ItemType> DETECTOR_RAIL = gen("Detector Rail",
                                                                      "detector_rail",
                                                                      builder -> builder.setNetworkId(686));
    public static final BuilderRegister<ItemType> DIAMOND = gen("Diamond",
                                                                "diamond",
                                                                builder -> builder.setNetworkId(722));
    public static final BuilderRegister<ItemType> DIAMOND_AXE = gen("Diamond Axe",
                                                                    "diamond_axe",
                                                                    builder -> builder.setNetworkId(758));
    public static final BuilderRegister<ItemType> DIAMOND_BLOCK = gen("Block of Diamond",
                                                                      "diamond_block",
                                                                      builder -> builder.setNetworkId(71));
    public static final BuilderRegister<ItemType> DIAMOND_BOOTS = gen("Diamond Boots",
                                                                      "diamond_boots",
                                                                      builder -> builder.setNetworkId(789));
    public static final BuilderRegister<ItemType> DIAMOND_CHESTPLATE = gen("Diamond Chestplate",
                                                                           "diamond_chestplate",
                                                                           builder -> builder.setNetworkId(787));
    public static final BuilderRegister<ItemType> DIAMOND_HELMET = gen("Diamond Helmet",
                                                                       "diamond_helmet",
                                                                       builder -> builder.setNetworkId(786));
    public static final BuilderRegister<ItemType> DIAMOND_HOE = gen("Diamond Hoe",
                                                                    "diamond_hoe",
                                                                    builder -> builder.setNetworkId(759));
    public static final BuilderRegister<ItemType> DIAMOND_HORSE_ARMOR = gen("Diamond Horse Armor",
                                                                            "diamond_horse_armor",
                                                                            builder -> builder
                                                                                    .setNetworkId(1018)
                                                                                    .setStackSize(1));
    public static final BuilderRegister<ItemType> DIAMOND_LEGGINGS = gen("Diamond Leggings",
                                                                         "diamond_leggings",
                                                                         builder -> builder.setNetworkId(788));
    public static final BuilderRegister<ItemType> DIAMOND_ORE = gen("Diamond Ore",
                                                                    "diamond_ore",
                                                                    builder -> builder.setNetworkId(57));
    public static final BuilderRegister<ItemType> DIAMOND_PICKAXE = gen("Diamond Pickaxe",
                                                                        "diamond_pickaxe",
                                                                        builder -> builder.setNetworkId(757));
    public static final BuilderRegister<ItemType> DIAMOND_SHOVEL = gen("Diamond Shovel",
                                                                       "diamond_shovel",
                                                                       builder -> builder.setNetworkId(756));
    public static final BuilderRegister<ItemType> DIAMOND_SWORD = gen("Diamond Sword",
                                                                      "diamond_sword",
                                                                      builder -> builder.setNetworkId(755));
    public static final BuilderRegister<ItemType> DIORITE = gen("Diorite",
                                                                "diorite",
                                                                builder -> builder.setNetworkId(4));
    public static final BuilderRegister<ItemType> DIORITE_SLAB = gen("Diorite Slab",
                                                                     "diorite_slab",
                                                                     builder -> builder.setNetworkId(602));
    public static final BuilderRegister<ItemType> DIORITE_STAIRS = gen("Diorite Stairs",
                                                                       "diorite_stairs",
                                                                       builder -> builder.setNetworkId(585));
    public static final BuilderRegister<ItemType> DIORITE_WALL = gen("Diorite Wall",
                                                                     "diorite_wall",
                                                                     builder -> builder.setNetworkId(363));
    public static final BuilderRegister<ItemType> DIRT = gen("Dirt", "dirt", builder -> builder.setNetworkId(15));
    public static final BuilderRegister<ItemType> DIRT_PATH = gen("Dirt Path",
                                                                  "dirt_path",
                                                                  builder -> builder.setNetworkId(416));
    public static final BuilderRegister<ItemType> DISPENSER = gen("Dispenser",
                                                                  "dispenser",
                                                                  builder -> builder.setNetworkId(619));
    public static final BuilderRegister<ItemType> DOLPHIN_SPAWN_EGG = gen("Dolphin Spawn Egg",
                                                                          "dolphin_spawn_egg",
                                                                          builder -> builder.setNetworkId(923));
    public static final BuilderRegister<ItemType> DONKEY_SPAWN_EGG = gen("Donkey Spawn Egg",
                                                                         "donkey_spawn_egg",
                                                                         builder -> builder.setNetworkId(924));
    public static final BuilderRegister<ItemType> DRAGON_BREATH = gen("Dragon's Breath",
                                                                      "dragon_breath",
                                                                      builder -> builder.setNetworkId(1047));
    public static final BuilderRegister<ItemType> DRAGON_EGG = gen("Dragon Egg",
                                                                   "dragon_egg",
                                                                   builder -> builder.setNetworkId(334));
    public static final BuilderRegister<ItemType> DRAGON_HEAD = gen("Dragon Head",
                                                                    "dragon_head",
                                                                    builder -> builder.setNetworkId(1001));
    public static final BuilderRegister<ItemType> DRIED_KELP = gen("Dried Kelp",
                                                                   "dried_kelp",
                                                                   builder -> builder.setNetworkId(889));
    public static final BuilderRegister<ItemType> DRIED_KELP_BLOCK = gen("Dried Kelp Block",
                                                                         "dried_kelp_block",
                                                                         builder -> builder.setNetworkId(828));
    public static final BuilderRegister<ItemType> DRIPSTONE_BLOCK = gen("Dripstone Block",
                                                                        "dripstone_block",
                                                                        builder -> builder.setNetworkId(13));
    public static final BuilderRegister<ItemType> DROPPER = gen("Dropper",
                                                                "dropper",
                                                                builder -> builder.setNetworkId(620));
    public static final BuilderRegister<ItemType> DROWNED_SPAWN_EGG = gen("Drowned Spawn Egg",
                                                                          "drowned_spawn_egg",
                                                                          builder -> builder.setNetworkId(925));
    public static final BuilderRegister<ItemType> EGG = gen("Egg",
                                                            "egg",
                                                            builder -> builder.setNetworkId(832).setStackSize(16));
    public static final BuilderRegister<ItemType> ELDER_GUARDIAN_SPAWN_EGG = gen("Elder Guardian Spawn Egg",
                                                                                 "elder_guardian_spawn_egg",
                                                                                 builder -> builder.setNetworkId(926));
    public static final BuilderRegister<ItemType> ELYTRA = gen("Elytra",
                                                               "elytra",
                                                               builder -> builder.setNetworkId(697));
    public static final BuilderRegister<ItemType> EMERALD = gen("Emerald",
                                                                "emerald",
                                                                builder -> builder.setNetworkId(723));
    public static final BuilderRegister<ItemType> EMERALD_BLOCK = gen("Block of Emerald",
                                                                      "emerald_block",
                                                                      builder -> builder.setNetworkId(337));
    public static final BuilderRegister<ItemType> EMERALD_ORE = gen("Emerald Ore",
                                                                    "emerald_ore",
                                                                    builder -> builder.setNetworkId(53));
    public static final BuilderRegister<ItemType> ENCHANTED_BOOK = gen("Enchanted Book",
                                                                       "enchanted_book",
                                                                       builder -> builder
                                                                               .setNetworkId(1006)
                                                                               .setStackSize(1));
    public static final BuilderRegister<ItemType> ENCHANTED_GOLDEN_APPLE = gen("Enchanted Golden Apple",
                                                                               "enchanted_golden_apple",
                                                                               builder -> builder.setNetworkId(803));
    public static final BuilderRegister<ItemType> ENCHANTING_TABLE = gen("Enchanting Table",
                                                                         "enchanting_table",
                                                                         builder -> builder.setNetworkId(330));
    public static final BuilderRegister<ItemType> ENDERMAN_SPAWN_EGG = gen("Enderman Spawn Egg",
                                                                           "enderman_spawn_egg",
                                                                           builder -> builder.setNetworkId(927));
    public static final BuilderRegister<ItemType> ENDERMITE_SPAWN_EGG = gen("Endermite Spawn Egg",
                                                                            "endermite_spawn_egg",
                                                                            builder -> builder.setNetworkId(928));
    public static final BuilderRegister<ItemType> ENDER_CHEST = gen("Ender Chest",
                                                                    "ender_chest",
                                                                    builder -> builder.setNetworkId(336));
    public static final BuilderRegister<ItemType> ENDER_EYE = gen("Eye of Ender",
                                                                  "ender_eye",
                                                                  builder -> builder.setNetworkId(910));
    public static final BuilderRegister<ItemType> ENDER_PEARL = gen("Ender Pearl",
                                                                    "ender_pearl",
                                                                    builder -> builder
                                                                            .setNetworkId(897)
                                                                            .setStackSize(16));
    public static final BuilderRegister<ItemType> END_CRYSTAL = gen("End Crystal",
                                                                    "end_crystal",
                                                                    builder -> builder.setNetworkId(1041));
    public static final BuilderRegister<ItemType> END_PORTAL_FRAME = gen("End Portal Frame",
                                                                         "end_portal_frame",
                                                                         builder -> builder.setNetworkId(331));
    public static final BuilderRegister<ItemType> END_ROD = gen("End Rod",
                                                                "end_rod",
                                                                builder -> builder.setNetworkId(249));
    public static final BuilderRegister<ItemType> END_STONE = gen("End Stone",
                                                                  "end_stone",
                                                                  builder -> builder.setNetworkId(332));
    public static final BuilderRegister<ItemType> END_STONE_BRICKS = gen("End Stone Bricks",
                                                                         "end_stone_bricks",
                                                                         builder -> builder.setNetworkId(333));
    public static final BuilderRegister<ItemType> END_STONE_BRICK_SLAB = gen("End Stone Brick Slab",
                                                                             "end_stone_brick_slab",
                                                                             builder -> builder.setNetworkId(595));
    public static final BuilderRegister<ItemType> END_STONE_BRICK_STAIRS = gen("End Stone Brick Stairs",
                                                                               "end_stone_brick_stairs",
                                                                               builder -> builder.setNetworkId(577));
    public static final BuilderRegister<ItemType> END_STONE_BRICK_WALL = gen("End Stone Brick Wall",
                                                                             "end_stone_brick_wall",
                                                                             builder -> builder.setNetworkId(362));
    public static final BuilderRegister<ItemType> EVOKER_SPAWN_EGG = gen("Evoker Spawn Egg",
                                                                         "evoker_spawn_egg",
                                                                         builder -> builder.setNetworkId(929));
    public static final BuilderRegister<ItemType> EXPERIENCE_BOTTLE = gen("Bottle o' Enchanting",
                                                                          "experience_bottle",
                                                                          builder -> builder.setNetworkId(983));
    public static final BuilderRegister<ItemType> EXPOSED_COPPER = gen("Exposed Copper",
                                                                       "exposed_copper",
                                                                       builder -> builder.setNetworkId(73));
    public static final BuilderRegister<ItemType> EXPOSED_CUT_COPPER = gen("Exposed Cut Copper",
                                                                           "exposed_cut_copper",
                                                                           builder -> builder.setNetworkId(77));
    public static final BuilderRegister<ItemType> EXPOSED_CUT_COPPER_SLAB = gen("Exposed Cut Copper Slab",
                                                                                "exposed_cut_copper_slab",
                                                                                builder -> builder.setNetworkId(85));
    public static final BuilderRegister<ItemType> EXPOSED_CUT_COPPER_STAIRS = gen("Exposed Cut Copper Stairs",
                                                                                  "exposed_cut_copper_stairs",
                                                                                  builder -> builder.setNetworkId(81));
    public static final BuilderRegister<ItemType> FARMLAND = gen("Farmland",
                                                                 "farmland",
                                                                 builder -> builder.setNetworkId(258));
    public static final BuilderRegister<ItemType> FEATHER = gen("Feather",
                                                                "feather",
                                                                builder -> builder.setNetworkId(769));
    public static final BuilderRegister<ItemType> FERMENTED_SPIDER_EYE = gen("Fermented Spider Eye",
                                                                             "fermented_spider_eye",
                                                                             builder -> builder.setNetworkId(905));
    public static final BuilderRegister<ItemType> FERN = gen("Fern", "fern", builder -> builder.setNetworkId(161));
    public static final BuilderRegister<ItemType> FILLED_MAP = gen("Map",
                                                                   "filled_map",
                                                                   builder -> builder.setNetworkId(886));
    public static final BuilderRegister<ItemType> FIREWORK_ROCKET = gen("Firework Rocket",
                                                                        "firework_rocket",
                                                                        builder -> builder.setNetworkId(1004));
    public static final BuilderRegister<ItemType> FIREWORK_STAR = gen("Firework Star",
                                                                      "firework_star",
                                                                      builder -> builder.setNetworkId(1005));
    public static final BuilderRegister<ItemType> FIRE_CHARGE = gen("Fire Charge",
                                                                    "fire_charge",
                                                                    builder -> builder.setNetworkId(984));
    public static final BuilderRegister<ItemType> FIRE_CORAL = gen("Fire Coral",
                                                                   "fire_coral",
                                                                   builder -> builder.setNetworkId(553));
    public static final BuilderRegister<ItemType> FIRE_CORAL_BLOCK = gen("Fire Coral Block",
                                                                         "fire_coral_block",
                                                                         builder -> builder.setNetworkId(548));
    public static final BuilderRegister<ItemType> FIRE_CORAL_FAN = gen("Fire Coral Fan",
                                                                       "fire_coral_fan",
                                                                       builder -> builder.setNetworkId(563));
    public static final BuilderRegister<ItemType> FISHING_ROD = gen("Fishing Rod",
                                                                    "fishing_rod",
                                                                    builder -> builder.setNetworkId(836));
    public static final BuilderRegister<ItemType> FLETCHING_TABLE = gen("Fletching Table",
                                                                        "fletching_table",
                                                                        builder -> builder.setNetworkId(1093));
    public static final BuilderRegister<ItemType> FLINT = gen("Flint", "flint", builder -> builder.setNetworkId(798));
    public static final BuilderRegister<ItemType> FLINT_AND_STEEL = gen("Flint and Steel",
                                                                        "flint_and_steel",
                                                                        builder -> builder.setNetworkId(716));
    public static final BuilderRegister<ItemType> FLOWERING_AZALEA = gen("Flowering Azalea",
                                                                         "flowering_azalea",
                                                                         builder -> builder.setNetworkId(163));
    public static final BuilderRegister<ItemType> FLOWERING_AZALEA_LEAVES = gen("Flowering Azalea Leaves",
                                                                                "flowering_azalea_leaves",
                                                                                builder -> builder.setNetworkId(150));
    public static final BuilderRegister<ItemType> FLOWER_BANNER_PATTERN = gen("Banner Pattern",
                                                                              "flower_banner_pattern",
                                                                              builder -> builder
                                                                                      .setNetworkId(1081)
                                                                                      .setStackSize(1));
    public static final BuilderRegister<ItemType> FLOWER_POT = gen("Flower Pot",
                                                                   "flower_pot",
                                                                   builder -> builder.setNetworkId(989));
    public static final BuilderRegister<ItemType> FOX_SPAWN_EGG = gen("Fox Spawn Egg",
                                                                      "fox_spawn_egg",
                                                                      builder -> builder.setNetworkId(930));
    public static final BuilderRegister<ItemType> FURNACE = gen("Furnace",
                                                                "furnace",
                                                                builder -> builder.setNetworkId(259));
    public static final BuilderRegister<ItemType> FURNACE_MINECART = gen("Minecart with Furnace",
                                                                         "furnace_minecart",
                                                                         builder -> builder
                                                                                 .setNetworkId(692)
                                                                                 .setStackSize(1));
    public static final BuilderRegister<ItemType> GHAST_SPAWN_EGG = gen("Ghast Spawn Egg",
                                                                        "ghast_spawn_egg",
                                                                        builder -> builder.setNetworkId(932));
    public static final BuilderRegister<ItemType> GHAST_TEAR = gen("Ghast Tear",
                                                                   "ghast_tear",
                                                                   builder -> builder.setNetworkId(899));
    public static final BuilderRegister<ItemType> GILDED_BLACKSTONE = gen("Gilded Blackstone",
                                                                          "gilded_blackstone",
                                                                          builder -> builder.setNetworkId(1115));
    public static final BuilderRegister<ItemType> GLASS = gen("Glass", "glass", builder -> builder.setNetworkId(153));
    public static final BuilderRegister<ItemType> GLASS_BOTTLE = gen("Glass Bottle",
                                                                     "glass_bottle",
                                                                     builder -> builder.setNetworkId(903));
    public static final BuilderRegister<ItemType> GLASS_PANE = gen("Glass Pane",
                                                                   "glass_pane",
                                                                   builder -> builder.setNetworkId(312));
    public static final BuilderRegister<ItemType> GLISTERING_MELON_SLICE = gen("Glistering Melon Slice",
                                                                               "glistering_melon_slice",
                                                                               builder -> builder.setNetworkId(911));
    public static final BuilderRegister<ItemType> GLOBE_BANNER_PATTERN = gen("Banner Pattern",
                                                                             "globe_banner_pattern",
                                                                             builder -> builder
                                                                                     .setNetworkId(1085)
                                                                                     .setStackSize(1));
    public static final BuilderRegister<ItemType> GLOWSTONE = gen("Glowstone",
                                                                  "glowstone",
                                                                  builder -> builder.setNetworkId(287));
    public static final BuilderRegister<ItemType> GLOWSTONE_DUST = gen("Glowstone Dust",
                                                                       "glowstone_dust",
                                                                       builder -> builder.setNetworkId(839));
    public static final BuilderRegister<ItemType> GLOW_BERRIES = gen("Glow Berries",
                                                                     "glow_berries",
                                                                     builder -> builder.setNetworkId(1101));
    public static final BuilderRegister<ItemType> GLOW_INK_SAC = gen("Glow Ink Sac",
                                                                     "glow_ink_sac",
                                                                     builder -> builder.setNetworkId(847));
    public static final BuilderRegister<ItemType> GLOW_ITEM_FRAME = gen("Glow Item Frame",
                                                                        "glow_item_frame",
                                                                        builder -> builder.setNetworkId(988));
    public static final BuilderRegister<ItemType> GLOW_LICHEN = gen("Glow Lichen",
                                                                    "glow_lichen",
                                                                    builder -> builder.setNetworkId(315));
    public static final BuilderRegister<ItemType> GLOW_SQUID_SPAWN_EGG = gen("Glow Squid Spawn Egg",
                                                                             "glow_squid_spawn_egg",
                                                                             builder -> builder.setNetworkId(933));
    public static final BuilderRegister<ItemType> GOAT_SPAWN_EGG = gen("Goat Spawn Egg",
                                                                       "goat_spawn_egg",
                                                                       builder -> builder.setNetworkId(934));
    public static final BuilderRegister<ItemType> GOLDEN_APPLE = gen("Golden Apple",
                                                                     "golden_apple",
                                                                     builder -> builder.setNetworkId(802));
    public static final BuilderRegister<ItemType> GOLDEN_AXE = gen("Golden Axe",
                                                                   "golden_axe",
                                                                   builder -> builder.setNetworkId(748));
    public static final BuilderRegister<ItemType> GOLDEN_BOOTS = gen("Golden Boots",
                                                                     "golden_boots",
                                                                     builder -> builder.setNetworkId(793));
    public static final BuilderRegister<ItemType> GOLDEN_CARROT = gen("Golden Carrot",
                                                                      "golden_carrot",
                                                                      builder -> builder.setNetworkId(995));
    public static final BuilderRegister<ItemType> GOLDEN_CHESTPLATE = gen("Golden Chestplate",
                                                                          "golden_chestplate",
                                                                          builder -> builder.setNetworkId(791));
    public static final BuilderRegister<ItemType> GOLDEN_HELMET = gen("Golden Helmet",
                                                                      "golden_helmet",
                                                                      builder -> builder.setNetworkId(790));
    public static final BuilderRegister<ItemType> GOLDEN_HOE = gen("Golden Hoe",
                                                                   "golden_hoe",
                                                                   builder -> builder.setNetworkId(749));
    public static final BuilderRegister<ItemType> GOLDEN_HORSE_ARMOR = gen("Golden Horse Armor",
                                                                           "golden_horse_armor",
                                                                           builder -> builder
                                                                                   .setNetworkId(1017)
                                                                                   .setStackSize(1));
    public static final BuilderRegister<ItemType> GOLDEN_LEGGINGS = gen("Golden Leggings",
                                                                        "golden_leggings",
                                                                        builder -> builder.setNetworkId(792));
    public static final BuilderRegister<ItemType> GOLDEN_PICKAXE = gen("Golden Pickaxe",
                                                                       "golden_pickaxe",
                                                                       builder -> builder.setNetworkId(747));
    public static final BuilderRegister<ItemType> GOLDEN_SHOVEL = gen("Golden Shovel",
                                                                      "golden_shovel",
                                                                      builder -> builder.setNetworkId(746));
    public static final BuilderRegister<ItemType> GOLDEN_SWORD = gen("Golden Sword",
                                                                     "golden_sword",
                                                                     builder -> builder.setNetworkId(745));
    public static final BuilderRegister<ItemType> GOLD_BLOCK = gen("Block of Gold",
                                                                   "gold_block",
                                                                   builder -> builder.setNetworkId(70));
    public static final BuilderRegister<ItemType> GOLD_INGOT = gen("Gold Ingot",
                                                                   "gold_ingot",
                                                                   builder -> builder.setNetworkId(732));
    public static final BuilderRegister<ItemType> GOLD_NUGGET = gen("Gold Nugget",
                                                                    "gold_nugget",
                                                                    builder -> builder.setNetworkId(900));
    public static final BuilderRegister<ItemType> GOLD_ORE = gen("Gold Ore",
                                                                 "gold_ore",
                                                                 builder -> builder.setNetworkId(49));
    public static final BuilderRegister<ItemType> GRANITE = gen("Granite",
                                                                "granite",
                                                                builder -> builder.setNetworkId(2));
    public static final BuilderRegister<ItemType> GRANITE_SLAB = gen("Granite Slab",
                                                                     "granite_slab",
                                                                     builder -> builder.setNetworkId(598));
    public static final BuilderRegister<ItemType> GRANITE_STAIRS = gen("Granite Stairs",
                                                                       "granite_stairs",
                                                                       builder -> builder.setNetworkId(581));
    public static final BuilderRegister<ItemType> GRANITE_WALL = gen("Granite Wall",
                                                                     "granite_wall",
                                                                     builder -> builder.setNetworkId(355));
    public static final BuilderRegister<ItemType> GRASS = gen("Grass", "grass", builder -> builder.setNetworkId(160));
    public static final BuilderRegister<ItemType> GRASS_BLOCK = gen("Grass Block",
                                                                    "grass_block",
                                                                    builder -> builder.setNetworkId(14));
    public static final BuilderRegister<ItemType> GRAVEL = gen("Gravel", "gravel", builder -> builder.setNetworkId(42));
    public static final BuilderRegister<ItemType> GRAY_BANNER = gen("Gray Banner",
                                                                    "gray_banner",
                                                                    builder -> builder
                                                                            .setNetworkId(1032)
                                                                            .setStackSize(16));
    public static final BuilderRegister<ItemType> GRAY_BED = gen("Gray Bed",
                                                                 "gray_bed",
                                                                 builder -> builder.setNetworkId(876).setStackSize(1));
    public static final BuilderRegister<ItemType> GRAY_CANDLE = gen("Gray Candle",
                                                                    "gray_candle",
                                                                    builder -> builder.setNetworkId(1133));
    public static final BuilderRegister<ItemType> GRAY_CARPET = gen("Gray Carpet",
                                                                    "gray_carpet",
                                                                    builder -> builder.setNetworkId(405));
    public static final BuilderRegister<ItemType> GRAY_CONCRETE = gen("Gray Concrete",
                                                                      "gray_concrete",
                                                                      builder -> builder.setNetworkId(514));
    public static final BuilderRegister<ItemType> GRAY_CONCRETE_POWDER = gen("Gray Concrete Powder",
                                                                             "gray_concrete_powder",
                                                                             builder -> builder.setNetworkId(530));
    public static final BuilderRegister<ItemType> GRAY_DYE = gen("Gray Dye",
                                                                 "gray_dye",
                                                                 builder -> builder.setNetworkId(856));
    public static final BuilderRegister<ItemType> GRAY_GLAZED_TERRACOTTA = gen("Gray Glazed Terracotta",
                                                                               "gray_glazed_terracotta",
                                                                               builder -> builder.setNetworkId(498));
    public static final BuilderRegister<ItemType> GRAY_SHULKER_BOX = gen("Gray Shulker Box",
                                                                         "gray_shulker_box",
                                                                         builder -> builder
                                                                                 .setNetworkId(482)
                                                                                 .setStackSize(1));
    public static final BuilderRegister<ItemType> GRAY_STAINED_GLASS = gen("Gray Stained Glass",
                                                                           "gray_stained_glass",
                                                                           builder -> builder.setNetworkId(430));
    public static final BuilderRegister<ItemType> GRAY_STAINED_GLASS_PANE = gen("Gray Stained Glass Pane",
                                                                                "gray_stained_glass_pane",
                                                                                builder -> builder.setNetworkId(446));
    public static final BuilderRegister<ItemType> GRAY_TERRACOTTA = gen("Gray Terracotta",
                                                                        "gray_terracotta",
                                                                        builder -> builder.setNetworkId(386));
    public static final BuilderRegister<ItemType> GRAY_WOOL = gen("Gray Wool",
                                                                  "gray_wool",
                                                                  builder -> builder.setNetworkId(174));
    public static final BuilderRegister<ItemType> GREEN_BANNER = gen("Green Banner",
                                                                     "green_banner",
                                                                     builder -> builder
                                                                             .setNetworkId(1038)
                                                                             .setStackSize(16));
    public static final BuilderRegister<ItemType> GREEN_BED = gen("Green Bed",
                                                                  "green_bed",
                                                                  builder -> builder.setNetworkId(882).setStackSize(1));
    public static final BuilderRegister<ItemType> GREEN_CANDLE = gen("Green Candle",
                                                                     "green_candle",
                                                                     builder -> builder.setNetworkId(1139));
    public static final BuilderRegister<ItemType> GREEN_CARPET = gen("Green Carpet",
                                                                     "green_carpet",
                                                                     builder -> builder.setNetworkId(411));
    public static final BuilderRegister<ItemType> GREEN_CONCRETE = gen("Green Concrete",
                                                                       "green_concrete",
                                                                       builder -> builder.setNetworkId(520));
    public static final BuilderRegister<ItemType> GREEN_CONCRETE_POWDER = gen("Green Concrete Powder",
                                                                              "green_concrete_powder",
                                                                              builder -> builder.setNetworkId(536));
    public static final BuilderRegister<ItemType> GREEN_DYE = gen("Green Dye",
                                                                  "green_dye",
                                                                  builder -> builder.setNetworkId(862));
    public static final BuilderRegister<ItemType> GREEN_GLAZED_TERRACOTTA = gen("Green Glazed Terracotta",
                                                                                "green_glazed_terracotta",
                                                                                builder -> builder.setNetworkId(504));
    public static final BuilderRegister<ItemType> GREEN_SHULKER_BOX = gen("Green Shulker Box",
                                                                          "green_shulker_box",
                                                                          builder -> builder
                                                                                  .setNetworkId(488)
                                                                                  .setStackSize(1));
    public static final BuilderRegister<ItemType> GREEN_STAINED_GLASS = gen("Green Stained Glass",
                                                                            "green_stained_glass",
                                                                            builder -> builder.setNetworkId(436));
    public static final BuilderRegister<ItemType> GREEN_STAINED_GLASS_PANE = gen("Green Stained Glass Pane",
                                                                                 "green_stained_glass_pane",
                                                                                 builder -> builder.setNetworkId(452));
    public static final BuilderRegister<ItemType> GREEN_TERRACOTTA = gen("Green Terracotta",
                                                                         "green_terracotta",
                                                                         builder -> builder.setNetworkId(392));
    public static final BuilderRegister<ItemType> GREEN_WOOL = gen("Green Wool",
                                                                   "green_wool",
                                                                   builder -> builder.setNetworkId(180));
    public static final BuilderRegister<ItemType> GRINDSTONE = gen("Grindstone",
                                                                   "grindstone",
                                                                   builder -> builder.setNetworkId(1094));
    public static final BuilderRegister<ItemType> GUARDIAN_SPAWN_EGG = gen("Guardian Spawn Egg",
                                                                           "guardian_spawn_egg",
                                                                           builder -> builder.setNetworkId(935));
    public static final BuilderRegister<ItemType> GUNPOWDER = gen("Gunpowder",
                                                                  "gunpowder",
                                                                  builder -> builder.setNetworkId(770));
    public static final BuilderRegister<ItemType> HANGING_ROOTS = gen("Hanging Roots",
                                                                      "hanging_roots",
                                                                      builder -> builder.setNetworkId(210));
    public static final BuilderRegister<ItemType> HAY_BLOCK = gen("Hay Bale",
                                                                  "hay_block",
                                                                  builder -> builder.setNetworkId(397));
    public static final BuilderRegister<ItemType> HEART_OF_THE_SEA = gen("Heart of the Sea",
                                                                         "heart_of_the_sea",
                                                                         builder -> builder.setNetworkId(1077));
    public static final BuilderRegister<ItemType> HEAVY_WEIGHTED_PRESSURE_PLATE = gen("Heavy Weighted Pressure Plate",
                                                                                      "heavy_weighted_pressure_plate",
                                                                                      builder -> builder.setNetworkId(
                                                                                              646));
    public static final BuilderRegister<ItemType> HOGLIN_SPAWN_EGG = gen("Hoglin Spawn Egg",
                                                                         "hoglin_spawn_egg",
                                                                         builder -> builder.setNetworkId(936));
    public static final BuilderRegister<ItemType> HONEYCOMB = gen("Honeycomb",
                                                                  "honeycomb",
                                                                  builder -> builder.setNetworkId(1105));
    public static final BuilderRegister<ItemType> HONEYCOMB_BLOCK = gen("Honeycomb Block",
                                                                        "honeycomb_block",
                                                                        builder -> builder.setNetworkId(1109));
    public static final BuilderRegister<ItemType> HONEY_BLOCK = gen("Honey Block",
                                                                    "honey_block",
                                                                    builder -> builder.setNetworkId(616));
    public static final BuilderRegister<ItemType> HONEY_BOTTLE = gen("Honey Bottle",
                                                                     "honey_bottle",
                                                                     builder -> builder
                                                                             .setNetworkId(1108)
                                                                             .setStackSize(16));
    public static final BuilderRegister<ItemType> HOPPER = gen("Hopper",
                                                               "hopper",
                                                               builder -> builder.setNetworkId(618));
    public static final BuilderRegister<ItemType> HOPPER_MINECART = gen("Minecart with Hopper",
                                                                        "hopper_minecart",
                                                                        builder -> builder
                                                                                .setNetworkId(694)
                                                                                .setStackSize(1));
    public static final BuilderRegister<ItemType> HORN_CORAL = gen("Horn Coral",
                                                                   "horn_coral",
                                                                   builder -> builder.setNetworkId(554));
    public static final BuilderRegister<ItemType> HORN_CORAL_BLOCK = gen("Horn Coral Block",
                                                                         "horn_coral_block",
                                                                         builder -> builder.setNetworkId(549));
    public static final BuilderRegister<ItemType> HORN_CORAL_FAN = gen("Horn Coral Fan",
                                                                       "horn_coral_fan",
                                                                       builder -> builder.setNetworkId(564));
    public static final BuilderRegister<ItemType> HORSE_SPAWN_EGG = gen("Horse Spawn Egg",
                                                                        "horse_spawn_egg",
                                                                        builder -> builder.setNetworkId(937));
    public static final BuilderRegister<ItemType> HUSK_SPAWN_EGG = gen("Husk Spawn Egg",
                                                                       "husk_spawn_egg",
                                                                       builder -> builder.setNetworkId(938));
    public static final BuilderRegister<ItemType> ICE = gen("Ice", "ice", builder -> builder.setNetworkId(263));
    public static final BuilderRegister<ItemType> INFESTED_CHISELED_STONE_BRICKS = gen("Infested Chiseled Stone Bricks",
                                                                                       "infested_chiseled_stone_bricks",
                                                                                       builder -> builder.setNetworkId(
                                                                                               293));
    public static final BuilderRegister<ItemType> INFESTED_COBBLESTONE = gen("Infested Cobblestone",
                                                                             "infested_cobblestone",
                                                                             builder -> builder.setNetworkId(289));
    public static final BuilderRegister<ItemType> INFESTED_CRACKED_STONE_BRICKS = gen("Infested Cracked Stone Bricks",
                                                                                      "infested_cracked_stone_bricks",
                                                                                      builder -> builder.setNetworkId(
                                                                                              292));
    public static final BuilderRegister<ItemType> INFESTED_DEEPSLATE = gen("Infested Deepslate",
                                                                           "infested_deepslate",
                                                                           builder -> builder.setNetworkId(294));
    public static final BuilderRegister<ItemType> INFESTED_MOSSY_STONE_BRICKS = gen("Infested Mossy Stone Bricks",
                                                                                    "infested_mossy_stone_bricks",
                                                                                    builder -> builder.setNetworkId(291));
    public static final BuilderRegister<ItemType> INFESTED_STONE = gen("Infested Stone",
                                                                       "infested_stone",
                                                                       builder -> builder.setNetworkId(288));
    public static final BuilderRegister<ItemType> INFESTED_STONE_BRICKS = gen("Infested Stone Bricks",
                                                                              "infested_stone_bricks",
                                                                              builder -> builder.setNetworkId(290));
    public static final BuilderRegister<ItemType> INK_SAC = gen("Ink Sac",
                                                                "ink_sac",
                                                                builder -> builder.setNetworkId(846));
    public static final BuilderRegister<ItemType> IRON_AXE = gen("Iron Axe",
                                                                 "iron_axe",
                                                                 builder -> builder.setNetworkId(753));
    public static final BuilderRegister<ItemType> IRON_BARS = gen("Iron Bars",
                                                                  "iron_bars",
                                                                  builder -> builder.setNetworkId(310));
    public static final BuilderRegister<ItemType> IRON_BLOCK = gen("Block of Iron",
                                                                   "iron_block",
                                                                   builder -> builder.setNetworkId(68));
    public static final BuilderRegister<ItemType> IRON_BOOTS = gen("Iron Boots",
                                                                   "iron_boots",
                                                                   builder -> builder.setNetworkId(785));
    public static final BuilderRegister<ItemType> IRON_CHESTPLATE = gen("Iron Chestplate",
                                                                        "iron_chestplate",
                                                                        builder -> builder.setNetworkId(783));
    public static final BuilderRegister<ItemType> IRON_DOOR = gen("Iron Door",
                                                                  "iron_door",
                                                                  builder -> builder.setNetworkId(656));
    public static final BuilderRegister<ItemType> IRON_HELMET = gen("Iron Helmet",
                                                                    "iron_helmet",
                                                                    builder -> builder.setNetworkId(782));
    public static final BuilderRegister<ItemType> IRON_HOE = gen("Iron Hoe",
                                                                 "iron_hoe",
                                                                 builder -> builder.setNetworkId(754));
    public static final BuilderRegister<ItemType> IRON_HORSE_ARMOR = gen("Iron Horse Armor",
                                                                         "iron_horse_armor",
                                                                         builder -> builder
                                                                                 .setNetworkId(1016)
                                                                                 .setStackSize(1));
    public static final BuilderRegister<ItemType> IRON_INGOT = gen("Iron Ingot",
                                                                   "iron_ingot",
                                                                   builder -> builder.setNetworkId(728));
    public static final BuilderRegister<ItemType> IRON_LEGGINGS = gen("Iron Leggings",
                                                                      "iron_leggings",
                                                                      builder -> builder.setNetworkId(784));
    public static final BuilderRegister<ItemType> IRON_NUGGET = gen("Iron Nugget",
                                                                    "iron_nugget",
                                                                    builder -> builder.setNetworkId(1055));
    public static final BuilderRegister<ItemType> IRON_ORE = gen("Iron Ore",
                                                                 "iron_ore",
                                                                 builder -> builder.setNetworkId(45));
    public static final BuilderRegister<ItemType> IRON_PICKAXE = gen("Iron Pickaxe",
                                                                     "iron_pickaxe",
                                                                     builder -> builder.setNetworkId(752));
    public static final BuilderRegister<ItemType> IRON_SHOVEL = gen("Iron Shovel",
                                                                    "iron_shovel",
                                                                    builder -> builder.setNetworkId(751));
    public static final BuilderRegister<ItemType> IRON_SWORD = gen("Iron Sword",
                                                                   "iron_sword",
                                                                   builder -> builder.setNetworkId(750));
    public static final BuilderRegister<ItemType> IRON_TRAPDOOR = gen("Iron Trapdoor",
                                                                      "iron_trapdoor",
                                                                      builder -> builder.setNetworkId(666));
    public static final BuilderRegister<ItemType> ITEM_FRAME = gen("Item Frame",
                                                                   "item_frame",
                                                                   builder -> builder.setNetworkId(987));
    public static final BuilderRegister<ItemType> JACK_O_LANTERN = gen("Jack o'Lantern",
                                                                       "jack_o_lantern",
                                                                       builder -> builder.setNetworkId(279));
    public static final BuilderRegister<ItemType> JIGSAW = gen("Jigsaw Block",
                                                               "jigsaw",
                                                               builder -> builder.setNetworkId(713));
    public static final BuilderRegister<ItemType> JUKEBOX = gen("Jukebox",
                                                                "jukebox",
                                                                builder -> builder.setNetworkId(267));
    public static final BuilderRegister<ItemType> JUNGLE_BOAT = gen("Jungle Boat",
                                                                    "jungle_boat",
                                                                    builder -> builder
                                                                            .setNetworkId(704)
                                                                            .setStackSize(1));
    public static final BuilderRegister<ItemType> JUNGLE_BUTTON = gen("Jungle Button",
                                                                      "jungle_button",
                                                                      builder -> builder.setNetworkId(637));
    public static final BuilderRegister<ItemType> JUNGLE_DOOR = gen("Jungle Door",
                                                                    "jungle_door",
                                                                    builder -> builder.setNetworkId(660));
    public static final BuilderRegister<ItemType> JUNGLE_FENCE = gen("Jungle Fence",
                                                                     "jungle_fence",
                                                                     builder -> builder.setNetworkId(271));
    public static final BuilderRegister<ItemType> JUNGLE_FENCE_GATE = gen("Jungle Fence Gate",
                                                                          "jungle_fence_gate",
                                                                          builder -> builder.setNetworkId(679));
    public static final BuilderRegister<ItemType> JUNGLE_LEAVES = gen("Jungle Leaves",
                                                                      "jungle_leaves",
                                                                      builder -> builder.setNetworkId(145));
    public static final BuilderRegister<ItemType> JUNGLE_LOG = gen("Jungle Log",
                                                                   "jungle_log",
                                                                   builder -> builder.setNetworkId(107));
    public static final BuilderRegister<ItemType> JUNGLE_PLANKS = gen("Jungle Planks",
                                                                      "jungle_planks",
                                                                      builder -> builder.setNetworkId(26));
    public static final BuilderRegister<ItemType> JUNGLE_PRESSURE_PLATE = gen("Jungle Pressure Plate",
                                                                              "jungle_pressure_plate",
                                                                              builder -> builder.setNetworkId(650));
    public static final BuilderRegister<ItemType> JUNGLE_SAPLING = gen("Jungle Sapling",
                                                                       "jungle_sapling",
                                                                       builder -> builder.setNetworkId(35));
    public static final BuilderRegister<ItemType> JUNGLE_SIGN = gen("Jungle Sign",
                                                                    "jungle_sign",
                                                                    builder -> builder
                                                                            .setNetworkId(807)
                                                                            .setStackSize(16));
    public static final BuilderRegister<ItemType> JUNGLE_SLAB = gen("Jungle Slab",
                                                                    "jungle_slab",
                                                                    builder -> builder.setNetworkId(217));
    public static final BuilderRegister<ItemType> JUNGLE_STAIRS = gen("Jungle Stairs",
                                                                      "jungle_stairs",
                                                                      builder -> builder.setNetworkId(341));
    public static final BuilderRegister<ItemType> JUNGLE_TRAPDOOR = gen("Jungle Trapdoor",
                                                                        "jungle_trapdoor",
                                                                        builder -> builder.setNetworkId(670));
    public static final BuilderRegister<ItemType> JUNGLE_WOOD = gen("Jungle Wood",
                                                                    "jungle_wood",
                                                                    builder -> builder.setNetworkId(136));
    public static final BuilderRegister<ItemType> KELP = gen("Kelp", "kelp", builder -> builder.setNetworkId(207));
    public static final BuilderRegister<ItemType> KNOWLEDGE_BOOK = gen("Knowledge Book",
                                                                       "knowledge_book",
                                                                       builder -> builder
                                                                               .setNetworkId(1056)
                                                                               .setStackSize(1));
    public static final BuilderRegister<ItemType> LADDER = gen("Ladder",
                                                               "ladder",
                                                               builder -> builder.setNetworkId(260));
    public static final BuilderRegister<ItemType> LANTERN = gen("Lantern",
                                                                "lantern",
                                                                builder -> builder.setNetworkId(1098));
    public static final BuilderRegister<ItemType> LAPIS_BLOCK = gen("Block of Lapis Lazuli",
                                                                    "lapis_block",
                                                                    builder -> builder.setNetworkId(155));
    public static final BuilderRegister<ItemType> LAPIS_LAZULI = gen("Lapis Lazuli",
                                                                     "lapis_lazuli",
                                                                     builder -> builder.setNetworkId(724));
    public static final BuilderRegister<ItemType> LAPIS_ORE = gen("Lapis Lazuli Ore",
                                                                  "lapis_ore",
                                                                  builder -> builder.setNetworkId(55));
    public static final BuilderRegister<ItemType> LARGE_AMETHYST_BUD = gen("Large Amethyst Bud",
                                                                           "large_amethyst_bud",
                                                                           builder -> builder.setNetworkId(1144));
    public static final BuilderRegister<ItemType> LARGE_FERN = gen("Large Fern",
                                                                   "large_fern",
                                                                   builder -> builder.setNetworkId(422));
    public static final BuilderRegister<ItemType> LAVA_BUCKET = gen("Lava Bucket",
                                                                    "lava_bucket",
                                                                    builder -> builder
                                                                            .setNetworkId(815)
                                                                            .setStackSize(1));
    public static final BuilderRegister<ItemType> LEAD = gen("Lead", "lead", builder -> builder.setNetworkId(1020));
    public static final BuilderRegister<ItemType> LEATHER = gen("Leather",
                                                                "leather",
                                                                builder -> builder.setNetworkId(818));
    public static final BuilderRegister<ItemType> LEATHER_BOOTS = gen("Leather Boots",
                                                                      "leather_boots",
                                                                      builder -> builder.setNetworkId(777));
    public static final BuilderRegister<ItemType> LEATHER_CHESTPLATE = gen("Leather Tunic",
                                                                           "leather_chestplate",
                                                                           builder -> builder.setNetworkId(775));
    public static final BuilderRegister<ItemType> LEATHER_HELMET = gen("Leather Cap",
                                                                       "leather_helmet",
                                                                       builder -> builder.setNetworkId(774));
    public static final BuilderRegister<ItemType> LEATHER_HORSE_ARMOR = gen("Leather Horse Armor",
                                                                            "leather_horse_armor",
                                                                            builder -> builder
                                                                                    .setNetworkId(1019)
                                                                                    .setStackSize(1));
    public static final BuilderRegister<ItemType> LEATHER_LEGGINGS = gen("Leather Pants",
                                                                         "leather_leggings",
                                                                         builder -> builder.setNetworkId(776));
    public static final BuilderRegister<ItemType> LECTERN = gen("Lectern",
                                                                "lectern",
                                                                builder -> builder.setNetworkId(621));
    public static final BuilderRegister<ItemType> LEVER = gen("Lever", "lever", builder -> builder.setNetworkId(623));
    public static final BuilderRegister<ItemType> LIGHT = gen("Light", "light", builder -> builder.setNetworkId(396));
    public static final BuilderRegister<ItemType> LIGHTNING_ROD = gen("Lightning Rod",
                                                                      "lightning_rod",
                                                                      builder -> builder.setNetworkId(624));
    public static final BuilderRegister<ItemType> LIGHT_BLUE_BANNER = gen("Light Blue Banner",
                                                                          "light_blue_banner",
                                                                          builder -> builder
                                                                                  .setNetworkId(1028)
                                                                                  .setStackSize(16));
    public static final BuilderRegister<ItemType> LIGHT_BLUE_BED = gen("Light Blue Bed",
                                                                       "light_blue_bed",
                                                                       builder -> builder
                                                                               .setNetworkId(872)
                                                                               .setStackSize(1));
    public static final BuilderRegister<ItemType> LIGHT_BLUE_CANDLE = gen("Light Blue Candle",
                                                                          "light_blue_candle",
                                                                          builder -> builder.setNetworkId(1129));
    public static final BuilderRegister<ItemType> LIGHT_BLUE_CARPET = gen("Light Blue Carpet",
                                                                          "light_blue_carpet",
                                                                          builder -> builder.setNetworkId(401));
    public static final BuilderRegister<ItemType> LIGHT_BLUE_CONCRETE = gen("Light Blue Concrete",
                                                                            "light_blue_concrete",
                                                                            builder -> builder.setNetworkId(510));
    public static final BuilderRegister<ItemType> LIGHT_BLUE_CONCRETE_POWDER = gen("Light Blue Concrete Powder",
                                                                                   "light_blue_concrete_powder",
                                                                                   builder -> builder.setNetworkId(526));
    public static final BuilderRegister<ItemType> LIGHT_BLUE_DYE = gen("Light Blue Dye",
                                                                       "light_blue_dye",
                                                                       builder -> builder.setNetworkId(852));
    public static final BuilderRegister<ItemType> LIGHT_BLUE_GLAZED_TERRACOTTA = gen("Light Blue Glazed Terracotta",
                                                                                     "light_blue_glazed_terracotta",
                                                                                     builder -> builder.setNetworkId(494));
    public static final BuilderRegister<ItemType> LIGHT_BLUE_SHULKER_BOX = gen("Light Blue Shulker Box",
                                                                               "light_blue_shulker_box",
                                                                               builder -> builder
                                                                                       .setNetworkId(478)
                                                                                       .setStackSize(1));
    public static final BuilderRegister<ItemType> LIGHT_BLUE_STAINED_GLASS = gen("Light Blue Stained Glass",
                                                                                 "light_blue_stained_glass",
                                                                                 builder -> builder.setNetworkId(426));
    public static final BuilderRegister<ItemType> LIGHT_BLUE_STAINED_GLASS_PANE = gen("Light Blue Stained Glass Pane",
                                                                                      "light_blue_stained_glass_pane",
                                                                                      builder -> builder.setNetworkId(
                                                                                              442));
    public static final BuilderRegister<ItemType> LIGHT_BLUE_TERRACOTTA = gen("Light Blue Terracotta",
                                                                              "light_blue_terracotta",
                                                                              builder -> builder.setNetworkId(382));
    public static final BuilderRegister<ItemType> LIGHT_BLUE_WOOL = gen("Light Blue Wool",
                                                                        "light_blue_wool",
                                                                        builder -> builder.setNetworkId(170));
    public static final BuilderRegister<ItemType> LIGHT_GRAY_BANNER = gen("Light Gray Banner",
                                                                          "light_gray_banner",
                                                                          builder -> builder
                                                                                  .setNetworkId(1033)
                                                                                  .setStackSize(16));
    public static final BuilderRegister<ItemType> LIGHT_GRAY_BED = gen("Light Gray Bed",
                                                                       "light_gray_bed",
                                                                       builder -> builder
                                                                               .setNetworkId(877)
                                                                               .setStackSize(1));
    public static final BuilderRegister<ItemType> LIGHT_GRAY_CANDLE = gen("Light Gray Candle",
                                                                          "light_gray_candle",
                                                                          builder -> builder.setNetworkId(1134));
    public static final BuilderRegister<ItemType> LIGHT_GRAY_CARPET = gen("Light Gray Carpet",
                                                                          "light_gray_carpet",
                                                                          builder -> builder.setNetworkId(406));
    public static final BuilderRegister<ItemType> LIGHT_GRAY_CONCRETE = gen("Light Gray Concrete",
                                                                            "light_gray_concrete",
                                                                            builder -> builder.setNetworkId(515));
    public static final BuilderRegister<ItemType> LIGHT_GRAY_CONCRETE_POWDER = gen("Light Gray Concrete Powder",
                                                                                   "light_gray_concrete_powder",
                                                                                   builder -> builder.setNetworkId(531));
    public static final BuilderRegister<ItemType> LIGHT_GRAY_DYE = gen("Light Gray Dye",
                                                                       "light_gray_dye",
                                                                       builder -> builder.setNetworkId(857));
    public static final BuilderRegister<ItemType> LIGHT_GRAY_GLAZED_TERRACOTTA = gen("Light Gray Glazed Terracotta",
                                                                                     "light_gray_glazed_terracotta",
                                                                                     builder -> builder.setNetworkId(499));
    public static final BuilderRegister<ItemType> LIGHT_GRAY_SHULKER_BOX = gen("Light Gray Shulker Box",
                                                                               "light_gray_shulker_box",
                                                                               builder -> builder
                                                                                       .setNetworkId(483)
                                                                                       .setStackSize(1));
    public static final BuilderRegister<ItemType> LIGHT_GRAY_STAINED_GLASS = gen("Light Gray Stained Glass",
                                                                                 "light_gray_stained_glass",
                                                                                 builder -> builder.setNetworkId(431));
    public static final BuilderRegister<ItemType> LIGHT_GRAY_STAINED_GLASS_PANE = gen("Light Gray Stained Glass Pane",
                                                                                      "light_gray_stained_glass_pane",
                                                                                      builder -> builder.setNetworkId(
                                                                                              447));
    public static final BuilderRegister<ItemType> LIGHT_GRAY_TERRACOTTA = gen("Light Gray Terracotta",
                                                                              "light_gray_terracotta",
                                                                              builder -> builder.setNetworkId(387));
    public static final BuilderRegister<ItemType> LIGHT_GRAY_WOOL = gen("Light Gray Wool",
                                                                        "light_gray_wool",
                                                                        builder -> builder.setNetworkId(175));
    public static final BuilderRegister<ItemType> LIGHT_WEIGHTED_PRESSURE_PLATE = gen("Light Weighted Pressure Plate",
                                                                                      "light_weighted_pressure_plate",
                                                                                      builder -> builder.setNetworkId(
                                                                                              645));
    public static final BuilderRegister<ItemType> LILAC = gen("Lilac", "lilac", builder -> builder.setNetworkId(418));
    public static final BuilderRegister<ItemType> LILY_OF_THE_VALLEY = gen("Lily of the Valley",
                                                                           "lily_of_the_valley",
                                                                           builder -> builder.setNetworkId(194));
    public static final BuilderRegister<ItemType> LILY_PAD = gen("Lily Pad",
                                                                 "lily_pad",
                                                                 builder -> builder.setNetworkId(320));
    public static final BuilderRegister<ItemType> LIME_BANNER = gen("Lime Banner",
                                                                    "lime_banner",
                                                                    builder -> builder
                                                                            .setNetworkId(1030)
                                                                            .setStackSize(16));
    public static final BuilderRegister<ItemType> LIME_BED = gen("Lime Bed",
                                                                 "lime_bed",
                                                                 builder -> builder.setNetworkId(874).setStackSize(1));
    public static final BuilderRegister<ItemType> LIME_CANDLE = gen("Lime Candle",
                                                                    "lime_candle",
                                                                    builder -> builder.setNetworkId(1131));
    public static final BuilderRegister<ItemType> LIME_CARPET = gen("Lime Carpet",
                                                                    "lime_carpet",
                                                                    builder -> builder.setNetworkId(403));
    public static final BuilderRegister<ItemType> LIME_CONCRETE = gen("Lime Concrete",
                                                                      "lime_concrete",
                                                                      builder -> builder.setNetworkId(512));
    public static final BuilderRegister<ItemType> LIME_CONCRETE_POWDER = gen("Lime Concrete Powder",
                                                                             "lime_concrete_powder",
                                                                             builder -> builder.setNetworkId(528));
    public static final BuilderRegister<ItemType> LIME_DYE = gen("Lime Dye",
                                                                 "lime_dye",
                                                                 builder -> builder.setNetworkId(854));
    public static final BuilderRegister<ItemType> LIME_GLAZED_TERRACOTTA = gen("Lime Glazed Terracotta",
                                                                               "lime_glazed_terracotta",
                                                                               builder -> builder.setNetworkId(496));
    public static final BuilderRegister<ItemType> LIME_SHULKER_BOX = gen("Lime Shulker Box",
                                                                         "lime_shulker_box",
                                                                         builder -> builder
                                                                                 .setNetworkId(480)
                                                                                 .setStackSize(1));
    public static final BuilderRegister<ItemType> LIME_STAINED_GLASS = gen("Lime Stained Glass",
                                                                           "lime_stained_glass",
                                                                           builder -> builder.setNetworkId(428));
    public static final BuilderRegister<ItemType> LIME_STAINED_GLASS_PANE = gen("Lime Stained Glass Pane",
                                                                                "lime_stained_glass_pane",
                                                                                builder -> builder.setNetworkId(444));
    public static final BuilderRegister<ItemType> LIME_TERRACOTTA = gen("Lime Terracotta",
                                                                        "lime_terracotta",
                                                                        builder -> builder.setNetworkId(384));
    public static final BuilderRegister<ItemType> LIME_WOOL = gen("Lime Wool",
                                                                  "lime_wool",
                                                                  builder -> builder.setNetworkId(172));
    public static final BuilderRegister<ItemType> LINGERING_POTION = gen("Lingering Potion",
                                                                         "lingering_potion",
                                                                         builder -> builder
                                                                                 .setNetworkId(1051)
                                                                                 .setStackSize(1));
    public static final BuilderRegister<ItemType> LLAMA_SPAWN_EGG = gen("Llama Spawn Egg",
                                                                        "llama_spawn_egg",
                                                                        builder -> builder.setNetworkId(939));
    public static final BuilderRegister<ItemType> LODESTONE = gen("Lodestone",
                                                                  "lodestone",
                                                                  builder -> builder.setNetworkId(1110));
    public static final BuilderRegister<ItemType> LOOM = gen("Loom", "loom", builder -> builder.setNetworkId(1080));
    public static final BuilderRegister<ItemType> MAGENTA_BANNER = gen("Magenta Banner",
                                                                       "magenta_banner",
                                                                       builder -> builder
                                                                               .setNetworkId(1027)
                                                                               .setStackSize(16));
    public static final BuilderRegister<ItemType> MAGENTA_BED = gen("Magenta Bed",
                                                                    "magenta_bed",
                                                                    builder -> builder
                                                                            .setNetworkId(871)
                                                                            .setStackSize(1));
    public static final BuilderRegister<ItemType> MAGENTA_CANDLE = gen("Magenta Candle",
                                                                       "magenta_candle",
                                                                       builder -> builder.setNetworkId(1128));
    public static final BuilderRegister<ItemType> MAGENTA_CARPET = gen("Magenta Carpet",
                                                                       "magenta_carpet",
                                                                       builder -> builder.setNetworkId(400));
    public static final BuilderRegister<ItemType> MAGENTA_CONCRETE = gen("Magenta Concrete",
                                                                         "magenta_concrete",
                                                                         builder -> builder.setNetworkId(509));
    public static final BuilderRegister<ItemType> MAGENTA_CONCRETE_POWDER = gen("Magenta Concrete Powder",
                                                                                "magenta_concrete_powder",
                                                                                builder -> builder.setNetworkId(525));
    public static final BuilderRegister<ItemType> MAGENTA_DYE = gen("Magenta Dye",
                                                                    "magenta_dye",
                                                                    builder -> builder.setNetworkId(851));
    public static final BuilderRegister<ItemType> MAGENTA_GLAZED_TERRACOTTA = gen("Magenta Glazed Terracotta",
                                                                                  "magenta_glazed_terracotta",
                                                                                  builder -> builder.setNetworkId(493));
    public static final BuilderRegister<ItemType> MAGENTA_SHULKER_BOX = gen("Magenta Shulker Box",
                                                                            "magenta_shulker_box",
                                                                            builder -> builder
                                                                                    .setNetworkId(477)
                                                                                    .setStackSize(1));
    public static final BuilderRegister<ItemType> MAGENTA_STAINED_GLASS = gen("Magenta Stained Glass",
                                                                              "magenta_stained_glass",
                                                                              builder -> builder.setNetworkId(425));
    public static final BuilderRegister<ItemType> MAGENTA_STAINED_GLASS_PANE = gen("Magenta Stained Glass Pane",
                                                                                   "magenta_stained_glass_pane",
                                                                                   builder -> builder.setNetworkId(441));
    public static final BuilderRegister<ItemType> MAGENTA_TERRACOTTA = gen("Magenta Terracotta",
                                                                           "magenta_terracotta",
                                                                           builder -> builder.setNetworkId(381));
    public static final BuilderRegister<ItemType> MAGENTA_WOOL = gen("Magenta Wool",
                                                                     "magenta_wool",
                                                                     builder -> builder.setNetworkId(169));
    public static final BuilderRegister<ItemType> MAGMA_BLOCK = gen("Magma Block",
                                                                    "magma_block",
                                                                    builder -> builder.setNetworkId(468));
    public static final BuilderRegister<ItemType> MAGMA_CREAM = gen("Magma Cream",
                                                                    "magma_cream",
                                                                    builder -> builder.setNetworkId(907));
    public static final BuilderRegister<ItemType> MAGMA_CUBE_SPAWN_EGG = gen("Magma Cube Spawn Egg",
                                                                             "magma_cube_spawn_egg",
                                                                             builder -> builder.setNetworkId(940));
    public static final BuilderRegister<ItemType> MAP = gen("Empty Map", "map", builder -> builder.setNetworkId(994));
    public static final BuilderRegister<ItemType> MEDIUM_AMETHYST_BUD = gen("Medium Amethyst Bud",
                                                                            "medium_amethyst_bud",
                                                                            builder -> builder.setNetworkId(1143));
    public static final BuilderRegister<ItemType> MELON = gen("Melon", "melon", builder -> builder.setNetworkId(313));
    public static final BuilderRegister<ItemType> MELON_SEEDS = gen("Melon Seeds",
                                                                    "melon_seeds",
                                                                    builder -> builder.setNetworkId(891));
    public static final BuilderRegister<ItemType> MELON_SLICE = gen("Melon Slice",
                                                                    "melon_slice",
                                                                    builder -> builder.setNetworkId(888));
    public static final BuilderRegister<ItemType> MILK_BUCKET = gen("Milk Bucket",
                                                                    "milk_bucket",
                                                                    builder -> builder
                                                                            .setNetworkId(819)
                                                                            .setStackSize(1));
    public static final BuilderRegister<ItemType> MINECART = gen("Minecart",
                                                                 "minecart",
                                                                 builder -> builder.setNetworkId(690).setStackSize(1));
    public static final BuilderRegister<ItemType> MOJANG_BANNER_PATTERN = gen("Banner Pattern",
                                                                              "mojang_banner_pattern",
                                                                              builder -> builder
                                                                                      .setNetworkId(1084)
                                                                                      .setStackSize(1));
    public static final BuilderRegister<ItemType> MOOSHROOM_SPAWN_EGG = gen("Mooshroom Spawn Egg",
                                                                            "mooshroom_spawn_egg",
                                                                            builder -> builder.setNetworkId(941));
    public static final BuilderRegister<ItemType> MOSSY_COBBLESTONE = gen("Mossy Cobblestone",
                                                                          "mossy_cobblestone",
                                                                          builder -> builder.setNetworkId(246));
    public static final BuilderRegister<ItemType> MOSSY_COBBLESTONE_SLAB = gen("Mossy Cobblestone Slab",
                                                                               "mossy_cobblestone_slab",
                                                                               builder -> builder.setNetworkId(594));
    public static final BuilderRegister<ItemType> MOSSY_COBBLESTONE_STAIRS = gen("Mossy Cobblestone Stairs",
                                                                                 "mossy_cobblestone_stairs",
                                                                                 builder -> builder.setNetworkId(576));
    public static final BuilderRegister<ItemType> MOSSY_COBBLESTONE_WALL = gen("Mossy Cobblestone Wall",
                                                                               "mossy_cobblestone_wall",
                                                                               builder -> builder.setNetworkId(350));
    public static final BuilderRegister<ItemType> MOSSY_STONE_BRICKS = gen("Mossy Stone Bricks",
                                                                           "mossy_stone_bricks",
                                                                           builder -> builder.setNetworkId(296));
    public static final BuilderRegister<ItemType> MOSSY_STONE_BRICK_SLAB = gen("Mossy Stone Brick Slab",
                                                                               "mossy_stone_brick_slab",
                                                                               builder -> builder.setNetworkId(592));
    public static final BuilderRegister<ItemType> MOSSY_STONE_BRICK_STAIRS = gen("Mossy Stone Brick Stairs",
                                                                                 "mossy_stone_brick_stairs",
                                                                                 builder -> builder.setNetworkId(574));
    public static final BuilderRegister<ItemType> MOSSY_STONE_BRICK_WALL = gen("Mossy Stone Brick Wall",
                                                                               "mossy_stone_brick_wall",
                                                                               builder -> builder.setNetworkId(354));
    public static final BuilderRegister<ItemType> MOSS_BLOCK = gen("Moss Block",
                                                                   "moss_block",
                                                                   builder -> builder.setNetworkId(209));
    public static final BuilderRegister<ItemType> MOSS_CARPET = gen("Moss Carpet",
                                                                    "moss_carpet",
                                                                    builder -> builder.setNetworkId(208));
    public static final BuilderRegister<ItemType> MULE_SPAWN_EGG = gen("Mule Spawn Egg",
                                                                       "mule_spawn_egg",
                                                                       builder -> builder.setNetworkId(942));
    public static final BuilderRegister<ItemType> MUSHROOM_STEM = gen("Mushroom Stem",
                                                                      "mushroom_stem",
                                                                      builder -> builder.setNetworkId(309));
    public static final BuilderRegister<ItemType> MUSHROOM_STEW = gen("Mushroom Stew",
                                                                      "mushroom_stew",
                                                                      builder -> builder
                                                                              .setNetworkId(767)
                                                                              .setStackSize(1));
    public static final BuilderRegister<ItemType> MUSIC_DISC_11 = gen("Music Disc",
                                                                      "music_disc_11",
                                                                      builder -> builder
                                                                              .setNetworkId(1068)
                                                                              .setStackSize(1));
    public static final BuilderRegister<ItemType> MUSIC_DISC_13 = gen("Music Disc",
                                                                      "music_disc_13",
                                                                      builder -> builder
                                                                              .setNetworkId(1058)
                                                                              .setStackSize(1));
    public static final BuilderRegister<ItemType> MUSIC_DISC_BLOCKS = gen("Music Disc",
                                                                          "music_disc_blocks",
                                                                          builder -> builder
                                                                                  .setNetworkId(1060)
                                                                                  .setStackSize(1));
    public static final BuilderRegister<ItemType> MUSIC_DISC_CAT = gen("Music Disc",
                                                                       "music_disc_cat",
                                                                       builder -> builder
                                                                               .setNetworkId(1059)
                                                                               .setStackSize(1));
    public static final BuilderRegister<ItemType> MUSIC_DISC_CHIRP = gen("Music Disc",
                                                                         "music_disc_chirp",
                                                                         builder -> builder
                                                                                 .setNetworkId(1061)
                                                                                 .setStackSize(1));
    public static final BuilderRegister<ItemType> MUSIC_DISC_FAR = gen("Music Disc",
                                                                       "music_disc_far",
                                                                       builder -> builder
                                                                               .setNetworkId(1062)
                                                                               .setStackSize(1));
    public static final BuilderRegister<ItemType> MUSIC_DISC_MALL = gen("Music Disc",
                                                                        "music_disc_mall",
                                                                        builder -> builder
                                                                                .setNetworkId(1063)
                                                                                .setStackSize(1));
    public static final BuilderRegister<ItemType> MUSIC_DISC_MELLOHI = gen("Music Disc",
                                                                           "music_disc_mellohi",
                                                                           builder -> builder
                                                                                   .setNetworkId(1064)
                                                                                   .setStackSize(1));
    public static final BuilderRegister<ItemType> MUSIC_DISC_OTHERSIDE = gen("Music Disc",
                                                                             "music_disc_otherside",
                                                                             builder -> builder
                                                                                     .setNetworkId(1070)
                                                                                     .setStackSize(1));
    public static final BuilderRegister<ItemType> MUSIC_DISC_PIGSTEP = gen("Music Disc",
                                                                           "music_disc_pigstep",
                                                                           builder -> builder
                                                                                   .setNetworkId(1072)
                                                                                   .setStackSize(1));
    public static final BuilderRegister<ItemType> MUSIC_DISC_STAL = gen("Music Disc",
                                                                        "music_disc_stal",
                                                                        builder -> builder
                                                                                .setNetworkId(1065)
                                                                                .setStackSize(1));
    public static final BuilderRegister<ItemType> MUSIC_DISC_STRAD = gen("Music Disc",
                                                                         "music_disc_strad",
                                                                         builder -> builder
                                                                                 .setNetworkId(1066)
                                                                                 .setStackSize(1));
    public static final BuilderRegister<ItemType> MUSIC_DISC_WAIT = gen("Music Disc",
                                                                        "music_disc_wait",
                                                                        builder -> builder
                                                                                .setNetworkId(1069)
                                                                                .setStackSize(1));
    public static final BuilderRegister<ItemType> MUSIC_DISC_WARD = gen("Music Disc",
                                                                        "music_disc_ward",
                                                                        builder -> builder
                                                                                .setNetworkId(1067)
                                                                                .setStackSize(1));
    public static final BuilderRegister<ItemType> MUTTON = gen("Raw Mutton",
                                                               "mutton",
                                                               builder -> builder.setNetworkId(1023));
    public static final BuilderRegister<ItemType> MYCELIUM = gen("Mycelium",
                                                                 "mycelium",
                                                                 builder -> builder.setNetworkId(319));
    public static final BuilderRegister<ItemType> NAME_TAG = gen("Name Tag",
                                                                 "name_tag",
                                                                 builder -> builder.setNetworkId(1021));
    public static final BuilderRegister<ItemType> NAUTILUS_SHELL = gen("Nautilus Shell",
                                                                       "nautilus_shell",
                                                                       builder -> builder.setNetworkId(1076));
    public static final BuilderRegister<ItemType> NETHERITE_AXE = gen("Netherite Axe",
                                                                      "netherite_axe",
                                                                      builder -> builder.setNetworkId(763));
    public static final BuilderRegister<ItemType> NETHERITE_BLOCK = gen("Block of Netherite",
                                                                        "netherite_block",
                                                                        builder -> builder.setNetworkId(72));
    public static final BuilderRegister<ItemType> NETHERITE_BOOTS = gen("Netherite Boots",
                                                                        "netherite_boots",
                                                                        builder -> builder.setNetworkId(797));
    public static final BuilderRegister<ItemType> NETHERITE_CHESTPLATE = gen("Netherite Chestplate",
                                                                             "netherite_chestplate",
                                                                             builder -> builder.setNetworkId(795));
    public static final BuilderRegister<ItemType> NETHERITE_HELMET = gen("Netherite Helmet",
                                                                         "netherite_helmet",
                                                                         builder -> builder.setNetworkId(794));
    public static final BuilderRegister<ItemType> NETHERITE_HOE = gen("Netherite Hoe",
                                                                      "netherite_hoe",
                                                                      builder -> builder.setNetworkId(764));
    public static final BuilderRegister<ItemType> NETHERITE_INGOT = gen("Netherite Ingot",
                                                                        "netherite_ingot",
                                                                        builder -> builder.setNetworkId(733));
    public static final BuilderRegister<ItemType> NETHERITE_LEGGINGS = gen("Netherite Leggings",
                                                                           "netherite_leggings",
                                                                           builder -> builder.setNetworkId(796));
    public static final BuilderRegister<ItemType> NETHERITE_PICKAXE = gen("Netherite Pickaxe",
                                                                          "netherite_pickaxe",
                                                                          builder -> builder.setNetworkId(762));
    public static final BuilderRegister<ItemType> NETHERITE_SCRAP = gen("Netherite Scrap",
                                                                        "netherite_scrap",
                                                                        builder -> builder.setNetworkId(734));
    public static final BuilderRegister<ItemType> NETHERITE_SHOVEL = gen("Netherite Shovel",
                                                                         "netherite_shovel",
                                                                         builder -> builder.setNetworkId(761));
    public static final BuilderRegister<ItemType> NETHERITE_SWORD = gen("Netherite Sword",
                                                                        "netherite_sword",
                                                                        builder -> builder.setNetworkId(760));
    public static final BuilderRegister<ItemType> NETHERRACK = gen("Netherrack",
                                                                   "netherrack",
                                                                   builder -> builder.setNetworkId(280));
    public static final BuilderRegister<ItemType> NETHER_BRICK = gen("Nether Brick",
                                                                     "nether_brick",
                                                                     builder -> builder.setNetworkId(1007));
    public static final BuilderRegister<ItemType> NETHER_BRICKS = gen("Nether Bricks",
                                                                      "nether_bricks",
                                                                      builder -> builder.setNetworkId(321));
    public static final BuilderRegister<ItemType> NETHER_BRICK_FENCE = gen("Nether Brick Fence",
                                                                           "nether_brick_fence",
                                                                           builder -> builder.setNetworkId(324));
    public static final BuilderRegister<ItemType> NETHER_BRICK_SLAB = gen("Nether Brick Slab",
                                                                          "nether_brick_slab",
                                                                          builder -> builder.setNetworkId(232));
    public static final BuilderRegister<ItemType> NETHER_BRICK_STAIRS = gen("Nether Brick Stairs",
                                                                            "nether_brick_stairs",
                                                                            builder -> builder.setNetworkId(325));
    public static final BuilderRegister<ItemType> NETHER_BRICK_WALL = gen("Nether Brick Wall",
                                                                          "nether_brick_wall",
                                                                          builder -> builder.setNetworkId(358));
    public static final BuilderRegister<ItemType> NETHER_GOLD_ORE = gen("Nether Gold Ore",
                                                                        "nether_gold_ore",
                                                                        builder -> builder.setNetworkId(59));
    public static final BuilderRegister<ItemType> NETHER_QUARTZ_ORE = gen("Nether Quartz Ore",
                                                                          "nether_quartz_ore",
                                                                          builder -> builder.setNetworkId(60));
    public static final BuilderRegister<ItemType> NETHER_SPROUTS = gen("Nether Sprouts",
                                                                       "nether_sprouts",
                                                                       builder -> builder.setNetworkId(203));
    public static final BuilderRegister<ItemType> NETHER_STAR = gen("Nether Star",
                                                                    "nether_star",
                                                                    builder -> builder.setNetworkId(1002));
    public static final BuilderRegister<ItemType> NETHER_WART = gen("Nether Wart",
                                                                    "nether_wart",
                                                                    builder -> builder.setNetworkId(901));
    public static final BuilderRegister<ItemType> NETHER_WART_BLOCK = gen("Nether Wart Block",
                                                                          "nether_wart_block",
                                                                          builder -> builder.setNetworkId(469));
    public static final BuilderRegister<ItemType> NOTE_BLOCK = gen("Note Block",
                                                                   "note_block",
                                                                   builder -> builder.setNetworkId(631));
    public static final BuilderRegister<ItemType> OAK_BOAT = gen("Oak Boat",
                                                                 "oak_boat",
                                                                 builder -> builder.setNetworkId(698).setStackSize(1));
    public static final BuilderRegister<ItemType> OAK_BUTTON = gen("Oak Button",
                                                                   "oak_button",
                                                                   builder -> builder.setNetworkId(634));
    public static final BuilderRegister<ItemType> OAK_DOOR = gen("Oak Door",
                                                                 "oak_door",
                                                                 builder -> builder.setNetworkId(657));
    public static final BuilderRegister<ItemType> OAK_FENCE = gen("Oak Fence",
                                                                  "oak_fence",
                                                                  builder -> builder.setNetworkId(268));
    public static final BuilderRegister<ItemType> OAK_FENCE_GATE = gen("Oak Fence Gate",
                                                                       "oak_fence_gate",
                                                                       builder -> builder.setNetworkId(676));
    public static final BuilderRegister<ItemType> OAK_LEAVES = gen("Oak Leaves",
                                                                   "oak_leaves",
                                                                   builder -> builder.setNetworkId(142));
    public static final BuilderRegister<ItemType> OAK_LOG = gen("Oak Log",
                                                                "oak_log",
                                                                builder -> builder.setNetworkId(104));
    public static final BuilderRegister<ItemType> OAK_PLANKS = gen("Oak Planks",
                                                                   "oak_planks",
                                                                   builder -> builder.setNetworkId(23));
    public static final BuilderRegister<ItemType> OAK_PRESSURE_PLATE = gen("Oak Pressure Plate",
                                                                           "oak_pressure_plate",
                                                                           builder -> builder.setNetworkId(647));
    public static final BuilderRegister<ItemType> OAK_SAPLING = gen("Oak Sapling",
                                                                    "oak_sapling",
                                                                    builder -> builder.setNetworkId(32));
    public static final BuilderRegister<ItemType> OAK_SIGN = gen("Oak Sign",
                                                                 "oak_sign",
                                                                 builder -> builder.setNetworkId(804).setStackSize(16));
    public static final BuilderRegister<ItemType> OAK_SLAB = gen("Oak Slab",
                                                                 "oak_slab",
                                                                 builder -> builder.setNetworkId(214));
    public static final BuilderRegister<ItemType> OAK_STAIRS = gen("Oak Stairs",
                                                                   "oak_stairs",
                                                                   builder -> builder.setNetworkId(338));
    public static final BuilderRegister<ItemType> OAK_TRAPDOOR = gen("Oak Trapdoor",
                                                                     "oak_trapdoor",
                                                                     builder -> builder.setNetworkId(667));
    public static final BuilderRegister<ItemType> OAK_WOOD = gen("Oak Wood",
                                                                 "oak_wood",
                                                                 builder -> builder.setNetworkId(133));
    public static final BuilderRegister<ItemType> OBSERVER = gen("Observer",
                                                                 "observer",
                                                                 builder -> builder.setNetworkId(617));
    public static final BuilderRegister<ItemType> OBSIDIAN = gen("Obsidian",
                                                                 "obsidian",
                                                                 builder -> builder.setNetworkId(247));
    public static final BuilderRegister<ItemType> OCELOT_SPAWN_EGG = gen("Ocelot Spawn Egg",
                                                                         "ocelot_spawn_egg",
                                                                         builder -> builder.setNetworkId(943));
    public static final BuilderRegister<ItemType> ORANGE_BANNER = gen("Orange Banner",
                                                                      "orange_banner",
                                                                      builder -> builder
                                                                              .setNetworkId(1026)
                                                                              .setStackSize(16));
    public static final BuilderRegister<ItemType> ORANGE_BED = gen("Orange Bed",
                                                                   "orange_bed",
                                                                   builder -> builder
                                                                           .setNetworkId(870)
                                                                           .setStackSize(1));
    public static final BuilderRegister<ItemType> ORANGE_CANDLE = gen("Orange Candle",
                                                                      "orange_candle",
                                                                      builder -> builder.setNetworkId(1127));
    public static final BuilderRegister<ItemType> ORANGE_CARPET = gen("Orange Carpet",
                                                                      "orange_carpet",
                                                                      builder -> builder.setNetworkId(399));
    public static final BuilderRegister<ItemType> ORANGE_CONCRETE = gen("Orange Concrete",
                                                                        "orange_concrete",
                                                                        builder -> builder.setNetworkId(508));
    public static final BuilderRegister<ItemType> ORANGE_CONCRETE_POWDER = gen("Orange Concrete Powder",
                                                                               "orange_concrete_powder",
                                                                               builder -> builder.setNetworkId(524));
    public static final BuilderRegister<ItemType> ORANGE_DYE = gen("Orange Dye",
                                                                   "orange_dye",
                                                                   builder -> builder.setNetworkId(850));
    public static final BuilderRegister<ItemType> ORANGE_GLAZED_TERRACOTTA = gen("Orange Glazed Terracotta",
                                                                                 "orange_glazed_terracotta",
                                                                                 builder -> builder.setNetworkId(492));
    public static final BuilderRegister<ItemType> ORANGE_SHULKER_BOX = gen("Orange Shulker Box",
                                                                           "orange_shulker_box",
                                                                           builder -> builder
                                                                                   .setNetworkId(476)
                                                                                   .setStackSize(1));
    public static final BuilderRegister<ItemType> ORANGE_STAINED_GLASS = gen("Orange Stained Glass",
                                                                             "orange_stained_glass",
                                                                             builder -> builder.setNetworkId(424));
    public static final BuilderRegister<ItemType> ORANGE_STAINED_GLASS_PANE = gen("Orange Stained Glass Pane",
                                                                                  "orange_stained_glass_pane",
                                                                                  builder -> builder.setNetworkId(440));
    public static final BuilderRegister<ItemType> ORANGE_TERRACOTTA = gen("Orange Terracotta",
                                                                          "orange_terracotta",
                                                                          builder -> builder.setNetworkId(380));
    public static final BuilderRegister<ItemType> ORANGE_TULIP = gen("Orange Tulip",
                                                                     "orange_tulip",
                                                                     builder -> builder.setNetworkId(189));
    public static final BuilderRegister<ItemType> ORANGE_WOOL = gen("Orange Wool",
                                                                    "orange_wool",
                                                                    builder -> builder.setNetworkId(168));
    public static final BuilderRegister<ItemType> OXEYE_DAISY = gen("Oxeye Daisy",
                                                                    "oxeye_daisy",
                                                                    builder -> builder.setNetworkId(192));
    public static final BuilderRegister<ItemType> OXIDIZED_COPPER = gen("Oxidized Copper",
                                                                        "oxidized_copper",
                                                                        builder -> builder.setNetworkId(75));
    public static final BuilderRegister<ItemType> OXIDIZED_CUT_COPPER = gen("Oxidized Cut Copper",
                                                                            "oxidized_cut_copper",
                                                                            builder -> builder.setNetworkId(79));
    public static final BuilderRegister<ItemType> OXIDIZED_CUT_COPPER_SLAB = gen("Oxidized Cut Copper Slab",
                                                                                 "oxidized_cut_copper_slab",
                                                                                 builder -> builder.setNetworkId(87));
    public static final BuilderRegister<ItemType> OXIDIZED_CUT_COPPER_STAIRS = gen("Oxidized Cut Copper Stairs",
                                                                                   "oxidized_cut_copper_stairs",
                                                                                   builder -> builder.setNetworkId(83));
    public static final BuilderRegister<ItemType> PACKED_ICE = gen("Packed Ice",
                                                                   "packed_ice",
                                                                   builder -> builder.setNetworkId(415));
    public static final BuilderRegister<ItemType> PAINTING = gen("Painting",
                                                                 "painting",
                                                                 builder -> builder.setNetworkId(801));
    public static final BuilderRegister<ItemType> PANDA_SPAWN_EGG = gen("Panda Spawn Egg",
                                                                        "panda_spawn_egg",
                                                                        builder -> builder.setNetworkId(944));
    public static final BuilderRegister<ItemType> PAPER = gen("Paper", "paper", builder -> builder.setNetworkId(829));
    public static final BuilderRegister<ItemType> PARROT_SPAWN_EGG = gen("Parrot Spawn Egg",
                                                                         "parrot_spawn_egg",
                                                                         builder -> builder.setNetworkId(945));
    public static final BuilderRegister<ItemType> PEONY = gen("Peony", "peony", builder -> builder.setNetworkId(420));
    public static final BuilderRegister<ItemType> PETRIFIED_OAK_SLAB = gen("Petrified Oak Slab",
                                                                           "petrified_oak_slab",
                                                                           builder -> builder.setNetworkId(227));
    public static final BuilderRegister<ItemType> PHANTOM_MEMBRANE = gen("Phantom Membrane",
                                                                         "phantom_membrane",
                                                                         builder -> builder.setNetworkId(1075));
    public static final BuilderRegister<ItemType> PHANTOM_SPAWN_EGG = gen("Phantom Spawn Egg",
                                                                          "phantom_spawn_egg",
                                                                          builder -> builder.setNetworkId(946));
    public static final BuilderRegister<ItemType> PIGLIN_BANNER_PATTERN = gen("Banner Pattern",
                                                                              "piglin_banner_pattern",
                                                                              builder -> builder
                                                                                      .setNetworkId(1086)
                                                                                      .setStackSize(1));
    public static final BuilderRegister<ItemType> PIGLIN_BRUTE_SPAWN_EGG = gen("Piglin Brute Spawn Egg",
                                                                               "piglin_brute_spawn_egg",
                                                                               builder -> builder.setNetworkId(949));
    public static final BuilderRegister<ItemType> PIGLIN_SPAWN_EGG = gen("Piglin Spawn Egg",
                                                                         "piglin_spawn_egg",
                                                                         builder -> builder.setNetworkId(948));
    public static final BuilderRegister<ItemType> PIG_SPAWN_EGG = gen("Pig Spawn Egg",
                                                                      "pig_spawn_egg",
                                                                      builder -> builder.setNetworkId(947));
    public static final BuilderRegister<ItemType> PILLAGER_SPAWN_EGG = gen("Pillager Spawn Egg",
                                                                           "pillager_spawn_egg",
                                                                           builder -> builder.setNetworkId(950));
    public static final BuilderRegister<ItemType> PINK_BANNER = gen("Pink Banner",
                                                                    "pink_banner",
                                                                    builder -> builder
                                                                            .setNetworkId(1031)
                                                                            .setStackSize(16));
    public static final BuilderRegister<ItemType> PINK_BED = gen("Pink Bed",
                                                                 "pink_bed",
                                                                 builder -> builder.setNetworkId(875).setStackSize(1));
    public static final BuilderRegister<ItemType> PINK_CANDLE = gen("Pink Candle",
                                                                    "pink_candle",
                                                                    builder -> builder.setNetworkId(1132));
    public static final BuilderRegister<ItemType> PINK_CARPET = gen("Pink Carpet",
                                                                    "pink_carpet",
                                                                    builder -> builder.setNetworkId(404));
    public static final BuilderRegister<ItemType> PINK_CONCRETE = gen("Pink Concrete",
                                                                      "pink_concrete",
                                                                      builder -> builder.setNetworkId(513));
    public static final BuilderRegister<ItemType> PINK_CONCRETE_POWDER = gen("Pink Concrete Powder",
                                                                             "pink_concrete_powder",
                                                                             builder -> builder.setNetworkId(529));
    public static final BuilderRegister<ItemType> PINK_DYE = gen("Pink Dye",
                                                                 "pink_dye",
                                                                 builder -> builder.setNetworkId(855));
    public static final BuilderRegister<ItemType> PINK_GLAZED_TERRACOTTA = gen("Pink Glazed Terracotta",
                                                                               "pink_glazed_terracotta",
                                                                               builder -> builder.setNetworkId(497));
    public static final BuilderRegister<ItemType> PINK_SHULKER_BOX = gen("Pink Shulker Box",
                                                                         "pink_shulker_box",
                                                                         builder -> builder
                                                                                 .setNetworkId(481)
                                                                                 .setStackSize(1));
    public static final BuilderRegister<ItemType> PINK_STAINED_GLASS = gen("Pink Stained Glass",
                                                                           "pink_stained_glass",
                                                                           builder -> builder.setNetworkId(429));
    public static final BuilderRegister<ItemType> PINK_STAINED_GLASS_PANE = gen("Pink Stained Glass Pane",
                                                                                "pink_stained_glass_pane",
                                                                                builder -> builder.setNetworkId(445));
    public static final BuilderRegister<ItemType> PINK_TERRACOTTA = gen("Pink Terracotta",
                                                                        "pink_terracotta",
                                                                        builder -> builder.setNetworkId(385));
    public static final BuilderRegister<ItemType> PINK_TULIP = gen("Pink Tulip",
                                                                   "pink_tulip",
                                                                   builder -> builder.setNetworkId(191));
    public static final BuilderRegister<ItemType> PINK_WOOL = gen("Pink Wool",
                                                                  "pink_wool",
                                                                  builder -> builder.setNetworkId(173));
    public static final BuilderRegister<ItemType> PISTON = gen("Piston",
                                                               "piston",
                                                               builder -> builder.setNetworkId(613));
    public static final BuilderRegister<ItemType> PLAYER_HEAD = gen("Player Head",
                                                                    "player_head",
                                                                    builder -> builder.setNetworkId(998));
    public static final BuilderRegister<ItemType> PODZOL = gen("Podzol", "podzol", builder -> builder.setNetworkId(17));
    public static final BuilderRegister<ItemType> POINTED_DRIPSTONE = gen("Pointed Dripstone",
                                                                          "pointed_dripstone",
                                                                          builder -> builder.setNetworkId(1146));
    public static final BuilderRegister<ItemType> POISONOUS_POTATO = gen("Poisonous Potato",
                                                                         "poisonous_potato",
                                                                         builder -> builder.setNetworkId(993));
    public static final BuilderRegister<ItemType> POLAR_BEAR_SPAWN_EGG = gen("Polar Bear Spawn Egg",
                                                                             "polar_bear_spawn_egg",
                                                                             builder -> builder.setNetworkId(951));
    public static final BuilderRegister<ItemType> POLISHED_ANDESITE = gen("Polished Andesite",
                                                                          "polished_andesite",
                                                                          builder -> builder.setNetworkId(7));
    public static final BuilderRegister<ItemType> POLISHED_ANDESITE_SLAB = gen("Polished Andesite Slab",
                                                                               "polished_andesite_slab",
                                                                               builder -> builder.setNetworkId(601));
    public static final BuilderRegister<ItemType> POLISHED_ANDESITE_STAIRS = gen("Polished Andesite Stairs",
                                                                                 "polished_andesite_stairs",
                                                                                 builder -> builder.setNetworkId(584));
    public static final BuilderRegister<ItemType> POLISHED_BASALT = gen("Polished Basalt",
                                                                        "polished_basalt",
                                                                        builder -> builder.setNetworkId(284));
    public static final BuilderRegister<ItemType> POLISHED_BLACKSTONE = gen("Polished Blackstone",
                                                                            "polished_blackstone",
                                                                            builder -> builder.setNetworkId(1116));
    public static final BuilderRegister<ItemType> POLISHED_BLACKSTONE_BRICKS = gen("Polished Blackstone Bricks",
                                                                                   "polished_blackstone_bricks",
                                                                                   builder -> builder.setNetworkId(1120));
    public static final BuilderRegister<ItemType> POLISHED_BLACKSTONE_BRICK_SLAB = gen("Polished Blackstone Brick Slab",
                                                                                       "polished_blackstone_brick_slab",
                                                                                       builder -> builder.setNetworkId(
                                                                                               1121));
    public static final BuilderRegister<ItemType> POLISHED_BLACKSTONE_BRICK_STAIRS = gen(
            "Polished Blackstone Brick Stairs",
            "polished_blackstone_brick_stairs",
            builder -> builder.setNetworkId(1122));
    public static final BuilderRegister<ItemType> POLISHED_BLACKSTONE_BRICK_WALL = gen("Polished Blackstone Brick Wall",
                                                                                       "polished_blackstone_brick_wall",
                                                                                       builder -> builder.setNetworkId(
                                                                                               366));
    public static final BuilderRegister<ItemType> POLISHED_BLACKSTONE_BUTTON = gen("Polished Blackstone Button",
                                                                                   "polished_blackstone_button",
                                                                                   builder -> builder.setNetworkId(633));
    public static final BuilderRegister<ItemType> POLISHED_BLACKSTONE_PRESSURE_PLATE = gen(
            "Polished Blackstone Pressure Plate",
            "polished_blackstone_pressure_plate",
            builder -> builder.setNetworkId(644));
    public static final BuilderRegister<ItemType> POLISHED_BLACKSTONE_SLAB = gen("Polished Blackstone Slab",
                                                                                 "polished_blackstone_slab",
                                                                                 builder -> builder.setNetworkId(1117));
    public static final BuilderRegister<ItemType> POLISHED_BLACKSTONE_STAIRS = gen("Polished Blackstone Stairs",
                                                                                   "polished_blackstone_stairs",
                                                                                   builder -> builder.setNetworkId(1118));
    public static final BuilderRegister<ItemType> POLISHED_BLACKSTONE_WALL = gen("Polished Blackstone Wall",
                                                                                 "polished_blackstone_wall",
                                                                                 builder -> builder.setNetworkId(365));
    public static final BuilderRegister<ItemType> POLISHED_DEEPSLATE = gen("Polished Deepslate",
                                                                           "polished_deepslate",
                                                                           builder -> builder.setNetworkId(10));
    public static final BuilderRegister<ItemType> POLISHED_DEEPSLATE_SLAB = gen("Polished Deepslate Slab",
                                                                                "polished_deepslate_slab",
                                                                                builder -> builder.setNetworkId(604));
    public static final BuilderRegister<ItemType> POLISHED_DEEPSLATE_STAIRS = gen("Polished Deepslate Stairs",
                                                                                  "polished_deepslate_stairs",
                                                                                  builder -> builder.setNetworkId(587));
    public static final BuilderRegister<ItemType> POLISHED_DEEPSLATE_WALL = gen("Polished Deepslate Wall",
                                                                                "polished_deepslate_wall",
                                                                                builder -> builder.setNetworkId(368));
    public static final BuilderRegister<ItemType> POLISHED_DIORITE = gen("Polished Diorite",
                                                                         "polished_diorite",
                                                                         builder -> builder.setNetworkId(5));
    public static final BuilderRegister<ItemType> POLISHED_DIORITE_SLAB = gen("Polished Diorite Slab",
                                                                              "polished_diorite_slab",
                                                                              builder -> builder.setNetworkId(593));
    public static final BuilderRegister<ItemType> POLISHED_DIORITE_STAIRS = gen("Polished Diorite Stairs",
                                                                                "polished_diorite_stairs",
                                                                                builder -> builder.setNetworkId(575));
    public static final BuilderRegister<ItemType> POLISHED_GRANITE = gen("Polished Granite",
                                                                         "polished_granite",
                                                                         builder -> builder.setNetworkId(3));
    public static final BuilderRegister<ItemType> POLISHED_GRANITE_SLAB = gen("Polished Granite Slab",
                                                                              "polished_granite_slab",
                                                                              builder -> builder.setNetworkId(590));
    public static final BuilderRegister<ItemType> POLISHED_GRANITE_STAIRS = gen("Polished Granite Stairs",
                                                                                "polished_granite_stairs",
                                                                                builder -> builder.setNetworkId(572));
    public static final BuilderRegister<ItemType> POPPED_CHORUS_FRUIT = gen("Popped Chorus Fruit",
                                                                            "popped_chorus_fruit",
                                                                            builder -> builder.setNetworkId(1043));
    public static final BuilderRegister<ItemType> POPPY = gen("Poppy", "poppy", builder -> builder.setNetworkId(184));
    public static final BuilderRegister<ItemType> PORKCHOP = gen("Raw Porkchop",
                                                                 "porkchop",
                                                                 builder -> builder.setNetworkId(799));
    public static final BuilderRegister<ItemType> POTATO = gen("Potato",
                                                               "potato",
                                                               builder -> builder.setNetworkId(991));
    public static final BuilderRegister<ItemType> POTION = gen("Potion",
                                                               "potion",
                                                               builder -> builder.setNetworkId(902).setStackSize(1));
    public static final BuilderRegister<ItemType> POWDER_SNOW_BUCKET = gen("Powder Snow Bucket",
                                                                           "powder_snow_bucket",
                                                                           builder -> builder
                                                                                   .setNetworkId(816)
                                                                                   .setStackSize(1));
    public static final BuilderRegister<ItemType> POWERED_RAIL = gen("Powered Rail",
                                                                     "powered_rail",
                                                                     builder -> builder.setNetworkId(685));
    public static final BuilderRegister<ItemType> PRISMARINE = gen("Prismarine",
                                                                   "prismarine",
                                                                   builder -> builder.setNetworkId(455));
    public static final BuilderRegister<ItemType> PRISMARINE_BRICKS = gen("Prismarine Bricks",
                                                                          "prismarine_bricks",
                                                                          builder -> builder.setNetworkId(456));
    public static final BuilderRegister<ItemType> PRISMARINE_BRICK_SLAB = gen("Prismarine Brick Slab",
                                                                              "prismarine_brick_slab",
                                                                              builder -> builder.setNetworkId(238));
    public static final BuilderRegister<ItemType> PRISMARINE_BRICK_STAIRS = gen("Prismarine Brick Stairs",
                                                                                "prismarine_brick_stairs",
                                                                                builder -> builder.setNetworkId(459));
    public static final BuilderRegister<ItemType> PRISMARINE_CRYSTALS = gen("Prismarine Crystals",
                                                                            "prismarine_crystals",
                                                                            builder -> builder.setNetworkId(1009));
    public static final BuilderRegister<ItemType> PRISMARINE_SHARD = gen("Prismarine Shard",
                                                                         "prismarine_shard",
                                                                         builder -> builder.setNetworkId(1008));
    public static final BuilderRegister<ItemType> PRISMARINE_SLAB = gen("Prismarine Slab",
                                                                        "prismarine_slab",
                                                                        builder -> builder.setNetworkId(237));
    public static final BuilderRegister<ItemType> PRISMARINE_STAIRS = gen("Prismarine Stairs",
                                                                          "prismarine_stairs",
                                                                          builder -> builder.setNetworkId(458));
    public static final BuilderRegister<ItemType> PRISMARINE_WALL = gen("Prismarine Wall",
                                                                        "prismarine_wall",
                                                                        builder -> builder.setNetworkId(352));
    public static final BuilderRegister<ItemType> PUFFERFISH = gen("Pufferfish",
                                                                   "pufferfish",
                                                                   builder -> builder.setNetworkId(843));
    public static final BuilderRegister<ItemType> PUFFERFISH_BUCKET = gen("Bucket of Pufferfish",
                                                                          "pufferfish_bucket",
                                                                          builder -> builder
                                                                                  .setNetworkId(820)
                                                                                  .setStackSize(1));
    public static final BuilderRegister<ItemType> PUFFERFISH_SPAWN_EGG = gen("Pufferfish Spawn Egg",
                                                                             "pufferfish_spawn_egg",
                                                                             builder -> builder.setNetworkId(952));
    public static final BuilderRegister<ItemType> PUMPKIN = gen("Pumpkin",
                                                                "pumpkin",
                                                                builder -> builder.setNetworkId(277));
    public static final BuilderRegister<ItemType> PUMPKIN_PIE = gen("Pumpkin Pie",
                                                                    "pumpkin_pie",
                                                                    builder -> builder.setNetworkId(1003));
    public static final BuilderRegister<ItemType> PUMPKIN_SEEDS = gen("Pumpkin Seeds",
                                                                      "pumpkin_seeds",
                                                                      builder -> builder.setNetworkId(890));
    public static final BuilderRegister<ItemType> PURPLE_BANNER = gen("Purple Banner",
                                                                      "purple_banner",
                                                                      builder -> builder
                                                                              .setNetworkId(1035)
                                                                              .setStackSize(16));
    public static final BuilderRegister<ItemType> PURPLE_BED = gen("Purple Bed",
                                                                   "purple_bed",
                                                                   builder -> builder
                                                                           .setNetworkId(879)
                                                                           .setStackSize(1));
    public static final BuilderRegister<ItemType> PURPLE_CANDLE = gen("Purple Candle",
                                                                      "purple_candle",
                                                                      builder -> builder.setNetworkId(1136));
    public static final BuilderRegister<ItemType> PURPLE_CARPET = gen("Purple Carpet",
                                                                      "purple_carpet",
                                                                      builder -> builder.setNetworkId(408));
    public static final BuilderRegister<ItemType> PURPLE_CONCRETE = gen("Purple Concrete",
                                                                        "purple_concrete",
                                                                        builder -> builder.setNetworkId(517));
    public static final BuilderRegister<ItemType> PURPLE_CONCRETE_POWDER = gen("Purple Concrete Powder",
                                                                               "purple_concrete_powder",
                                                                               builder -> builder.setNetworkId(533));
    public static final BuilderRegister<ItemType> PURPLE_DYE = gen("Purple Dye",
                                                                   "purple_dye",
                                                                   builder -> builder.setNetworkId(859));
    public static final BuilderRegister<ItemType> PURPLE_GLAZED_TERRACOTTA = gen("Purple Glazed Terracotta",
                                                                                 "purple_glazed_terracotta",
                                                                                 builder -> builder.setNetworkId(501));
    public static final BuilderRegister<ItemType> PURPLE_SHULKER_BOX = gen("Purple Shulker Box",
                                                                           "purple_shulker_box",
                                                                           builder -> builder
                                                                                   .setNetworkId(485)
                                                                                   .setStackSize(1));
    public static final BuilderRegister<ItemType> PURPLE_STAINED_GLASS = gen("Purple Stained Glass",
                                                                             "purple_stained_glass",
                                                                             builder -> builder.setNetworkId(433));
    public static final BuilderRegister<ItemType> PURPLE_STAINED_GLASS_PANE = gen("Purple Stained Glass Pane",
                                                                                  "purple_stained_glass_pane",
                                                                                  builder -> builder.setNetworkId(449));
    public static final BuilderRegister<ItemType> PURPLE_TERRACOTTA = gen("Purple Terracotta",
                                                                          "purple_terracotta",
                                                                          builder -> builder.setNetworkId(389));
    public static final BuilderRegister<ItemType> PURPLE_WOOL = gen("Purple Wool",
                                                                    "purple_wool",
                                                                    builder -> builder.setNetworkId(177));
    public static final BuilderRegister<ItemType> PURPUR_BLOCK = gen("Purpur Block",
                                                                     "purpur_block",
                                                                     builder -> builder.setNetworkId(252));
    public static final BuilderRegister<ItemType> PURPUR_PILLAR = gen("Purpur Pillar",
                                                                      "purpur_pillar",
                                                                      builder -> builder.setNetworkId(253));
    public static final BuilderRegister<ItemType> PURPUR_SLAB = gen("Purpur Slab",
                                                                    "purpur_slab",
                                                                    builder -> builder.setNetworkId(236));
    public static final BuilderRegister<ItemType> PURPUR_STAIRS = gen("Purpur Stairs",
                                                                      "purpur_stairs",
                                                                      builder -> builder.setNetworkId(254));
    public static final BuilderRegister<ItemType> QUARTZ = gen("Nether Quartz",
                                                               "quartz",
                                                               builder -> builder.setNetworkId(725));
    public static final BuilderRegister<ItemType> QUARTZ_BLOCK = gen("Block of Quartz",
                                                                     "quartz_block",
                                                                     builder -> builder.setNetworkId(375));
    public static final BuilderRegister<ItemType> QUARTZ_BRICKS = gen("Quartz Bricks",
                                                                      "quartz_bricks",
                                                                      builder -> builder.setNetworkId(376));
    public static final BuilderRegister<ItemType> QUARTZ_PILLAR = gen("Quartz Pillar",
                                                                      "quartz_pillar",
                                                                      builder -> builder.setNetworkId(377));
    public static final BuilderRegister<ItemType> QUARTZ_SLAB = gen("Quartz Slab",
                                                                    "quartz_slab",
                                                                    builder -> builder.setNetworkId(233));
    public static final BuilderRegister<ItemType> QUARTZ_STAIRS = gen("Quartz Stairs",
                                                                      "quartz_stairs",
                                                                      builder -> builder.setNetworkId(378));
    public static final BuilderRegister<ItemType> RABBIT = gen("Raw Rabbit",
                                                               "rabbit",
                                                               builder -> builder.setNetworkId(1010));
    public static final BuilderRegister<ItemType> RABBIT_FOOT = gen("Rabbit's Foot",
                                                                    "rabbit_foot",
                                                                    builder -> builder.setNetworkId(1013));
    public static final BuilderRegister<ItemType> RABBIT_HIDE = gen("Rabbit Hide",
                                                                    "rabbit_hide",
                                                                    builder -> builder.setNetworkId(1014));
    public static final BuilderRegister<ItemType> RABBIT_SPAWN_EGG = gen("Rabbit Spawn Egg",
                                                                         "rabbit_spawn_egg",
                                                                         builder -> builder.setNetworkId(953));
    public static final BuilderRegister<ItemType> RABBIT_STEW = gen("Rabbit Stew",
                                                                    "rabbit_stew",
                                                                    builder -> builder
                                                                            .setNetworkId(1012)
                                                                            .setStackSize(1));
    public static final BuilderRegister<ItemType> RAIL = gen("Rail", "rail", builder -> builder.setNetworkId(687));
    public static final BuilderRegister<ItemType> RAVAGER_SPAWN_EGG = gen("Ravager Spawn Egg",
                                                                          "ravager_spawn_egg",
                                                                          builder -> builder.setNetworkId(954));
    public static final BuilderRegister<ItemType> RAW_COPPER = gen("Raw Copper",
                                                                   "raw_copper",
                                                                   builder -> builder.setNetworkId(729));
    public static final BuilderRegister<ItemType> RAW_COPPER_BLOCK = gen("Block of Raw Copper",
                                                                         "raw_copper_block",
                                                                         builder -> builder.setNetworkId(64));
    public static final BuilderRegister<ItemType> RAW_GOLD = gen("Raw Gold",
                                                                 "raw_gold",
                                                                 builder -> builder.setNetworkId(731));
    public static final BuilderRegister<ItemType> RAW_GOLD_BLOCK = gen("Block of Raw Gold",
                                                                       "raw_gold_block",
                                                                       builder -> builder.setNetworkId(65));
    public static final BuilderRegister<ItemType> RAW_IRON = gen("Raw Iron",
                                                                 "raw_iron",
                                                                 builder -> builder.setNetworkId(727));
    public static final BuilderRegister<ItemType> RAW_IRON_BLOCK = gen("Block of Raw Iron",
                                                                       "raw_iron_block",
                                                                       builder -> builder.setNetworkId(63));
    public static final BuilderRegister<ItemType> REDSTONE = gen("Redstone Dust",
                                                                 "redstone",
                                                                 builder -> builder.setNetworkId(608));
    public static final BuilderRegister<ItemType> REDSTONE_BLOCK = gen("Block of Redstone",
                                                                       "redstone_block",
                                                                       builder -> builder.setNetworkId(610));
    public static final BuilderRegister<ItemType> REDSTONE_LAMP = gen("Redstone Lamp",
                                                                      "redstone_lamp",
                                                                      builder -> builder.setNetworkId(630));
    public static final BuilderRegister<ItemType> REDSTONE_ORE = gen("Redstone Ore",
                                                                     "redstone_ore",
                                                                     builder -> builder.setNetworkId(51));
    public static final BuilderRegister<ItemType> REDSTONE_TORCH = gen("Redstone Torch",
                                                                       "redstone_torch",
                                                                       builder -> builder.setNetworkId(609));
    public static final BuilderRegister<ItemType> RED_BANNER = gen("Red Banner",
                                                                   "red_banner",
                                                                   builder -> builder
                                                                           .setNetworkId(1039)
                                                                           .setStackSize(16));
    public static final BuilderRegister<ItemType> RED_BED = gen("Red Bed",
                                                                "red_bed",
                                                                builder -> builder.setNetworkId(883).setStackSize(1));
    public static final BuilderRegister<ItemType> RED_CANDLE = gen("Red Candle",
                                                                   "red_candle",
                                                                   builder -> builder.setNetworkId(1140));
    public static final BuilderRegister<ItemType> RED_CARPET = gen("Red Carpet",
                                                                   "red_carpet",
                                                                   builder -> builder.setNetworkId(412));
    public static final BuilderRegister<ItemType> RED_CONCRETE = gen("Red Concrete",
                                                                     "red_concrete",
                                                                     builder -> builder.setNetworkId(521));
    public static final BuilderRegister<ItemType> RED_CONCRETE_POWDER = gen("Red Concrete Powder",
                                                                            "red_concrete_powder",
                                                                            builder -> builder.setNetworkId(537));
    public static final BuilderRegister<ItemType> RED_DYE = gen("Red Dye",
                                                                "red_dye",
                                                                builder -> builder.setNetworkId(863));
    public static final BuilderRegister<ItemType> RED_GLAZED_TERRACOTTA = gen("Red Glazed Terracotta",
                                                                              "red_glazed_terracotta",
                                                                              builder -> builder.setNetworkId(505));
    public static final BuilderRegister<ItemType> RED_MUSHROOM = gen("Red Mushroom",
                                                                     "red_mushroom",
                                                                     builder -> builder.setNetworkId(198));
    public static final BuilderRegister<ItemType> RED_MUSHROOM_BLOCK = gen("Red Mushroom Block",
                                                                           "red_mushroom_block",
                                                                           builder -> builder.setNetworkId(308));
    public static final BuilderRegister<ItemType> RED_NETHER_BRICKS = gen("Red Nether Bricks",
                                                                          "red_nether_bricks",
                                                                          builder -> builder.setNetworkId(471));
    public static final BuilderRegister<ItemType> RED_NETHER_BRICK_SLAB = gen("Red Nether Brick Slab",
                                                                              "red_nether_brick_slab",
                                                                              builder -> builder.setNetworkId(600));
    public static final BuilderRegister<ItemType> RED_NETHER_BRICK_STAIRS = gen("Red Nether Brick Stairs",
                                                                                "red_nether_brick_stairs",
                                                                                builder -> builder.setNetworkId(583));
    public static final BuilderRegister<ItemType> RED_NETHER_BRICK_WALL = gen("Red Nether Brick Wall",
                                                                              "red_nether_brick_wall",
                                                                              builder -> builder.setNetworkId(360));
    public static final BuilderRegister<ItemType> RED_SAND = gen("Red Sand",
                                                                 "red_sand",
                                                                 builder -> builder.setNetworkId(41));
    public static final BuilderRegister<ItemType> RED_SANDSTONE = gen("Red Sandstone",
                                                                      "red_sandstone",
                                                                      builder -> builder.setNetworkId(462));
    public static final BuilderRegister<ItemType> RED_SANDSTONE_SLAB = gen("Red Sandstone Slab",
                                                                           "red_sandstone_slab",
                                                                           builder -> builder.setNetworkId(234));
    public static final BuilderRegister<ItemType> RED_SANDSTONE_STAIRS = gen("Red Sandstone Stairs",
                                                                             "red_sandstone_stairs",
                                                                             builder -> builder.setNetworkId(465));
    public static final BuilderRegister<ItemType> RED_SANDSTONE_WALL = gen("Red Sandstone Wall",
                                                                           "red_sandstone_wall",
                                                                           builder -> builder.setNetworkId(353));
    public static final BuilderRegister<ItemType> RED_SHULKER_BOX = gen("Red Shulker Box",
                                                                        "red_shulker_box",
                                                                        builder -> builder
                                                                                .setNetworkId(489)
                                                                                .setStackSize(1));
    public static final BuilderRegister<ItemType> RED_STAINED_GLASS = gen("Red Stained Glass",
                                                                          "red_stained_glass",
                                                                          builder -> builder.setNetworkId(437));
    public static final BuilderRegister<ItemType> RED_STAINED_GLASS_PANE = gen("Red Stained Glass Pane",
                                                                               "red_stained_glass_pane",
                                                                               builder -> builder.setNetworkId(453));
    public static final BuilderRegister<ItemType> RED_TERRACOTTA = gen("Red Terracotta",
                                                                       "red_terracotta",
                                                                       builder -> builder.setNetworkId(393));
    public static final BuilderRegister<ItemType> RED_TULIP = gen("Red Tulip",
                                                                  "red_tulip",
                                                                  builder -> builder.setNetworkId(188));
    public static final BuilderRegister<ItemType> RED_WOOL = gen("Red Wool",
                                                                 "red_wool",
                                                                 builder -> builder.setNetworkId(181));
    public static final BuilderRegister<ItemType> REPEATER = gen("Redstone Repeater",
                                                                 "repeater",
                                                                 builder -> builder.setNetworkId(611));
    public static final BuilderRegister<ItemType> REPEATING_COMMAND_BLOCK = gen("Repeating Command Block",
                                                                                "repeating_command_block",
                                                                                builder -> builder.setNetworkId(466));
    public static final BuilderRegister<ItemType> RESPAWN_ANCHOR = gen("Respawn Anchor",
                                                                       "respawn_anchor",
                                                                       builder -> builder.setNetworkId(1124));
    public static final BuilderRegister<ItemType> ROOTED_DIRT = gen("Rooted Dirt",
                                                                    "rooted_dirt",
                                                                    builder -> builder.setNetworkId(18));
    public static final BuilderRegister<ItemType> ROSE_BUSH = gen("Rose Bush",
                                                                  "rose_bush",
                                                                  builder -> builder.setNetworkId(419));
    public static final BuilderRegister<ItemType> ROTTEN_FLESH = gen("Rotten Flesh",
                                                                     "rotten_flesh",
                                                                     builder -> builder.setNetworkId(896));
    public static final BuilderRegister<ItemType> SADDLE = gen("Saddle",
                                                               "saddle",
                                                               builder -> builder.setNetworkId(689).setStackSize(1));
    public static final BuilderRegister<ItemType> SALMON = gen("Raw Salmon",
                                                               "salmon",
                                                               builder -> builder.setNetworkId(841));
    public static final BuilderRegister<ItemType> SALMON_BUCKET = gen("Bucket of Salmon",
                                                                      "salmon_bucket",
                                                                      builder -> builder
                                                                              .setNetworkId(821)
                                                                              .setStackSize(1));
    public static final BuilderRegister<ItemType> SALMON_SPAWN_EGG = gen("Salmon Spawn Egg",
                                                                         "salmon_spawn_egg",
                                                                         builder -> builder.setNetworkId(955));
    public static final BuilderRegister<ItemType> SAND = gen("Sand", "sand", builder -> builder.setNetworkId(40));
    public static final BuilderRegister<ItemType> SANDSTONE = gen("Sandstone",
                                                                  "sandstone",
                                                                  builder -> builder.setNetworkId(156));
    public static final BuilderRegister<ItemType> SANDSTONE_SLAB = gen("Sandstone Slab",
                                                                       "sandstone_slab",
                                                                       builder -> builder.setNetworkId(225));
    public static final BuilderRegister<ItemType> SANDSTONE_STAIRS = gen("Sandstone Stairs",
                                                                         "sandstone_stairs",
                                                                         builder -> builder.setNetworkId(335));
    public static final BuilderRegister<ItemType> SANDSTONE_WALL = gen("Sandstone Wall",
                                                                       "sandstone_wall",
                                                                       builder -> builder.setNetworkId(361));
    public static final BuilderRegister<ItemType> SCAFFOLDING = gen("Scaffolding",
                                                                    "scaffolding",
                                                                    builder -> builder.setNetworkId(607));
    public static final BuilderRegister<ItemType> SCULK_SENSOR = gen("Sculk Sensor",
                                                                     "sculk_sensor",
                                                                     builder -> builder.setNetworkId(626));
    public static final BuilderRegister<ItemType> SCUTE = gen("Scute", "scute", builder -> builder.setNetworkId(715));
    public static final BuilderRegister<ItemType> SEAGRASS = gen("Seagrass",
                                                                 "seagrass",
                                                                 builder -> builder.setNetworkId(165));
    public static final BuilderRegister<ItemType> SEA_LANTERN = gen("Sea Lantern",
                                                                    "sea_lantern",
                                                                    builder -> builder.setNetworkId(461));
    public static final BuilderRegister<ItemType> SEA_PICKLE = gen("Sea Pickle",
                                                                   "sea_pickle",
                                                                   builder -> builder.setNetworkId(166));
    public static final BuilderRegister<ItemType> SHEARS = gen("Shears",
                                                               "shears",
                                                               builder -> builder.setNetworkId(887));
    public static final BuilderRegister<ItemType> SHEEP_SPAWN_EGG = gen("Sheep Spawn Egg",
                                                                        "sheep_spawn_egg",
                                                                        builder -> builder.setNetworkId(956));
    public static final BuilderRegister<ItemType> SHIELD = gen("Shield",
                                                               "shield",
                                                               builder -> builder.setNetworkId(1052));
    public static final BuilderRegister<ItemType> SHROOMLIGHT = gen("Shroomlight",
                                                                    "shroomlight",
                                                                    builder -> builder.setNetworkId(1104));
    public static final BuilderRegister<ItemType> SHULKER_BOX = gen("Shulker Box",
                                                                    "shulker_box",
                                                                    builder -> builder
                                                                            .setNetworkId(474)
                                                                            .setStackSize(1));
    public static final BuilderRegister<ItemType> SHULKER_SHELL = gen("Shulker Shell",
                                                                      "shulker_shell",
                                                                      builder -> builder.setNetworkId(1054));
    public static final BuilderRegister<ItemType> SHULKER_SPAWN_EGG = gen("Shulker Spawn Egg",
                                                                          "shulker_spawn_egg",
                                                                          builder -> builder.setNetworkId(957));
    public static final BuilderRegister<ItemType> SILVERFISH_SPAWN_EGG = gen("Silverfish Spawn Egg",
                                                                             "silverfish_spawn_egg",
                                                                             builder -> builder.setNetworkId(958));
    public static final BuilderRegister<ItemType> SKELETON_HORSE_SPAWN_EGG = gen("Skeleton Horse Spawn Egg",
                                                                                 "skeleton_horse_spawn_egg",
                                                                                 builder -> builder.setNetworkId(960));
    public static final BuilderRegister<ItemType> SKELETON_SKULL = gen("Skeleton Skull",
                                                                       "skeleton_skull",
                                                                       builder -> builder.setNetworkId(996));
    public static final BuilderRegister<ItemType> SKELETON_SPAWN_EGG = gen("Skeleton Spawn Egg",
                                                                           "skeleton_spawn_egg",
                                                                           builder -> builder.setNetworkId(959));
    public static final BuilderRegister<ItemType> SKULL_BANNER_PATTERN = gen("Banner Pattern",
                                                                             "skull_banner_pattern",
                                                                             builder -> builder
                                                                                     .setNetworkId(1083)
                                                                                     .setStackSize(1));
    public static final BuilderRegister<ItemType> SLIME_BALL = gen("Slimeball",
                                                                   "slime_ball",
                                                                   builder -> builder.setNetworkId(831));
    public static final BuilderRegister<ItemType> SLIME_BLOCK = gen("Slime Block",
                                                                    "slime_block",
                                                                    builder -> builder.setNetworkId(615));
    public static final BuilderRegister<ItemType> SLIME_SPAWN_EGG = gen("Slime Spawn Egg",
                                                                        "slime_spawn_egg",
                                                                        builder -> builder.setNetworkId(961));
    public static final BuilderRegister<ItemType> SMALL_AMETHYST_BUD = gen("Small Amethyst Bud",
                                                                           "small_amethyst_bud",
                                                                           builder -> builder.setNetworkId(1142));
    public static final BuilderRegister<ItemType> SMALL_DRIPLEAF = gen("Small Dripleaf",
                                                                       "small_dripleaf",
                                                                       builder -> builder.setNetworkId(212));
    public static final BuilderRegister<ItemType> SMITHING_TABLE = gen("Smithing Table",
                                                                       "smithing_table",
                                                                       builder -> builder.setNetworkId(1095));
    public static final BuilderRegister<ItemType> SMOKER = gen("Smoker",
                                                               "smoker",
                                                               builder -> builder.setNetworkId(1090));
    public static final BuilderRegister<ItemType> SMOOTH_BASALT = gen("Smooth Basalt",
                                                                      "smooth_basalt",
                                                                      builder -> builder.setNetworkId(285));
    public static final BuilderRegister<ItemType> SMOOTH_QUARTZ = gen("Smooth Quartz Block",
                                                                      "smooth_quartz",
                                                                      builder -> builder.setNetworkId(240));
    public static final BuilderRegister<ItemType> SMOOTH_QUARTZ_SLAB = gen("Smooth Quartz Slab",
                                                                           "smooth_quartz_slab",
                                                                           builder -> builder.setNetworkId(597));
    public static final BuilderRegister<ItemType> SMOOTH_QUARTZ_STAIRS = gen("Smooth Quartz Stairs",
                                                                             "smooth_quartz_stairs",
                                                                             builder -> builder.setNetworkId(580));
    public static final BuilderRegister<ItemType> SMOOTH_RED_SANDSTONE = gen("Smooth Red Sandstone",
                                                                             "smooth_red_sandstone",
                                                                             builder -> builder.setNetworkId(241));
    public static final BuilderRegister<ItemType> SMOOTH_RED_SANDSTONE_SLAB = gen("Smooth Red Sandstone Slab",
                                                                                  "smooth_red_sandstone_slab",
                                                                                  builder -> builder.setNetworkId(591));
    public static final BuilderRegister<ItemType> SMOOTH_RED_SANDSTONE_STAIRS = gen("Smooth Red Sandstone Stairs",
                                                                                    "smooth_red_sandstone_stairs",
                                                                                    builder -> builder.setNetworkId(573));
    public static final BuilderRegister<ItemType> SMOOTH_SANDSTONE = gen("Smooth Sandstone",
                                                                         "smooth_sandstone",
                                                                         builder -> builder.setNetworkId(242));
    public static final BuilderRegister<ItemType> SMOOTH_SANDSTONE_SLAB = gen("Smooth Sandstone Slab",
                                                                              "smooth_sandstone_slab",
                                                                              builder -> builder.setNetworkId(596));
    public static final BuilderRegister<ItemType> SMOOTH_SANDSTONE_STAIRS = gen("Smooth Sandstone Stairs",
                                                                                "smooth_sandstone_stairs",
                                                                                builder -> builder.setNetworkId(579));
    public static final BuilderRegister<ItemType> SMOOTH_STONE = gen("Smooth Stone",
                                                                     "smooth_stone",
                                                                     builder -> builder.setNetworkId(243));
    public static final BuilderRegister<ItemType> SMOOTH_STONE_SLAB = gen("Smooth Stone Slab",
                                                                          "smooth_stone_slab",
                                                                          builder -> builder.setNetworkId(224));
    public static final BuilderRegister<ItemType> SNOW = gen("Snow", "snow", builder -> builder.setNetworkId(262));
    public static final BuilderRegister<ItemType> SNOWBALL = gen("Snowball",
                                                                 "snowball",
                                                                 builder -> builder.setNetworkId(817).setStackSize(16));
    public static final BuilderRegister<ItemType> SNOW_BLOCK = gen("Snow Block",
                                                                   "snow_block",
                                                                   builder -> builder.setNetworkId(264));
    public static final BuilderRegister<ItemType> SOUL_CAMPFIRE = gen("Soul Campfire",
                                                                      "soul_campfire",
                                                                      builder -> builder.setNetworkId(1103));
    public static final BuilderRegister<ItemType> SOUL_LANTERN = gen("Soul Lantern",
                                                                     "soul_lantern",
                                                                     builder -> builder.setNetworkId(1099));
    public static final BuilderRegister<ItemType> SOUL_SAND = gen("Soul Sand",
                                                                  "soul_sand",
                                                                  builder -> builder.setNetworkId(281));
    public static final BuilderRegister<ItemType> SOUL_SOIL = gen("Soul Soil",
                                                                  "soul_soil",
                                                                  builder -> builder.setNetworkId(282));
    public static final BuilderRegister<ItemType> SOUL_TORCH = gen("Soul Torch",
                                                                   "soul_torch",
                                                                   builder -> builder.setNetworkId(286));
    public static final BuilderRegister<ItemType> SPAWNER = gen("Spawner",
                                                                "spawner",
                                                                builder -> builder.setNetworkId(255));
    public static final BuilderRegister<ItemType> SPECTRAL_ARROW = gen("Spectral Arrow",
                                                                       "spectral_arrow",
                                                                       builder -> builder.setNetworkId(1049));
    public static final BuilderRegister<ItemType> SPIDER_EYE = gen("Spider Eye",
                                                                   "spider_eye",
                                                                   builder -> builder.setNetworkId(904));
    public static final BuilderRegister<ItemType> SPIDER_SPAWN_EGG = gen("Spider Spawn Egg",
                                                                         "spider_spawn_egg",
                                                                         builder -> builder.setNetworkId(962));
    public static final BuilderRegister<ItemType> SPLASH_POTION = gen("Splash Potion",
                                                                      "splash_potion",
                                                                      builder -> builder
                                                                              .setNetworkId(1048)
                                                                              .setStackSize(1));
    public static final BuilderRegister<ItemType> SPONGE = gen("Sponge",
                                                               "sponge",
                                                               builder -> builder.setNetworkId(151));
    public static final BuilderRegister<ItemType> SPORE_BLOSSOM = gen("Spore Blossom",
                                                                      "spore_blossom",
                                                                      builder -> builder.setNetworkId(196));
    public static final BuilderRegister<ItemType> SPRUCE_BOAT = gen("Spruce Boat",
                                                                    "spruce_boat",
                                                                    builder -> builder
                                                                            .setNetworkId(700)
                                                                            .setStackSize(1));
    public static final BuilderRegister<ItemType> SPRUCE_BUTTON = gen("Spruce Button",
                                                                      "spruce_button",
                                                                      builder -> builder.setNetworkId(635));
    public static final BuilderRegister<ItemType> SPRUCE_DOOR = gen("Spruce Door",
                                                                    "spruce_door",
                                                                    builder -> builder.setNetworkId(658));
    public static final BuilderRegister<ItemType> SPRUCE_FENCE = gen("Spruce Fence",
                                                                     "spruce_fence",
                                                                     builder -> builder.setNetworkId(269));
    public static final BuilderRegister<ItemType> SPRUCE_FENCE_GATE = gen("Spruce Fence Gate",
                                                                          "spruce_fence_gate",
                                                                          builder -> builder.setNetworkId(677));
    public static final BuilderRegister<ItemType> SPRUCE_LEAVES = gen("Spruce Leaves",
                                                                      "spruce_leaves",
                                                                      builder -> builder.setNetworkId(143));
    public static final BuilderRegister<ItemType> SPRUCE_LOG = gen("Spruce Log",
                                                                   "spruce_log",
                                                                   builder -> builder.setNetworkId(105));
    public static final BuilderRegister<ItemType> SPRUCE_PLANKS = gen("Spruce Planks",
                                                                      "spruce_planks",
                                                                      builder -> builder.setNetworkId(24));
    public static final BuilderRegister<ItemType> SPRUCE_PRESSURE_PLATE = gen("Spruce Pressure Plate",
                                                                              "spruce_pressure_plate",
                                                                              builder -> builder.setNetworkId(648));
    public static final BuilderRegister<ItemType> SPRUCE_SAPLING = gen("Spruce Sapling",
                                                                       "spruce_sapling",
                                                                       builder -> builder.setNetworkId(33));
    public static final BuilderRegister<ItemType> SPRUCE_SIGN = gen("Spruce Sign",
                                                                    "spruce_sign",
                                                                    builder -> builder
                                                                            .setNetworkId(805)
                                                                            .setStackSize(16));
    public static final BuilderRegister<ItemType> SPRUCE_SLAB = gen("Spruce Slab",
                                                                    "spruce_slab",
                                                                    builder -> builder.setNetworkId(215));
    public static final BuilderRegister<ItemType> SPRUCE_STAIRS = gen("Spruce Stairs",
                                                                      "spruce_stairs",
                                                                      builder -> builder.setNetworkId(339));
    public static final BuilderRegister<ItemType> SPRUCE_TRAPDOOR = gen("Spruce Trapdoor",
                                                                        "spruce_trapdoor",
                                                                        builder -> builder.setNetworkId(668));
    public static final BuilderRegister<ItemType> SPRUCE_WOOD = gen("Spruce Wood",
                                                                    "spruce_wood",
                                                                    builder -> builder.setNetworkId(134));
    public static final BuilderRegister<ItemType> SPYGLASS = gen("Spyglass",
                                                                 "spyglass",
                                                                 builder -> builder.setNetworkId(838).setStackSize(1));
    public static final BuilderRegister<ItemType> SQUID_SPAWN_EGG = gen("Squid Spawn Egg",
                                                                        "squid_spawn_egg",
                                                                        builder -> builder.setNetworkId(963));
    public static final BuilderRegister<ItemType> STICK = gen("Stick", "stick", builder -> builder.setNetworkId(765));
    public static final BuilderRegister<ItemType> STICKY_PISTON = gen("Sticky Piston",
                                                                      "sticky_piston",
                                                                      builder -> builder.setNetworkId(614));
    public static final BuilderRegister<ItemType> STONE = gen("Stone", "stone", builder -> builder.setNetworkId(1));
    public static final BuilderRegister<ItemType> STONECUTTER = gen("Stonecutter",
                                                                    "stonecutter",
                                                                    builder -> builder.setNetworkId(1096));
    public static final BuilderRegister<ItemType> STONE_AXE = gen("Stone Axe",
                                                                  "stone_axe",
                                                                  builder -> builder.setNetworkId(743));
    public static final BuilderRegister<ItemType> STONE_BRICKS = gen("Stone Bricks",
                                                                     "stone_bricks",
                                                                     builder -> builder.setNetworkId(295));
    public static final BuilderRegister<ItemType> STONE_BRICK_SLAB = gen("Stone Brick Slab",
                                                                         "stone_brick_slab",
                                                                         builder -> builder.setNetworkId(230));
    public static final BuilderRegister<ItemType> STONE_BRICK_STAIRS = gen("Stone Brick Stairs",
                                                                           "stone_brick_stairs",
                                                                           builder -> builder.setNetworkId(317));
    public static final BuilderRegister<ItemType> STONE_BRICK_WALL = gen("Stone Brick Wall",
                                                                         "stone_brick_wall",
                                                                         builder -> builder.setNetworkId(356));
    public static final BuilderRegister<ItemType> STONE_BUTTON = gen("Stone Button",
                                                                     "stone_button",
                                                                     builder -> builder.setNetworkId(632));
    public static final BuilderRegister<ItemType> STONE_HOE = gen("Stone Hoe",
                                                                  "stone_hoe",
                                                                  builder -> builder.setNetworkId(744));
    public static final BuilderRegister<ItemType> STONE_PICKAXE = gen("Stone Pickaxe",
                                                                      "stone_pickaxe",
                                                                      builder -> builder.setNetworkId(742));
    public static final BuilderRegister<ItemType> STONE_PRESSURE_PLATE = gen("Stone Pressure Plate",
                                                                             "stone_pressure_plate",
                                                                             builder -> builder.setNetworkId(643));
    public static final BuilderRegister<ItemType> STONE_SHOVEL = gen("Stone Shovel",
                                                                     "stone_shovel",
                                                                     builder -> builder.setNetworkId(741));
    public static final BuilderRegister<ItemType> STONE_SLAB = gen("Stone Slab",
                                                                   "stone_slab",
                                                                   builder -> builder.setNetworkId(223));
    public static final BuilderRegister<ItemType> STONE_STAIRS = gen("Stone Stairs",
                                                                     "stone_stairs",
                                                                     builder -> builder.setNetworkId(578));
    public static final BuilderRegister<ItemType> STONE_SWORD = gen("Stone Sword",
                                                                    "stone_sword",
                                                                    builder -> builder.setNetworkId(740));
    public static final BuilderRegister<ItemType> STRAY_SPAWN_EGG = gen("Stray Spawn Egg",
                                                                        "stray_spawn_egg",
                                                                        builder -> builder.setNetworkId(964));
    public static final BuilderRegister<ItemType> STRIDER_SPAWN_EGG = gen("Strider Spawn Egg",
                                                                          "strider_spawn_egg",
                                                                          builder -> builder.setNetworkId(965));
    public static final BuilderRegister<ItemType> STRING = gen("String",
                                                               "string",
                                                               builder -> builder.setNetworkId(768));
    public static final BuilderRegister<ItemType> STRIPPED_ACACIA_LOG = gen("Stripped Acacia Log",
                                                                            "stripped_acacia_log",
                                                                            builder -> builder.setNetworkId(119));
    public static final BuilderRegister<ItemType> STRIPPED_ACACIA_WOOD = gen("Stripped Acacia Wood",
                                                                             "stripped_acacia_wood",
                                                                             builder -> builder.setNetworkId(128));
    public static final BuilderRegister<ItemType> STRIPPED_BIRCH_LOG = gen("Stripped Birch Log",
                                                                           "stripped_birch_log",
                                                                           builder -> builder.setNetworkId(117));
    public static final BuilderRegister<ItemType> STRIPPED_BIRCH_WOOD = gen("Stripped Birch Wood",
                                                                            "stripped_birch_wood",
                                                                            builder -> builder.setNetworkId(126));
    public static final BuilderRegister<ItemType> STRIPPED_CRIMSON_HYPHAE = gen("Stripped Crimson Hyphae",
                                                                                "stripped_crimson_hyphae",
                                                                                builder -> builder.setNetworkId(131));
    public static final BuilderRegister<ItemType> STRIPPED_CRIMSON_STEM = gen("Stripped Crimson Stem",
                                                                              "stripped_crimson_stem",
                                                                              builder -> builder.setNetworkId(122));
    public static final BuilderRegister<ItemType> STRIPPED_DARK_OAK_LOG = gen("Stripped Dark Oak Log",
                                                                              "stripped_dark_oak_log",
                                                                              builder -> builder.setNetworkId(120));
    public static final BuilderRegister<ItemType> STRIPPED_DARK_OAK_WOOD = gen("Stripped Dark Oak Wood",
                                                                               "stripped_dark_oak_wood",
                                                                               builder -> builder.setNetworkId(129));
    public static final BuilderRegister<ItemType> STRIPPED_JUNGLE_LOG = gen("Stripped Jungle Log",
                                                                            "stripped_jungle_log",
                                                                            builder -> builder.setNetworkId(118));
    public static final BuilderRegister<ItemType> STRIPPED_JUNGLE_WOOD = gen("Stripped Jungle Wood",
                                                                             "stripped_jungle_wood",
                                                                             builder -> builder.setNetworkId(127));
    public static final BuilderRegister<ItemType> STRIPPED_OAK_LOG = gen("Stripped Oak Log",
                                                                         "stripped_oak_log",
                                                                         builder -> builder.setNetworkId(115));
    public static final BuilderRegister<ItemType> STRIPPED_OAK_WOOD = gen("Stripped Oak Wood",
                                                                          "stripped_oak_wood",
                                                                          builder -> builder.setNetworkId(124));
    public static final BuilderRegister<ItemType> STRIPPED_SPRUCE_LOG = gen("Stripped Spruce Log",
                                                                            "stripped_spruce_log",
                                                                            builder -> builder.setNetworkId(116));
    public static final BuilderRegister<ItemType> STRIPPED_SPRUCE_WOOD = gen("Stripped Spruce Wood",
                                                                             "stripped_spruce_wood",
                                                                             builder -> builder.setNetworkId(125));
    public static final BuilderRegister<ItemType> STRIPPED_WARPED_HYPHAE = gen("Stripped Warped Hyphae",
                                                                               "stripped_warped_hyphae",
                                                                               builder -> builder.setNetworkId(132));
    public static final BuilderRegister<ItemType> STRIPPED_WARPED_STEM = gen("Stripped Warped Stem",
                                                                             "stripped_warped_stem",
                                                                             builder -> builder.setNetworkId(123));
    public static final BuilderRegister<ItemType> STRUCTURE_BLOCK = gen("Structure Block",
                                                                        "structure_block",
                                                                        builder -> builder.setNetworkId(712));
    public static final BuilderRegister<ItemType> STRUCTURE_VOID = gen("Structure Void",
                                                                       "structure_void",
                                                                       builder -> builder.setNetworkId(473));
    public static final BuilderRegister<ItemType> SUGAR = gen("Sugar", "sugar", builder -> builder.setNetworkId(867));
    public static final BuilderRegister<ItemType> SUGAR_CANE = gen("Sugar Cane",
                                                                   "sugar_cane",
                                                                   builder -> builder.setNetworkId(206));
    public static final BuilderRegister<ItemType> SUNFLOWER = gen("Sunflower",
                                                                  "sunflower",
                                                                  builder -> builder.setNetworkId(417));
    public static final BuilderRegister<ItemType> SUSPICIOUS_STEW = gen("Suspicious Stew",
                                                                        "suspicious_stew",
                                                                        builder -> builder
                                                                                .setNetworkId(1079)
                                                                                .setStackSize(1));
    public static final BuilderRegister<ItemType> SWEET_BERRIES = gen("Sweet Berries",
                                                                      "sweet_berries",
                                                                      builder -> builder.setNetworkId(1100));
    public static final BuilderRegister<ItemType> TALL_GRASS = gen("Tall Grass",
                                                                   "tall_grass",
                                                                   builder -> builder.setNetworkId(421));
    public static final BuilderRegister<ItemType> TARGET = gen("Target",
                                                               "target",
                                                               builder -> builder.setNetworkId(622));
    public static final BuilderRegister<ItemType> TERRACOTTA = gen("Terracotta",
                                                                   "terracotta",
                                                                   builder -> builder.setNetworkId(414));
    public static final BuilderRegister<ItemType> TINTED_GLASS = gen("Tinted Glass",
                                                                     "tinted_glass",
                                                                     builder -> builder.setNetworkId(154));
    public static final BuilderRegister<ItemType> TIPPED_ARROW = gen("Tipped Arrow",
                                                                     "tipped_arrow",
                                                                     builder -> builder.setNetworkId(1050));
    public static final BuilderRegister<ItemType> TNT = gen("TNT", "tnt", builder -> builder.setNetworkId(629));
    public static final BuilderRegister<ItemType> TNT_MINECART = gen("Minecart with TNT",
                                                                     "tnt_minecart",
                                                                     builder -> builder
                                                                             .setNetworkId(693)
                                                                             .setStackSize(1));
    public static final BuilderRegister<ItemType> TORCH = gen("Torch", "torch", builder -> builder.setNetworkId(248));
    public static final BuilderRegister<ItemType> TOTEM_OF_UNDYING = gen("Totem of Undying",
                                                                         "totem_of_undying",
                                                                         builder -> builder
                                                                                 .setNetworkId(1053)
                                                                                 .setStackSize(1));
    public static final BuilderRegister<ItemType> TRADER_LLAMA_SPAWN_EGG = gen("Trader Llama Spawn Egg",
                                                                               "trader_llama_spawn_egg",
                                                                               builder -> builder.setNetworkId(967));
    public static final BuilderRegister<ItemType> TRAPPED_CHEST = gen("Trapped Chest",
                                                                      "trapped_chest",
                                                                      builder -> builder.setNetworkId(628));
    public static final BuilderRegister<ItemType> TRIDENT = gen("Trident",
                                                                "trident",
                                                                builder -> builder.setNetworkId(1074));
    public static final BuilderRegister<ItemType> TRIPWIRE_HOOK = gen("Tripwire Hook",
                                                                      "tripwire_hook",
                                                                      builder -> builder.setNetworkId(627));
    public static final BuilderRegister<ItemType> TROPICAL_FISH = gen("Tropical Fish",
                                                                      "tropical_fish",
                                                                      builder -> builder.setNetworkId(842));
    public static final BuilderRegister<ItemType> TROPICAL_FISH_BUCKET = gen("Bucket of Tropical Fish",
                                                                             "tropical_fish_bucket",
                                                                             builder -> builder
                                                                                     .setNetworkId(823)
                                                                                     .setStackSize(1));
    public static final BuilderRegister<ItemType> TROPICAL_FISH_SPAWN_EGG = gen("Tropical Fish Spawn Egg",
                                                                                "tropical_fish_spawn_egg",
                                                                                builder -> builder.setNetworkId(968));
    public static final BuilderRegister<ItemType> TUBE_CORAL = gen("Tube Coral",
                                                                   "tube_coral",
                                                                   builder -> builder.setNetworkId(550));
    public static final BuilderRegister<ItemType> TUBE_CORAL_BLOCK = gen("Tube Coral Block",
                                                                         "tube_coral_block",
                                                                         builder -> builder.setNetworkId(545));
    public static final BuilderRegister<ItemType> TUBE_CORAL_FAN = gen("Tube Coral Fan",
                                                                       "tube_coral_fan",
                                                                       builder -> builder.setNetworkId(560));
    public static final BuilderRegister<ItemType> TUFF = gen("Tuff", "tuff", builder -> builder.setNetworkId(12));
    public static final BuilderRegister<ItemType> TURTLE_EGG = gen("Turtle Egg",
                                                                   "turtle_egg",
                                                                   builder -> builder.setNetworkId(539));
    public static final BuilderRegister<ItemType> TURTLE_HELMET = gen("Turtle Shell",
                                                                      "turtle_helmet",
                                                                      builder -> builder.setNetworkId(714));
    public static final BuilderRegister<ItemType> TURTLE_SPAWN_EGG = gen("Turtle Spawn Egg",
                                                                         "turtle_spawn_egg",
                                                                         builder -> builder.setNetworkId(969));
    public static final BuilderRegister<ItemType> TWISTING_VINES = gen("Twisting Vines",
                                                                       "twisting_vines",
                                                                       builder -> builder.setNetworkId(205));
    public static final BuilderRegister<ItemType> VEX_SPAWN_EGG = gen("Vex Spawn Egg",
                                                                      "vex_spawn_egg",
                                                                      builder -> builder.setNetworkId(970));
    public static final BuilderRegister<ItemType> VILLAGER_SPAWN_EGG = gen("Villager Spawn Egg",
                                                                           "villager_spawn_egg",
                                                                           builder -> builder.setNetworkId(971));
    public static final BuilderRegister<ItemType> VINDICATOR_SPAWN_EGG = gen("Vindicator Spawn Egg",
                                                                             "vindicator_spawn_egg",
                                                                             builder -> builder.setNetworkId(972));
    public static final BuilderRegister<ItemType> VINE = gen("Vines", "vine", builder -> builder.setNetworkId(314));
    public static final BuilderRegister<ItemType> WANDERING_TRADER_SPAWN_EGG = gen("Wandering Trader Spawn Egg",
                                                                                   "wandering_trader_spawn_egg",
                                                                                   builder -> builder.setNetworkId(973));
    public static final BuilderRegister<ItemType> WARPED_BUTTON = gen("Warped Button",
                                                                      "warped_button",
                                                                      builder -> builder.setNetworkId(642));
    public static final BuilderRegister<ItemType> WARPED_DOOR = gen("Warped Door",
                                                                    "warped_door",
                                                                    builder -> builder.setNetworkId(665));
    public static final BuilderRegister<ItemType> WARPED_FENCE = gen("Warped Fence",
                                                                     "warped_fence",
                                                                     builder -> builder.setNetworkId(276));
    public static final BuilderRegister<ItemType> WARPED_FENCE_GATE = gen("Warped Fence Gate",
                                                                          "warped_fence_gate",
                                                                          builder -> builder.setNetworkId(684));
    public static final BuilderRegister<ItemType> WARPED_FUNGUS = gen("Warped Fungus",
                                                                      "warped_fungus",
                                                                      builder -> builder.setNetworkId(200));
    public static final BuilderRegister<ItemType> WARPED_FUNGUS_ON_A_STICK = gen("Warped Fungus on a Stick",
                                                                                 "warped_fungus_on_a_stick",
                                                                                 builder -> builder.setNetworkId(696));
    public static final BuilderRegister<ItemType> WARPED_HYPHAE = gen("Warped Hyphae",
                                                                      "warped_hyphae",
                                                                      builder -> builder.setNetworkId(141));
    public static final BuilderRegister<ItemType> WARPED_NYLIUM = gen("Warped Nylium",
                                                                      "warped_nylium",
                                                                      builder -> builder.setNetworkId(21));
    public static final BuilderRegister<ItemType> WARPED_PLANKS = gen("Warped Planks",
                                                                      "warped_planks",
                                                                      builder -> builder.setNetworkId(31));
    public static final BuilderRegister<ItemType> WARPED_PRESSURE_PLATE = gen("Warped Pressure Plate",
                                                                              "warped_pressure_plate",
                                                                              builder -> builder.setNetworkId(655));
    public static final BuilderRegister<ItemType> WARPED_ROOTS = gen("Warped Roots",
                                                                     "warped_roots",
                                                                     builder -> builder.setNetworkId(202));
    public static final BuilderRegister<ItemType> WARPED_SIGN = gen("Warped Sign",
                                                                    "warped_sign",
                                                                    builder -> builder
                                                                            .setNetworkId(812)
                                                                            .setStackSize(16));
    public static final BuilderRegister<ItemType> WARPED_SLAB = gen("Warped Slab",
                                                                    "warped_slab",
                                                                    builder -> builder.setNetworkId(222));
    public static final BuilderRegister<ItemType> WARPED_STAIRS = gen("Warped Stairs",
                                                                      "warped_stairs",
                                                                      builder -> builder.setNetworkId(346));
    public static final BuilderRegister<ItemType> WARPED_STEM = gen("Warped Stem",
                                                                    "warped_stem",
                                                                    builder -> builder.setNetworkId(114));
    public static final BuilderRegister<ItemType> WARPED_TRAPDOOR = gen("Warped Trapdoor",
                                                                        "warped_trapdoor",
                                                                        builder -> builder.setNetworkId(675));
    public static final BuilderRegister<ItemType> WARPED_WART_BLOCK = gen("Warped Wart Block",
                                                                          "warped_wart_block",
                                                                          builder -> builder.setNetworkId(470));
    public static final BuilderRegister<ItemType> WATER_BUCKET = gen("Water Bucket",
                                                                     "water_bucket",
                                                                     builder -> builder
                                                                             .setNetworkId(814)
                                                                             .setStackSize(1));
    public static final BuilderRegister<ItemType> WAXED_COPPER_BLOCK = gen("Waxed Block of Copper",
                                                                           "waxed_copper_block",
                                                                           builder -> builder.setNetworkId(88));
    public static final BuilderRegister<ItemType> WAXED_CUT_COPPER = gen("Waxed Cut Copper",
                                                                         "waxed_cut_copper",
                                                                         builder -> builder.setNetworkId(92));
    public static final BuilderRegister<ItemType> WAXED_CUT_COPPER_SLAB = gen("Waxed Cut Copper Slab",
                                                                              "waxed_cut_copper_slab",
                                                                              builder -> builder.setNetworkId(100));
    public static final BuilderRegister<ItemType> WAXED_CUT_COPPER_STAIRS = gen("Waxed Cut Copper Stairs",
                                                                                "waxed_cut_copper_stairs",
                                                                                builder -> builder.setNetworkId(96));
    public static final BuilderRegister<ItemType> WAXED_EXPOSED_COPPER = gen("Waxed Exposed Copper",
                                                                             "waxed_exposed_copper",
                                                                             builder -> builder.setNetworkId(89));
    public static final BuilderRegister<ItemType> WAXED_EXPOSED_CUT_COPPER = gen("Waxed Exposed Cut Copper",
                                                                                 "waxed_exposed_cut_copper",
                                                                                 builder -> builder.setNetworkId(93));
    public static final BuilderRegister<ItemType> WAXED_EXPOSED_CUT_COPPER_SLAB = gen("Waxed Exposed Cut Copper Slab",
                                                                                      "waxed_exposed_cut_copper_slab",
                                                                                      builder -> builder.setNetworkId(
                                                                                              101));
    public static final BuilderRegister<ItemType> WAXED_EXPOSED_CUT_COPPER_STAIRS = gen(
            "Waxed Exposed Cut Copper Stairs",
            "waxed_exposed_cut_copper_stairs",
            builder -> builder.setNetworkId(97));
    public static final BuilderRegister<ItemType> WAXED_OXIDIZED_COPPER = gen("Waxed Oxidized Copper",
                                                                              "waxed_oxidized_copper",
                                                                              builder -> builder.setNetworkId(91));
    public static final BuilderRegister<ItemType> WAXED_OXIDIZED_CUT_COPPER = gen("Waxed Oxidized Cut Copper",
                                                                                  "waxed_oxidized_cut_copper",
                                                                                  builder -> builder.setNetworkId(95));
    public static final BuilderRegister<ItemType> WAXED_OXIDIZED_CUT_COPPER_SLAB = gen("Waxed Oxidized Cut Copper Slab",
                                                                                       "waxed_oxidized_cut_copper_slab",
                                                                                       builder -> builder.setNetworkId(
                                                                                               103));
    public static final BuilderRegister<ItemType> WAXED_OXIDIZED_CUT_COPPER_STAIRS = gen(
            "Waxed Oxidized Cut Copper Stairs",
            "waxed_oxidized_cut_copper_stairs",
            builder -> builder.setNetworkId(99));
    public static final BuilderRegister<ItemType> WAXED_WEATHERED_COPPER = gen("Waxed Weathered Copper",
                                                                               "waxed_weathered_copper",
                                                                               builder -> builder.setNetworkId(90));
    public static final BuilderRegister<ItemType> WAXED_WEATHERED_CUT_COPPER = gen("Waxed Weathered Cut Copper",
                                                                                   "waxed_weathered_cut_copper",
                                                                                   builder -> builder.setNetworkId(94));
    public static final BuilderRegister<ItemType> WAXED_WEATHERED_CUT_COPPER_SLAB = gen(
            "Waxed Weathered Cut Copper Slab",
            "waxed_weathered_cut_copper_slab",
            builder -> builder.setNetworkId(102));
    public static final BuilderRegister<ItemType> WAXED_WEATHERED_CUT_COPPER_STAIRS = gen(
            "Waxed Weathered Cut Copper Stairs",
            "waxed_weathered_cut_copper_stairs",
            builder -> builder.setNetworkId(98));
    public static final BuilderRegister<ItemType> WEATHERED_COPPER = gen("Weathered Copper",
                                                                         "weathered_copper",
                                                                         builder -> builder.setNetworkId(74));
    public static final BuilderRegister<ItemType> WEATHERED_CUT_COPPER = gen("Weathered Cut Copper",
                                                                             "weathered_cut_copper",
                                                                             builder -> builder.setNetworkId(78));
    public static final BuilderRegister<ItemType> WEATHERED_CUT_COPPER_SLAB = gen("Weathered Cut Copper Slab",
                                                                                  "weathered_cut_copper_slab",
                                                                                  builder -> builder.setNetworkId(86));
    public static final BuilderRegister<ItemType> WEATHERED_CUT_COPPER_STAIRS = gen("Weathered Cut Copper Stairs",
                                                                                    "weathered_cut_copper_stairs",
                                                                                    builder -> builder.setNetworkId(82));
    public static final BuilderRegister<ItemType> WEEPING_VINES = gen("Weeping Vines",
                                                                      "weeping_vines",
                                                                      builder -> builder.setNetworkId(204));
    public static final BuilderRegister<ItemType> WET_SPONGE = gen("Wet Sponge",
                                                                   "wet_sponge",
                                                                   builder -> builder.setNetworkId(152));
    public static final BuilderRegister<ItemType> WHEAT = gen("Wheat", "wheat", builder -> builder.setNetworkId(772));
    public static final BuilderRegister<ItemType> WHEAT_SEEDS = gen("Wheat Seeds",
                                                                    "wheat_seeds",
                                                                    builder -> builder.setNetworkId(771));
    public static final BuilderRegister<ItemType> WHITE_BANNER = gen("White Banner",
                                                                     "white_banner",
                                                                     builder -> builder
                                                                             .setNetworkId(1025)
                                                                             .setStackSize(16));
    public static final BuilderRegister<ItemType> WHITE_BED = gen("White Bed",
                                                                  "white_bed",
                                                                  builder -> builder.setNetworkId(869).setStackSize(1));
    public static final BuilderRegister<ItemType> WHITE_CANDLE = gen("White Candle",
                                                                     "white_candle",
                                                                     builder -> builder.setNetworkId(1126));
    public static final BuilderRegister<ItemType> WHITE_CARPET = gen("White Carpet",
                                                                     "white_carpet",
                                                                     builder -> builder.setNetworkId(398));
    public static final BuilderRegister<ItemType> WHITE_CONCRETE = gen("White Concrete",
                                                                       "white_concrete",
                                                                       builder -> builder.setNetworkId(507));
    public static final BuilderRegister<ItemType> WHITE_CONCRETE_POWDER = gen("White Concrete Powder",
                                                                              "white_concrete_powder",
                                                                              builder -> builder.setNetworkId(523));
    public static final BuilderRegister<ItemType> WHITE_DYE = gen("White Dye",
                                                                  "white_dye",
                                                                  builder -> builder.setNetworkId(849));
    public static final BuilderRegister<ItemType> WHITE_GLAZED_TERRACOTTA = gen("White Glazed Terracotta",
                                                                                "white_glazed_terracotta",
                                                                                builder -> builder.setNetworkId(491));
    public static final BuilderRegister<ItemType> WHITE_SHULKER_BOX = gen("White Shulker Box",
                                                                          "white_shulker_box",
                                                                          builder -> builder
                                                                                  .setNetworkId(475)
                                                                                  .setStackSize(1));
    public static final BuilderRegister<ItemType> WHITE_STAINED_GLASS = gen("White Stained Glass",
                                                                            "white_stained_glass",
                                                                            builder -> builder.setNetworkId(423));
    public static final BuilderRegister<ItemType> WHITE_STAINED_GLASS_PANE = gen("White Stained Glass Pane",
                                                                                 "white_stained_glass_pane",
                                                                                 builder -> builder.setNetworkId(439));
    public static final BuilderRegister<ItemType> WHITE_TERRACOTTA = gen("White Terracotta",
                                                                         "white_terracotta",
                                                                         builder -> builder.setNetworkId(379));
    public static final BuilderRegister<ItemType> WHITE_TULIP = gen("White Tulip",
                                                                    "white_tulip",
                                                                    builder -> builder.setNetworkId(190));
    public static final BuilderRegister<ItemType> WHITE_WOOL = gen("White Wool",
                                                                   "white_wool",
                                                                   builder -> builder.setNetworkId(167));
    public static final BuilderRegister<ItemType> WITCH_SPAWN_EGG = gen("Witch Spawn Egg",
                                                                        "witch_spawn_egg",
                                                                        builder -> builder.setNetworkId(975));
    public static final BuilderRegister<ItemType> WITHER_ROSE = gen("Wither Rose",
                                                                    "wither_rose",
                                                                    builder -> builder.setNetworkId(195));
    public static final BuilderRegister<ItemType> WITHER_SKELETON_SKULL = gen("Wither Skeleton Skull",
                                                                              "wither_skeleton_skull",
                                                                              builder -> builder.setNetworkId(997));
    public static final BuilderRegister<ItemType> WITHER_SKELETON_SPAWN_EGG = gen("Wither Skeleton Spawn Egg",
                                                                                  "wither_skeleton_spawn_egg",
                                                                                  builder -> builder.setNetworkId(976));
    public static final BuilderRegister<ItemType> WOLF_SPAWN_EGG = gen("Wolf Spawn Egg",
                                                                       "wolf_spawn_egg",
                                                                       builder -> builder.setNetworkId(977));
    public static final BuilderRegister<ItemType> WOODEN_AXE = gen("Wooden Axe",
                                                                   "wooden_axe",
                                                                   builder -> builder.setNetworkId(738));
    public static final BuilderRegister<ItemType> WOODEN_HOE = gen("Wooden Hoe",
                                                                   "wooden_hoe",
                                                                   builder -> builder.setNetworkId(739));
    public static final BuilderRegister<ItemType> WOODEN_PICKAXE = gen("Wooden Pickaxe",
                                                                       "wooden_pickaxe",
                                                                       builder -> builder.setNetworkId(737));
    public static final BuilderRegister<ItemType> WOODEN_SHOVEL = gen("Wooden Shovel",
                                                                      "wooden_shovel",
                                                                      builder -> builder.setNetworkId(736));
    public static final BuilderRegister<ItemType> WOODEN_SWORD = gen("Wooden Sword",
                                                                     "wooden_sword",
                                                                     builder -> builder.setNetworkId(735));
    public static final BuilderRegister<ItemType> WRITABLE_BOOK = gen("Book and Quill",
                                                                      "writable_book",
                                                                      builder -> builder
                                                                              .setNetworkId(985)
                                                                              .setStackSize(1)
                                                                              .addSupportedData(StackDataKeys.SIMPLE_PAGES));
    public static final BuilderRegister<ItemType> WRITTEN_BOOK = gen("Written Book",
                                                                     "written_book",
                                                                     builder -> builder
                                                                             .setNetworkId(986)
                                                                             .setStackSize(16));
    public static final BuilderRegister<ItemType> YELLOW_BANNER = gen("Yellow Banner",
                                                                      "yellow_banner",
                                                                      builder -> builder
                                                                              .setNetworkId(1029)
                                                                              .setStackSize(16));
    public static final BuilderRegister<ItemType> YELLOW_BED = gen("Yellow Bed",
                                                                   "yellow_bed",
                                                                   builder -> builder
                                                                           .setNetworkId(873)
                                                                           .setStackSize(1));
    public static final BuilderRegister<ItemType> YELLOW_CANDLE = gen("Yellow Candle",
                                                                      "yellow_candle",
                                                                      builder -> builder.setNetworkId(1130));
    public static final BuilderRegister<ItemType> YELLOW_CARPET = gen("Yellow Carpet",
                                                                      "yellow_carpet",
                                                                      builder -> builder.setNetworkId(402));
    public static final BuilderRegister<ItemType> YELLOW_CONCRETE = gen("Yellow Concrete",
                                                                        "yellow_concrete",
                                                                        builder -> builder.setNetworkId(511));
    public static final BuilderRegister<ItemType> YELLOW_CONCRETE_POWDER = gen("Yellow Concrete Powder",
                                                                               "yellow_concrete_powder",
                                                                               builder -> builder.setNetworkId(527));
    public static final BuilderRegister<ItemType> YELLOW_DYE = gen("Yellow Dye",
                                                                   "yellow_dye",
                                                                   builder -> builder.setNetworkId(853));
    public static final BuilderRegister<ItemType> YELLOW_GLAZED_TERRACOTTA = gen("Yellow Glazed Terracotta",
                                                                                 "yellow_glazed_terracotta",
                                                                                 builder -> builder.setNetworkId(495));
    public static final BuilderRegister<ItemType> YELLOW_SHULKER_BOX = gen("Yellow Shulker Box",
                                                                           "yellow_shulker_box",
                                                                           builder -> builder
                                                                                   .setNetworkId(479)
                                                                                   .setStackSize(1));
    public static final BuilderRegister<ItemType> YELLOW_STAINED_GLASS = gen("Yellow Stained Glass",
                                                                             "yellow_stained_glass",
                                                                             builder -> builder.setNetworkId(427));
    public static final BuilderRegister<ItemType> YELLOW_STAINED_GLASS_PANE = gen("Yellow Stained Glass Pane",
                                                                                  "yellow_stained_glass_pane",
                                                                                  builder -> builder.setNetworkId(443));
    public static final BuilderRegister<ItemType> YELLOW_TERRACOTTA = gen("Yellow Terracotta",
                                                                          "yellow_terracotta",
                                                                          builder -> builder.setNetworkId(383));
    public static final BuilderRegister<ItemType> YELLOW_WOOL = gen("Yellow Wool",
                                                                    "yellow_wool",
                                                                    builder -> builder.setNetworkId(171));
    public static final BuilderRegister<ItemType> ZOGLIN_SPAWN_EGG = gen("Zoglin Spawn Egg",
                                                                         "zoglin_spawn_egg",
                                                                         builder -> builder.setNetworkId(978));
    public static final BuilderRegister<ItemType> ZOMBIE_HEAD = gen("Zombie Head",
                                                                    "zombie_head",
                                                                    builder -> builder.setNetworkId(999));
    public static final BuilderRegister<ItemType> ZOMBIE_HORSE_SPAWN_EGG = gen("Zombie Horse Spawn Egg",
                                                                               "zombie_horse_spawn_egg",
                                                                               builder -> builder.setNetworkId(980));
    public static final BuilderRegister<ItemType> ZOMBIE_SPAWN_EGG = gen("Zombie Spawn Egg",
                                                                         "zombie_spawn_egg",
                                                                         builder -> builder.setNetworkId(979));
    public static final BuilderRegister<ItemType> ZOMBIE_VILLAGER_SPAWN_EGG = gen("Zombie Villager Spawn Egg",
                                                                                  "zombie_villager_spawn_egg",
                                                                                  builder -> builder.setNetworkId(981));
    public static final BuilderRegister<ItemType> ZOMBIFIED_PIGLIN_SPAWN_EGG = gen("Zombified Piglin Spawn Egg",
                                                                                   "zombified_piglin_spawn_egg",
                                                                                   builder -> builder.setNetworkId(982));


    private static BuilderRegister<ItemType> gen(String name, String key,
                                                 Function<ItemTypeBuilder, ItemTypeBuilder> function) {
        return new BuilderRegister<>(name,
                                     Identifiable.MINECRAFT_HOST,
                                     key,
                                     () -> function
                                             .apply(new ItemTypeBuilder()
                                                            .setHost(Identifiable.MINECRAFT_HOST)
                                                            .setKey(key)
                                                            .setName(name))
                                             .build());
    }
}

