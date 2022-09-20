package org.absorb.net.packet.play.outgoing.entity.metadata.types.value;

import net.kyori.adventure.text.Component;
import org.absorb.entity.living.human.Hand;
import org.absorb.inventory.slot.Slot;
import org.absorb.net.data.NetSerializers;
import org.absorb.net.packet.play.outgoing.entity.metadata.types.value.bitmask.DisplayBitmask;
import org.absorb.net.packet.play.outgoing.entity.metadata.types.value.bitmask.HandBitmask;
import org.absorb.net.packet.play.outgoing.entity.metadata.types.value.bitmask.MobBitmask;
import org.absorb.net.packet.play.outgoing.entity.metadata.types.value.bitmask.SkinBitmask;
import org.spongepowered.math.vector.Vector3i;

public interface MetadataValueTypes {

    MetadataValueType.SimpleMetadataValueType<Byte> BYTE = new MetadataValueType.SimpleMetadataValueType<>(
            NetSerializers.BYTE,
            0);

    MetadataValueType.BitMaskMetadataValueType<DisplayBitmask> DISPLAY_BITMASK = new MetadataValueType.BitMaskMetadataValueType<>(
            0);

    MetadataValueType.BitMaskMetadataValueType<HandBitmask> HAND_BITMASK = new MetadataValueType.BitMaskMetadataValueType<>(
            0);


    MetadataValueType.SimpleMetadataValueType<Integer> VAR_INT = new MetadataValueType.SimpleMetadataValueType<>(
            NetSerializers.VAR_INTEGER,
            1);

    MetadataValueType.SimpleMetadataValueType<Float> FLOAT = new MetadataValueType.SimpleMetadataValueType<>(
            NetSerializers.FLOAT,
            2);

    MetadataValueType.SimpleMetadataValueType<String> STRING = new MetadataValueType.SimpleMetadataValueType<>(
            NetSerializers.STRING,
            3);

    MetadataValueType.SimpleMetadataValueType<Component> CHAT = new MetadataValueType.SimpleMetadataValueType<>(
            NetSerializers.CHAT,
            4);

    MetadataValueType.SimpleMetadataValueType<Component> OPTIONAL_CHAT = new MetadataValueType.SimpleMetadataValueType<>(
            NetSerializers.CHAT,
            5,
            true);

    MetadataValueType.SimpleMetadataValueType<Slot> SLOT = new MetadataValueType.SimpleMetadataValueType<>(
            NetSerializers.SLOT,
            6);

    MetadataValueType.SimpleMetadataValueType<Boolean> BOOLEAN = new MetadataValueType.SimpleMetadataValueType<>(
            NetSerializers.BOOLEAN,
            7);

    MetadataValueType.SimpleMetadataValueType<Vector3i> BLOCK_POSITION = new MetadataValueType.SimpleMetadataValueType<>(
            NetSerializers.POSITION,
            9);
    MetadataValueType.BooleanDefinedOptionalType<Vector3i, Vector3i> OPTIONAL_BLOCK_POSITION = new MetadataValueType.BooleanDefinedOptionalType<>(
            NetSerializers.POSITION,
            10);
    MetadataValueType.BitMaskMetadataValueType<MobBitmask> MOB = new MetadataValueType.BitMaskMetadataValueType<>(15);
    MetadataValueType.SimpleMetadataValueType<Boolean> IS_CHARGED = new MetadataValueType.SimpleMetadataValueType<>(
            NetSerializers.BOOLEAN,
            17);
    MetadataValueType.SimpleMetadataValueType<Boolean> IS_IGNITED = new MetadataValueType.SimpleMetadataValueType<>(
            NetSerializers.BOOLEAN,
            18);
    MetadataValueType.SimpleMetadataValueType<Float> ADDITIONAL_HEALTH = new MetadataValueType.SimpleMetadataValueType<>(
            NetSerializers.FLOAT,
            15);
    MetadataValueType.SimpleMetadataValueType<Integer> SCORE = new MetadataValueType.SimpleMetadataValueType<>(
            NetSerializers.VAR_INTEGER,
            16);
    MetadataValueType.BitMaskMetadataValueType<SkinBitmask> SKIN_BITMASK = new MetadataValueType.BitMaskMetadataValueType<>(
            17);
    MetadataValueType<Byte, Hand> PLAYER_HAND = new MetadataValueType<>(NetSerializers.BYTE,
                                                                        hand -> (byte) hand.getNetworkId(),
                                                                        18);

}
