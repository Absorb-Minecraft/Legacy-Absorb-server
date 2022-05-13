package org.absorb.inventory.recipe;

import org.absorb.utils.Builder;

import java.nio.ByteBuffer;

public interface RecipeBuilder<R extends Recipe> extends Builder<R> {

    RecipeBuilder<R> from(ByteBuffer data);
}
