package org.absorb.node.write.viewer;

import org.absorb.node.write.WritableNotNullableNodeData;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public class NotNullableViewerNodeData<T> extends AbstractViewerNodeData<T> implements WritableNotNullableNodeData<T> {

	public NotNullableViewerNodeData(@NotNull T value) {
		this(value, ex -> {
			if (ex == null) {
				return new IllegalArgumentException("Value cannot be null");
			}
			//noinspection ReturnOfNull
			return null;
		});
	}

	public NotNullableViewerNodeData(@NotNull T value, Function<T, IllegalArgumentException> function) {
		super(value, function);
	}

	@Override
	public @NotNull T getValue() {
		T value = super.getValue();
		if (value == null) {
			throw new RuntimeException("Somehow got null");
		}
		return value;
	}

	@Override
	public void setValue(@NotNull T value) {
		super.setValue(value);
	}
}
