package org.absorb.net.packet.play.outgoing.entity.metadata.types;

import net.kyori.adventure.text.Component;
import org.absorb.entity.living.human.Hand;
import org.absorb.net.packet.play.outgoing.entity.metadata.types.value.MetadataValueTypes;
import org.absorb.net.packet.play.outgoing.entity.metadata.types.value.bitmask.DisplayBitmask;
import org.absorb.net.packet.play.outgoing.entity.metadata.types.value.bitmask.HandBitmask;
import org.absorb.net.packet.play.outgoing.entity.metadata.types.value.bitmask.MobBitmask;
import org.absorb.net.packet.play.outgoing.entity.metadata.types.value.bitmask.SkinBitmask;
import org.spongepowered.math.vector.Vector3i;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public interface EntityMetadataTypes {

    EntityMetadataType<Byte, DisplayBitmask> DISPLAY = new EntityMetadataType<>(MetadataValueTypes.DISPLAY_BITMASK,
                                                                                0,
                                                                                new DisplayBitmask());
    EntityMetadataType<Integer, Integer> AIR = new EntityMetadataType<>(MetadataValueTypes.VAR_INT, 1, 300);
    EntityMetadataType<Component, Component> CUSTOM_NAME = new EntityMetadataType<>(MetadataValueTypes.CHAT, 2, null);
    EntityMetadataType<Boolean, Boolean> CUSTOM_NAME_VISIBLE = new EntityMetadataType<>(MetadataValueTypes.BOOLEAN,
                                                                                        3,
                                                                                        false);
    EntityMetadataType<Boolean, Boolean> SILENT = new EntityMetadataType<>(MetadataValueTypes.BOOLEAN, 4, false);
    EntityMetadataType<Boolean, Boolean> NO_GRAVITY = new EntityMetadataType<>(MetadataValueTypes.BOOLEAN, 5, false);
    EntityMetadataType<Integer, Integer> FROZEN_SNOW = new EntityMetadataType<>(MetadataValueTypes.VAR_INT, 7, 0);
    EntityMetadataType<Byte, HandBitmask> HAND = new EntityMetadataType<>(MetadataValueTypes.HAND_BITMASK,
                                                                          8,
                                                                          new HandBitmask());
    EntityMetadataType<Float, Float> HEALTH = new EntityMetadataType<>(MetadataValueTypes.FLOAT, 9, 1.0f);
    EntityMetadataType<Integer, Integer> POTION_EFFECT_COLOUR = new EntityMetadataType<>(MetadataValueTypes.VAR_INT,
                                                                                         10,
                                                                                         0);
    EntityMetadataType<Boolean, Boolean> POTION_EFFECT_AMBIENT = new EntityMetadataType<>(MetadataValueTypes.BOOLEAN,
                                                                                          11,
                                                                                          false);
    EntityMetadataType<Integer, Integer> ARROWS = new EntityMetadataType<>(MetadataValueTypes.VAR_INT, 12, 0);
    EntityMetadataType<Integer, Integer> BEE_STINGS = new EntityMetadataType<>(MetadataValueTypes.VAR_INT, 13, 0);
    EntityMetadataType<Vector3i, Vector3i> SLEEPING_LOCATION = new EntityMetadataType<>(MetadataValueTypes.OPTIONAL_BLOCK_POSITION,
                                                                                        14,
                                                                                        null);
    EntityMetadataType<Byte, MobBitmask> MOB = new EntityMetadataType<>(MetadataValueTypes.MOB, 15, new MobBitmask());

    EntityMetadataType<Boolean, Boolean> IS_CHARGED = new EntityMetadataType<>(MetadataValueTypes.IS_CHARGED,
                                                                               17,
                                                                               false);
    EntityMetadataType<Boolean, Boolean> IS_IGNITED = new EntityMetadataType<>(MetadataValueTypes.IS_IGNITED,
                                                                               18,
                                                                               false);

    EntityMetadataType<Float, Float> ADDITIONAL_HEALTH = new EntityMetadataType<>(MetadataValueTypes.ADDITIONAL_HEALTH,
                                                                                  15,
                                                                                  0f);

    EntityMetadataType<Integer, Integer> SCORE = new EntityMetadataType<>(MetadataValueTypes.SCORE, 16, 0);
    EntityMetadataType<Byte, SkinBitmask> SKIN = new EntityMetadataType<>(MetadataValueTypes.SKIN_BITMASK,
                                                                          17,
                                                                          new SkinBitmask());
    EntityMetadataType<Byte, Hand> PLAYER_HAND = new EntityMetadataType<>(MetadataValueTypes.PLAYER_HAND,
                                                                          18,
                                                                          Hand.RIGHT);


    static Collection<EntityMetadataType<?, ?>> getEntityMetadata() {
        return Set.of(DISPLAY, AIR, CUSTOM_NAME, CUSTOM_NAME_VISIBLE, SILENT, NO_GRAVITY, FROZEN_SNOW);
    }

    static Collection<EntityMetadataType<?, ?>> getLivingEntityMetadata() {
        Collection<EntityMetadataType<?, ?>> collection = new HashSet<>(getEntityMetadata());
        collection.addAll(Set.of(HAND,
                                 HEALTH,
                                 POTION_EFFECT_COLOUR,
                                 POTION_EFFECT_AMBIENT,
                                 ARROWS,
                                 BEE_STINGS,
                                 SLEEPING_LOCATION));
        return Collections.unmodifiableCollection(collection);
    }

    static Collection<EntityMetadataType<?, ?>> getCreeperMetadata() {
        Collection<EntityMetadataType<?, ?>> collection = new HashSet<>(getLivingEntityMetadata());
        collection.addAll(Set.of(MOB, IS_CHARGED, IS_IGNITED));
        return Collections.unmodifiableCollection(collection);
    }

}
