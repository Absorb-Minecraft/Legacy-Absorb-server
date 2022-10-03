package org.absorb.node;

import org.absorb.node.read.BasicReadonlyNodeData;
import org.absorb.node.read.MappedReadonlyNodeData;
import org.absorb.node.read.ReadOnlyNodeData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;
import java.util.function.Function;

public interface NodeData<V> {

	@Nullable V getValue();

	default @NotNull V getValue(@NotNull V alternative) {
		V value = this.getValue();
		if (value == null) {
			return alternative;
		}
		return value;
	}

	void onChange(@NotNull Consumer<NodeContext<V>> onChange);

	default <T> @NotNull MappedReadonlyNodeData<V, T> map(@NotNull Function<V, T> map) {
		return new MappedReadonlyNodeData<>(this, map);
	}

	default @NotNull ReadOnlyNodeData<V> asReadonly() {
		return new BasicReadonlyNodeData<>(this.getValue());
	}
}
