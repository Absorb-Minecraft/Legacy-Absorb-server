package org.absorb.node.read.number.mapped;

import org.absorb.node.number.NumberNodeData;
import org.absorb.node.read.ReadOnlyNodeData;

public interface MappedReadonlyNumberNodeData<T extends Number>
		extends ReadOnlyNodeData<T>,
		NumberNodeData<T, T> {
}
