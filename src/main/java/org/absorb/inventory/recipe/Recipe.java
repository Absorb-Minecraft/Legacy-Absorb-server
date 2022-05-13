package org.absorb.inventory.recipe;

import org.absorb.register.AbsorbKey;
import org.absorb.utils.Identifiable;

import java.nio.ByteBuffer;

public interface Recipe extends Identifiable {

    AbsorbKey getType();

    RecipeBuilder<? extends Recipe> toBuilder();

    ByteBuffer write();

}
