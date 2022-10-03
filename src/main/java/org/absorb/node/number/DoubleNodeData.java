package org.absorb.node.number;

import org.absorb.node.read.number.mapped.MappedReadonlyDoubleNodeData;
import org.jetbrains.annotations.NotNull;

public interface DoubleNodeData extends NumberNodeData<Double, Double> {

	@Override
	default @NotNull MappedReadonlyDoubleNodeData subtract(int amount) {
		return this.subtract((double) amount);
	}

	@Override
	default @NotNull MappedReadonlyDoubleNodeData plus(int amount) {
		return this.plus((double) amount);
	}
}
