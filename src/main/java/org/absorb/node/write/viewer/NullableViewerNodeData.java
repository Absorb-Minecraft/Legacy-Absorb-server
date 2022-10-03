package org.absorb.node.write.viewer;

import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

public class NullableViewerNodeData<T> extends AbstractViewerNodeData<T> {

	public NullableViewerNodeData() {
		this(null);
	}

	public NullableViewerNodeData(@Nullable T value) {
		//noinspection ReturnOfNull
		this(value, e -> null);
	}

	public NullableViewerNodeData(@Nullable T value, Function<T, IllegalArgumentException> ex) {
		super(value, ex);
	}

	@Override
	public @Nullable T getValue() {
		return super.getValue();
	}

	@Override
	public void setValue(@Nullable T value) {
		super.setValue(value);
	}
}
