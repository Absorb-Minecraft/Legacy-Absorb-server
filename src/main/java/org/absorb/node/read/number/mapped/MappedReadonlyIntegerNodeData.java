package org.absorb.node.read.number.mapped;

import org.absorb.node.NodeData;
import org.absorb.node.number.IntegerNodeData;
import org.absorb.node.read.MappedReadonlyNodeData;

import java.util.function.Function;

public class MappedReadonlyIntegerNodeData<O> extends MappedReadonlyNodeData<O, Integer>
		implements IntegerNodeData, MappedReadonlyNumberNodeData<Integer> {

	public MappedReadonlyIntegerNodeData(NodeData<O> data, Function<O, Integer> map) {
		super(data, map);
	}
}
