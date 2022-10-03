package org.absorb.node.write;

import org.absorb.node.NodeData;
import org.jetbrains.annotations.Nullable;

public interface WritableNodeData<V> extends NodeData<V> {

	void setValue(@Nullable V value);

}
