package org.absorb.node.read.number.mapped;

import org.absorb.node.NodeData;
import org.absorb.node.number.FloatNodeData;
import org.absorb.node.read.MappedReadonlyNodeData;

import java.util.function.Function;

public class MappedReadonlyFloatNodeData<O> extends MappedReadonlyNodeData<O, Float>
		implements FloatNodeData, MappedReadonlyNumberNodeData<Float> {

	public MappedReadonlyFloatNodeData(NodeData<O> data, Function<O, Float> map) {
		super(data, map);
	}
}
