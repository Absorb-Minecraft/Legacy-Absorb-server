package org.absorb.node.number;

import org.absorb.node.read.number.mapped.MappedReadonlyIntegerNodeData;
import org.absorb.node.read.number.mapped.MappedReadonlyNumberNodeData;
import org.jetbrains.annotations.NotNull;

public interface IntegerNodeData extends NumberNodeData<Integer, Integer> {

	@Override
	default @NotNull MappedReadonlyNumberNodeData<Integer> subtract(int amount) {
		return new MappedReadonlyIntegerNodeData<>(this, v -> v - amount);
	}

	@Override
	default @NotNull MappedReadonlyNumberNodeData<Integer> plus(int amount) {
		return new MappedReadonlyIntegerNodeData<>(this, v -> v + amount);
	}
}
