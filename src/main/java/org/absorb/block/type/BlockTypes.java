
package org.absorb.block.type;

import org.absorb.block.state.properties.type.bool.BooleanBlockStatePropertyTypes;
import org.absorb.block.state.properties.type.enu.EnumBlockStatePropertyTypes;
import org.absorb.block.state.properties.type.number.IntegerBlockStatePropertyTypes;
import org.absorb.block.type.properties.mass.MassType;
import org.absorb.inventory.item.ItemTypes;
import org.absorb.register.registry.BuilderRegister;
import org.absorb.utils.Identifiable;

import java.util.function.Function;

@SuppressWarnings("unused")
public abstract class BlockTypes {

    public static final BuilderRegister<BlockType> ACACIA_BUTTON = gen(
            "Acacia Button",
            "acacia_button",
            builder -> builder
                    .setNetworkId(325)
                    .setMass(MassType.SOLID)
                    .setItem(ItemTypes.ACACIA_BUTTON)
                    .addStateProperty(EnumBlockStatePropertyTypes.FACING)
                    .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
                    .addStateProperty(EnumBlockStatePropertyTypes.ATTACHABLE_FACE_STANDARD));
    public static final BuilderRegister<BlockType> ACACIA_DOOR = gen(
            "Acacia Door",
            "acacia_door",
            builder -> builder
                    .setNetworkId(502)
                    .setMass(MassType.SOLID)
                    .setItem(ItemTypes.ACACIA_DOOR)
                    .addStateProperty(EnumBlockStatePropertyTypes.HALF)
                    .addStateProperty(EnumBlockStatePropertyTypes.FACING)
                    .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
                    .addStateProperty(EnumBlockStatePropertyTypes.HINGE)
                    .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> ACACIA_FENCE = gen("Acacia Fence", "acacia_fence", builder -> builder
            .setNetworkId(497)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ACACIA_FENCE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> ACACIA_FENCE_GATE = gen("Acacia Fence Gate", "acacia_fence_gate", builder -> builder
            .setNetworkId(492)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ACACIA_FENCE_GATE)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.IN_WALL));
    public static final BuilderRegister<BlockType> ACACIA_LEAVES = gen("Acacia Leaves", "acacia_leaves", builder -> builder
            .setNetworkId(66)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ACACIA_LEAVES)
            .addStateProperty(IntegerBlockStatePropertyTypes.DISTANCE)
            .addStateProperty(BooleanBlockStatePropertyTypes.PERSISTENT));
    public static final BuilderRegister<BlockType> ACACIA_LOG = gen("Acacia Log", "acacia_log", builder -> builder
            .setNetworkId(42)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ACACIA_LOG)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> ACACIA_PLANKS = gen("Acacia Planks", "acacia_planks", builder -> builder
            .setNetworkId(17)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ACACIA_PLANKS));
    public static final BuilderRegister<BlockType> ACACIA_PRESSURE_PLATE = gen("Acacia Pressure Plate", "acacia_pressure_plate", builder -> builder
            .setNetworkId(185)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ACACIA_PRESSURE_PLATE)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> ACACIA_SAPLING = gen("Acacia Sapling", "acacia_sapling", builder -> builder
            .setNetworkId(23)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ACACIA_SAPLING)
            .addStateProperty(IntegerBlockStatePropertyTypes.GROWTH_STAGE));
    public static final BuilderRegister<BlockType> ACACIA_SIGN = gen("Acacia Sign", "acacia_sign",
            builder -> builder
                    .setNetworkId(165)
                    .setMass(MassType.SOLID)
                    .setItem(ItemTypes.ACACIA_SIGN)
                    .addStateProperty(EnumBlockStatePropertyTypes.ROTATION)
                    .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> ACACIA_SLAB = gen("Acacia Slab", "acacia_slab",
            builder -> builder
                    .setNetworkId(470)
                    .setMass(MassType.SOLID)
                    .setItem(ItemTypes.ACACIA_SLAB)
                    .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
                    .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> ACACIA_STAIRS = gen("Acacia Stairs", "acacia_stairs", builder ->
            builder
                    .setNetworkId(388)
                    .setMass(MassType.SOLID)
                    .setItem(ItemTypes.ACACIA_STAIRS)
                    .addStateProperty(EnumBlockStatePropertyTypes.FACING)
                    .addStateProperty(EnumBlockStatePropertyTypes.HALF)
                    .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
                    .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> ACACIA_TRAPDOOR = gen("Acacia Trapdoor", "acacia_trapdoor", builder -> builder
            .setNetworkId(234)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ACACIA_TRAPDOOR)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> ACACIA_WALL_SIGN = gen("Acacia Wall Sign", "acacia_wall_sign", builder -> builder
            .setNetworkId(175)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ACACIA_SIGN)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> ACACIA_WOOD = gen("Acacia Wood", "acacia_wood", builder -> builder
            .setNetworkId(54)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ACACIA_WOOD)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> ACTIVATOR_RAIL = gen("Activator Rail", "activator_rail", builder -> builder
            .setNetworkId(354)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ACTIVATOR_RAIL)
            .addStateProperty(EnumBlockStatePropertyTypes.STRAIGHT_RAIL_DIRECTION)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> AIR = gen("Air", "air", builder -> builder
            .setNetworkId(0)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.AIR));
    public static final BuilderRegister<BlockType> ALLIUM = gen("Allium", "allium", builder -> builder
            .setNetworkId(128)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ALLIUM));
    public static final BuilderRegister<BlockType> AMETHYST_BLOCK = gen("Block of Amethyst", "amethyst_block", builder -> builder
            .setNetworkId(811)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.AMETHYST_BLOCK));
    public static final BuilderRegister<BlockType> AMETHYST_CLUSTER = gen("Amethyst Cluster", "amethyst_cluster", builder -> builder
            .setNetworkId(813)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.AMETHYST_CLUSTER)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> ANCIENT_DEBRIS = gen("Ancient Debris", "ancient_debris", builder -> builder
            .setNetworkId(749)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ANCIENT_DEBRIS));
    public static final BuilderRegister<BlockType> ANDESITE = gen("Andesite", "andesite", builder -> builder
            .setNetworkId(6)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ANDESITE));
    public static final BuilderRegister<BlockType> ANDESITE_SLAB = gen("Andesite Slab", "andesite_slab", builder -> builder
            .setNetworkId(664)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ANDESITE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> ANDESITE_STAIRS = gen("Andesite Stairs", "andesite_stairs", builder -> builder
            .setNetworkId(651)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ANDESITE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> ANDESITE_WALL = gen("Andesite Wall", "andesite_wall", builder -> builder
            .setNetworkId(675)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ANDESITE_WALL)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> ANVIL = gen("Anvil", "anvil", builder -> builder
            .setNetworkId(339)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ANVIL)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> ATTACHED_MELON_STEM = gen("Attached Melon Stem", "attached_melon_stem", builder -> builder
            .setNetworkId(254)
            .setMass(MassType.SOLID)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> ATTACHED_PUMPKIN_STEM = gen("Attached Pumpkin Stem",
            "attached_pumpkin_stem", builder -> builder
                    .setNetworkId(253)
                    .setMass(MassType.SOLID)
                    .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> AZALEA = gen("Azalea", "azalea", builder -> builder
            .setNetworkId(862)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.AZALEA));
    public static final BuilderRegister<BlockType> AZALEA_LEAVES = gen("Azalea Leaves", "azalea_leaves", builder -> builder
            .setNetworkId(68)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.AZALEA_LEAVES)
            .addStateProperty(IntegerBlockStatePropertyTypes.DISTANCE)
            .addStateProperty(BooleanBlockStatePropertyTypes.PERSISTENT));
    public static final BuilderRegister<BlockType> AZURE_BLUET = gen("Azure Bluet", "azure_bluet", builder -> builder
            .setNetworkId(129)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.AZURE_BLUET));
    public static final BuilderRegister<BlockType> BAMBOO = gen("Bamboo", "bamboo", builder -> builder
            .setNetworkId(636)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BAMBOO)
            .addStateProperty(IntegerBlockStatePropertyTypes.AGE_2)
            .addStateProperty(EnumBlockStatePropertyTypes.LEAVES)
            .addStateProperty(IntegerBlockStatePropertyTypes.GROWTH_STAGE));
    public static final BuilderRegister<BlockType> BAMBOO_SAPLING = gen("Bamboo Shoot", "bamboo_sapling", builder -> builder
            .setNetworkId(635)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BAMBOO));
    public static final BuilderRegister<BlockType> BARREL = gen("Barrel", "barrel", builder -> builder
            .setNetworkId(682)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BARREL)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN));
    public static final BuilderRegister<BlockType> BARRIER = gen("Barrier", "barrier", builder -> builder
            .setNetworkId(391)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BARRIER));
    public static final BuilderRegister<BlockType> BASALT = gen("Basalt", "basalt", builder -> builder
            .setNetworkId(204)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BASALT)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> BEACON = gen("Beacon", "beacon", builder -> builder
            .setNetworkId(291)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BEACON));
    public static final BuilderRegister<BlockType> BEDROCK = gen("Bedrock", "bedrock", builder -> builder
            .setNetworkId(25)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BEDROCK));
    public static final BuilderRegister<BlockType> BEEHIVE = gen("Beehive", "beehive", builder -> builder
            .setNetworkId(745)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BEEHIVE)
            .addStateProperty(IntegerBlockStatePropertyTypes.HONEY_LEVEL)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> BEETROOTS = gen("Beetroots", "beetroots", builder -> builder
            .setNetworkId(511)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BEETROOT)
            .addStateProperty(IntegerBlockStatePropertyTypes.AGE_4));
    public static final BuilderRegister<BlockType> BEE_NEST = gen("Bee Nest", "bee_nest", builder -> builder
            .setNetworkId(744)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BEE_NEST)
            .addStateProperty(IntegerBlockStatePropertyTypes.HONEY_LEVEL)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> BELL = gen("Bell", "bell", builder -> builder
            .setNetworkId(691)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BELL)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.ATTACHABLE_FACE_DOUBLE)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> BIG_DRIPLEAF = gen("Big Dripleaf", "big_dripleaf", builder -> builder
            .setNetworkId(866)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BIG_DRIPLEAF)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.DRIP_LEAF_TILT));
    public static final BuilderRegister<BlockType> BIG_DRIPLEAF_STEM = gen("Big Dripleaf Stem", "big_dripleaf_stem", builder -> builder
            .setNetworkId(867)
            .setMass(MassType.SOLID)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> BIRCH_BUTTON = gen("Birch Button", "birch_button", builder -> builder
            .setNetworkId(323)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BIRCH_BUTTON)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(EnumBlockStatePropertyTypes.ATTACHABLE_FACE_STANDARD));
    public static final BuilderRegister<BlockType> BIRCH_DOOR = gen("Birch Door", "birch_door", builder -> builder
            .setNetworkId(500)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BIRCH_DOOR)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(EnumBlockStatePropertyTypes.HINGE)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> BIRCH_FENCE = gen("Birch Fence", "birch_fence", builder -> builder
            .setNetworkId(495)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BIRCH_FENCE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BIRCH_FENCE_GATE = gen("Birch Fence Gate", "birch_fence_gate", builder -> builder
            .setNetworkId(490)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BIRCH_FENCE_GATE)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.IN_WALL));
    public static final BuilderRegister<BlockType> BIRCH_LEAVES = gen("Birch Leaves", "birch_leaves", builder -> builder
            .setNetworkId(64)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BIRCH_LEAVES)
            .addStateProperty(IntegerBlockStatePropertyTypes.DISTANCE)
            .addStateProperty(BooleanBlockStatePropertyTypes.PERSISTENT));
    public static final BuilderRegister<BlockType> BIRCH_LOG = gen("Birch Log", "birch_log", builder -> builder
            .setNetworkId(40)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BIRCH_LOG)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> BIRCH_PLANKS = gen("Birch Planks", "birch_planks", builder -> builder
            .setNetworkId(15)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BIRCH_PLANKS));
    public static final BuilderRegister<BlockType> BIRCH_PRESSURE_PLATE = gen("Birch Pressure Plate", "birch_pressure_plate", builder -> builder
            .setNetworkId(183)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BIRCH_PRESSURE_PLATE)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> BIRCH_SAPLING = gen("Birch Sapling", "birch_sapling",
            builder -> builder
                    .setNetworkId(21)
                    .setMass(MassType.SOLID)
                    .setItem(ItemTypes.BIRCH_SAPLING)
                    .addStateProperty(IntegerBlockStatePropertyTypes.GROWTH_STAGE));
    public static final BuilderRegister<BlockType> BIRCH_SIGN = gen("Birch Sign", "birch_sign", builder -> builder
            .setNetworkId(164)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BIRCH_SIGN)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BIRCH_SLAB = gen("Birch Slab", "birch_slab", builder -> builder
            .setNetworkId(468)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BIRCH_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BIRCH_STAIRS = gen("Birch Stairs", "birch_stairs", builder -> builder
            .setNetworkId(288)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BIRCH_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BIRCH_TRAPDOOR = gen("Birch Trapdoor", "birch_trapdoor", builder -> builder
            .setNetworkId(232)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BIRCH_TRAPDOOR)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BIRCH_WALL_SIGN = gen("Birch Wall Sign", "birch_wall_sign", builder -> builder
            .setNetworkId(174)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BIRCH_SIGN)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BIRCH_WOOD = gen("Birch Wood", "birch_wood", builder -> builder
            .setNetworkId(52)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BIRCH_WOOD)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> BLACKSTONE = gen("Blackstone", "blackstone", builder -> builder
            .setNetworkId(757)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLACKSTONE));
    public static final BuilderRegister<BlockType> BLACKSTONE_SLAB = gen("Blackstone Slab", "blackstone_slab", builder -> builder
            .setNetworkId(760)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLACKSTONE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BLACKSTONE_STAIRS = gen("Blackstone Stairs", "blackstone_stairs", builder -> builder
            .setNetworkId(758)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLACKSTONE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BLACKSTONE_WALL = gen("Blackstone Wall", "blackstone_wall", builder -> builder
            .setNetworkId(759)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLACKSTONE_WALL)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BLACK_BANNER = gen("Black Banner", "black_banner", builder -> builder
            .setNetworkId(445)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLACK_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> BLACK_BED = gen("Black Bed", "black_bed", builder -> builder
            .setNetworkId(96)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLACK_BED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.BED_HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.OCCUPIED));
    public static final BuilderRegister<BlockType> BLACK_CANDLE = gen("Black Candle", "black_candle", builder -> builder
            .setNetworkId(793)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLACK_CANDLE)
            .addStateProperty(IntegerBlockStatePropertyTypes.CANDLES)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BLACK_CANDLE_CAKE = gen("Cake with Black Candle", "black_candle_cake", builder -> builder
            .setNetworkId(810)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAKE)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> BLACK_CARPET = gen("Black Carpet", "black_carpet", builder -> builder
            .setNetworkId(420)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLACK_CARPET));
    public static final BuilderRegister<BlockType> BLACK_CONCRETE = gen("Black Concrete", "black_concrete", builder -> builder
            .setNetworkId(571)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLACK_CONCRETE));
    public static final BuilderRegister<BlockType> BLACK_CONCRETE_POWDER = gen("Black Concrete Powder", "black_concrete_powder", builder -> builder
            .setNetworkId(587)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLACK_CONCRETE_POWDER));
    public static final BuilderRegister<BlockType> BLACK_GLAZED_TERRACOTTA = gen("Black Glazed Terracotta", "black_glazed_terracotta", builder -> builder
            .setNetworkId(555)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLACK_GLAZED_TERRACOTTA)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> BLACK_SHULKER_BOX = gen("Black Shulker Box", "black_shulker_box", builder -> builder
            .setNetworkId(539)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLACK_SHULKER_BOX)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> BLACK_STAINED_GLASS = gen("Black Stained Glass", "black_stained_glass", builder -> builder
            .setNetworkId(229)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLACK_STAINED_GLASS));
    public static final BuilderRegister<BlockType> BLACK_STAINED_GLASS_PANE = gen("Black Stained Glass Pane", "black_stained_glass_pane", builder -> builder
            .setNetworkId(387)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLACK_STAINED_GLASS_PANE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BLACK_TERRACOTTA = gen("Black Terracotta", "black_terracotta", builder -> builder
            .setNetworkId(371)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLACK_TERRACOTTA));
    public static final BuilderRegister<BlockType> BLACK_WALL_BANNER = gen("null", "black_wall_banner", builder -> builder
            .setNetworkId(461)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLACK_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> BLACK_WOOL = gen("Black Wool", "black_wool", builder -> builder
            .setNetworkId(123)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLACK_WOOL));
    public static final BuilderRegister<BlockType> BLAST_FURNACE = gen("Blast Furnace", "blast_furnace", builder -> builder
            .setNetworkId(684)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLAST_FURNACE)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> BLUE_BANNER = gen("Blue Banner", "blue_banner", builder -> builder
            .setNetworkId(441)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLUE_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> BLUE_BED = gen("Blue Bed", "blue_bed", builder -> builder
            .setNetworkId(92)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLUE_BED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.BED_HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.OCCUPIED));
    public static final BuilderRegister<BlockType> BLUE_CANDLE = gen("Blue Candle", "blue_candle", builder -> builder
            .setNetworkId(789)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLUE_CANDLE)
            .addStateProperty(IntegerBlockStatePropertyTypes.CANDLES)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BLUE_CANDLE_CAKE = gen(
            "Cake with Blue Candle",
            "blue_candle_cake",
            builder -> builder
                    .setNetworkId(806)
                    .setMass(MassType.SOLID)
                    .setItem(ItemTypes.CAKE)
                    .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> BLUE_CARPET = gen("Blue Carpet", "blue_carpet", builder -> builder
            .setNetworkId(416)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLUE_CARPET));
    public static final BuilderRegister<BlockType> BLUE_CONCRETE = gen("Blue Concrete", "blue_concrete", builder -> builder
            .setNetworkId(567)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLUE_CONCRETE));
    public static final BuilderRegister<BlockType> BLUE_CONCRETE_POWDER = gen("Blue Concrete Powder", "blue_concrete_powder", builder -> builder
            .setNetworkId(583)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLUE_CONCRETE_POWDER));
    public static final BuilderRegister<BlockType> BLUE_GLAZED_TERRACOTTA = gen("Blue Glazed Terracotta", "blue_glazed_terracotta", builder -> builder
            .setNetworkId(551)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLUE_GLAZED_TERRACOTTA)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> BLUE_ICE = gen("Blue Ice", "blue_ice", builder -> builder
            .setNetworkId(633)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLUE_ICE));
    public static final BuilderRegister<BlockType> BLUE_ORCHID = gen("Blue Orchid", "blue_orchid", builder -> builder
            .setNetworkId(127)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLUE_ORCHID));
    public static final BuilderRegister<BlockType> BLUE_SHULKER_BOX = gen("Blue Shulker Box", "blue_shulker_box", builder -> builder
            .setNetworkId(535)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLUE_SHULKER_BOX)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> BLUE_STAINED_GLASS = gen("Blue Stained Glass", "blue_stained_glass", builder -> builder
            .setNetworkId(225)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLUE_STAINED_GLASS));
    public static final BuilderRegister<BlockType> BLUE_STAINED_GLASS_PANE = gen("Blue Stained Glass Pane", "blue_stained_glass_pane", builder -> builder
            .setNetworkId(383)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLUE_STAINED_GLASS_PANE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BLUE_TERRACOTTA = gen("Blue Terracotta", "blue_terracotta", builder -> builder
            .setNetworkId(367)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLUE_TERRACOTTA));
    public static final BuilderRegister<BlockType> BLUE_WALL_BANNER = gen("null", "blue_wall_banner", builder -> builder
            .setNetworkId(457)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLUE_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> BLUE_WOOL = gen("Blue Wool", "blue_wool", builder -> builder
            .setNetworkId(119)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BLUE_WOOL));
    public static final BuilderRegister<BlockType> BONE_BLOCK = gen("Bone Block", "bone_block", builder -> builder
            .setNetworkId(520)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BONE_BLOCK)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> BOOKSHELF = gen("Bookshelf", "bookshelf", builder -> builder
            .setNetworkId(144)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BOOKSHELF));
    public static final BuilderRegister<BlockType> BRAIN_CORAL = gen("Brain Coral", "brain_coral", builder -> builder
            .setNetworkId(608)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BRAIN_CORAL)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BRAIN_CORAL_BLOCK = gen("Brain Coral Block", "brain_coral_block", builder -> builder
            .setNetworkId(598)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BRAIN_CORAL_BLOCK));
    public static final BuilderRegister<BlockType> BRAIN_CORAL_FAN = gen("Brain Coral Fan", "brain_coral_fan", builder -> builder
            .setNetworkId(618)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BRAIN_CORAL_FAN)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BRAIN_CORAL_WALL_FAN = gen("Brain Coral Wall Fan", "brain_coral_wall_fan", builder -> builder
            .setNetworkId(628)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BRAIN_CORAL_FAN)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BREWING_STAND = gen("Brewing Stand", "brewing_stand", builder -> builder
            .setNetworkId(269)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BREWING_STAND)
            .addStateProperty(BooleanBlockStatePropertyTypes.HAS_BOTTLE_0)
            .addStateProperty(BooleanBlockStatePropertyTypes.HAS_BOTTLE_1)
            .addStateProperty(BooleanBlockStatePropertyTypes.HAS_BOTTLE_2));
    public static final BuilderRegister<BlockType> BRICKS = gen("Bricks", "bricks", builder -> builder
            .setNetworkId(142)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BRICKS));
    public static final BuilderRegister<BlockType> BRICK_SLAB = gen("Brick Slab", "brick_slab", builder -> builder
            .setNetworkId(478)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BRICK_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BRICK_STAIRS = gen("Brick Stairs", "brick_stairs", builder -> builder
            .setNetworkId(260)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BRICK_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BRICK_WALL = gen("Brick Wall", "brick_wall", builder -> builder
            .setNetworkId(668)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BRICK_WALL)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BROWN_BANNER = gen("Brown Banner", "brown_banner", builder -> builder
            .setNetworkId(442)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BROWN_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> BROWN_BED = gen("Brown Bed", "brown_bed", builder -> builder
            .setNetworkId(93)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BROWN_BED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.BED_HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.OCCUPIED));
    public static final BuilderRegister<BlockType> BROWN_CANDLE = gen("Brown Candle", "brown_candle", builder -> builder
            .setNetworkId(790)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BROWN_CANDLE)
            .addStateProperty(IntegerBlockStatePropertyTypes.CANDLES)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BROWN_CANDLE_CAKE = gen("Cake with Brown Candle", "brown_candle_cake", builder -> builder
            .setNetworkId(807)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAKE)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> BROWN_CARPET = gen("Brown Carpet", "brown_carpet", builder -> builder
            .setNetworkId(417)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BROWN_CARPET));
    public static final BuilderRegister<BlockType> BROWN_CONCRETE = gen("Brown Concrete", "brown_concrete", builder -> builder
            .setNetworkId(568)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BROWN_CONCRETE));
    public static final BuilderRegister<BlockType> BROWN_CONCRETE_POWDER = gen("Brown Concrete Powder", "brown_concrete_powder", builder -> builder
            .setNetworkId(584)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BROWN_CONCRETE_POWDER));
    public static final BuilderRegister<BlockType> BROWN_GLAZED_TERRACOTTA = gen("Brown Glazed Terracotta", "brown_glazed_terracotta", builder -> builder
            .setNetworkId(552)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BROWN_GLAZED_TERRACOTTA)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> BROWN_MUSHROOM = gen("Brown Mushroom", "brown_mushroom", builder -> builder
            .setNetworkId(138)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BROWN_MUSHROOM));
    public static final BuilderRegister<BlockType> BROWN_MUSHROOM_BLOCK = gen("Brown Mushroom Block", "brown_mushroom_block", builder -> builder
            .setNetworkId(246)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BROWN_MUSHROOM_BLOCK)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(BooleanBlockStatePropertyTypes.DOWN)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST));
    public static final BuilderRegister<BlockType> BROWN_SHULKER_BOX = gen("Brown Shulker Box", "brown_shulker_box", builder -> builder
            .setNetworkId(536)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BROWN_SHULKER_BOX)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> BROWN_STAINED_GLASS = gen("Brown Stained Glass", "brown_stained_glass", builder -> builder
            .setNetworkId(226)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BROWN_STAINED_GLASS));
    public static final BuilderRegister<BlockType> BROWN_STAINED_GLASS_PANE = gen("Brown Stained Glass Pane", "brown_stained_glass_pane", builder -> builder
            .setNetworkId(384)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BROWN_STAINED_GLASS_PANE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BROWN_TERRACOTTA = gen("Brown Terracotta", "brown_terracotta", builder -> builder
            .setNetworkId(368)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BROWN_TERRACOTTA));
    public static final BuilderRegister<BlockType> BROWN_WALL_BANNER = gen("null", "brown_wall_banner", builder -> builder
            .setNetworkId(458)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BROWN_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> BROWN_WOOL = gen("Brown Wool", "brown_wool", builder -> builder
            .setNetworkId(120)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BROWN_WOOL));
    public static final BuilderRegister<BlockType> BUBBLE_COLUMN = gen("Bubble Column", "bubble_column", builder -> builder
            .setNetworkId(640)
            .setMass(MassType.SOLID)
            .addStateProperty(BooleanBlockStatePropertyTypes.DRAG));
    public static final BuilderRegister<BlockType> BUBBLE_CORAL = gen("Bubble Coral", "bubble_coral", builder -> builder
            .setNetworkId(609)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BUBBLE_CORAL)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BUBBLE_CORAL_BLOCK = gen("Bubble Coral Block", "bubble_coral_block", builder -> builder
            .setNetworkId(599)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BUBBLE_CORAL_BLOCK));
    public static final BuilderRegister<BlockType> BUBBLE_CORAL_FAN = gen("Bubble Coral Fan", "bubble_coral_fan", builder -> builder
            .setNetworkId(619)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BUBBLE_CORAL_FAN)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BUBBLE_CORAL_WALL_FAN = gen("Bubble Coral Wall Fan", "bubble_coral_wall_fan", builder -> builder
            .setNetworkId(629)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BUBBLE_CORAL_FAN)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> BUDDING_AMETHYST = gen("Budding Amethyst", "budding_amethyst", builder -> builder
            .setNetworkId(812)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.BUDDING_AMETHYST));
    public static final BuilderRegister<BlockType> CACTUS = gen("Cactus", "cactus", builder -> builder
            .setNetworkId(195)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CACTUS)
            .addStateProperty(IntegerBlockStatePropertyTypes.AGE_16));
    public static final BuilderRegister<BlockType> CAKE = gen("Cake", "cake", builder -> builder
            .setNetworkId(212)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAKE)
            .addStateProperty(IntegerBlockStatePropertyTypes.BITES));
    public static final BuilderRegister<BlockType> CALCITE = gen("Calcite", "calcite", builder -> builder
            .setNetworkId(818)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CALCITE));
    public static final BuilderRegister<BlockType> CAMPFIRE = gen("Campfire", "campfire", builder -> builder
            .setNetworkId(694)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAMPFIRE)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT)
            .addStateProperty(BooleanBlockStatePropertyTypes.SIGNAL_FIRE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> CANDLE = gen("Candle", "candle", builder -> builder
            .setNetworkId(777)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CANDLE)
            .addStateProperty(IntegerBlockStatePropertyTypes.CANDLES)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> CANDLE_CAKE = gen("Cake with Candle", "candle_cake", builder -> builder
            .setNetworkId(794)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAKE)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> CARROTS = gen("Carrots", "carrots", builder -> builder
            .setNetworkId(319)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CARROT)
            .addStateProperty(IntegerBlockStatePropertyTypes.AGE_8));
    public static final BuilderRegister<BlockType> CARTOGRAPHY_TABLE = gen("Cartography Table", "cartography_table", builder -> builder
            .setNetworkId(685)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CARTOGRAPHY_TABLE));
    public static final BuilderRegister<BlockType> CARVED_PUMPKIN = gen("Carved Pumpkin", "carved_pumpkin", builder -> builder
            .setNetworkId(210)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CARVED_PUMPKIN)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> CAULDRON = gen("Cauldron", "cauldron", builder -> builder
            .setNetworkId(270)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAULDRON));
    public static final BuilderRegister<BlockType> CAVE_AIR = gen("Cave Air", "cave_air", builder -> builder
            .setNetworkId(639)
            .setMass(MassType.SOLID)
    );
    public static final BuilderRegister<BlockType> CAVE_VINES = gen("Cave Vines", "cave_vines", builder -> builder
            .setNetworkId(859)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GLOW_BERRIES));
    public static final BuilderRegister<BlockType> CAVE_VINES_PLANT = gen("Cave Vines Plant", "cave_vines_plant", builder -> builder
            .setNetworkId(860)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GLOW_BERRIES));
    public static final BuilderRegister<BlockType> CHAIN = gen("Chain", "chain", builder -> builder
            .setNetworkId(250)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CHAIN)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> CHAIN_COMMAND_BLOCK = gen("Chain Command Block", "chain_command_block", builder -> builder
            .setNetworkId(515)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CHAIN_COMMAND_BLOCK)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.REPEAT_CONDITIONAL));
    public static final BuilderRegister<BlockType> CHEST = gen("Chest", "chest", builder -> builder
            .setNetworkId(153)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CHEST)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.CHEST_HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> CHIPPED_ANVIL = gen("Chipped Anvil", "chipped_anvil", builder -> builder
            .setNetworkId(340)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CHIPPED_ANVIL)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> CHISELED_DEEPSLATE = gen("Chiseled Deepslate", "chiseled_deepslate", builder -> builder
            .setNetworkId(888)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CHISELED_DEEPSLATE));
    public static final BuilderRegister<BlockType> CHISELED_NETHER_BRICKS = gen("Chiseled Nether Bricks", "chiseled_nether_bricks", builder -> builder
            .setNetworkId(774)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CHISELED_NETHER_BRICKS));
    public static final BuilderRegister<BlockType> CHISELED_POLISHED_BLACKSTONE = gen("Chiseled Polished Blackstone", "chiseled_polished_blackstone", builder -> builder
            .setNetworkId(764)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CHISELED_POLISHED_BLACKSTONE));
    public static final BuilderRegister<BlockType> CHISELED_QUARTZ_BLOCK = gen("Chiseled Quartz Block", "chiseled_quartz_block", builder -> builder
            .setNetworkId(351)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CHISELED_QUARTZ_BLOCK));
    public static final BuilderRegister<BlockType> CHISELED_RED_SANDSTONE = gen("Chiseled Red Sandstone", "chiseled_red_sandstone", builder -> builder
            .setNetworkId(463)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CHISELED_RED_SANDSTONE));
    public static final BuilderRegister<BlockType> CHISELED_SANDSTONE = gen("Chiseled Sandstone", "chiseled_sandstone", builder -> builder
            .setNetworkId(78)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CHISELED_SANDSTONE));
    public static final BuilderRegister<BlockType> CHISELED_STONE_BRICKS = gen("Chiseled Stone Bricks", "chiseled_stone_bricks", builder -> builder
            .setNetworkId(239)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CHISELED_STONE_BRICKS));
    public static final BuilderRegister<BlockType> CHORUS_FLOWER = gen("Chorus Flower", "chorus_flower", builder -> builder
            .setNetworkId(506)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CHORUS_FLOWER)
            .addStateProperty(IntegerBlockStatePropertyTypes.AGE_6));
    public static final BuilderRegister<BlockType> CHORUS_PLANT = gen("Chorus Plant", "chorus_plant", builder -> builder
            .setNetworkId(505)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CHORUS_PLANT)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(BooleanBlockStatePropertyTypes.DOWN));
    public static final BuilderRegister<BlockType> CLAY = gen("Clay", "clay", builder -> builder
            .setNetworkId(196)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CLAY));
    public static final BuilderRegister<BlockType> COAL_BLOCK = gen("Block of Coal", "coal_block", builder -> builder
            .setNetworkId(422)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.COAL_BLOCK));
    public static final BuilderRegister<BlockType> COAL_ORE = gen("Coal Ore", "coal_ore", builder -> builder
            .setNetworkId(35)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.COAL_ORE));
    public static final BuilderRegister<BlockType> COARSE_DIRT = gen("Coarse Dirt", "coarse_dirt", builder -> builder
            .setNetworkId(10)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.COARSE_DIRT));
    public static final BuilderRegister<BlockType> COBBLED_DEEPSLATE = gen("Cobbled Deepslate", "cobbled_deepslate", builder -> builder
            .setNetworkId(872)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.COBBLED_DEEPSLATE));
    public static final BuilderRegister<BlockType> COBBLED_DEEPSLATE_SLAB = gen("Cobbled Deepslate Slab", "cobbled_deepslate_slab", builder -> builder
            .setNetworkId(874)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.COBBLED_DEEPSLATE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> COBBLED_DEEPSLATE_STAIRS = gen("Cobbled Deepslate Stairs", "cobbled_deepslate_stairs", builder -> builder
            .setNetworkId(873)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.COBBLED_DEEPSLATE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> COBBLED_DEEPSLATE_WALL = gen("Cobbled Deepslate Wall", "cobbled_deepslate_wall", builder -> builder
            .setNetworkId(875)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.COBBLED_DEEPSLATE_WALL)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> COBBLESTONE = gen("Cobblestone", "cobblestone", builder -> builder
            .setNetworkId(12)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.COBBLESTONE));
    public static final BuilderRegister<BlockType> COBBLESTONE_SLAB = gen("Cobblestone Slab", "cobblestone_slab", builder -> builder
            .setNetworkId(477)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.COBBLESTONE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> COBBLESTONE_STAIRS = gen("Cobblestone Stairs", "cobblestone_stairs", builder -> builder
            .setNetworkId(171)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.COBBLESTONE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> COBBLESTONE_WALL = gen("Cobblestone Wall", "cobblestone_wall", builder -> builder
            .setNetworkId(292)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.COBBLESTONE_WALL)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> COBWEB = gen("Cobweb", "cobweb", builder -> builder
            .setNetworkId(100)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.COBWEB));
    public static final BuilderRegister<BlockType> COCOA = gen("Cocoa", "cocoa",
            builder -> builder
                    .setNetworkId(279)
                    .setMass(MassType.SOLID)
                    .setItem(ItemTypes.COCOA_BEANS)
                    .addStateProperty(EnumBlockStatePropertyTypes.FACING)
                    .addStateProperty(IntegerBlockStatePropertyTypes.AGE_3));
    public static final BuilderRegister<BlockType> COMMAND_BLOCK = gen("Command Block", "command_block", builder -> builder
            .setNetworkId(290)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.COMMAND_BLOCK)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.REPEAT_CONDITIONAL));
    public static final BuilderRegister<BlockType> COMPARATOR = gen("Redstone Comparator", "comparator", builder -> builder
            .setNetworkId(345)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.COMPARATOR)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.COMPARATOR_MODE)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> COMPOSTER = gen("Composter", "composter", builder -> builder
            .setNetworkId(742)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.COMPOSTER)
            .addStateProperty(IntegerBlockStatePropertyTypes.COMPOSTER_LEVEL));
    public static final BuilderRegister<BlockType> CONDUIT = gen("Conduit", "conduit", builder -> builder
            .setNetworkId(634)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CONDUIT)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> COPPER_BLOCK = gen("Block of Copper", "copper_block", builder -> builder
            .setNetworkId(825)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.COPPER_BLOCK));
    public static final BuilderRegister<BlockType> COPPER_ORE = gen("Copper Ore", "copper_ore", builder -> builder
            .setNetworkId(826)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.COPPER_ORE));
    public static final BuilderRegister<BlockType> CORNFLOWER = gen("Cornflower", "cornflower", builder -> builder
            .setNetworkId(135)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CORNFLOWER));
    public static final BuilderRegister<BlockType> CRACKED_DEEPSLATE_BRICKS = gen("Cracked Deepslate Bricks", "cracked_deepslate_bricks", builder -> builder
            .setNetworkId(889)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRACKED_DEEPSLATE_BRICKS));
    public static final BuilderRegister<BlockType> CRACKED_DEEPSLATE_TILES = gen("Cracked Deepslate Tiles", "cracked_deepslate_tiles", builder -> builder
            .setNetworkId(890)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRACKED_DEEPSLATE_TILES));
    public static final BuilderRegister<BlockType> CRACKED_NETHER_BRICKS = gen("Cracked Nether Bricks", "cracked_nether_bricks", builder -> builder
            .setNetworkId(775)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRACKED_NETHER_BRICKS));
    public static final BuilderRegister<BlockType> CRACKED_POLISHED_BLACKSTONE_BRICKS = gen("Cracked Polished Blackstone Bricks", "cracked_polished_blackstone_bricks", builder -> builder
            .setNetworkId(763)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRACKED_POLISHED_BLACKSTONE_BRICKS));
    public static final BuilderRegister<BlockType> CRACKED_STONE_BRICKS = gen("Cracked Stone Bricks", "cracked_stone_bricks", builder -> builder
            .setNetworkId(238)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRACKED_STONE_BRICKS));
    public static final BuilderRegister<BlockType> CRAFTING_TABLE = gen("Crafting Table", "crafting_table", builder -> builder
            .setNetworkId(158)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRAFTING_TABLE));
    public static final BuilderRegister<BlockType> CREEPER_HEAD = gen("Creeper Head", "creeper_head", builder -> builder
            .setNetworkId(335)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CREEPER_HEAD)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> CREEPER_WALL_HEAD = gen("Creeper Wall Head", "creeper_wall_head", builder -> builder
            .setNetworkId(336)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CREEPER_HEAD)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> CRIMSON_BUTTON = gen("Crimson Button", "crimson_button", builder -> builder
            .setNetworkId(732)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRIMSON_BUTTON)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(EnumBlockStatePropertyTypes.ATTACHABLE_FACE_STANDARD));
    public static final BuilderRegister<BlockType> CRIMSON_DOOR = gen("Crimson Door", "crimson_door", builder -> builder
            .setNetworkId(734)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRIMSON_DOOR)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(EnumBlockStatePropertyTypes.HINGE)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> CRIMSON_FENCE = gen("Crimson Fence", "crimson_fence", builder -> builder
            .setNetworkId(724)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRIMSON_FENCE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> CRIMSON_FENCE_GATE = gen("Crimson Fence Gate", "crimson_fence_gate", builder -> builder
            .setNetworkId(728)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRIMSON_FENCE_GATE)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.IN_WALL));
    public static final BuilderRegister<BlockType> CRIMSON_FUNGUS = gen("Crimson Fungus", "crimson_fungus", builder -> builder
            .setNetworkId(711)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRIMSON_FUNGUS));
    public static final BuilderRegister<BlockType> CRIMSON_HYPHAE = gen("Crimson Hyphae", "crimson_hyphae", builder -> builder
            .setNetworkId(708)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRIMSON_HYPHAE)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> CRIMSON_NYLIUM = gen("Crimson Nylium", "crimson_nylium", builder -> builder
            .setNetworkId(710)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRIMSON_NYLIUM));
    public static final BuilderRegister<BlockType> CRIMSON_PLANKS = gen("Crimson Planks", "crimson_planks", builder -> builder
            .setNetworkId(718)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRIMSON_PLANKS));
    public static final BuilderRegister<BlockType> CRIMSON_PRESSURE_PLATE = gen("Crimson Pressure Plate", "crimson_pressure_plate", builder -> builder
            .setNetworkId(722)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRIMSON_PRESSURE_PLATE)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> CRIMSON_ROOTS = gen("Crimson Roots", "crimson_roots", builder -> builder
            .setNetworkId(717)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRIMSON_ROOTS));
    public static final BuilderRegister<BlockType> CRIMSON_SIGN = gen("Crimson Sign", "crimson_sign", builder -> builder
            .setNetworkId(736)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRIMSON_SIGN)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> CRIMSON_SLAB = gen("Crimson Slab", "crimson_slab", builder -> builder
            .setNetworkId(720)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRIMSON_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> CRIMSON_STAIRS = gen("Crimson Stairs", "crimson_stairs", builder -> builder
            .setNetworkId(730)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRIMSON_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> CRIMSON_STEM = gen("Crimson Stem", "crimson_stem", builder -> builder
            .setNetworkId(706)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRIMSON_STEM)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> CRIMSON_TRAPDOOR = gen("Crimson Trapdoor", "crimson_trapdoor", builder -> builder
            .setNetworkId(726)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRIMSON_TRAPDOOR)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> CRIMSON_WALL_SIGN = gen("Crimson Wall Sign", "crimson_wall_sign", builder -> builder
            .setNetworkId(738)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRIMSON_SIGN)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> CRYING_OBSIDIAN = gen("Crying Obsidian", "crying_obsidian", builder -> builder
            .setNetworkId(750)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CRYING_OBSIDIAN));
    public static final BuilderRegister<BlockType> CUT_COPPER = gen("Cut Copper", "cut_copper", builder -> builder
            .setNetworkId(831)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CUT_COPPER));
    public static final BuilderRegister<BlockType> CUT_COPPER_SLAB = gen("Cut Copper Slab", "cut_copper_slab", builder -> builder
            .setNetworkId(839)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CUT_COPPER_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> CUT_COPPER_STAIRS = gen("Cut Copper Stairs", "cut_copper_stairs", builder -> builder
            .setNetworkId(835)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CUT_COPPER_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> CUT_RED_SANDSTONE = gen("Cut Red Sandstone", "cut_red_sandstone", builder -> builder
            .setNetworkId(464)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CUT_RED_SANDSTONE));
    public static final BuilderRegister<BlockType> CUT_RED_SANDSTONE_SLAB = gen("Cut Red Sandstone Slab", "cut_red_sandstone_slab", builder -> builder
            .setNetworkId(483)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CUT_RED_SANDSTONE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> CUT_SANDSTONE = gen("Cut Sandstone", "cut_sandstone", builder -> builder
            .setNetworkId(79)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CUT_SANDSTONE));
    public static final BuilderRegister<BlockType> CUT_SANDSTONE_SLAB = gen("Cut Sandstone Slab", "cut_sandstone_slab", builder -> builder
            .setNetworkId(475)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CUT_SANDSTONE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> CYAN_BANNER = gen("Cyan Banner", "cyan_banner", builder -> builder
            .setNetworkId(439)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CYAN_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> CYAN_BED = gen("Cyan Bed", "cyan_bed", builder -> builder
            .setNetworkId(90)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CYAN_BED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.BED_HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.OCCUPIED));
    public static final BuilderRegister<BlockType> CYAN_CANDLE = gen("Cyan Candle", "cyan_candle", builder -> builder
            .setNetworkId(787)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CYAN_CANDLE)
            .addStateProperty(IntegerBlockStatePropertyTypes.CANDLES)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> CYAN_CANDLE_CAKE = gen("Cake with Cyan Candle", "cyan_candle_cake", builder -> builder
            .setNetworkId(804)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAKE)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> CYAN_CARPET = gen("Cyan Carpet", "cyan_carpet", builder -> builder
            .setNetworkId(414)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CYAN_CARPET));
    public static final BuilderRegister<BlockType> CYAN_CONCRETE = gen("Cyan Concrete", "cyan_concrete", builder -> builder
            .setNetworkId(565)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CYAN_CONCRETE));
    public static final BuilderRegister<BlockType> CYAN_CONCRETE_POWDER = gen("Cyan Concrete Powder", "cyan_concrete_powder", builder -> builder
            .setNetworkId(581)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CYAN_CONCRETE_POWDER));
    public static final BuilderRegister<BlockType> CYAN_GLAZED_TERRACOTTA = gen("Cyan Glazed Terracotta", "cyan_glazed_terracotta", builder -> builder
            .setNetworkId(549)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CYAN_GLAZED_TERRACOTTA)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> CYAN_SHULKER_BOX = gen("Cyan Shulker Box", "cyan_shulker_box", builder -> builder
            .setNetworkId(533)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CYAN_SHULKER_BOX)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> CYAN_STAINED_GLASS = gen("Cyan Stained Glass", "cyan_stained_glass", builder -> builder
            .setNetworkId(223)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CYAN_STAINED_GLASS));
    public static final BuilderRegister<BlockType> CYAN_STAINED_GLASS_PANE = gen("Cyan Stained Glass Pane", "cyan_stained_glass_pane", builder -> builder
            .setNetworkId(381)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CYAN_STAINED_GLASS_PANE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> CYAN_TERRACOTTA = gen("Cyan Terracotta", "cyan_terracotta", builder -> builder
            .setNetworkId(365)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CYAN_TERRACOTTA));
    public static final BuilderRegister<BlockType> CYAN_WALL_BANNER = gen("null", "cyan_wall_banner", builder -> builder
            .setNetworkId(455)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CYAN_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> CYAN_WOOL = gen("Cyan Wool", "cyan_wool", builder -> builder
            .setNetworkId(117)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CYAN_WOOL));
    public static final BuilderRegister<BlockType> DAMAGED_ANVIL = gen("Damaged Anvil", "damaged_anvil", builder -> builder
            .setNetworkId(341)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DAMAGED_ANVIL)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> DANDELION = gen("Dandelion", "dandelion", builder -> builder
            .setNetworkId(125)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DANDELION));
    public static final BuilderRegister<BlockType> DARK_OAK_BUTTON = gen("Dark Oak Button", "dark_oak_button", builder -> builder
            .setNetworkId(326)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DARK_OAK_BUTTON)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(EnumBlockStatePropertyTypes.ATTACHABLE_FACE_STANDARD));
    public static final BuilderRegister<BlockType> DARK_OAK_DOOR = gen("Dark Oak Door", "dark_oak_door", builder -> builder
            .setNetworkId(503)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DARK_OAK_DOOR)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(EnumBlockStatePropertyTypes.HINGE)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> DARK_OAK_FENCE = gen("Dark Oak Fence", "dark_oak_fence", builder -> builder
            .setNetworkId(498)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DARK_OAK_FENCE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DARK_OAK_FENCE_GATE = gen("Dark Oak Fence Gate", "dark_oak_fence_gate", builder -> builder
            .setNetworkId(493)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DARK_OAK_FENCE_GATE)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.IN_WALL));
    public static final BuilderRegister<BlockType> DARK_OAK_LEAVES = gen("Dark Oak Leaves", "dark_oak_leaves", builder -> builder
            .setNetworkId(67)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DARK_OAK_LEAVES)
            .addStateProperty(IntegerBlockStatePropertyTypes.DISTANCE)
            .addStateProperty(BooleanBlockStatePropertyTypes.PERSISTENT));
    public static final BuilderRegister<BlockType> DARK_OAK_LOG = gen("Dark Oak Log", "dark_oak_log", builder -> builder
            .setNetworkId(43)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DARK_OAK_LOG)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> DARK_OAK_PLANKS = gen("Dark Oak Planks", "dark_oak_planks", builder -> builder
            .setNetworkId(18)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DARK_OAK_PLANKS));
    public static final BuilderRegister<BlockType> DARK_OAK_PRESSURE_PLATE = gen("Dark Oak Pressure Plate", "dark_oak_pressure_plate", builder -> builder
            .setNetworkId(186)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DARK_OAK_PRESSURE_PLATE)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> DARK_OAK_SAPLING = gen("Dark Oak Sapling", "dark_oak_sapling", builder -> builder
            .setNetworkId(24)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DARK_OAK_SAPLING)
            .addStateProperty(IntegerBlockStatePropertyTypes.GROWTH_STAGE));
    public static final BuilderRegister<BlockType> DARK_OAK_SIGN = gen("Dark Oak Sign", "dark_oak_sign", builder -> builder
            .setNetworkId(167)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DARK_OAK_SIGN)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DARK_OAK_SLAB = gen("Dark Oak Slab", "dark_oak_slab", builder -> builder
            .setNetworkId(471)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DARK_OAK_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DARK_OAK_STAIRS = gen("Dark Oak Stairs", "dark_oak_stairs", builder -> builder
            .setNetworkId(389)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DARK_OAK_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DARK_OAK_TRAPDOOR = gen("Dark Oak Trapdoor", "dark_oak_trapdoor", builder -> builder
            .setNetworkId(235)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DARK_OAK_TRAPDOOR)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DARK_OAK_WALL_SIGN = gen("Dark Oak Wall Sign", "dark_oak_wall_sign", builder -> builder
            .setNetworkId(177)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DARK_OAK_SIGN)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DARK_OAK_WOOD = gen("Dark Oak Wood", "dark_oak_wood", builder -> builder
            .setNetworkId(55)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DARK_OAK_WOOD)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> DARK_PRISMARINE = gen("Dark Prismarine", "dark_prismarine", builder -> builder
            .setNetworkId(396)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DARK_PRISMARINE));
    public static final BuilderRegister<BlockType> DARK_PRISMARINE_SLAB = gen("Dark Prismarine Slab", "dark_prismarine_slab", builder -> builder
            .setNetworkId(402)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DARK_PRISMARINE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DARK_PRISMARINE_STAIRS = gen("Dark Prismarine Stairs", "dark_prismarine_stairs", builder -> builder
            .setNetworkId(399)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DARK_PRISMARINE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DAYLIGHT_DETECTOR = gen("Daylight Detector", "daylight_detector", builder -> builder
            .setNetworkId(346)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DAYLIGHT_DETECTOR)
            .addStateProperty(IntegerBlockStatePropertyTypes.REDSTONE_POWER_LEVEL)
            .addStateProperty(BooleanBlockStatePropertyTypes.INVERTED));
    public static final BuilderRegister<BlockType> DEAD_BRAIN_CORAL = gen("Dead Brain Coral", "dead_brain_coral", builder -> builder
            .setNetworkId(603)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEAD_BRAIN_CORAL)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DEAD_BRAIN_CORAL_BLOCK = gen("Dead Brain Coral Block", "dead_brain_coral_block", builder -> builder
            .setNetworkId(593)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEAD_BRAIN_CORAL_BLOCK));
    public static final BuilderRegister<BlockType> DEAD_BRAIN_CORAL_FAN = gen("Dead Brain Coral Fan", "dead_brain_coral_fan", builder -> builder
            .setNetworkId(613)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEAD_BRAIN_CORAL_FAN)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DEAD_BRAIN_CORAL_WALL_FAN = gen("Dead Brain Coral Wall Fan", "dead_brain_coral_wall_fan", builder -> builder
            .setNetworkId(623)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEAD_BRAIN_CORAL_FAN)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DEAD_BUBBLE_CORAL = gen("Dead Bubble Coral", "dead_bubble_coral", builder -> builder
            .setNetworkId(604)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEAD_BUBBLE_CORAL)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DEAD_BUBBLE_CORAL_BLOCK = gen("Dead Bubble Coral Block", "dead_bubble_coral_block", builder -> builder
            .setNetworkId(594)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEAD_BUBBLE_CORAL_BLOCK));
    public static final BuilderRegister<BlockType> DEAD_BUBBLE_CORAL_FAN = gen("Dead Bubble Coral Fan", "dead_bubble_coral_fan", builder -> builder
            .setNetworkId(614)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEAD_BUBBLE_CORAL_FAN)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DEAD_BUBBLE_CORAL_WALL_FAN = gen("Dead Bubble Coral Wall Fan", "dead_bubble_coral_wall_fan", builder -> builder
            .setNetworkId(624)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEAD_BUBBLE_CORAL_FAN)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DEAD_BUSH = gen("Dead Bush", "dead_bush", builder -> builder
            .setNetworkId(103)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEAD_BUSH));
    public static final BuilderRegister<BlockType> DEAD_FIRE_CORAL = gen("Dead Fire Coral", "dead_fire_coral", builder -> builder
            .setNetworkId(605)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEAD_FIRE_CORAL)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DEAD_FIRE_CORAL_BLOCK = gen("Dead Fire Coral Block", "dead_fire_coral_block", builder -> builder
            .setNetworkId(595)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEAD_FIRE_CORAL_BLOCK));
    public static final BuilderRegister<BlockType> DEAD_FIRE_CORAL_FAN = gen("Dead Fire Coral Fan", "dead_fire_coral_fan", builder -> builder
            .setNetworkId(615)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEAD_FIRE_CORAL_FAN)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DEAD_FIRE_CORAL_WALL_FAN = gen("Dead Fire Coral Wall Fan", "dead_fire_coral_wall_fan", builder -> builder
            .setNetworkId(625)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEAD_FIRE_CORAL_FAN)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DEAD_HORN_CORAL = gen("Dead Horn Coral", "dead_horn_coral", builder -> builder
            .setNetworkId(606)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEAD_HORN_CORAL)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DEAD_HORN_CORAL_BLOCK = gen("Dead Horn Coral Block", "dead_horn_coral_block", builder -> builder
            .setNetworkId(596)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEAD_HORN_CORAL_BLOCK));
    public static final BuilderRegister<BlockType> DEAD_HORN_CORAL_FAN = gen("Dead Horn Coral Fan", "dead_horn_coral_fan", builder -> builder
            .setNetworkId(616)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEAD_HORN_CORAL_FAN)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DEAD_HORN_CORAL_WALL_FAN = gen("Dead Horn Coral Wall Fan", "dead_horn_coral_wall_fan", builder -> builder
            .setNetworkId(626)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEAD_HORN_CORAL_FAN)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DEAD_TUBE_CORAL = gen("Dead Tube Coral", "dead_tube_coral", builder -> builder
            .setNetworkId(602)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEAD_TUBE_CORAL)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DEAD_TUBE_CORAL_BLOCK = gen("Dead Tube Coral Block", "dead_tube_coral_block", builder -> builder
            .setNetworkId(592)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEAD_TUBE_CORAL_BLOCK));
    public static final BuilderRegister<BlockType> DEAD_TUBE_CORAL_FAN = gen("Dead Tube Coral Fan", "dead_tube_coral_fan", builder -> builder
            .setNetworkId(612)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEAD_TUBE_CORAL_FAN)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DEAD_TUBE_CORAL_WALL_FAN = gen("Dead Tube Coral Wall Fan", "dead_tube_coral_wall_fan", builder -> builder
            .setNetworkId(622)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEAD_TUBE_CORAL_FAN)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DEEPSLATE = gen("Deepslate", "deepslate", builder -> builder
            .setNetworkId(871)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEEPSLATE)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> DEEPSLATE_BRICKS = gen("Deepslate Bricks", "deepslate_bricks", builder -> builder
            .setNetworkId(884)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEEPSLATE_BRICKS));
    public static final BuilderRegister<BlockType> DEEPSLATE_BRICK_SLAB = gen("Deepslate Brick Slab", "deepslate_brick_slab", builder -> builder
            .setNetworkId(886)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEEPSLATE_BRICK_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DEEPSLATE_BRICK_STAIRS = gen("Deepslate Brick Stairs", "deepslate_brick_stairs", builder -> builder
            .setNetworkId(885)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEEPSLATE_BRICK_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DEEPSLATE_BRICK_WALL = gen("Deepslate Brick Wall", "deepslate_brick_wall", builder -> builder
            .setNetworkId(887)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEEPSLATE_BRICK_WALL)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DEEPSLATE_COAL_ORE = gen("Deepslate Coal Ore", "deepslate_coal_ore", builder -> builder
            .setNetworkId(36)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEEPSLATE_COAL_ORE));
    public static final BuilderRegister<BlockType> DEEPSLATE_COPPER_ORE = gen("Deepslate Copper Ore", "deepslate_copper_ore", builder -> builder
            .setNetworkId(827)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEEPSLATE_COPPER_ORE));
    public static final BuilderRegister<BlockType> DEEPSLATE_DIAMOND_ORE = gen("Deepslate Diamond Ore", "deepslate_diamond_ore", builder -> builder
            .setNetworkId(156)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEEPSLATE_DIAMOND_ORE));
    public static final BuilderRegister<BlockType> DEEPSLATE_EMERALD_ORE = gen("Deepslate Emerald Ore", "deepslate_emerald_ore", builder -> builder
            .setNetworkId(282)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEEPSLATE_EMERALD_ORE));
    public static final BuilderRegister<BlockType> DEEPSLATE_GOLD_ORE = gen("Deepslate Gold Ore", "deepslate_gold_ore", builder -> builder
            .setNetworkId(32)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEEPSLATE_GOLD_ORE));
    public static final BuilderRegister<BlockType> DEEPSLATE_IRON_ORE = gen("Deepslate Iron Ore", "deepslate_iron_ore", builder -> builder
            .setNetworkId(34)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEEPSLATE_IRON_ORE));
    public static final BuilderRegister<BlockType> DEEPSLATE_LAPIS_ORE = gen("Deepslate Lapis Lazuli Ore", "deepslate_lapis_ore", builder -> builder
            .setNetworkId(74)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEEPSLATE_LAPIS_ORE));
    public static final BuilderRegister<BlockType> DEEPSLATE_REDSTONE_ORE = gen("Deepslate Redstone Ore", "deepslate_redstone_ore", builder -> builder
            .setNetworkId(188)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEEPSLATE_REDSTONE_ORE)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> DEEPSLATE_TILES = gen("Deepslate Tiles", "deepslate_tiles", builder -> builder
            .setNetworkId(880)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEEPSLATE_TILES));
    public static final BuilderRegister<BlockType> DEEPSLATE_TILE_SLAB = gen("Deepslate Tile Slab", "deepslate_tile_slab", builder -> builder
            .setNetworkId(882)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEEPSLATE_TILE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DEEPSLATE_TILE_STAIRS = gen("Deepslate Tile Stairs", "deepslate_tile_stairs", builder -> builder
            .setNetworkId(881)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEEPSLATE_TILE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DEEPSLATE_TILE_WALL = gen("Deepslate Tile Wall", "deepslate_tile_wall", builder -> builder
            .setNetworkId(883)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DEEPSLATE_TILE_WALL)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DETECTOR_RAIL = gen("Detector Rail", "detector_rail", builder -> builder
            .setNetworkId(98)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DETECTOR_RAIL)
            .addStateProperty(EnumBlockStatePropertyTypes.STRAIGHT_RAIL_DIRECTION)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DIAMOND_BLOCK = gen("Block of Diamond", "diamond_block", builder -> builder
            .setNetworkId(157)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DIAMOND_BLOCK));
    public static final BuilderRegister<BlockType> DIAMOND_ORE = gen("Diamond Ore", "diamond_ore", builder -> builder
            .setNetworkId(155)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DIAMOND_ORE));
    public static final BuilderRegister<BlockType> DIORITE = gen("Diorite", "diorite", builder -> builder
            .setNetworkId(4)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DIORITE));
    public static final BuilderRegister<BlockType> DIORITE_SLAB = gen("Diorite Slab", "diorite_slab", builder -> builder
            .setNetworkId(667)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DIORITE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DIORITE_STAIRS = gen("Diorite Stairs", "diorite_stairs", builder -> builder
            .setNetworkId(654)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DIORITE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DIORITE_WALL = gen("Diorite Wall", "diorite_wall", builder -> builder
            .setNetworkId(679)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DIORITE_WALL)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> DIRT = gen("Dirt", "dirt", builder -> builder
            .setNetworkId(9)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DIRT));
    public static final BuilderRegister<BlockType> DIRT_PATH = gen("Dirt Path", "dirt_path", builder -> builder
            .setNetworkId(512)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DIRT_PATH));
    public static final BuilderRegister<BlockType> DISPENSER = gen("Dispenser", "dispenser", builder -> builder
            .setNetworkId(76)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DISPENSER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.TRIGGERED));
    public static final BuilderRegister<BlockType> DRAGON_EGG = gen("Dragon Egg", "dragon_egg", builder -> builder
            .setNetworkId(277)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DRAGON_EGG));
    public static final BuilderRegister<BlockType> DRAGON_HEAD = gen("Dragon Head", "dragon_head", builder -> builder
            .setNetworkId(337)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DRAGON_HEAD)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> DRAGON_WALL_HEAD = gen("Dragon Wall Head", "dragon_wall_head", builder -> builder
            .setNetworkId(338)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DRAGON_HEAD)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> DRIED_KELP_BLOCK = gen("Dried Kelp Block", "dried_kelp_block", builder -> builder
            .setNetworkId(590)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DRIED_KELP_BLOCK));
    public static final BuilderRegister<BlockType> DRIPSTONE_BLOCK = gen("Dripstone Block", "dripstone_block", builder -> builder
            .setNetworkId(858)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DRIPSTONE_BLOCK));
    public static final BuilderRegister<BlockType> DROPPER = gen("Dropper", "dropper", builder -> builder
            .setNetworkId(355)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.DROPPER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.TRIGGERED));
    public static final BuilderRegister<BlockType> EMERALD_BLOCK = gen("Block of Emerald", "emerald_block", builder -> builder
            .setNetworkId(286)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.EMERALD_BLOCK));
    public static final BuilderRegister<BlockType> EMERALD_ORE = gen("Emerald Ore", "emerald_ore", builder -> builder
            .setNetworkId(281)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.EMERALD_ORE));
    public static final BuilderRegister<BlockType> ENCHANTING_TABLE = gen("Enchanting Table", "enchanting_table", builder -> builder
            .setNetworkId(268)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ENCHANTING_TABLE));
    public static final BuilderRegister<BlockType> ENDER_CHEST = gen("Ender Chest", "ender_chest", builder -> builder
            .setNetworkId(283)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ENDER_CHEST)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> END_GATEWAY = gen("End Gateway", "end_gateway", builder -> builder
            .setNetworkId(513)
            .setMass(MassType.SOLID));
    public static final BuilderRegister<BlockType> END_PORTAL = gen("End Portal", "end_portal", builder -> builder
            .setNetworkId(274)
            .setMass(MassType.SOLID));
    public static final BuilderRegister<BlockType> END_PORTAL_FRAME = gen("End Portal Frame", "end_portal_frame", builder -> builder
            .setNetworkId(275)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.END_PORTAL_FRAME)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.EYE));
    public static final BuilderRegister<BlockType> END_ROD = gen("End Rod", "end_rod", builder -> builder
            .setNetworkId(504)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.END_ROD)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> END_STONE = gen("End Stone", "end_stone", builder -> builder
            .setNetworkId(276)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.END_STONE));
    public static final BuilderRegister<BlockType> END_STONE_BRICKS = gen("End Stone Bricks", "end_stone_bricks", builder -> builder
            .setNetworkId(510)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.END_STONE_BRICKS));
    public static final BuilderRegister<BlockType> END_STONE_BRICK_SLAB = gen("End Stone Brick Slab", "end_stone_brick_slab", builder -> builder
            .setNetworkId(660)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.END_STONE_BRICK_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> END_STONE_BRICK_STAIRS = gen("End Stone Brick Stairs", "end_stone_brick_stairs", builder -> builder
            .setNetworkId(646)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.END_STONE_BRICK_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> END_STONE_BRICK_WALL = gen("End Stone Brick Wall", "end_stone_brick_wall", builder -> builder
            .setNetworkId(678)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.END_STONE_BRICK_WALL)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> EXPOSED_COPPER = gen("Exposed Copper", "exposed_copper", builder -> builder
            .setNetworkId(824)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.EXPOSED_COPPER));
    public static final BuilderRegister<BlockType> EXPOSED_CUT_COPPER = gen("Exposed Cut Copper", "exposed_cut_copper", builder -> builder
            .setNetworkId(830)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.EXPOSED_CUT_COPPER));
    public static final BuilderRegister<BlockType> EXPOSED_CUT_COPPER_SLAB = gen("Exposed Cut Copper Slab", "exposed_cut_copper_slab", builder -> builder
            .setNetworkId(838)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.EXPOSED_CUT_COPPER_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> EXPOSED_CUT_COPPER_STAIRS = gen("Exposed Cut Copper Stairs", "exposed_cut_copper_stairs", builder -> builder
            .setNetworkId(834)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.EXPOSED_CUT_COPPER_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> FARMLAND = gen("Farmland", "farmland", builder -> builder
            .setNetworkId(160)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FARMLAND)
            .addStateProperty(IntegerBlockStatePropertyTypes.MOISTURE));
    public static final BuilderRegister<BlockType> FERN = gen("Fern", "fern", builder -> builder
            .setNetworkId(102)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FERN));
    public static final BuilderRegister<BlockType> FIRE = gen("Fire", "fire", builder -> builder
            .setNetworkId(149)
            .setMass(MassType.SOLID)
            .addStateProperty(IntegerBlockStatePropertyTypes.AGE_16)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP));
    public static final BuilderRegister<BlockType> FIRE_CORAL = gen("Fire Coral", "fire_coral", builder -> builder
            .setNetworkId(610)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FIRE_CORAL)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> FIRE_CORAL_BLOCK = gen("Fire Coral Block", "fire_coral_block", builder -> builder
            .setNetworkId(600)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FIRE_CORAL_BLOCK));
    public static final BuilderRegister<BlockType> FIRE_CORAL_FAN = gen("Fire Coral Fan", "fire_coral_fan", builder -> builder
            .setNetworkId(620)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FIRE_CORAL_FAN)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> FIRE_CORAL_WALL_FAN = gen("Fire Coral Wall Fan", "fire_coral_wall_fan", builder -> builder
            .setNetworkId(630)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FIRE_CORAL_FAN)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> FLETCHING_TABLE = gen("Fletching Table", "fletching_table", builder -> builder
            .setNetworkId(686)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLETCHING_TABLE));
    public static final BuilderRegister<BlockType> FLOWERING_AZALEA = gen("Flowering Azalea", "flowering_azalea", builder -> builder
            .setNetworkId(863)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWERING_AZALEA));
    public static final BuilderRegister<BlockType> FLOWERING_AZALEA_LEAVES = gen("Flowering Azalea Leaves", "flowering_azalea_leaves", builder -> builder
            .setNetworkId(69)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWERING_AZALEA_LEAVES)
            .addStateProperty(IntegerBlockStatePropertyTypes.DISTANCE)
            .addStateProperty(BooleanBlockStatePropertyTypes.PERSISTENT));
    public static final BuilderRegister<BlockType> FLOWER_POT = gen("Flower Pot", "flower_pot", builder -> builder
            .setNetworkId(294)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> FROSTED_ICE = gen("Frosted Ice", "frosted_ice", builder -> builder
            .setNetworkId(516)
            .setMass(MassType.SOLID)
            .addStateProperty(IntegerBlockStatePropertyTypes.AGE_4));
    public static final BuilderRegister<BlockType> FURNACE = gen("Furnace", "furnace", builder -> builder
            .setNetworkId(161)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FURNACE)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> GILDED_BLACKSTONE = gen("Gilded Blackstone", "gilded_blackstone", builder -> builder
            .setNetworkId(768)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GILDED_BLACKSTONE));
    public static final BuilderRegister<BlockType> GLASS = gen("Glass", "glass", builder -> builder
            .setNetworkId(72)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GLASS));
    public static final BuilderRegister<BlockType> GLASS_PANE = gen("Glass Pane", "glass_pane", builder -> builder
            .setNetworkId(251)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GLASS_PANE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> GLOWSTONE = gen("Glowstone", "glowstone", builder -> builder
            .setNetworkId(208)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GLOWSTONE));
    public static final BuilderRegister<BlockType> GLOW_LICHEN = gen("Glow Lichen", "glow_lichen", builder -> builder
            .setNetworkId(258)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GLOW_LICHEN));
    public static final BuilderRegister<BlockType> GOLD_BLOCK = gen("Block of Gold", "gold_block", builder -> builder
            .setNetworkId(140)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GOLD_BLOCK));
    public static final BuilderRegister<BlockType> GOLD_ORE = gen("Gold Ore", "gold_ore", builder -> builder
            .setNetworkId(31)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GOLD_ORE));
    public static final BuilderRegister<BlockType> GRANITE = gen("Granite", "granite", builder -> builder
            .setNetworkId(2)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GRANITE));
    public static final BuilderRegister<BlockType> GRANITE_SLAB = gen("Granite Slab", "granite_slab", builder -> builder
            .setNetworkId(663)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GRANITE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> GRANITE_STAIRS = gen("Granite Stairs", "granite_stairs", builder -> builder
            .setNetworkId(650)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GRANITE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> GRANITE_WALL = gen("Granite Wall", "granite_wall", builder -> builder
            .setNetworkId(672)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GRANITE_WALL)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> GRASS = gen("Grass", "grass", builder -> builder
            .setNetworkId(101)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GRASS));
    public static final BuilderRegister<BlockType> GRASS_BLOCK = gen("Grass Block", "grass_block", builder -> builder
            .setNetworkId(8)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GRASS_BLOCK)
            .addStateProperty(BooleanBlockStatePropertyTypes.SNOWY));
    public static final BuilderRegister<BlockType> GRAVEL = gen("Gravel", "gravel", builder -> builder
            .setNetworkId(30)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GRAVEL));
    public static final BuilderRegister<BlockType> GRAY_BANNER = gen("Gray Banner", "gray_banner", builder -> builder
            .setNetworkId(437)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GRAY_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> GRAY_BED = gen("Gray Bed", "gray_bed", builder -> builder
            .setNetworkId(88)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GRAY_BED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.BED_HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.OCCUPIED));
    public static final BuilderRegister<BlockType> GRAY_CANDLE = gen("Gray Candle", "gray_candle", builder -> builder
            .setNetworkId(785)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GRAY_CANDLE)
            .addStateProperty(IntegerBlockStatePropertyTypes.CANDLES)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> GRAY_CANDLE_CAKE = gen("Cake with Gray Candle", "gray_candle_cake", builder -> builder
            .setNetworkId(802)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAKE)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> GRAY_CARPET = gen("Gray Carpet", "gray_carpet", builder -> builder
            .setNetworkId(412)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GRAY_CARPET));
    public static final BuilderRegister<BlockType> GRAY_CONCRETE = gen("Gray Concrete", "gray_concrete", builder -> builder
            .setNetworkId(563)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GRAY_CONCRETE));
    public static final BuilderRegister<BlockType> GRAY_CONCRETE_POWDER = gen("Gray Concrete Powder", "gray_concrete_powder", builder -> builder
            .setNetworkId(579)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GRAY_CONCRETE_POWDER));
    public static final BuilderRegister<BlockType> GRAY_GLAZED_TERRACOTTA = gen("Gray Glazed Terracotta", "gray_glazed_terracotta", builder -> builder
            .setNetworkId(547)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GRAY_GLAZED_TERRACOTTA)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> GRAY_SHULKER_BOX = gen("Gray Shulker Box", "gray_shulker_box", builder -> builder
            .setNetworkId(531)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GRAY_SHULKER_BOX)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> GRAY_STAINED_GLASS = gen("Gray Stained Glass", "gray_stained_glass", builder -> builder
            .setNetworkId(221)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GRAY_STAINED_GLASS));
    public static final BuilderRegister<BlockType> GRAY_STAINED_GLASS_PANE = gen("Gray Stained Glass Pane", "gray_stained_glass_pane", builder -> builder
            .setNetworkId(379)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GRAY_STAINED_GLASS_PANE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> GRAY_TERRACOTTA = gen("Gray Terracotta", "gray_terracotta", builder -> builder
            .setNetworkId(363)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GRAY_TERRACOTTA));
    public static final BuilderRegister<BlockType> GRAY_WALL_BANNER = gen("null", "gray_wall_banner", builder -> builder
            .setNetworkId(453)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GRAY_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> GRAY_WOOL = gen("Gray Wool", "gray_wool", builder -> builder
            .setNetworkId(115)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GRAY_WOOL));
    public static final BuilderRegister<BlockType> GREEN_BANNER = gen("Green Banner", "green_banner", builder -> builder
            .setNetworkId(443)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GREEN_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> GREEN_BED = gen("Green Bed", "green_bed", builder -> builder
            .setNetworkId(94)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GREEN_BED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.BED_HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.OCCUPIED));
    public static final BuilderRegister<BlockType> GREEN_CANDLE = gen("Green Candle", "green_candle", builder -> builder
            .setNetworkId(791)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GREEN_CANDLE)
            .addStateProperty(IntegerBlockStatePropertyTypes.CANDLES)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> GREEN_CANDLE_CAKE = gen("Cake with Green Candle", "green_candle_cake", builder -> builder
            .setNetworkId(808)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAKE)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> GREEN_CARPET = gen("Green Carpet", "green_carpet", builder -> builder
            .setNetworkId(418)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GREEN_CARPET));
    public static final BuilderRegister<BlockType> GREEN_CONCRETE = gen("Green Concrete", "green_concrete", builder -> builder
            .setNetworkId(569)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GREEN_CONCRETE));
    public static final BuilderRegister<BlockType> GREEN_CONCRETE_POWDER = gen("Green Concrete Powder", "green_concrete_powder", builder -> builder
            .setNetworkId(585)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GREEN_CONCRETE_POWDER));
    public static final BuilderRegister<BlockType> GREEN_GLAZED_TERRACOTTA = gen("Green Glazed Terracotta", "green_glazed_terracotta", builder -> builder
            .setNetworkId(553)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GREEN_GLAZED_TERRACOTTA)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> GREEN_SHULKER_BOX = gen("Green Shulker Box", "green_shulker_box", builder -> builder
            .setNetworkId(537)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GREEN_SHULKER_BOX)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> GREEN_STAINED_GLASS = gen("Green Stained Glass", "green_stained_glass", builder -> builder
            .setNetworkId(227)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GREEN_STAINED_GLASS));
    public static final BuilderRegister<BlockType> GREEN_STAINED_GLASS_PANE = gen("Green Stained Glass Pane", "green_stained_glass_pane", builder -> builder
            .setNetworkId(385)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GREEN_STAINED_GLASS_PANE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> GREEN_TERRACOTTA = gen("Green Terracotta", "green_terracotta", builder -> builder
            .setNetworkId(369)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GREEN_TERRACOTTA));
    public static final BuilderRegister<BlockType> GREEN_WALL_BANNER = gen("null", "green_wall_banner", builder -> builder
            .setNetworkId(459)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GREEN_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> GREEN_WOOL = gen("Green Wool", "green_wool", builder -> builder
            .setNetworkId(121)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GREEN_WOOL));
    public static final BuilderRegister<BlockType> GRINDSTONE = gen("Grindstone", "grindstone", builder -> builder
            .setNetworkId(687)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.GRINDSTONE)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.ATTACHABLE_FACE_STANDARD));
    public static final BuilderRegister<BlockType> HANGING_ROOTS = gen("Hanging Roots", "hanging_roots", builder -> builder
            .setNetworkId(869)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.HANGING_ROOTS)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> HAY_BLOCK = gen("Hay Bale", "hay_block", builder -> builder
            .setNetworkId(404)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.HAY_BLOCK)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> HEAVY_WEIGHTED_PRESSURE_PLATE = gen("Heavy Weighted Pressure Plate", "heavy_weighted_pressure_plate", builder -> builder
            .setNetworkId(344)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.HEAVY_WEIGHTED_PRESSURE_PLATE)
            .addStateProperty(IntegerBlockStatePropertyTypes.REDSTONE_POWER_LEVEL));
    public static final BuilderRegister<BlockType> HONEYCOMB_BLOCK = gen("Honeycomb Block", "honeycomb_block", builder -> builder
            .setNetworkId(747)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.HONEYCOMB_BLOCK));
    public static final BuilderRegister<BlockType> HONEY_BLOCK = gen("Honey Block", "honey_block", builder -> builder
            .setNetworkId(746)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.HONEY_BLOCK));
    public static final BuilderRegister<BlockType> HOPPER = gen("Hopper", "hopper", builder -> builder
            .setNetworkId(349)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.HOPPER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.ENABLED));
    public static final BuilderRegister<BlockType> HORN_CORAL = gen("Horn Coral", "horn_coral", builder -> builder
            .setNetworkId(611)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.HORN_CORAL)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> HORN_CORAL_BLOCK = gen("Horn Coral Block", "horn_coral_block", builder -> builder
            .setNetworkId(601)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.HORN_CORAL_BLOCK));
    public static final BuilderRegister<BlockType> HORN_CORAL_FAN = gen("Horn Coral Fan", "horn_coral_fan", builder -> builder
            .setNetworkId(621)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.HORN_CORAL_FAN)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> HORN_CORAL_WALL_FAN = gen("Horn Coral Wall Fan", "horn_coral_wall_fan", builder -> builder
            .setNetworkId(631)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.HORN_CORAL_FAN)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> ICE = gen("Ice", "ice", builder -> builder
            .setNetworkId(193)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ICE));
    public static final BuilderRegister<BlockType> INFESTED_CHISELED_STONE_BRICKS = gen("Infested Chiseled Stone Bricks", "infested_chiseled_stone_bricks", builder -> builder
            .setNetworkId(245)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.INFESTED_CHISELED_STONE_BRICKS));
    public static final BuilderRegister<BlockType> INFESTED_COBBLESTONE = gen("Infested Cobblestone", "infested_cobblestone", builder -> builder
            .setNetworkId(241)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.INFESTED_COBBLESTONE));
    public static final BuilderRegister<BlockType> INFESTED_CRACKED_STONE_BRICKS = gen("Infested Cracked Stone Bricks", "infested_cracked_stone_bricks", builder -> builder
            .setNetworkId(244)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.INFESTED_CRACKED_STONE_BRICKS));
    public static final BuilderRegister<BlockType> INFESTED_DEEPSLATE = gen("Infested Deepslate", "infested_deepslate", builder -> builder
            .setNetworkId(891)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.INFESTED_DEEPSLATE));
    public static final BuilderRegister<BlockType> INFESTED_MOSSY_STONE_BRICKS = gen("Infested Mossy Stone Bricks", "infested_mossy_stone_bricks", builder -> builder
            .setNetworkId(243)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.INFESTED_MOSSY_STONE_BRICKS));
    public static final BuilderRegister<BlockType> INFESTED_STONE = gen("Infested Stone", "infested_stone", builder -> builder
            .setNetworkId(240)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.INFESTED_STONE));
    public static final BuilderRegister<BlockType> INFESTED_STONE_BRICKS = gen("Infested Stone Bricks", "infested_stone_bricks", builder -> builder
            .setNetworkId(242)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.INFESTED_STONE_BRICKS));
    public static final BuilderRegister<BlockType> IRON_BARS = gen("Iron Bars", "iron_bars", builder -> builder
            .setNetworkId(249)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.IRON_BARS)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> IRON_BLOCK = gen("Block of Iron", "iron_block", builder -> builder
            .setNetworkId(141)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.IRON_BLOCK));
    public static final BuilderRegister<BlockType> IRON_DOOR = gen("Iron Door", "iron_door", builder -> builder
            .setNetworkId(180)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.IRON_DOOR)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(EnumBlockStatePropertyTypes.HINGE)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> IRON_ORE = gen("Iron Ore", "iron_ore", builder -> builder
            .setNetworkId(33)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.IRON_ORE));
    public static final BuilderRegister<BlockType> IRON_TRAPDOOR = gen("Iron Trapdoor", "iron_trapdoor", builder -> builder
            .setNetworkId(393)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.IRON_TRAPDOOR)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> JACK_O_LANTERN = gen("Jack o'Lantern", "jack_o_lantern", builder -> builder
            .setNetworkId(211)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.JACK_O_LANTERN)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> JIGSAW = gen("Jigsaw Block", "jigsaw", builder -> builder
            .setNetworkId(741)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.JIGSAW)
            .addStateProperty(EnumBlockStatePropertyTypes.PLACEMENT_ORIENTATION));
    public static final BuilderRegister<BlockType> JUKEBOX = gen("Jukebox", "jukebox", builder -> builder
            .setNetworkId(198)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.JUKEBOX)
            .addStateProperty(BooleanBlockStatePropertyTypes.HAS_RECORD));
    public static final BuilderRegister<BlockType> JUNGLE_BUTTON = gen("Jungle Button", "jungle_button", builder -> builder
            .setNetworkId(324)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.JUNGLE_BUTTON)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(EnumBlockStatePropertyTypes.ATTACHABLE_FACE_STANDARD));
    public static final BuilderRegister<BlockType> JUNGLE_DOOR = gen("Jungle Door", "jungle_door", builder -> builder
            .setNetworkId(501)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.JUNGLE_DOOR)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(EnumBlockStatePropertyTypes.HINGE)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> JUNGLE_FENCE = gen("Jungle Fence", "jungle_fence", builder -> builder
            .setNetworkId(496)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.JUNGLE_FENCE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> JUNGLE_FENCE_GATE = gen("Jungle Fence Gate", "jungle_fence_gate", builder -> builder
            .setNetworkId(491)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.JUNGLE_FENCE_GATE)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.IN_WALL));
    public static final BuilderRegister<BlockType> JUNGLE_LEAVES = gen("Jungle Leaves", "jungle_leaves", builder -> builder
            .setNetworkId(65)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.JUNGLE_LEAVES)
            .addStateProperty(IntegerBlockStatePropertyTypes.DISTANCE)
            .addStateProperty(BooleanBlockStatePropertyTypes.PERSISTENT));
    public static final BuilderRegister<BlockType> JUNGLE_LOG = gen("Jungle Log", "jungle_log", builder -> builder
            .setNetworkId(41)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.JUNGLE_LOG)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> JUNGLE_PLANKS = gen("Jungle Planks", "jungle_planks", builder -> builder
            .setNetworkId(16)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.JUNGLE_PLANKS));
    public static final BuilderRegister<BlockType> JUNGLE_PRESSURE_PLATE = gen("Jungle Pressure Plate", "jungle_pressure_plate", builder -> builder
            .setNetworkId(184)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.JUNGLE_PRESSURE_PLATE)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> JUNGLE_SAPLING = gen("Jungle Sapling", "jungle_sapling", builder -> builder
            .setNetworkId(22)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.JUNGLE_SAPLING)
            .addStateProperty(IntegerBlockStatePropertyTypes.GROWTH_STAGE));
    public static final BuilderRegister<BlockType> JUNGLE_SIGN = gen("Jungle Sign", "jungle_sign", builder -> builder
            .setNetworkId(166)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.JUNGLE_SIGN)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> JUNGLE_SLAB = gen("Jungle Slab", "jungle_slab", builder -> builder
            .setNetworkId(469)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.JUNGLE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> JUNGLE_STAIRS = gen("Jungle Stairs", "jungle_stairs", builder -> builder
            .setNetworkId(289)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.JUNGLE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> JUNGLE_TRAPDOOR = gen("Jungle Trapdoor", "jungle_trapdoor", builder -> builder
            .setNetworkId(233)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.JUNGLE_TRAPDOOR)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> JUNGLE_WALL_SIGN = gen("Jungle Wall Sign", "jungle_wall_sign", builder -> builder
            .setNetworkId(176)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.JUNGLE_SIGN)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> JUNGLE_WOOD = gen("Jungle Wood", "jungle_wood", builder -> builder
            .setNetworkId(53)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.JUNGLE_WOOD)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> KELP = gen("Kelp", "kelp", builder -> builder
            .setNetworkId(588)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.KELP)
            .addStateProperty(IntegerBlockStatePropertyTypes.AGE_26));
    public static final BuilderRegister<BlockType> KELP_PLANT = gen("Kelp Plant", "kelp_plant", builder -> builder
            .setNetworkId(589)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.KELP));
    /*public static final BuilderRegister<BlockType>
            .addER =

    gen("
                .adder", "
                .adder", builder -> builder
                .setNetworkId(169)
            .

    setMass(MassType.SOLID)
            .

    setItem(ItemTypes .
.addER)
.

    addStateProperty(EnumBlockStatePropertyTypes.FACING)
.

    addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));*/
    public static final BuilderRegister<BlockType> LANTERN = gen("Lantern", "lantern", builder -> builder
            .setNetworkId(692)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LANTERN)
            .addStateProperty(BooleanBlockStatePropertyTypes.HANGING)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> LAPIS_BLOCK = gen("Block of Lapis Lazuli", "lapis_block", builder -> builder
            .setNetworkId(75)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LAPIS_BLOCK));
    public static final BuilderRegister<BlockType> LAPIS_ORE = gen("Lapis Lazuli Ore", "lapis_ore", builder -> builder
            .setNetworkId(73)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LAPIS_ORE));
    public static final BuilderRegister<BlockType> LARGE_AMETHYST_BUD = gen("Large Amethyst Bud", "large_amethyst_bud", builder -> builder
            .setNetworkId(814)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LARGE_AMETHYST_BUD)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> LARGE_FERN = gen("Large Fern", "large_fern", builder -> builder
            .setNetworkId(429)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LARGE_FERN)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF));
    public static final BuilderRegister<BlockType> LAVA = gen("Lava", "lava", builder -> builder
            .setNetworkId(27)
            .setMass(MassType.LIQUID)
            .addStateProperty(IntegerBlockStatePropertyTypes.LIQUID_LEVEL));
    public static final BuilderRegister<BlockType> LAVA_CAULDRON = gen("Lava Cauldron", "lava_cauldron", builder -> builder
            .setNetworkId(272)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAULDRON));
    public static final BuilderRegister<BlockType> LECTERN = gen("Lectern", "lectern", builder -> builder
            .setNetworkId(688)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LECTERN)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.HAS_BOOK));
    public static final BuilderRegister<BlockType> LEVER = gen("Lever", "lever", builder -> builder
            .setNetworkId(178)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LEVER)
            .addStateProperty(EnumBlockStatePropertyTypes.ATTACHABLE_FACE_STANDARD)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> LIGHT = gen("Light", "light", builder -> builder
            .setNetworkId(392)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT)
            .addStateProperty(IntegerBlockStatePropertyTypes.LIGHT_LEVEL)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> LIGHTNING_ROD = gen("Lightning Rod", "lightning_rod", builder -> builder
            .setNetworkId(856)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHTNING_ROD)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> LIGHT_BLUE_BANNER = gen("Light Blue Banner", "light_blue_banner", builder -> builder
            .setNetworkId(433)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_BLUE_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> LIGHT_BLUE_BED = gen("Light Blue Bed", "light_blue_bed", builder -> builder
            .setNetworkId(84)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_BLUE_BED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.BED_HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.OCCUPIED));
    public static final BuilderRegister<BlockType> LIGHT_BLUE_CANDLE = gen("Light Blue Candle", "light_blue_candle", builder -> builder
            .setNetworkId(781)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_BLUE_CANDLE)
            .addStateProperty(IntegerBlockStatePropertyTypes.CANDLES)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> LIGHT_BLUE_CANDLE_CAKE = gen("Cake with Light Blue Candle", "light_blue_candle_cake", builder -> builder
            .setNetworkId(798)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAKE)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> LIGHT_BLUE_CARPET = gen("Light Blue Carpet", "light_blue_carpet", builder -> builder
            .setNetworkId(408)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_BLUE_CARPET));
    public static final BuilderRegister<BlockType> LIGHT_BLUE_CONCRETE = gen("Light Blue Concrete", "light_blue_concrete", builder -> builder
            .setNetworkId(559)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_BLUE_CONCRETE));
    public static final BuilderRegister<BlockType> LIGHT_BLUE_CONCRETE_POWDER = gen("Light Blue Concrete Powder", "light_blue_concrete_powder", builder -> builder
            .setNetworkId(575)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_BLUE_CONCRETE_POWDER));
    public static final BuilderRegister<BlockType> LIGHT_BLUE_GLAZED_TERRACOTTA = gen("Light Blue Glazed Terracotta", "light_blue_glazed_terracotta", builder -> builder
            .setNetworkId(543)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_BLUE_GLAZED_TERRACOTTA)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> LIGHT_BLUE_SHULKER_BOX = gen("Light Blue Shulker Box", "light_blue_shulker_box", builder -> builder
            .setNetworkId(527)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_BLUE_SHULKER_BOX)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> LIGHT_BLUE_STAINED_GLASS = gen("Light Blue Stained Glass", "light_blue_stained_glass", builder -> builder
            .setNetworkId(217)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_BLUE_STAINED_GLASS));
    public static final BuilderRegister<BlockType> LIGHT_BLUE_STAINED_GLASS_PANE = gen("Light Blue Stained Glass Pane", "light_blue_stained_glass_pane", builder -> builder
            .setNetworkId(375)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_BLUE_STAINED_GLASS_PANE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> LIGHT_BLUE_TERRACOTTA = gen("Light Blue Terracotta", "light_blue_terracotta", builder -> builder
            .setNetworkId(359)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_BLUE_TERRACOTTA));
    public static final BuilderRegister<BlockType> LIGHT_BLUE_WALL_BANNER = gen("null", "light_blue_wall_banner", builder -> builder
            .setNetworkId(449)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_BLUE_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> LIGHT_BLUE_WOOL = gen("Light Blue Wool", "light_blue_wool", builder -> builder
            .setNetworkId(111)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_BLUE_WOOL));
    public static final BuilderRegister<BlockType> LIGHT_GRAY_BANNER = gen("Light Gray Banner", "light_gray_banner", builder -> builder
            .setNetworkId(438)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_GRAY_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> LIGHT_GRAY_BED = gen("Light Gray Bed", "light_gray_bed", builder -> builder
            .setNetworkId(89)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_GRAY_BED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.BED_HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.OCCUPIED));
    public static final BuilderRegister<BlockType> LIGHT_GRAY_CANDLE = gen("Light Gray Candle", "light_gray_candle", builder -> builder
            .setNetworkId(786)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_GRAY_CANDLE)
            .addStateProperty(IntegerBlockStatePropertyTypes.CANDLES)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> LIGHT_GRAY_CANDLE_CAKE = gen("Cake with Light Gray Candle", "light_gray_candle_cake", builder -> builder
            .setNetworkId(803)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAKE)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> LIGHT_GRAY_CARPET = gen("Light Gray Carpet", "light_gray_carpet", builder -> builder
            .setNetworkId(413)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_GRAY_CARPET));
    public static final BuilderRegister<BlockType> LIGHT_GRAY_CONCRETE = gen("Light Gray Concrete", "light_gray_concrete", builder -> builder
            .setNetworkId(564)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_GRAY_CONCRETE));
    public static final BuilderRegister<BlockType> LIGHT_GRAY_CONCRETE_POWDER = gen("Light Gray Concrete Powder", "light_gray_concrete_powder", builder -> builder
            .setNetworkId(580)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_GRAY_CONCRETE_POWDER));
    public static final BuilderRegister<BlockType> LIGHT_GRAY_GLAZED_TERRACOTTA = gen("Light Gray Glazed Terracotta", "light_gray_glazed_terracotta", builder -> builder
            .setNetworkId(548)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_GRAY_GLAZED_TERRACOTTA)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> LIGHT_GRAY_SHULKER_BOX = gen("Light Gray Shulker Box", "light_gray_shulker_box", builder -> builder
            .setNetworkId(532)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_GRAY_SHULKER_BOX)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> LIGHT_GRAY_STAINED_GLASS = gen("Light Gray Stained Glass", "light_gray_stained_glass", builder -> builder
            .setNetworkId(222)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_GRAY_STAINED_GLASS));
    public static final BuilderRegister<BlockType> LIGHT_GRAY_STAINED_GLASS_PANE = gen("Light Gray Stained Glass Pane", "light_gray_stained_glass_pane", builder -> builder
            .setNetworkId(380)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_GRAY_STAINED_GLASS_PANE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> LIGHT_GRAY_TERRACOTTA = gen("Light Gray Terracotta", "light_gray_terracotta", builder -> builder
            .setNetworkId(364)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_GRAY_TERRACOTTA));
    public static final BuilderRegister<BlockType> LIGHT_GRAY_WALL_BANNER = gen("null", "light_gray_wall_banner", builder -> builder
            .setNetworkId(454)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_GRAY_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> LIGHT_GRAY_WOOL = gen("Light Gray Wool", "light_gray_wool", builder -> builder
            .setNetworkId(116)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_GRAY_WOOL));
    public static final BuilderRegister<BlockType> LIGHT_WEIGHTED_PRESSURE_PLATE = gen("Light Weighted Pressure Plate", "light_weighted_pressure_plate", builder -> builder
            .setNetworkId(343)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIGHT_WEIGHTED_PRESSURE_PLATE)
            .addStateProperty(IntegerBlockStatePropertyTypes.REDSTONE_POWER_LEVEL));
    public static final BuilderRegister<BlockType> LILAC = gen("Lilac", "lilac", builder -> builder
            .setNetworkId(425)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LILAC)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF));
    public static final BuilderRegister<BlockType> LILY_OF_THE_VALLEY = gen("Lily of the Valley", "lily_of_the_valley", builder -> builder
            .setNetworkId(137)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LILY_OF_THE_VALLEY));
    public static final BuilderRegister<BlockType> LILY_PAD = gen("Lily Pad", "lily_pad", builder -> builder
            .setNetworkId(263)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LILY_PAD));
    public static final BuilderRegister<BlockType> LIME_BANNER = gen("Lime Banner", "lime_banner", builder -> builder
            .setNetworkId(435)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIME_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> LIME_BED = gen("Lime Bed", "lime_bed", builder -> builder
            .setNetworkId(86)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIME_BED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.BED_HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.OCCUPIED));
    public static final BuilderRegister<BlockType> LIME_CANDLE = gen("Lime Candle", "lime_candle", builder -> builder
            .setNetworkId(783)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIME_CANDLE)
            .addStateProperty(IntegerBlockStatePropertyTypes.CANDLES)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> LIME_CANDLE_CAKE = gen("Cake with Lime Candle", "lime_candle_cake", builder -> builder
            .setNetworkId(800)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAKE)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> LIME_CARPET = gen("Lime Carpet", "lime_carpet", builder -> builder
            .setNetworkId(410)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIME_CARPET));
    public static final BuilderRegister<BlockType> LIME_CONCRETE = gen("Lime Concrete", "lime_concrete", builder -> builder
            .setNetworkId(561)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIME_CONCRETE));
    public static final BuilderRegister<BlockType> LIME_CONCRETE_POWDER = gen("Lime Concrete Powder", "lime_concrete_powder", builder -> builder
            .setNetworkId(577)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIME_CONCRETE_POWDER));
    public static final BuilderRegister<BlockType> LIME_GLAZED_TERRACOTTA = gen("Lime Glazed Terracotta", "lime_glazed_terracotta", builder -> builder
            .setNetworkId(545)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIME_GLAZED_TERRACOTTA)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> LIME_SHULKER_BOX = gen("Lime Shulker Box", "lime_shulker_box", builder -> builder
            .setNetworkId(529)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIME_SHULKER_BOX)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> LIME_STAINED_GLASS = gen("Lime Stained Glass", "lime_stained_glass", builder -> builder
            .setNetworkId(219)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIME_STAINED_GLASS));
    public static final BuilderRegister<BlockType> LIME_STAINED_GLASS_PANE = gen("Lime Stained Glass Pane", "lime_stained_glass_pane", builder -> builder
            .setNetworkId(377)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIME_STAINED_GLASS_PANE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> LIME_TERRACOTTA = gen("Lime Terracotta", "lime_terracotta", builder -> builder
            .setNetworkId(361)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIME_TERRACOTTA));
    public static final BuilderRegister<BlockType> LIME_WALL_BANNER = gen("null", "lime_wall_banner", builder -> builder
            .setNetworkId(451)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIME_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> LIME_WOOL = gen("Lime Wool", "lime_wool", builder -> builder
            .setNetworkId(113)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LIME_WOOL));
    public static final BuilderRegister<BlockType> LODESTONE = gen("Lodestone", "lodestone", builder -> builder
            .setNetworkId(756)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LODESTONE));
    public static final BuilderRegister<BlockType> LOOM = gen("Loom", "loom", builder -> builder
            .setNetworkId(681)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.LOOM)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> MAGENTA_BANNER = gen("Magenta Banner", "magenta_banner", builder -> builder
            .setNetworkId(432)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MAGENTA_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> MAGENTA_BED = gen("Magenta Bed", "magenta_bed", builder -> builder
            .setNetworkId(83)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MAGENTA_BED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.BED_HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.OCCUPIED));
    public static final BuilderRegister<BlockType> MAGENTA_CANDLE = gen("Magenta Candle", "magenta_candle", builder -> builder
            .setNetworkId(780)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MAGENTA_CANDLE)
            .addStateProperty(IntegerBlockStatePropertyTypes.CANDLES)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> MAGENTA_CANDLE_CAKE = gen("Cake with Magenta Candle", "magenta_candle_cake", builder -> builder
            .setNetworkId(797)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAKE)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> MAGENTA_CARPET = gen("Magenta Carpet", "magenta_carpet", builder -> builder
            .setNetworkId(407)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MAGENTA_CARPET));
    public static final BuilderRegister<BlockType> MAGENTA_CONCRETE = gen("Magenta Concrete", "magenta_concrete", builder -> builder
            .setNetworkId(558)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MAGENTA_CONCRETE));
    public static final BuilderRegister<BlockType> MAGENTA_CONCRETE_POWDER = gen("Magenta Concrete Powder", "magenta_concrete_powder", builder -> builder
            .setNetworkId(574)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MAGENTA_CONCRETE_POWDER));
    public static final BuilderRegister<BlockType> MAGENTA_GLAZED_TERRACOTTA = gen("Magenta Glazed Terracotta", "magenta_glazed_terracotta", builder -> builder
            .setNetworkId(542)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MAGENTA_GLAZED_TERRACOTTA)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> MAGENTA_SHULKER_BOX = gen("Magenta Shulker Box", "magenta_shulker_box", builder -> builder
            .setNetworkId(526)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MAGENTA_SHULKER_BOX)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> MAGENTA_STAINED_GLASS = gen("Magenta Stained Glass", "magenta_stained_glass", builder -> builder
            .setNetworkId(216)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MAGENTA_STAINED_GLASS));
    public static final BuilderRegister<BlockType> MAGENTA_STAINED_GLASS_PANE = gen("Magenta Stained Glass Pane", "magenta_stained_glass_pane", builder -> builder
            .setNetworkId(374)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MAGENTA_STAINED_GLASS_PANE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> MAGENTA_TERRACOTTA = gen("Magenta Terracotta", "magenta_terracotta", builder -> builder
            .setNetworkId(358)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MAGENTA_TERRACOTTA));
    public static final BuilderRegister<BlockType> MAGENTA_WALL_BANNER = gen("null", "magenta_wall_banner", builder -> builder
            .setNetworkId(448)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MAGENTA_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> MAGENTA_WOOL = gen("Magenta Wool", "magenta_wool", builder -> builder
            .setNetworkId(110)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MAGENTA_WOOL));
    public static final BuilderRegister<BlockType> MAGMA_BLOCK = gen("Magma Block", "magma_block", builder -> builder
            .setNetworkId(517)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MAGMA_BLOCK));
    public static final BuilderRegister<BlockType> MEDIUM_AMETHYST_BUD = gen("Medium Amethyst Bud", "medium_amethyst_bud", builder -> builder
            .setNetworkId(815)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MEDIUM_AMETHYST_BUD)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> MELON = gen("Melon", "melon", builder -> builder
            .setNetworkId(252)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MELON));
    public static final BuilderRegister<BlockType> MELON_STEM = gen("Melon Stem", "melon_stem", builder -> builder
            .setNetworkId(256)
            .setMass(MassType.SOLID)
            .addStateProperty(IntegerBlockStatePropertyTypes.AGE_8));
    public static final BuilderRegister<BlockType> MOSSY_COBBLESTONE = gen("Mossy Cobblestone", "mossy_cobblestone", builder -> builder
            .setNetworkId(145)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MOSSY_COBBLESTONE));
    public static final BuilderRegister<BlockType> MOSSY_COBBLESTONE_SLAB = gen("Mossy Cobblestone Slab", "mossy_cobblestone_slab", builder -> builder
            .setNetworkId(659)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MOSSY_COBBLESTONE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> MOSSY_COBBLESTONE_STAIRS = gen("Mossy Cobblestone Stairs", "mossy_cobblestone_stairs", builder -> builder
            .setNetworkId(645)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MOSSY_COBBLESTONE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> MOSSY_COBBLESTONE_WALL = gen("Mossy Cobblestone Wall", "mossy_cobblestone_wall", builder -> builder
            .setNetworkId(293)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MOSSY_COBBLESTONE_WALL)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> MOSSY_STONE_BRICKS = gen("Mossy Stone Bricks", "mossy_stone_bricks", builder -> builder
            .setNetworkId(237)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MOSSY_STONE_BRICKS));
    public static final BuilderRegister<BlockType> MOSSY_STONE_BRICK_SLAB = gen("Mossy Stone Brick Slab", "mossy_stone_brick_slab", builder -> builder
            .setNetworkId(657)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MOSSY_STONE_BRICK_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> MOSSY_STONE_BRICK_STAIRS = gen("Mossy Stone Brick Stairs", "mossy_stone_brick_stairs", builder -> builder
            .setNetworkId(643)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MOSSY_STONE_BRICK_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> MOSSY_STONE_BRICK_WALL = gen("Mossy Stone Brick Wall", "mossy_stone_brick_wall", builder -> builder
            .setNetworkId(671)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MOSSY_STONE_BRICK_WALL)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> MOSS_BLOCK = gen("Moss Block", "moss_block", builder -> builder
            .setNetworkId(865)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MOSS_BLOCK));
    public static final BuilderRegister<BlockType> MOSS_CARPET = gen("Moss Carpet", "moss_carpet", builder -> builder
            .setNetworkId(864)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MOSS_CARPET));
    public static final BuilderRegister<BlockType> MOVING_PISTON = gen("Moving Piston", "moving_piston", builder -> builder
            .setNetworkId(124)
            .setMass(MassType.SOLID)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.PISTON_HEAD_TYPE));
    public static final BuilderRegister<BlockType> MUSHROOM_STEM = gen("Mushroom Stem", "mushroom_stem", builder -> builder
            .setNetworkId(248)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MUSHROOM_STEM)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(BooleanBlockStatePropertyTypes.DOWN)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST));
    public static final BuilderRegister<BlockType> MYCELIUM = gen("Mycelium", "mycelium", builder -> builder
            .setNetworkId(262)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.MYCELIUM)
            .addStateProperty(BooleanBlockStatePropertyTypes.SNOWY));
    public static final BuilderRegister<BlockType> NETHERITE_BLOCK = gen("Block of Netherite", "netherite_block", builder -> builder
            .setNetworkId(748)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.NETHERITE_BLOCK));
    public static final BuilderRegister<BlockType> NETHERRACK = gen("Netherrack", "netherrack", builder -> builder
            .setNetworkId(201)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.NETHERRACK));
    public static final BuilderRegister<BlockType> NETHER_BRICKS = gen("Nether Bricks", "nether_bricks", builder -> builder
            .setNetworkId(264)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.NETHER_BRICKS));
    public static final BuilderRegister<BlockType> NETHER_BRICK_FENCE = gen("Nether Brick Fence", "nether_brick_fence", builder -> builder
            .setNetworkId(265)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.NETHER_BRICK_FENCE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> NETHER_BRICK_SLAB = gen("Nether Brick Slab", "nether_brick_slab", builder -> builder
            .setNetworkId(480)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.NETHER_BRICK_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> NETHER_BRICK_STAIRS = gen("Nether Brick Stairs", "nether_brick_stairs", builder -> builder
            .setNetworkId(266)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.NETHER_BRICK_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> NETHER_BRICK_WALL = gen("Nether Brick Wall", "nether_brick_wall", builder -> builder
            .setNetworkId(674)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.NETHER_BRICK_WALL)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> NETHER_GOLD_ORE = gen("Nether Gold Ore", "nether_gold_ore", builder -> builder
            .setNetworkId(37)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.NETHER_GOLD_ORE));
    public static final BuilderRegister<BlockType> NETHER_PORTAL = gen("Nether Portal", "nether_portal", builder -> builder
            .setNetworkId(209)
            .setMass(MassType.SOLID)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> NETHER_QUARTZ_ORE = gen("Nether Quartz Ore", "nether_quartz_ore", builder -> builder
            .setNetworkId(348)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.NETHER_QUARTZ_ORE));
    public static final BuilderRegister<BlockType> NETHER_SPROUTS = gen("Nether Sprouts", "nether_sprouts", builder -> builder
            .setNetworkId(705)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.NETHER_SPROUTS));
    public static final BuilderRegister<BlockType> NETHER_WART = gen("Nether Wart", "nether_wart", builder -> builder
            .setNetworkId(267)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.NETHER_WART)
            .addStateProperty(IntegerBlockStatePropertyTypes.AGE_4));
    public static final BuilderRegister<BlockType> NETHER_WART_BLOCK = gen("Nether Wart Block", "nether_wart_block", builder -> builder
            .setNetworkId(518)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.NETHER_WART_BLOCK));
    public static final BuilderRegister<BlockType> NOTE_BLOCK = gen("Note Block", "note_block", builder -> builder
            .setNetworkId(80)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.NOTE_BLOCK)
            .addStateProperty(EnumBlockStatePropertyTypes.NOTE_BLOCK_INSTRUMENT)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(IntegerBlockStatePropertyTypes.NOTE));
    public static final BuilderRegister<BlockType> OAK_BUTTON = gen("Oak Button", "oak_button", builder -> builder
            .setNetworkId(321)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OAK_BUTTON)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(EnumBlockStatePropertyTypes.ATTACHABLE_FACE_STANDARD));
    public static final BuilderRegister<BlockType> OAK_DOOR = gen("Oak Door", "oak_door", builder -> builder
            .setNetworkId(168)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OAK_DOOR)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(EnumBlockStatePropertyTypes.HINGE)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> OAK_FENCE = gen("Oak Fence", "oak_fence", builder -> builder
            .setNetworkId(199)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OAK_FENCE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> OAK_FENCE_GATE = gen("Oak Fence Gate", "oak_fence_gate", builder -> builder
            .setNetworkId(259)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OAK_FENCE_GATE)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.IN_WALL));
    public static final BuilderRegister<BlockType> OAK_LEAVES = gen("Oak Leaves", "oak_leaves", builder -> builder
            .setNetworkId(62)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OAK_LEAVES)
            .addStateProperty(IntegerBlockStatePropertyTypes.DISTANCE)
            .addStateProperty(BooleanBlockStatePropertyTypes.PERSISTENT));
    public static final BuilderRegister<BlockType> OAK_LOG = gen("Oak Log", "oak_log", builder -> builder
            .setNetworkId(38)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OAK_LOG)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> OAK_PLANKS = gen("Oak Planks", "oak_planks", builder -> builder
            .setNetworkId(13)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OAK_PLANKS));
    public static final BuilderRegister<BlockType> OAK_PRESSURE_PLATE = gen("Oak Pressure Plate", "oak_pressure_plate", builder -> builder
            .setNetworkId(181)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OAK_PRESSURE_PLATE)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> OAK_SAPLING = gen("Oak Sapling", "oak_sapling", builder -> builder
            .setNetworkId(19)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OAK_SAPLING)
            .addStateProperty(IntegerBlockStatePropertyTypes.GROWTH_STAGE));
    public static final BuilderRegister<BlockType> OAK_SIGN = gen("Oak Sign", "oak_sign", builder -> builder
            .setNetworkId(162)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OAK_SIGN)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> OAK_SLAB = gen("Oak Slab", "oak_slab", builder -> builder
            .setNetworkId(466)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OAK_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> OAK_STAIRS = gen("Oak Stairs", "oak_stairs", builder -> builder
            .setNetworkId(152)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OAK_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> OAK_TRAPDOOR = gen("Oak Trapdoor", "oak_trapdoor", builder -> builder
            .setNetworkId(230)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OAK_TRAPDOOR)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> OAK_WALL_SIGN = gen("Oak Wall Sign", "oak_wall_sign", builder -> builder
            .setNetworkId(172)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OAK_SIGN)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> OAK_WOOD = gen("Oak Wood", "oak_wood", builder -> builder
            .setNetworkId(50)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OAK_WOOD)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> OBSERVER = gen("Observer", "observer", builder -> builder
            .setNetworkId(522)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OBSERVER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> OBSIDIAN = gen("Obsidian", "obsidian", builder -> builder
            .setNetworkId(146)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OBSIDIAN));
    public static final BuilderRegister<BlockType> ORANGE_BANNER = gen("Orange Banner", "orange_banner", builder -> builder
            .setNetworkId(431)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ORANGE_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> ORANGE_BED = gen("Orange Bed", "orange_bed", builder -> builder
            .setNetworkId(82)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ORANGE_BED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.BED_HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.OCCUPIED));
    public static final BuilderRegister<BlockType> ORANGE_CANDLE = gen("Orange Candle", "orange_candle", builder -> builder
            .setNetworkId(779)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ORANGE_CANDLE)
            .addStateProperty(IntegerBlockStatePropertyTypes.CANDLES)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> ORANGE_CANDLE_CAKE = gen("Cake with Orange Candle", "orange_candle_cake", builder -> builder
            .setNetworkId(796)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAKE)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> ORANGE_CARPET = gen("Orange Carpet", "orange_carpet", builder -> builder
            .setNetworkId(406)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ORANGE_CARPET));
    public static final BuilderRegister<BlockType> ORANGE_CONCRETE = gen("Orange Concrete", "orange_concrete", builder -> builder
            .setNetworkId(557)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ORANGE_CONCRETE));
    public static final BuilderRegister<BlockType> ORANGE_CONCRETE_POWDER = gen("Orange Concrete Powder", "orange_concrete_powder", builder -> builder
            .setNetworkId(573)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ORANGE_CONCRETE_POWDER));
    public static final BuilderRegister<BlockType> ORANGE_GLAZED_TERRACOTTA = gen("Orange Glazed Terracotta", "orange_glazed_terracotta", builder -> builder
            .setNetworkId(541)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ORANGE_GLAZED_TERRACOTTA)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> ORANGE_SHULKER_BOX = gen("Orange Shulker Box", "orange_shulker_box", builder -> builder
            .setNetworkId(525)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ORANGE_SHULKER_BOX)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> ORANGE_STAINED_GLASS = gen("Orange Stained Glass", "orange_stained_glass", builder -> builder
            .setNetworkId(215)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ORANGE_STAINED_GLASS));
    public static final BuilderRegister<BlockType> ORANGE_STAINED_GLASS_PANE = gen("Orange Stained Glass Pane", "orange_stained_glass_pane", builder -> builder
            .setNetworkId(373)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ORANGE_STAINED_GLASS_PANE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> ORANGE_TERRACOTTA = gen("Orange Terracotta", "orange_terracotta", builder -> builder
            .setNetworkId(357)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ORANGE_TERRACOTTA));
    public static final BuilderRegister<BlockType> ORANGE_TULIP = gen("Orange Tulip", "orange_tulip", builder -> builder
            .setNetworkId(131)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ORANGE_TULIP));
    public static final BuilderRegister<BlockType> ORANGE_WALL_BANNER = gen("null", "orange_wall_banner", builder -> builder
            .setNetworkId(447)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ORANGE_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> ORANGE_WOOL = gen("Orange Wool", "orange_wool", builder -> builder
            .setNetworkId(109)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ORANGE_WOOL));
    public static final BuilderRegister<BlockType> OXEYE_DAISY = gen("Oxeye Daisy", "oxeye_daisy", builder -> builder
            .setNetworkId(134)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OXEYE_DAISY));
    public static final BuilderRegister<BlockType> OXIDIZED_COPPER = gen("Oxidized Copper", "oxidized_copper", builder -> builder
            .setNetworkId(822)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OXIDIZED_COPPER));
    public static final BuilderRegister<BlockType> OXIDIZED_CUT_COPPER = gen("Oxidized Cut Copper", "oxidized_cut_copper", builder -> builder
            .setNetworkId(828)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OXIDIZED_CUT_COPPER));
    public static final BuilderRegister<BlockType> OXIDIZED_CUT_COPPER_SLAB = gen("Oxidized Cut Copper Slab", "oxidized_cut_copper_slab", builder -> builder
            .setNetworkId(836)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OXIDIZED_CUT_COPPER_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> OXIDIZED_CUT_COPPER_STAIRS = gen("Oxidized Cut Copper Stairs", "oxidized_cut_copper_stairs", builder -> builder
            .setNetworkId(832)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.OXIDIZED_CUT_COPPER_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> PACKED_ICE = gen("Packed Ice", "packed_ice", builder -> builder
            .setNetworkId(423)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PACKED_ICE));
    public static final BuilderRegister<BlockType> PEONY = gen("Peony", "peony", builder -> builder
            .setNetworkId(427)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PEONY)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF));
    public static final BuilderRegister<BlockType> PETRIFIED_OAK_SLAB = gen("Petrified Oak Slab", "petrified_oak_slab", builder -> builder
            .setNetworkId(476)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PETRIFIED_OAK_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> PINK_BANNER = gen("Pink Banner",
            "pink_banner",
            builder -> builder
                    .setNetworkId(436)
                    .setMass(MassType.SOLID)
                    .setItem(ItemTypes.PINK_BANNER)
                    .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> PINK_BED = gen("Pink Bed", "pink_bed", builder -> builder
            .setNetworkId(87)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PINK_BED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.BED_HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.OCCUPIED));
    public static final BuilderRegister<BlockType> PINK_CANDLE = gen("Pink Candle", "pink_candle", builder -> builder
            .setNetworkId(784)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PINK_CANDLE)
            .addStateProperty(IntegerBlockStatePropertyTypes.CANDLES)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> PINK_CANDLE_CAKE = gen("Cake with Pink Candle", "pink_candle_cake", builder -> builder
            .setNetworkId(801)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAKE)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> PINK_CARPET = gen("Pink Carpet", "pink_carpet", builder -> builder
            .setNetworkId(411)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PINK_CARPET));
    public static final BuilderRegister<BlockType> PINK_CONCRETE = gen("Pink Concrete", "pink_concrete", builder -> builder
            .setNetworkId(562)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PINK_CONCRETE));
    public static final BuilderRegister<BlockType> PINK_CONCRETE_POWDER = gen("Pink Concrete Powder", "pink_concrete_powder", builder -> builder
            .setNetworkId(578)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PINK_CONCRETE_POWDER));
    public static final BuilderRegister<BlockType> PINK_GLAZED_TERRACOTTA = gen("Pink Glazed Terracotta", "pink_glazed_terracotta", builder -> builder
            .setNetworkId(546)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PINK_GLAZED_TERRACOTTA)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> PINK_SHULKER_BOX = gen("Pink Shulker Box", "pink_shulker_box", builder -> builder
            .setNetworkId(530)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PINK_SHULKER_BOX)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> PINK_STAINED_GLASS = gen("Pink Stained Glass", "pink_stained_glass", builder -> builder
            .setNetworkId(220)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PINK_STAINED_GLASS));
    public static final BuilderRegister<BlockType> PINK_STAINED_GLASS_PANE = gen("Pink Stained Glass Pane", "pink_stained_glass_pane", builder -> builder
            .setNetworkId(378)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PINK_STAINED_GLASS_PANE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> PINK_TERRACOTTA = gen("Pink Terracotta", "pink_terracotta", builder -> builder
            .setNetworkId(362)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PINK_TERRACOTTA));
    public static final BuilderRegister<BlockType> PINK_TULIP = gen("Pink Tulip", "pink_tulip", builder -> builder
            .setNetworkId(133)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PINK_TULIP));
    public static final BuilderRegister<BlockType> PINK_WALL_BANNER = gen("null", "pink_wall_banner", builder -> builder
            .setNetworkId(452)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PINK_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> PINK_WOOL = gen("Pink Wool", "pink_wool", builder -> builder
            .setNetworkId(114)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PINK_WOOL));
    public static final BuilderRegister<BlockType> PISTON = gen("Piston", "piston", builder -> builder
            .setNetworkId(106)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PISTON)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.EXTENDED));
    public static final BuilderRegister<BlockType> PISTON_HEAD = gen("Piston Head", "piston_head", builder -> builder
            .setNetworkId(107)
            .setMass(MassType.SOLID)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.PISTON_HEAD_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.SHORT));
    public static final BuilderRegister<BlockType> PLAYER_HEAD = gen("Player Head", "player_head", builder -> builder
            .setNetworkId(333)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PLAYER_HEAD)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> PLAYER_WALL_HEAD = gen("Player Wall Head", "player_wall_head", builder -> builder
            .setNetworkId(334)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PLAYER_HEAD)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> PODZOL = gen("Podzol", "podzol", builder -> builder
            .setNetworkId(11)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PODZOL)
            .addStateProperty(BooleanBlockStatePropertyTypes.SNOWY));
    public static final BuilderRegister<BlockType> POINTED_DRIPSTONE = gen("Pointed Dripstone", "pointed_dripstone", builder -> builder
            .setNetworkId(857)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POINTED_DRIPSTONE)
            .addStateProperty(EnumBlockStatePropertyTypes.VERTICAL_DIRECTION)
            .addStateProperty(EnumBlockStatePropertyTypes.DRIPSTONE_SIZE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> POLISHED_ANDESITE = gen("Polished Andesite", "polished_andesite", builder -> builder
            .setNetworkId(7)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_ANDESITE));
    public static final BuilderRegister<BlockType> POLISHED_ANDESITE_SLAB = gen("Polished Andesite Slab", "polished_andesite_slab", builder -> builder
            .setNetworkId(666)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_ANDESITE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> POLISHED_ANDESITE_STAIRS = gen("Polished Andesite Stairs", "polished_andesite_stairs", builder -> builder
            .setNetworkId(653)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_ANDESITE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> POLISHED_BASALT = gen("Polished Basalt", "polished_basalt", builder -> builder
            .setNetworkId(205)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_BASALT)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> POLISHED_BLACKSTONE = gen("Polished Blackstone", "polished_blackstone", builder -> builder
            .setNetworkId(761)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_BLACKSTONE));
    public static final BuilderRegister<BlockType> POLISHED_BLACKSTONE_BRICKS = gen("Polished Blackstone Bricks", "polished_blackstone_bricks", builder -> builder
            .setNetworkId(762)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_BLACKSTONE_BRICKS));
    public static final BuilderRegister<BlockType> POLISHED_BLACKSTONE_BRICK_SLAB = gen("Polished Blackstone Brick Slab", "polished_blackstone_brick_slab", builder -> builder
            .setNetworkId(765)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_BLACKSTONE_BRICK_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> POLISHED_BLACKSTONE_BRICK_STAIRS = gen("Polished Blackstone Brick Stairs", "polished_blackstone_brick_stairs", builder -> builder
            .setNetworkId(766)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_BLACKSTONE_BRICK_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> POLISHED_BLACKSTONE_BRICK_WALL = gen("Polished Blackstone Brick Wall", "polished_blackstone_brick_wall", builder -> builder
            .setNetworkId(767)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_BLACKSTONE_BRICK_WALL)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> POLISHED_BLACKSTONE_BUTTON = gen("Polished Blackstone Button", "polished_blackstone_button", builder -> builder
            .setNetworkId(772)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_BLACKSTONE_BUTTON)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(EnumBlockStatePropertyTypes.ATTACHABLE_FACE_STANDARD));
    public static final BuilderRegister<BlockType> POLISHED_BLACKSTONE_PRESSURE_PLATE = gen("Polished Blackstone Pressure Plate", "polished_blackstone_pressure_plate", builder -> builder
            .setNetworkId(771)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_BLACKSTONE_PRESSURE_PLATE)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> POLISHED_BLACKSTONE_SLAB = gen("Polished Blackstone Slab", "polished_blackstone_slab", builder -> builder
            .setNetworkId(770)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_BLACKSTONE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> POLISHED_BLACKSTONE_STAIRS = gen("Polished Blackstone Stairs", "polished_blackstone_stairs", builder -> builder
            .setNetworkId(769)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_BLACKSTONE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> POLISHED_BLACKSTONE_WALL = gen("Polished Blackstone Wall", "polished_blackstone_wall", builder -> builder
            .setNetworkId(773)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_BLACKSTONE_WALL)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> POLISHED_DEEPSLATE = gen("Polished Deepslate", "polished_deepslate", builder -> builder
            .setNetworkId(876)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_DEEPSLATE));
    public static final BuilderRegister<BlockType> POLISHED_DEEPSLATE_SLAB = gen("Polished Deepslate Slab", "polished_deepslate_slab", builder -> builder
            .setNetworkId(878)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_DEEPSLATE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> POLISHED_DEEPSLATE_STAIRS = gen("Polished Deepslate Stairs", "polished_deepslate_stairs", builder -> builder
            .setNetworkId(877)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_DEEPSLATE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> POLISHED_DEEPSLATE_WALL = gen("Polished Deepslate Wall", "polished_deepslate_wall", builder -> builder
            .setNetworkId(879)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_DEEPSLATE_WALL)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> POLISHED_DIORITE = gen("Polished Diorite", "polished_diorite", builder -> builder
            .setNetworkId(5)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_DIORITE));
    public static final BuilderRegister<BlockType> POLISHED_DIORITE_SLAB = gen("Polished Diorite Slab", "polished_diorite_slab", builder -> builder
            .setNetworkId(658)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_DIORITE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> POLISHED_DIORITE_STAIRS = gen("Polished Diorite Stairs", "polished_diorite_stairs", builder -> builder
            .setNetworkId(644)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_DIORITE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> POLISHED_GRANITE = gen("Polished Granite", "polished_granite", builder -> builder
            .setNetworkId(3)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_GRANITE));
    public static final BuilderRegister<BlockType> POLISHED_GRANITE_SLAB = gen("Polished Granite Slab", "polished_granite_slab", builder -> builder
            .setNetworkId(655)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_GRANITE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> POLISHED_GRANITE_STAIRS = gen("Polished Granite Stairs", "polished_granite_stairs", builder -> builder
            .setNetworkId(641)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POLISHED_GRANITE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> POPPY = gen("Poppy", "poppy", builder -> builder
            .setNetworkId(126)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POPPY));
    public static final BuilderRegister<BlockType> POTATOES = gen("Potatoes", "potatoes", builder -> builder
            .setNetworkId(320)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POTATO)
            .addStateProperty(IntegerBlockStatePropertyTypes.AGE_8));
    public static final BuilderRegister<BlockType> POTTED_ACACIA_SAPLING = gen("Potted Acacia Sapling", "potted_acacia_sapling", builder -> builder
            .setNetworkId(299)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_ALLIUM = gen("Potted Allium", "potted_allium", builder -> builder
            .setNetworkId(305)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_AZALEA_BUSH = gen("Potted Azalea", "potted_azalea_bush", builder -> builder
            .setNetworkId(896)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_AZURE_BLUET = gen("Potted Azure Bluet", "potted_azure_bluet", builder -> builder
            .setNetworkId(306)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_BAMBOO = gen("Potted Bamboo", "potted_bamboo", builder -> builder
            .setNetworkId(637)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_BIRCH_SAPLING = gen("Potted Birch Sapling", "potted_birch_sapling", builder -> builder
            .setNetworkId(297)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_BLUE_ORCHID = gen("Potted Blue Orchid", "potted_blue_orchid", builder -> builder
            .setNetworkId(304)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_BROWN_MUSHROOM = gen("Potted Brown Mushroom", "potted_brown_mushroom", builder -> builder
            .setNetworkId(316)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_CACTUS = gen("Potted Cactus", "potted_cactus", builder -> builder
            .setNetworkId(318)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_CORNFLOWER = gen("Potted Cornflower", "potted_cornflower", builder -> builder
            .setNetworkId(312)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_CRIMSON_FUNGUS = gen("Potted Crimson Fungus", "potted_crimson_fungus", builder -> builder
            .setNetworkId(752)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_CRIMSON_ROOTS = gen("Potted Crimson Roots", "potted_crimson_roots", builder -> builder
            .setNetworkId(754)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_DANDELION = gen("Potted Dandelion", "potted_dandelion", builder -> builder
            .setNetworkId(302)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_DARK_OAK_SAPLING = gen("Potted Dark Oak Sapling", "potted_dark_oak_sapling", builder -> builder
            .setNetworkId(300)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_DEAD_BUSH = gen("Potted Dead Bush", "potted_dead_bush", builder -> builder
            .setNetworkId(317)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_FERN = gen("Potted Fern", "potted_fern", builder -> builder
            .setNetworkId(301)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_FLOWERING_AZALEA_BUSH = gen("Potted Flowering Azalea", "potted_flowering_azalea_bush", builder -> builder
            .setNetworkId(897)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_JUNGLE_SAPLING = gen("Potted Jungle Sapling", "potted_jungle_sapling", builder -> builder
            .setNetworkId(298)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_LILY_OF_THE_VALLEY = gen("Potted Lily of the Valley", "potted_lily_of_the_valley", builder -> builder
            .setNetworkId(313)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_OAK_SAPLING = gen("Potted Oak Sapling", "potted_oak_sapling", builder -> builder
            .setNetworkId(295)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_ORANGE_TULIP = gen("Potted Orange Tulip", "potted_orange_tulip", builder -> builder
            .setNetworkId(308)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_OXEYE_DAISY = gen("Potted Oxeye Daisy", "potted_oxeye_daisy", builder -> builder
            .setNetworkId(311)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_PINK_TULIP = gen("Potted Pink Tulip", "potted_pink_tulip", builder -> builder
            .setNetworkId(310)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_POPPY = gen("Potted Poppy", "potted_poppy", builder -> builder
            .setNetworkId(303)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_RED_MUSHROOM = gen("Potted Red Mushroom", "potted_red_mushroom", builder -> builder
            .setNetworkId(315)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_RED_TULIP = gen("Potted Red Tulip", "potted_red_tulip", builder -> builder
            .setNetworkId(307)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_SPRUCE_SAPLING = gen("Potted Spruce Sapling", "potted_spruce_sapling", builder -> builder
            .setNetworkId(296)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_WARPED_FUNGUS = gen("Potted Warped Fungus", "potted_warped_fungus", builder -> builder
            .setNetworkId(753)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_WARPED_ROOTS = gen("Potted Warped Roots", "potted_warped_roots", builder -> builder
            .setNetworkId(755)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_WHITE_TULIP = gen("Potted White Tulip", "potted_white_tulip", builder -> builder
            .setNetworkId(309)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POTTED_WITHER_ROSE = gen("Potted Wither Rose", "potted_wither_rose", builder -> builder
            .setNetworkId(314)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POWDER_SNOW = gen("Powder Snow", "powder_snow", builder -> builder
            .setNetworkId(820)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.FLOWER_POT));
    public static final BuilderRegister<BlockType> POWDER_SNOW_CAULDRON = gen("Powder Snow Cauldron", "powder_snow_cauldron", builder -> builder
            .setNetworkId(273)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAULDRON)
            .addStateProperty(IntegerBlockStatePropertyTypes.REDSTONE_POWER_LEVEL));
    public static final BuilderRegister<BlockType> POWERED_RAIL = gen("Powered Rail", "powered_rail", builder -> builder
            .setNetworkId(97)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.POWERED_RAIL)
            .addStateProperty(EnumBlockStatePropertyTypes.STRAIGHT_RAIL_DIRECTION)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> PRISMARINE = gen("Prismarine", "prismarine", builder -> builder
            .setNetworkId(394)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PRISMARINE));
    public static final BuilderRegister<BlockType> PRISMARINE_BRICKS = gen("Prismarine Bricks", "prismarine_bricks", builder -> builder
            .setNetworkId(395)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PRISMARINE_BRICKS));
    public static final BuilderRegister<BlockType> PRISMARINE_BRICK_SLAB = gen("Prismarine Brick Slab", "prismarine_brick_slab", builder -> builder
            .setNetworkId(401)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PRISMARINE_BRICK_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> PRISMARINE_BRICK_STAIRS = gen("Prismarine Brick Stairs", "prismarine_brick_stairs", builder -> builder
            .setNetworkId(398)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PRISMARINE_BRICK_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> PRISMARINE_SLAB = gen("Prismarine Slab", "prismarine_slab", builder -> builder
            .setNetworkId(400)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PRISMARINE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> PRISMARINE_STAIRS = gen("Prismarine Stairs", "prismarine_stairs", builder -> builder
            .setNetworkId(397)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PRISMARINE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> PRISMARINE_WALL = gen("Prismarine Wall", "prismarine_wall", builder -> builder
            .setNetworkId(669)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PRISMARINE_WALL)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> PUMPKIN = gen("Pumpkin", "pumpkin", builder -> builder
            .setNetworkId(200)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PUMPKIN));
    public static final BuilderRegister<BlockType> PUMPKIN_STEM = gen("Pumpkin Stem", "pumpkin_stem", builder -> builder
            .setNetworkId(255)
            .setMass(MassType.SOLID)
            .addStateProperty(IntegerBlockStatePropertyTypes.AGE_8));
    public static final BuilderRegister<BlockType> PURPLE_BANNER = gen("Purple Banner", "purple_banner", builder -> builder
            .setNetworkId(440)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PURPLE_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> PURPLE_BED = gen("Purple Bed", "purple_bed", builder -> builder
            .setNetworkId(91)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PURPLE_BED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.BED_HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.OCCUPIED));
    public static final BuilderRegister<BlockType> PURPLE_CANDLE = gen("Purple Candle", "purple_candle", builder -> builder
            .setNetworkId(788)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PURPLE_CANDLE)
            .addStateProperty(IntegerBlockStatePropertyTypes.CANDLES)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> PURPLE_CANDLE_CAKE = gen("Cake with Purple Candle", "purple_candle_cake", builder -> builder
            .setNetworkId(805)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAKE)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> PURPLE_CARPET = gen("Purple Carpet", "purple_carpet", builder -> builder
            .setNetworkId(415)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PURPLE_CARPET));
    public static final BuilderRegister<BlockType> PURPLE_CONCRETE = gen("Purple Concrete", "purple_concrete", builder -> builder
            .setNetworkId(566)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PURPLE_CONCRETE));
    public static final BuilderRegister<BlockType> PURPLE_CONCRETE_POWDER = gen("Purple Concrete Powder", "purple_concrete_powder", builder -> builder
            .setNetworkId(582)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PURPLE_CONCRETE_POWDER));
    public static final BuilderRegister<BlockType> PURPLE_GLAZED_TERRACOTTA = gen("Purple Glazed Terracotta", "purple_glazed_terracotta", builder -> builder
            .setNetworkId(550)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PURPLE_GLAZED_TERRACOTTA)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> PURPLE_SHULKER_BOX = gen("Purple Shulker Box", "purple_shulker_box", builder -> builder
            .setNetworkId(534)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PURPLE_SHULKER_BOX)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> PURPLE_STAINED_GLASS = gen("Purple Stained Glass", "purple_stained_glass", builder -> builder
            .setNetworkId(224)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PURPLE_STAINED_GLASS));
    public static final BuilderRegister<BlockType> PURPLE_STAINED_GLASS_PANE = gen("Purple Stained Glass Pane", "purple_stained_glass_pane", builder -> builder
            .setNetworkId(382)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PURPLE_STAINED_GLASS_PANE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> PURPLE_TERRACOTTA = gen("Purple Terracotta", "purple_terracotta", builder -> builder
            .setNetworkId(366)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PURPLE_TERRACOTTA));
    public static final BuilderRegister<BlockType> PURPLE_WALL_BANNER = gen("null", "purple_wall_banner", builder -> builder
            .setNetworkId(456)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PURPLE_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> PURPLE_WOOL = gen("Purple Wool", "purple_wool", builder -> builder
            .setNetworkId(118)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PURPLE_WOOL));
    public static final BuilderRegister<BlockType> PURPUR_BLOCK = gen("Purpur Block", "purpur_block", builder -> builder
            .setNetworkId(507)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PURPUR_BLOCK));
    public static final BuilderRegister<BlockType> PURPUR_PILLAR = gen("Purpur Pillar", "purpur_pillar", builder -> builder
            .setNetworkId(508)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PURPUR_PILLAR)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> PURPUR_SLAB = gen("Purpur Slab", "purpur_slab", builder -> builder
            .setNetworkId(484)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PURPUR_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> PURPUR_STAIRS = gen("Purpur Stairs", "purpur_stairs", builder -> builder
            .setNetworkId(509)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.PURPUR_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> QUARTZ_BLOCK = gen("Block of Quartz", "quartz_block", builder -> builder
            .setNetworkId(350)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.QUARTZ_BLOCK));
    public static final BuilderRegister<BlockType> QUARTZ_BRICKS = gen("Quartz Bricks", "quartz_bricks", builder -> builder
            .setNetworkId(776)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.QUARTZ_BRICKS));
    public static final BuilderRegister<BlockType> QUARTZ_PILLAR = gen("Quartz Pillar", "quartz_pillar", builder -> builder
            .setNetworkId(352)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.QUARTZ_PILLAR)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> QUARTZ_SLAB = gen("Quartz Slab", "quartz_slab", builder -> builder
            .setNetworkId(481)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.QUARTZ_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> QUARTZ_STAIRS = gen("Quartz Stairs", "quartz_stairs", builder -> builder
            .setNetworkId(353)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.QUARTZ_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> RAIL = gen("Rail", "rail", builder -> builder
            .setNetworkId(170)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RAIL)
            .addStateProperty(EnumBlockStatePropertyTypes.RAIL_DIRECTION)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> RAW_COPPER_BLOCK = gen("Block of Raw Copper", "raw_copper_block", builder -> builder
            .setNetworkId(894)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RAW_COPPER_BLOCK));
    public static final BuilderRegister<BlockType> RAW_GOLD_BLOCK = gen("Block of Raw Gold", "raw_gold_block", builder -> builder
            .setNetworkId(895)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RAW_GOLD_BLOCK));
    public static final BuilderRegister<BlockType> RAW_IRON_BLOCK = gen("Block of Raw Iron", "raw_iron_block", builder -> builder
            .setNetworkId(893)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RAW_IRON_BLOCK));
    public static final BuilderRegister<BlockType> REDSTONE_BLOCK = gen("Block of Redstone", "redstone_block", builder -> builder
            .setNetworkId(347)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.REDSTONE_BLOCK));
    public static final BuilderRegister<BlockType> REDSTONE_LAMP = gen("Redstone Lamp", "redstone_lamp", builder -> builder
            .setNetworkId(278)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.REDSTONE_LAMP)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> REDSTONE_ORE = gen("Redstone Ore", "redstone_ore", builder -> builder
            .setNetworkId(187)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.REDSTONE_ORE)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> REDSTONE_TORCH = gen("Redstone Torch", "redstone_torch", builder -> builder
            .setNetworkId(189)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.REDSTONE_TORCH)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> REDSTONE_WALL_TORCH = gen("Redstone Wall Torch", "redstone_wall_torch", builder -> builder
            .setNetworkId(190)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.REDSTONE_TORCH)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> REDSTONE_WIRE = gen("Redstone Wire", "redstone_wire", builder -> builder
            .setNetworkId(154)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.REDSTONE)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(IntegerBlockStatePropertyTypes.REDSTONE_POWER_LEVEL));
    public static final BuilderRegister<BlockType> RED_BANNER = gen("Red Banner", "red_banner", builder -> builder
            .setNetworkId(444)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> RED_BED = gen("Red Bed", "red_bed", builder -> builder
            .setNetworkId(95)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_BED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.BED_HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.OCCUPIED));
    public static final BuilderRegister<BlockType> RED_CANDLE = gen("Red Candle", "red_candle", builder -> builder
            .setNetworkId(792)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_CANDLE)
            .addStateProperty(IntegerBlockStatePropertyTypes.CANDLES)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> RED_CANDLE_CAKE = gen("Cake with Red Candle", "red_candle_cake", builder -> builder
            .setNetworkId(809)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAKE)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> RED_CARPET = gen("Red Carpet", "red_carpet", builder -> builder
            .setNetworkId(419)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_CARPET));
    public static final BuilderRegister<BlockType> RED_CONCRETE = gen("Red Concrete", "red_concrete", builder -> builder
            .setNetworkId(570)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_CONCRETE));
    public static final BuilderRegister<BlockType> RED_CONCRETE_POWDER = gen("Red Concrete Powder", "red_concrete_powder", builder -> builder
            .setNetworkId(586)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_CONCRETE_POWDER));
    public static final BuilderRegister<BlockType> RED_GLAZED_TERRACOTTA = gen("Red Glazed Terracotta", "red_glazed_terracotta", builder -> builder
            .setNetworkId(554)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_GLAZED_TERRACOTTA)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> RED_MUSHROOM = gen("Red Mushroom", "red_mushroom", builder -> builder
            .setNetworkId(139)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_MUSHROOM));
    public static final BuilderRegister<BlockType> RED_MUSHROOM_BLOCK = gen("Red Mushroom Block", "red_mushroom_block", builder -> builder
            .setNetworkId(247)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_MUSHROOM_BLOCK)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(BooleanBlockStatePropertyTypes.DOWN)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST));
    public static final BuilderRegister<BlockType> RED_NETHER_BRICKS = gen("Red Nether Bricks", "red_nether_bricks", builder -> builder
            .setNetworkId(519)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_NETHER_BRICKS));
    public static final BuilderRegister<BlockType> RED_NETHER_BRICK_SLAB = gen("Red Nether Brick Slab", "red_nether_brick_slab", builder -> builder
            .setNetworkId(665)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_NETHER_BRICK_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> RED_NETHER_BRICK_STAIRS = gen("Red Nether Brick Stairs", "red_nether_brick_stairs", builder -> builder
            .setNetworkId(652)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_NETHER_BRICK_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> RED_NETHER_BRICK_WALL = gen("Red Nether Brick Wall", "red_nether_brick_wall", builder -> builder
            .setNetworkId(676)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_NETHER_BRICK_WALL)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> RED_SAND = gen("Red Sand", "red_sand", builder -> builder
            .setNetworkId(29)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_SAND));
    public static final BuilderRegister<BlockType> RED_SANDSTONE = gen("Red Sandstone", "red_sandstone", builder -> builder
            .setNetworkId(462)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_SANDSTONE));
    public static final BuilderRegister<BlockType> RED_SANDSTONE_SLAB = gen("Red Sandstone Slab", "red_sandstone_slab", builder -> builder
            .setNetworkId(482)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_SANDSTONE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> RED_SANDSTONE_STAIRS = gen("Red Sandstone Stairs", "red_sandstone_stairs", builder -> builder
            .setNetworkId(465)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_SANDSTONE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> RED_SANDSTONE_WALL = gen("Red Sandstone Wall", "red_sandstone_wall", builder -> builder
            .setNetworkId(670)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_SANDSTONE_WALL)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> RED_SHULKER_BOX = gen("Red Shulker Box", "red_shulker_box", builder -> builder
            .setNetworkId(538)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_SHULKER_BOX)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> RED_STAINED_GLASS = gen("Red Stained Glass", "red_stained_glass", builder -> builder
            .setNetworkId(228)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_STAINED_GLASS));
    public static final BuilderRegister<BlockType> RED_STAINED_GLASS_PANE = gen("Red Stained Glass Pane", "red_stained_glass_pane", builder -> builder
            .setNetworkId(386)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_STAINED_GLASS_PANE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> RED_TERRACOTTA = gen("Red Terracotta", "red_terracotta", builder -> builder
            .setNetworkId(370)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_TERRACOTTA));
    public static final BuilderRegister<BlockType> RED_TULIP = gen("Red Tulip", "red_tulip", builder -> builder
            .setNetworkId(130)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_TULIP));
    public static final BuilderRegister<BlockType> RED_WALL_BANNER = gen("null", "red_wall_banner", builder -> builder
            .setNetworkId(460)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> RED_WOOL = gen("Red Wool", "red_wool", builder -> builder
            .setNetworkId(122)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RED_WOOL));
    public static final BuilderRegister<BlockType> REPEATER = gen("Redstone Repeater", "repeater", builder -> builder
            .setNetworkId(213)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.REPEATER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(IntegerBlockStatePropertyTypes.DELAY)
            .addStateProperty(BooleanBlockStatePropertyTypes.LOCKED)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> REPEATING_COMMAND_BLOCK = gen("Repeating Command Block", "repeating_command_block", builder -> builder
            .setNetworkId(514)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.REPEATING_COMMAND_BLOCK)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.REPEAT_CONDITIONAL));
    public static final BuilderRegister<BlockType> RESPAWN_ANCHOR = gen("Respawn Anchor", "respawn_anchor", builder -> builder
            .setNetworkId(751)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.RESPAWN_ANCHOR)
            .addStateProperty(IntegerBlockStatePropertyTypes.RESPAWN_ANCHOR_CHARGE));
    public static final BuilderRegister<BlockType> ROOTED_DIRT = gen("Rooted Dirt", "rooted_dirt", builder -> builder
            .setNetworkId(870)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ROOTED_DIRT));
    public static final BuilderRegister<BlockType> ROSE_BUSH = gen("Rose Bush", "rose_bush", builder -> builder
            .setNetworkId(426)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ROSE_BUSH)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF));
    public static final BuilderRegister<BlockType> SAND = gen("Sand", "sand", builder -> builder
            .setNetworkId(28)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SAND));
    public static final BuilderRegister<BlockType> SANDSTONE = gen("Sandstone", "sandstone", builder -> builder
            .setNetworkId(77)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SANDSTONE));
    public static final BuilderRegister<BlockType> SANDSTONE_SLAB = gen("Sandstone Slab", "sandstone_slab", builder -> builder
            .setNetworkId(474)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SANDSTONE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> SANDSTONE_STAIRS = gen("Sandstone Stairs", "sandstone_stairs", builder -> builder
            .setNetworkId(280)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SANDSTONE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> SANDSTONE_WALL = gen("Sandstone Wall", "sandstone_wall", builder -> builder
            .setNetworkId(677)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SANDSTONE_WALL)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> SCAFFOLDING = gen("Scaffolding", "scaffolding", builder -> builder
            .setNetworkId(680)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SCAFFOLDING)
            .addStateProperty(IntegerBlockStatePropertyTypes.DISTANCE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED)
            .addStateProperty(BooleanBlockStatePropertyTypes.BOTTOM));
    public static final BuilderRegister<BlockType> SCULK_SENSOR = gen("Sculk Sensor", "sculk_sensor", builder -> builder
            .setNetworkId(821)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SCULK_SENSOR)
            .addStateProperty(EnumBlockStatePropertyTypes.SCULK_SENSOR_PHASE)
            .addStateProperty(IntegerBlockStatePropertyTypes.REDSTONE_POWER_LEVEL)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> SEAGRASS = gen("Seagrass", "seagrass", builder -> builder
            .setNetworkId(104)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SEAGRASS));
    public static final BuilderRegister<BlockType> SEA_LANTERN = gen("Sea Lantern", "sea_lantern", builder -> builder
            .setNetworkId(403)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SEA_LANTERN));
    public static final BuilderRegister<BlockType> SEA_PICKLE = gen("Sea Pickle", "sea_pickle", builder -> builder
            .setNetworkId(632)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SEA_PICKLE)
            .addStateProperty(IntegerBlockStatePropertyTypes.PICKLES)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> SHROOMLIGHT = gen("Shroomlight", "shroomlight", builder -> builder
            .setNetworkId(712)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SHROOMLIGHT));
    public static final BuilderRegister<BlockType> SHULKER_BOX = gen("Shulker Box", "shulker_box", builder -> builder
            .setNetworkId(523)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SHULKER_BOX)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> SKELETON_SKULL = gen("Skeleton Skull", "skeleton_skull", builder -> builder
            .setNetworkId(327)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SKELETON_SKULL)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> SKELETON_WALL_SKULL = gen("Skeleton Wall Skull", "skeleton_wall_skull", builder -> builder
            .setNetworkId(328)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SKELETON_SKULL)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> SLIME_BLOCK = gen("Slime Block", "slime_block", builder -> builder
            .setNetworkId(390)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SLIME_BLOCK));
    public static final BuilderRegister<BlockType> SMALL_AMETHYST_BUD = gen("Small Amethyst Bud", "small_amethyst_bud", builder -> builder
            .setNetworkId(816)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SMALL_AMETHYST_BUD)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> SMALL_DRIPLEAF = gen("Small Dripleaf", "small_dripleaf", builder -> builder
            .setNetworkId(868)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SMALL_DRIPLEAF)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> SMITHING_TABLE = gen("Smithing Table", "smithing_table", builder -> builder
            .setNetworkId(689)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SMITHING_TABLE));
    public static final BuilderRegister<BlockType> SMOKER = gen("Smoker", "smoker", builder -> builder
            .setNetworkId(683)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SMOKER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> SMOOTH_BASALT = gen("Smooth Basalt", "smooth_basalt", builder -> builder
            .setNetworkId(892)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SMOOTH_BASALT));
    public static final BuilderRegister<BlockType> SMOOTH_QUARTZ = gen("Smooth Quartz Block", "smooth_quartz", builder -> builder
            .setNetworkId(487)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SMOOTH_QUARTZ));
    public static final BuilderRegister<BlockType> SMOOTH_QUARTZ_SLAB = gen("Smooth Quartz Slab", "smooth_quartz_slab", builder -> builder
            .setNetworkId(662)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SMOOTH_QUARTZ_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> SMOOTH_QUARTZ_STAIRS = gen("Smooth Quartz Stairs", "smooth_quartz_stairs", builder -> builder
            .setNetworkId(649)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SMOOTH_QUARTZ_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> SMOOTH_RED_SANDSTONE = gen("Smooth Red Sandstone", "smooth_red_sandstone", builder -> builder
            .setNetworkId(488)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SMOOTH_RED_SANDSTONE));
    public static final BuilderRegister<BlockType> SMOOTH_RED_SANDSTONE_SLAB = gen("Smooth Red Sandstone Slab", "smooth_red_sandstone_slab", builder -> builder
            .setNetworkId(656)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SMOOTH_RED_SANDSTONE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> SMOOTH_RED_SANDSTONE_STAIRS = gen("Smooth Red Sandstone Stairs", "smooth_red_sandstone_stairs", builder -> builder
            .setNetworkId(642)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SMOOTH_RED_SANDSTONE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> SMOOTH_SANDSTONE = gen("Smooth Sandstone", "smooth_sandstone", builder -> builder
            .setNetworkId(486)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SMOOTH_SANDSTONE));
    public static final BuilderRegister<BlockType> SMOOTH_SANDSTONE_SLAB = gen("Smooth Sandstone Slab", "smooth_sandstone_slab", builder -> builder
            .setNetworkId(661)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SMOOTH_SANDSTONE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> SMOOTH_SANDSTONE_STAIRS = gen("Smooth Sandstone Stairs", "smooth_sandstone_stairs", builder -> builder
            .setNetworkId(648)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SMOOTH_SANDSTONE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> SMOOTH_STONE = gen("Smooth Stone", "smooth_stone", builder -> builder
            .setNetworkId(485)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SMOOTH_STONE));
    public static final BuilderRegister<BlockType> SMOOTH_STONE_SLAB = gen("Smooth Stone Slab", "smooth_stone_slab", builder -> builder
            .setNetworkId(473)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SMOOTH_STONE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> SNOW = gen("Snow", "snow", builder -> builder
            .setNetworkId(192)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SNOW)
            .addStateProperty(IntegerBlockStatePropertyTypes.SNOW_LAYER));
    public static final BuilderRegister<BlockType> SNOW_BLOCK = gen("Snow Block", "snow_block", builder -> builder
            .setNetworkId(194)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SNOW_BLOCK));
    public static final BuilderRegister<BlockType> SOUL_CAMPFIRE = gen("Soul Campfire", "soul_campfire", builder -> builder
            .setNetworkId(695)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SOUL_CAMPFIRE)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT)
            .addStateProperty(BooleanBlockStatePropertyTypes.SIGNAL_FIRE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> SOUL_FIRE = gen("Soul Fire", "soul_fire", builder -> builder
            .setNetworkId(150)
            .setMass(MassType.SOLID)
    );
    public static final BuilderRegister<BlockType> SOUL_LANTERN = gen("Soul Lantern", "soul_lantern",
            builder -> builder
                    .setNetworkId(693)
                    .setMass(MassType.SOLID)
                    .setItem(ItemTypes.SOUL_LANTERN)
                    .addStateProperty(BooleanBlockStatePropertyTypes.HANGING)
                    .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> SOUL_SAND = gen("Soul Sand", "soul_sand", builder -> builder
            .setNetworkId(202)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SOUL_SAND));
    public static final BuilderRegister<BlockType> SOUL_SOIL = gen("Soul Soil", "soul_soil", builder -> builder
            .setNetworkId(203)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SOUL_SOIL));
    public static final BuilderRegister<BlockType> SOUL_TORCH = gen("Soul Torch", "soul_torch", builder -> builder
            .setNetworkId(206)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SOUL_TORCH));
    public static final BuilderRegister<BlockType> SOUL_WALL_TORCH = gen("Soul Wall Torch", "soul_wall_torch", builder -> builder
            .setNetworkId(207)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SOUL_TORCH)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> SPAWNER = gen("Spawner", "spawner", builder -> builder
            .setNetworkId(151)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SPAWNER));
    public static final BuilderRegister<BlockType> SPONGE = gen("Sponge", "sponge", builder -> builder
            .setNetworkId(70)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SPONGE));
    public static final BuilderRegister<BlockType> SPORE_BLOSSOM = gen("Spore Blossom", "spore_blossom", builder -> builder
            .setNetworkId(861)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SPORE_BLOSSOM));
    public static final BuilderRegister<BlockType> SPRUCE_BUTTON = gen("Spruce Button", "spruce_button", builder -> builder
            .setNetworkId(322)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SPRUCE_BUTTON)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(EnumBlockStatePropertyTypes.ATTACHABLE_FACE_STANDARD));
    public static final BuilderRegister<BlockType> SPRUCE_DOOR = gen("Spruce Door", "spruce_door", builder -> builder
            .setNetworkId(499)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SPRUCE_DOOR)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(EnumBlockStatePropertyTypes.HINGE)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> SPRUCE_FENCE = gen("Spruce Fence", "spruce_fence", builder -> builder
            .setNetworkId(494)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SPRUCE_FENCE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> SPRUCE_FENCE_GATE = gen("Spruce Fence Gate", "spruce_fence_gate", builder -> builder
            .setNetworkId(489)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SPRUCE_FENCE_GATE)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.IN_WALL));
    public static final BuilderRegister<BlockType> SPRUCE_LEAVES = gen("Spruce Leaves", "spruce_leaves", builder -> builder
            .setNetworkId(63)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SPRUCE_LEAVES)
            .addStateProperty(IntegerBlockStatePropertyTypes.DISTANCE)
            .addStateProperty(BooleanBlockStatePropertyTypes.PERSISTENT));
    public static final BuilderRegister<BlockType> SPRUCE_LOG = gen("Spruce Log", "spruce_log", builder -> builder
            .setNetworkId(39)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SPRUCE_LOG)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> SPRUCE_PLANKS = gen("Spruce Planks", "spruce_planks", builder -> builder
            .setNetworkId(14)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SPRUCE_PLANKS));
    public static final BuilderRegister<BlockType> SPRUCE_PRESSURE_PLATE = gen("Spruce Pressure Plate", "spruce_pressure_plate", builder -> builder
            .setNetworkId(182)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SPRUCE_PRESSURE_PLATE)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> SPRUCE_SAPLING = gen("Spruce Sapling", "spruce_sapling", builder -> builder
            .setNetworkId(20)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SPRUCE_SAPLING)
            .addStateProperty(IntegerBlockStatePropertyTypes.GROWTH_STAGE));
    public static final BuilderRegister<BlockType> SPRUCE_SIGN = gen("Spruce Sign", "spruce_sign", builder -> builder
            .setNetworkId(163)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SPRUCE_SIGN)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> SPRUCE_SLAB = gen("Spruce Slab", "spruce_slab", builder -> builder
            .setNetworkId(467)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SPRUCE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> SPRUCE_STAIRS = gen("Spruce Stairs", "spruce_stairs", builder -> builder
            .setNetworkId(287)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SPRUCE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> SPRUCE_TRAPDOOR = gen("Spruce Trapdoor", "spruce_trapdoor", builder -> builder
            .setNetworkId(231)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SPRUCE_TRAPDOOR)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> SPRUCE_WALL_SIGN = gen("Spruce Wall Sign", "spruce_wall_sign", builder -> builder
            .setNetworkId(173)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SPRUCE_SIGN)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> SPRUCE_WOOD = gen("Spruce Wood", "spruce_wood", builder -> builder
            .setNetworkId(51)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SPRUCE_WOOD)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> STICKY_PISTON = gen("Sticky Piston", "sticky_piston", builder -> builder
            .setNetworkId(99)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STICKY_PISTON)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.EXTENDED));
    public static final BuilderRegister<BlockType> STONE = gen("Stone", "stone", builder -> builder
            .setNetworkId(1)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STONE));
    public static final BuilderRegister<BlockType> STONECUTTER = gen("Stonecutter", "stonecutter", builder -> builder
            .setNetworkId(690)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STONECUTTER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> STONE_BRICKS = gen("Stone Bricks", "stone_bricks", builder -> builder
            .setNetworkId(236)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STONE_BRICKS));
    public static final BuilderRegister<BlockType> STONE_BRICK_SLAB = gen("Stone Brick Slab", "stone_brick_slab", builder -> builder
            .setNetworkId(479)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STONE_BRICK_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> STONE_BRICK_STAIRS = gen("Stone Brick Stairs", "stone_brick_stairs", builder -> builder
            .setNetworkId(261)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STONE_BRICK_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> STONE_BRICK_WALL = gen("Stone Brick Wall", "stone_brick_wall", builder -> builder
            .setNetworkId(673)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STONE_BRICK_WALL)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(EnumBlockStatePropertyTypes.NORTH)
            .addStateProperty(EnumBlockStatePropertyTypes.EAST)
            .addStateProperty(EnumBlockStatePropertyTypes.WEST)
            .addStateProperty(EnumBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> STONE_BUTTON = gen("Stone Button", "stone_button", builder -> builder
            .setNetworkId(191)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STONE_BUTTON)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(EnumBlockStatePropertyTypes.ATTACHABLE_FACE_STANDARD));
    public static final BuilderRegister<BlockType> STONE_PRESSURE_PLATE = gen("Stone Pressure Plate", "stone_pressure_plate", builder -> builder
            .setNetworkId(179)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STONE_PRESSURE_PLATE)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> STONE_SLAB = gen("Stone Slab", "stone_slab", builder -> builder
            .setNetworkId(472)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STONE_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> STONE_STAIRS = gen("Stone Stairs", "stone_stairs", builder -> builder
            .setNetworkId(647)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STONE_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> STRIPPED_ACACIA_LOG = gen("Stripped Acacia Log", "stripped_acacia_log", builder -> builder
            .setNetworkId(47)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STRIPPED_ACACIA_LOG)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> STRIPPED_ACACIA_WOOD = gen("Stripped Acacia Wood", "stripped_acacia_wood", builder -> builder
            .setNetworkId(60)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STRIPPED_ACACIA_WOOD)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> STRIPPED_BIRCH_LOG = gen("Stripped Birch Log", "stripped_birch_log", builder -> builder
            .setNetworkId(45)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STRIPPED_BIRCH_LOG)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> STRIPPED_BIRCH_WOOD = gen("Stripped Birch Wood", "stripped_birch_wood", builder -> builder
            .setNetworkId(58)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STRIPPED_BIRCH_WOOD)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> STRIPPED_CRIMSON_HYPHAE = gen("Stripped Crimson Hyphae", "stripped_crimson_hyphae", builder -> builder
            .setNetworkId(709)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STRIPPED_CRIMSON_HYPHAE)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> STRIPPED_CRIMSON_STEM = gen("Stripped Crimson Stem", "stripped_crimson_stem", builder -> builder
            .setNetworkId(707)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STRIPPED_CRIMSON_STEM)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> STRIPPED_DARK_OAK_LOG = gen("Stripped Dark Oak Log", "stripped_dark_oak_log", builder -> builder
            .setNetworkId(48)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STRIPPED_DARK_OAK_LOG)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> STRIPPED_DARK_OAK_WOOD = gen("Stripped Dark Oak Wood", "stripped_dark_oak_wood", builder -> builder
            .setNetworkId(61)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STRIPPED_DARK_OAK_WOOD)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> STRIPPED_JUNGLE_LOG = gen("Stripped Jungle Log", "stripped_jungle_log", builder -> builder
            .setNetworkId(46)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STRIPPED_JUNGLE_LOG)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> STRIPPED_JUNGLE_WOOD = gen("Stripped Jungle Wood", "stripped_jungle_wood", builder -> builder
            .setNetworkId(59)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STRIPPED_JUNGLE_WOOD)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> STRIPPED_OAK_LOG = gen("Stripped Oak Log", "stripped_oak_log", builder -> builder
            .setNetworkId(49)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STRIPPED_OAK_LOG)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> STRIPPED_OAK_WOOD = gen("Stripped Oak Wood", "stripped_oak_wood", builder -> builder
            .setNetworkId(56)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STRIPPED_OAK_WOOD)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> STRIPPED_SPRUCE_LOG = gen("Stripped Spruce Log", "stripped_spruce_log", builder -> builder
            .setNetworkId(44)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STRIPPED_SPRUCE_LOG)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> STRIPPED_SPRUCE_WOOD = gen("Stripped Spruce Wood", "stripped_spruce_wood", builder -> builder
            .setNetworkId(57)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STRIPPED_SPRUCE_WOOD)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> STRIPPED_WARPED_HYPHAE = gen("Stripped Warped Hyphae", "stripped_warped_hyphae", builder -> builder
            .setNetworkId(700)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STRIPPED_WARPED_HYPHAE)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> STRIPPED_WARPED_STEM = gen("Stripped Warped Stem", "stripped_warped_stem", builder -> builder
            .setNetworkId(698)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STRIPPED_WARPED_STEM)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> STRUCTURE_BLOCK = gen("Structure Block", "structure_block", builder -> builder
            .setNetworkId(740)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STRUCTURE_BLOCK)
            .addStateProperty(EnumBlockStatePropertyTypes.STRUCTURE_MODE));
    public static final BuilderRegister<BlockType> STRUCTURE_VOID = gen("Structure Void", "structure_void", builder -> builder
            .setNetworkId(521)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STRUCTURE_VOID));
    public static final BuilderRegister<BlockType> SUGAR_CANE = gen("Sugar Cane", "sugar_cane", builder -> builder
            .setNetworkId(197)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SUGAR_CANE)
            .addStateProperty(IntegerBlockStatePropertyTypes.AGE_16));
    public static final BuilderRegister<BlockType> SUNFLOWER = gen("Sunflower", "sunflower", builder -> builder
            .setNetworkId(424)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SUNFLOWER)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF));
    public static final BuilderRegister<BlockType> SWEET_BERRY_BUSH = gen("Sweet Berry Bush", "sweet_berry_bush", builder -> builder
            .setNetworkId(696)
            .setMass(MassType.SOLID)
            .addStateProperty(IntegerBlockStatePropertyTypes.AGE_4));
    public static final BuilderRegister<BlockType> TALL_GRASS = gen("Tall Grass", "tall_grass", builder -> builder
            .setNetworkId(428)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.TALL_GRASS)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF));
    public static final BuilderRegister<BlockType> TALL_SEAGRASS = gen("Tall Seagrass", "tall_seagrass", builder -> builder
            .setNetworkId(105)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.SEAGRASS)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF));
    public static final BuilderRegister<BlockType> TARGET = gen("Target", "target", builder -> builder
            .setNetworkId(743)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.TARGET)
            .addStateProperty(IntegerBlockStatePropertyTypes.REDSTONE_POWER_LEVEL));
    public static final BuilderRegister<BlockType> TERRACOTTA = gen("Terracotta", "terracotta", builder -> builder
            .setNetworkId(421)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.TERRACOTTA));
    public static final BuilderRegister<BlockType> TINTED_GLASS = gen("Tinted Glass", "tinted_glass", builder -> builder
            .setNetworkId(819)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.TINTED_GLASS));
    public static final BuilderRegister<BlockType> TNT = gen("TNT", "tnt", builder -> builder
            .setNetworkId(143)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.TNT)
            .addStateProperty(BooleanBlockStatePropertyTypes.UNSTABLE));
    public static final BuilderRegister<BlockType> TORCH = gen("Torch", "torch", builder -> builder
            .setNetworkId(147)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.TORCH));
    public static final BuilderRegister<BlockType> TRAPPED_CHEST = gen("Trapped Chest", "trapped_chest", builder -> builder
            .setNetworkId(342)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.TRAPPED_CHEST)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.CHEST_HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> TRIPWIRE = gen("Tripwire", "tripwire", builder -> builder
            .setNetworkId(285)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.STRING)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.ATTACHED)
            .addStateProperty(BooleanBlockStatePropertyTypes.DISARMED)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH));
    public static final BuilderRegister<BlockType> TRIPWIRE_HOOK = gen("Tripwire Hook", "tripwire_hook", builder -> builder
            .setNetworkId(284)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.TRIPWIRE_HOOK)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.ATTACHED));
    public static final BuilderRegister<BlockType> TUBE_CORAL = gen("Tube Coral", "tube_coral", builder -> builder
            .setNetworkId(607)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.TUBE_CORAL)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> TUBE_CORAL_BLOCK = gen("Tube Coral Block", "tube_coral_block", builder -> builder
            .setNetworkId(597)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.TUBE_CORAL_BLOCK));
    public static final BuilderRegister<BlockType> TUBE_CORAL_FAN = gen("Tube Coral Fan", "tube_coral_fan", builder -> builder
            .setNetworkId(617)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.TUBE_CORAL_FAN)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> TUBE_CORAL_WALL_FAN = gen("Tube Coral Wall Fan", "tube_coral_wall_fan", builder -> builder
            .setNetworkId(627)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.TUBE_CORAL_FAN)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> TUFF = gen("Tuff", "tuff", builder -> builder
            .setNetworkId(817)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.TUFF));
    public static final BuilderRegister<BlockType> TURTLE_EGG = gen("Turtle Egg", "turtle_egg", builder -> builder
            .setNetworkId(591)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.TURTLE_EGG)
            .addStateProperty(IntegerBlockStatePropertyTypes.TURTLE_HATCHED)
            .addStateProperty(IntegerBlockStatePropertyTypes.TURTLE_EGGS));
    public static final BuilderRegister<BlockType> TWISTING_VINES = gen("Twisting Vines", "twisting_vines", builder -> builder
            .setNetworkId(715)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.TWISTING_VINES)
            .addStateProperty(IntegerBlockStatePropertyTypes.AGE_26));
    public static final BuilderRegister<BlockType> TWISTING_VINES_PLANT = gen("Twisting Vines Plant", "twisting_vines_plant", builder -> builder
            .setNetworkId(716)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.TWISTING_VINES));
    public static final BuilderRegister<BlockType> VINE = gen("Vines", "vine", builder -> builder
            .setNetworkId(257)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.VINE)
            .addStateProperty(BooleanBlockStatePropertyTypes.UP)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST));
    public static final BuilderRegister<BlockType> VOID_AIR = gen("Void Air", "void_air", builder -> builder
            .setNetworkId(638)
            .setMass(MassType.SOLID));
    public static final BuilderRegister<BlockType> WALL_TORCH = gen("Wall Torch", "wall_torch", builder -> builder
            .setNetworkId(148)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.TORCH)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> WARPED_BUTTON = gen("Warped Button", "warped_button", builder -> builder
            .setNetworkId(733)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WARPED_BUTTON)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(EnumBlockStatePropertyTypes.ATTACHABLE_FACE_STANDARD));
    public static final BuilderRegister<BlockType> WARPED_DOOR = gen("Warped Door", "warped_door", builder -> builder
            .setNetworkId(735)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WARPED_DOOR)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(EnumBlockStatePropertyTypes.HINGE)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> WARPED_FENCE = gen("Warped Fence", "warped_fence", builder -> builder
            .setNetworkId(725)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WARPED_FENCE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> WARPED_FENCE_GATE = gen("Warped Fence Gate", "warped_fence_gate", builder -> builder
            .setNetworkId(729)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WARPED_FENCE_GATE)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.IN_WALL));
    public static final BuilderRegister<BlockType> WARPED_FUNGUS = gen("Warped Fungus", "warped_fungus", builder -> builder
            .setNetworkId(702)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WARPED_FUNGUS));
    public static final BuilderRegister<BlockType> WARPED_HYPHAE = gen("Warped Hyphae", "warped_hyphae", builder -> builder
            .setNetworkId(699)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WARPED_HYPHAE)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> WARPED_NYLIUM = gen("Warped Nylium", "warped_nylium", builder -> builder
            .setNetworkId(701)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WARPED_NYLIUM));
    public static final BuilderRegister<BlockType> WARPED_PLANKS = gen("Warped Planks", "warped_planks", builder -> builder
            .setNetworkId(719)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WARPED_PLANKS));
    public static final BuilderRegister<BlockType> WARPED_PRESSURE_PLATE = gen("Warped Pressure Plate", "warped_pressure_plate", builder -> builder
            .setNetworkId(723)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WARPED_PRESSURE_PLATE)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED));
    public static final BuilderRegister<BlockType> WARPED_ROOTS = gen("Warped Roots", "warped_roots", builder -> builder
            .setNetworkId(704)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WARPED_ROOTS));
    public static final BuilderRegister<BlockType> WARPED_SIGN = gen("Warped Sign", "warped_sign", builder -> builder
            .setNetworkId(737)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WARPED_SIGN)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> WARPED_SLAB = gen("Warped Slab", "warped_slab", builder -> builder
            .setNetworkId(721)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WARPED_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> WARPED_STAIRS = gen("Warped Stairs", "warped_stairs", builder -> builder
            .setNetworkId(731)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WARPED_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> WARPED_STEM = gen("Warped Stem", "warped_stem", builder -> builder
            .setNetworkId(697)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WARPED_STEM)
            .addStateProperty(EnumBlockStatePropertyTypes.AXIS));
    public static final BuilderRegister<BlockType> WARPED_TRAPDOOR = gen("Warped Trapdoor", "warped_trapdoor", builder -> builder
            .setNetworkId(727)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WARPED_TRAPDOOR)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.OPEN)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.POWERED)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> WARPED_WALL_SIGN = gen("Warped Wall Sign", "warped_wall_sign", builder -> builder
            .setNetworkId(739)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WARPED_SIGN)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> WARPED_WART_BLOCK = gen("Warped Wart Block", "warped_wart_block", builder -> builder
            .setNetworkId(703)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WARPED_WART_BLOCK));
    public static final BuilderRegister<BlockType> WATER = gen("Water", "water", builder -> builder
            .setNetworkId(26)
            .setMass(MassType.LIQUID)
            .addStateProperty(IntegerBlockStatePropertyTypes.LIQUID_LEVEL));
    public static final BuilderRegister<BlockType> WATER_CAULDRON = gen("Water Cauldron", "water_cauldron", builder -> builder
            .setNetworkId(271)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAULDRON)
            .addStateProperty(IntegerBlockStatePropertyTypes.CAULDRON_LEVEL));
    public static final BuilderRegister<BlockType> WAXED_COPPER_BLOCK = gen("Waxed Block of Copper", "waxed_copper_block", builder -> builder
            .setNetworkId(840)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WAXED_COPPER_BLOCK));
    public static final BuilderRegister<BlockType> WAXED_CUT_COPPER = gen("Waxed Cut Copper", "waxed_cut_copper", builder -> builder
            .setNetworkId(847)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WAXED_CUT_COPPER));
    public static final BuilderRegister<BlockType> WAXED_CUT_COPPER_SLAB = gen("Waxed Cut Copper Slab", "waxed_cut_copper_slab", builder -> builder
            .setNetworkId(855)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WAXED_CUT_COPPER_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> WAXED_CUT_COPPER_STAIRS = gen("Waxed Cut Copper Stairs", "waxed_cut_copper_stairs", builder -> builder
            .setNetworkId(851)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WAXED_CUT_COPPER_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> WAXED_EXPOSED_COPPER = gen("Waxed Exposed Copper", "waxed_exposed_copper", builder -> builder
            .setNetworkId(842)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WAXED_EXPOSED_COPPER));
    public static final BuilderRegister<BlockType> WAXED_EXPOSED_CUT_COPPER = gen("Waxed Exposed Cut Copper", "waxed_exposed_cut_copper", builder -> builder
            .setNetworkId(846)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WAXED_EXPOSED_CUT_COPPER));
    public static final BuilderRegister<BlockType> WAXED_EXPOSED_CUT_COPPER_SLAB = gen("Waxed Exposed Cut Copper Slab", "waxed_exposed_cut_copper_slab", builder -> builder
            .setNetworkId(854)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WAXED_EXPOSED_CUT_COPPER_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> WAXED_EXPOSED_CUT_COPPER_STAIRS = gen("Waxed Exposed Cut Copper Stairs", "waxed_exposed_cut_copper_stairs", builder -> builder
            .setNetworkId(850)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WAXED_EXPOSED_CUT_COPPER_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> WAXED_OXIDIZED_COPPER = gen("Waxed Oxidized Copper", "waxed_oxidized_copper", builder -> builder
            .setNetworkId(843)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WAXED_OXIDIZED_COPPER));
    public static final BuilderRegister<BlockType> WAXED_OXIDIZED_CUT_COPPER = gen("Waxed Oxidized Cut Copper", "waxed_oxidized_cut_copper", builder -> builder
            .setNetworkId(844)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WAXED_OXIDIZED_CUT_COPPER));
    public static final BuilderRegister<BlockType> WAXED_OXIDIZED_CUT_COPPER_SLAB = gen("Waxed Oxidized Cut Copper Slab", "waxed_oxidized_cut_copper_slab", builder -> builder
            .setNetworkId(852)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WAXED_OXIDIZED_CUT_COPPER_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> WAXED_OXIDIZED_CUT_COPPER_STAIRS = gen("Waxed Oxidized Cut Copper Stairs", "waxed_oxidized_cut_copper_stairs", builder -> builder
            .setNetworkId(848)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WAXED_OXIDIZED_CUT_COPPER_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> WAXED_WEATHERED_COPPER = gen("Waxed Weathered Copper", "waxed_weathered_copper", builder -> builder
            .setNetworkId(841)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WAXED_WEATHERED_COPPER));
    public static final BuilderRegister<BlockType> WAXED_WEATHERED_CUT_COPPER = gen("Waxed Weathered Cut Copper", "waxed_weathered_cut_copper", builder -> builder
            .setNetworkId(845)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WAXED_WEATHERED_CUT_COPPER));
    public static final BuilderRegister<BlockType> WAXED_WEATHERED_CUT_COPPER_SLAB = gen("Waxed Weathered Cut Copper Slab", "waxed_weathered_cut_copper_slab", builder -> builder
            .setNetworkId(853)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WAXED_WEATHERED_CUT_COPPER_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> WAXED_WEATHERED_CUT_COPPER_STAIRS = gen("Waxed Weathered Cut Copper Stairs", "waxed_weathered_cut_copper_stairs", builder -> builder
            .setNetworkId(849)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WAXED_WEATHERED_CUT_COPPER_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> WEATHERED_COPPER = gen("Weathered Copper", "weathered_copper", builder -> builder
            .setNetworkId(823)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WEATHERED_COPPER));
    public static final BuilderRegister<BlockType> WEATHERED_CUT_COPPER = gen("Weathered Cut Copper", "weathered_cut_copper", builder -> builder
            .setNetworkId(829)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WEATHERED_CUT_COPPER));
    public static final BuilderRegister<BlockType> WEATHERED_CUT_COPPER_SLAB = gen("Weathered Cut Copper Slab", "weathered_cut_copper_slab", builder -> builder
            .setNetworkId(837)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WEATHERED_CUT_COPPER_SLAB)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF_BLOCK_TYPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> WEATHERED_CUT_COPPER_STAIRS = gen("Weathered Cut Copper Stairs", "weathered_cut_copper_stairs", builder -> builder
            .setNetworkId(833)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WEATHERED_CUT_COPPER_STAIRS)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.HALF)
            .addStateProperty(EnumBlockStatePropertyTypes.STAIR_SHAPE)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> WEEPING_VINES = gen("Weeping Vines", "weeping_vines", builder -> builder
            .setNetworkId(713)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WEEPING_VINES)
            .addStateProperty(IntegerBlockStatePropertyTypes.AGE_26));
    public static final BuilderRegister<BlockType> WEEPING_VINES_PLANT = gen("Weeping Vines Plant", "weeping_vines_plant", builder -> builder
            .setNetworkId(714)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WEEPING_VINES));
    public static final BuilderRegister<BlockType> WET_SPONGE = gen("Wet Sponge", "wet_sponge", builder -> builder
            .setNetworkId(71)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WET_SPONGE));
    public static final BuilderRegister<BlockType> WHEAT = gen("Wheat Crops", "wheat", builder -> builder
            .setNetworkId(159)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WHEAT)
            .addStateProperty(IntegerBlockStatePropertyTypes.AGE_8));
    public static final BuilderRegister<BlockType> WHITE_BANNER = gen("White Banner", "white_banner", builder -> builder
            .setNetworkId(430)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WHITE_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> WHITE_BED = gen("White Bed", "white_bed", builder -> builder
            .setNetworkId(81)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WHITE_BED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.BED_HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.OCCUPIED));
    public static final BuilderRegister<BlockType> WHITE_CANDLE = gen("White Candle", "white_candle", builder -> builder
            .setNetworkId(778)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WHITE_CANDLE)
            .addStateProperty(IntegerBlockStatePropertyTypes.CANDLES)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> WHITE_CANDLE_CAKE = gen("Cake with White Candle", "white_candle_cake", builder -> builder
            .setNetworkId(795)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAKE)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> WHITE_CARPET = gen("White Carpet", "white_carpet", builder -> builder
            .setNetworkId(405)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WHITE_CARPET));
    public static final BuilderRegister<BlockType> WHITE_CONCRETE = gen("White Concrete", "white_concrete", builder -> builder
            .setNetworkId(556)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WHITE_CONCRETE));
    public static final BuilderRegister<BlockType> WHITE_CONCRETE_POWDER = gen("White Concrete Powder", "white_concrete_powder", builder -> builder
            .setNetworkId(572)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WHITE_CONCRETE_POWDER));
    public static final BuilderRegister<BlockType> WHITE_GLAZED_TERRACOTTA = gen("White Glazed Terracotta", "white_glazed_terracotta", builder -> builder
            .setNetworkId(540)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WHITE_GLAZED_TERRACOTTA)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> WHITE_SHULKER_BOX = gen("White Shulker Box", "white_shulker_box", builder -> builder
            .setNetworkId(524)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WHITE_SHULKER_BOX)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> WHITE_STAINED_GLASS = gen("White Stained Glass", "white_stained_glass", builder -> builder
            .setNetworkId(214)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WHITE_STAINED_GLASS));
    public static final BuilderRegister<BlockType> WHITE_STAINED_GLASS_PANE = gen("White Stained Glass Pane", "white_stained_glass_pane", builder -> builder
            .setNetworkId(372)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WHITE_STAINED_GLASS_PANE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> WHITE_TERRACOTTA = gen("White Terracotta", "white_terracotta", builder -> builder
            .setNetworkId(356)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WHITE_TERRACOTTA));
    public static final BuilderRegister<BlockType> WHITE_TULIP = gen("White Tulip", "white_tulip", builder -> builder
            .setNetworkId(132)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WHITE_TULIP));
    public static final BuilderRegister<BlockType> WHITE_WALL_BANNER = gen("null", "white_wall_banner", builder -> builder
            .setNetworkId(446)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WHITE_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> WHITE_WOOL = gen("White Wool", "white_wool", builder -> builder
            .setNetworkId(108)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WHITE_WOOL));
    public static final BuilderRegister<BlockType> WITHER_ROSE = gen("Wither Rose", "wither_rose", builder -> builder
            .setNetworkId(136)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WITHER_ROSE));
    public static final BuilderRegister<BlockType> WITHER_SKELETON_SKULL = gen("Wither Skeleton Skull", "wither_skeleton_skull", builder -> builder
            .setNetworkId(329)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WITHER_SKELETON_SKULL)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> WITHER_SKELETON_WALL_SKULL = gen("Wither Skeleton Wall Skull", "wither_skeleton_wall_skull", builder -> builder
            .setNetworkId(330)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.WITHER_SKELETON_SKULL)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> YELLOW_BANNER = gen("Yellow Banner", "yellow_banner", builder -> builder
            .setNetworkId(434)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.YELLOW_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> YELLOW_BED = gen("Yellow Bed", "yellow_bed", builder -> builder
            .setNetworkId(85)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.YELLOW_BED)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING)
            .addStateProperty(EnumBlockStatePropertyTypes.BED_HALF)
            .addStateProperty(BooleanBlockStatePropertyTypes.OCCUPIED));
    public static final BuilderRegister<BlockType> YELLOW_CANDLE = gen("Yellow Candle", "yellow_candle", builder -> builder
            .setNetworkId(782)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.YELLOW_CANDLE)
            .addStateProperty(IntegerBlockStatePropertyTypes.CANDLES)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> YELLOW_CANDLE_CAKE = gen("Cake with Yellow Candle", "yellow_candle_cake", builder -> builder
            .setNetworkId(799)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.CAKE)
            .addStateProperty(BooleanBlockStatePropertyTypes.LIT));
    public static final BuilderRegister<BlockType> YELLOW_CARPET = gen("Yellow Carpet", "yellow_carpet", builder -> builder
            .setNetworkId(409)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.YELLOW_CARPET));
    public static final BuilderRegister<BlockType> YELLOW_CONCRETE = gen("Yellow Concrete", "yellow_concrete", builder -> builder
            .setNetworkId(560)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.YELLOW_CONCRETE));
    public static final BuilderRegister<BlockType> YELLOW_CONCRETE_POWDER = gen("Yellow Concrete Powder", "yellow_concrete_powder", builder -> builder
            .setNetworkId(576)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.YELLOW_CONCRETE_POWDER));
    public static final BuilderRegister<BlockType> YELLOW_GLAZED_TERRACOTTA = gen("Yellow Glazed Terracotta", "yellow_glazed_terracotta", builder -> builder
            .setNetworkId(544)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.YELLOW_GLAZED_TERRACOTTA)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> YELLOW_SHULKER_BOX = gen("Yellow Shulker Box", "yellow_shulker_box", builder -> builder
            .setNetworkId(528)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.YELLOW_SHULKER_BOX)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> YELLOW_STAINED_GLASS = gen("Yellow Stained Glass", "yellow_stained_glass", builder -> builder
            .setNetworkId(218)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.YELLOW_STAINED_GLASS));
    public static final BuilderRegister<BlockType> YELLOW_STAINED_GLASS_PANE = gen("Yellow Stained Glass Pane", "yellow_stained_glass_pane", builder -> builder
            .setNetworkId(376)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.YELLOW_STAINED_GLASS_PANE)
            .addStateProperty(BooleanBlockStatePropertyTypes.NORTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.EAST)
            .addStateProperty(BooleanBlockStatePropertyTypes.WEST)
            .addStateProperty(BooleanBlockStatePropertyTypes.SOUTH)
            .addStateProperty(BooleanBlockStatePropertyTypes.WATERLOGGED));
    public static final BuilderRegister<BlockType> YELLOW_TERRACOTTA = gen("Yellow Terracotta", "yellow_terracotta", builder -> builder
            .setNetworkId(360)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.YELLOW_TERRACOTTA));
    public static final BuilderRegister<BlockType> YELLOW_WALL_BANNER = gen("null", "yellow_wall_banner", builder -> builder
            .setNetworkId(450)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.YELLOW_BANNER)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));
    public static final BuilderRegister<BlockType> YELLOW_WOOL = gen("Yellow Wool", "yellow_wool", builder -> builder
            .setNetworkId(112)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.YELLOW_WOOL));
    public static final BuilderRegister<BlockType> ZOMBIE_HEAD = gen("Zombie Head", "zombie_head", builder -> builder
            .setNetworkId(331)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ZOMBIE_HEAD)
            .addStateProperty(EnumBlockStatePropertyTypes.ROTATION));
    public static final BuilderRegister<BlockType> ZOMBIE_WALL_HEAD = gen("Zombie Wall Head", "zombie_wall_head", builder -> builder
            .setNetworkId(332)
            .setMass(MassType.SOLID)
            .setItem(ItemTypes.ZOMBIE_HEAD)
            .addStateProperty(EnumBlockStatePropertyTypes.FACING));

    private static BuilderRegister<BlockType> gen(String name, String key, Function<BlockTypeBuilder,
            BlockTypeBuilder> function) {
        return new BuilderRegister<>(name, Identifiable.MINECRAFT_HOST, key, () -> function.apply(new BlockTypeBuilder()
                .setHost(Identifiable.MINECRAFT_HOST)
                .setKey(key)
                .setName(name)).build());
    }
}


    /*public static final BuilderRegister<BlockType> AIR = gen("Air", "air",
            builder -> builder
.setMass(MassType.GAS)
.setNetworkId(0)
.setItem(ItemTypes.AIR));

    public static final BuilderRegister<BlockType> CAVE_AIR = gen("Cave Air", "cave_air",
            builder -> builder
.setMass(MassType.GAS)
.setNetworkId(0)
.setItem(ItemTypes.AIR));

    public static final BuilderRegister<BlockType> VOID_AIR = gen("Void Air", "void_air",
            builder -> builder
.setMass(MassType.GAS)
.setNetworkId(0)
.setItem(ItemTypes.AIR));
    public static final BuilderRegister<BlockType> BEDROCK = gen("Bedrock", "bedrock",
            builder -> builder
.setMass(MassType.SOLID)
.setNetworkId(25)
.setItem(ItemTypes.BEDROCK));

    private static BuilderRegister<BlockType> gen(String name, String key, Function<BlockTypeBuilder,
            BlockTypeBuilder> function) {
        return new BuilderRegister<>(name, Identifiable.MINECRAFT_HOST, key, () -> function.apply(new BlockTypeBuilder()
.setHost(Identifiable.MINECRAFT_HOST)
.setKey(key)
.setName(name)).build());

    }*/

