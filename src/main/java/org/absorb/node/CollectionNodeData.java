package org.absorb.node;

import java.util.Collection;

public interface CollectionNodeData<V, C extends Collection<V>> extends NodeData<C> {

	void add(V value);

	void remove(V value);
}
