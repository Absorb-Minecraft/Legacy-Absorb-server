package org.absorb.block.state.properties.type.enu;

import org.absorb.block.state.properties.type.enu.type.*;
import org.absorb.world.location.Direction;

import java.util.EnumSet;

public class EnumBlockStatePropertyTypes {

    public static final EnumBlockStatePropertyType<PistonHeadType> PISTON_HEAD_TYPE =
            new AbstractEnumBlockStatePropertyType<PistonHeadType>("Piston Head Type", "type", PistonHeadType.class);

    public static final AbstractEnumBlockStatePropertyType<AttachableFace> ATTACHABLE_FACE_STANDARD =
            new AbstractEnumBlockStatePropertyType<>("Attachable face", "face", EnumSet.of(AttachableFace.CEILING,
                    AttachableFace.WALL, AttachableFace.FLOOR));
    public static final AbstractEnumBlockStatePropertyType<AttachableFace> ATTACHABLE_FACE_DOUBLE =
            new AbstractEnumBlockStatePropertyType<AttachableFace>("Attachable face", "face",
                    EnumSet.of(AttachableFace.FLOOR, AttachableFace.CEILING, AttachableFace.SINGLE_WALL,
                            AttachableFace.DOUBLE_WALL));
    public static final AbstractEnumBlockStatePropertyType<Direction> FACING =
            new AbstractEnumBlockStatePropertyType<>("Face", "face", EnumSet.of(Direction.NORTH, Direction.SOUTH,
                    Direction.WEST, Direction.EAST));
    public static final AbstractEnumBlockStatePropertyType<Direction> ROTATION =
            new AbstractEnumBlockStatePropertyType<>("Rotation", "rotation", EnumSet.range(Direction.NORTH,
                    Direction.WEST_NORTH_WEST));
    public static final AbstractEnumBlockStatePropertyType<BlockHalfType> HALF =
            new AbstractEnumBlockStatePropertyType<>("Block Half", "half", EnumSet.of(BlockHalfType.BOTTOM,
                    BlockHalfType.TOP));
    public static final AbstractEnumBlockStatePropertyType<BlockHalfType> HALF_BLOCK_TYPE =
            new AbstractEnumBlockStatePropertyType<>("Half Block Type", "type", BlockHalfType.class);
    public static final AbstractEnumBlockStatePropertyType<HingSide> HINGE =
            new AbstractEnumBlockStatePropertyType<>("Hinge Side", "hinge", HingSide.class);
    public static final AbstractEnumBlockStatePropertyType<Axis> AXIS = new AbstractEnumBlockStatePropertyType<>("Axis",
            "axis", Axis.class);
    public static final AbstractEnumBlockStatePropertyType<StairShape> STAIR_SHAPE =
            new AbstractEnumBlockStatePropertyType<>("Stair Shape", "shape", StairShape.class);
    public static final AbstractEnumBlockStatePropertyType<RailDirection> STRAIGHT_RAIL_DIRECTION =
            new AbstractEnumBlockStatePropertyType<>("Rail Direction", "shape",
                    EnumSet.of(RailDirection.ASCENDING_EAST, RailDirection.ASCENDING_NORTH, RailDirection.EAST_WEST,
                            RailDirection.ASCENDING_SOUTH, RailDirection.NORTH_SOUTH));
    public static final EnumBlockStatePropertyType<RailDirection> RAIL_DIRECTION =
            new AbstractEnumBlockStatePropertyType<RailDirection>("Rail Direction", "shape", RailDirection.class);
    public static final AbstractEnumBlockStatePropertyType<BedHalf> BED_HALF =
            new AbstractEnumBlockStatePropertyType<>("Bed Half", "part", BedHalf.class);
    public static final AbstractEnumBlockStatePropertyType<HeightAttachment> SOUTH =
            new AbstractEnumBlockStatePropertyType<>("South Height", "south", HeightAttachment.class);
    public static final AbstractEnumBlockStatePropertyType<HeightAttachment> NORTH =
            new AbstractEnumBlockStatePropertyType<>("North Height", "north", HeightAttachment.class);
    public static final AbstractEnumBlockStatePropertyType<HeightAttachment> EAST =
            new AbstractEnumBlockStatePropertyType<>("East Height", "east", HeightAttachment.class);
    public static final AbstractEnumBlockStatePropertyType<HeightAttachment> WEST =
            new AbstractEnumBlockStatePropertyType<>("West Height", "west", HeightAttachment.class);
    public static final EnumBlockStatePropertyType<ChestHalf> CHEST_HALF =
            new AbstractEnumBlockStatePropertyType<>("Chest half", "type", ChestHalf.class);
    public static final EnumBlockStatePropertyType<StructureMode> STRUCTURE_MODE =
            new AbstractEnumBlockStatePropertyType<>("Structure Mode", "mode", StructureMode.class);
    public static final EnumBlockStatePropertyType<SculkSensorPhase> SCULK_SENSOR_PHASE =
            new AbstractEnumBlockStatePropertyType<>("Sculk Sensor Phase", "sculk_sensor_phase",
                    SculkSensorPhase.class);
    public static final EnumBlockStatePropertyType<DripstoneSize> DRIPSTONE_SIZE =
            new AbstractEnumBlockStatePropertyType<>("Dripstone Size", "thickness", DripstoneSize.class);
    public static final EnumBlockStatePropertyType<Direction> VERTICAL_DIRECTION =
            new AbstractEnumBlockStatePropertyType<>("Vertical Direction", "vertical_direction",
                    EnumSet.of(Direction.UP, Direction.DOWN));
    public static final AbstractEnumBlockStatePropertyType<BlockLeaves> LEAVES =
            new AbstractEnumBlockStatePropertyType<>("Leaves", "leaves", BlockLeaves.class);
    public static final AbstractEnumBlockStatePropertyType<DripLeafTilt> DRIP_LEAF_TILT =
            new AbstractEnumBlockStatePropertyType<>("Drip Leaf Tilt", "tilt", DripLeafTilt.class);
    public static final AbstractEnumBlockStatePropertyType<ComparatorMode> COMPARATOR_MODE =
            new AbstractEnumBlockStatePropertyType<>("Comparator Mode", "mode", ComparatorMode.class);
    public static final EnumBlockStatePropertyType<PlacementOrientation> PLACEMENT_ORIENTATION =
            new AbstractEnumBlockStatePropertyType<>("Placement Orientation", "orientation",
                    PlacementOrientation.class);
    public static final EnumBlockStatePropertyType<NoteBlockSound> NOTE_BLOCK_INSTRUMENT =
            new AbstractEnumBlockStatePropertyType<>("Note Block Instrument", "instrument",
                    NoteBlockSound.class);
}
