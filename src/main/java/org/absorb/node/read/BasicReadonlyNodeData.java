package org.absorb.node.read;

import org.absorb.node.NodeContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class BasicReadonlyNodeData<T> implements ReadOnlyNodeData<T> {

	private final @Nullable T value;

	public BasicReadonlyNodeData() {
		this(null);
	}

	public BasicReadonlyNodeData(@Nullable T value) {
		this.value = value;
	}

	@Override
	public @Nullable T getValue() {
		return this.value;
	}

	@Override
	public void onChange(@NotNull Consumer<NodeContext<T>> onChange) {

	}
}
