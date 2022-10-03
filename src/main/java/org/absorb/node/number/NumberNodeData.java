package org.absorb.node.number;

import org.absorb.node.NodeData;
import org.absorb.node.read.number.mapped.MappedReadonlyDoubleNodeData;
import org.absorb.node.read.number.mapped.MappedReadonlyIntegerNodeData;
import org.absorb.node.read.number.mapped.MappedReadonlyNumberNodeData;
import org.jetbrains.annotations.NotNull;

import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;

public interface NumberNodeData<V extends Number, T extends Number> extends NodeData<V> {

	@NotNull MappedReadonlyNumberNodeData<T> subtract(int amount);

	default @NotNull MappedReadonlyDoubleNodeData<V> subtract(double amount) {
		return this.mapToDouble(context -> context.doubleValue() - amount);
	}

	@NotNull MappedReadonlyNumberNodeData<T> plus(int amount);

	default @NotNull MappedReadonlyDoubleNodeData<V> plus(double amount) {
		return this.mapToDouble(context -> context.doubleValue() + amount);
	}

	default @NotNull MappedReadonlyDoubleNodeData<V> multiply(double amount) {
		return this.mapToDouble(context -> context.doubleValue() * amount);
	}

	default @NotNull MappedReadonlyDoubleNodeData<V> divide(double amount) {
		return this.mapToDouble(context -> context.doubleValue() / amount);
	}

	default @NotNull MappedReadonlyDoubleNodeData<V> mapToDouble(@NotNull ToDoubleFunction<? super V> map) {
		return new MappedReadonlyDoubleNodeData<>(this, map::applyAsDouble);
	}

	default @NotNull MappedReadonlyIntegerNodeData<V> mapToInteger(@NotNull ToIntFunction<? super V> map) {
		return new MappedReadonlyIntegerNodeData<>(this, map::applyAsInt);
	}
}
