package org.absorb.node.write;

import org.absorb.node.NotNullableNodeData;
import org.jetbrains.annotations.NotNull;

public interface WritableNotNullableNodeData<V> extends WritableNodeData<V>, NotNullableNodeData<V> {

	@Override
	void setValue(@NotNull V value);
}
