package org.absorb.node.number;

import org.absorb.node.read.number.mapped.MappedReadonlyFloatNodeData;
import org.jetbrains.annotations.NotNull;

public interface FloatNodeData extends NumberNodeData<Float, Float> {

	@Override
	default @NotNull MappedReadonlyFloatNodeData subtract(int amount) {
		return new MappedReadonlyFloatNodeData<>(this, value -> value - amount);
	}

	@Override
	default @NotNull MappedReadonlyFloatNodeData plus(int amount) {
		return new MappedReadonlyFloatNodeData<>(this, value -> value + amount);
	}
}
