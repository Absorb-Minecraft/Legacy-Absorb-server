package org.absorb.node;

import org.jetbrains.annotations.NotNull;

public interface NotNullableNodeData<T> extends NodeData<T> {

	@Override
	@NotNull T getValue();

	@Override
	@NotNull
	@Deprecated
	default T getValue(@NotNull T alternative) {
		return NodeData.super.getValue(alternative);
	}
}
