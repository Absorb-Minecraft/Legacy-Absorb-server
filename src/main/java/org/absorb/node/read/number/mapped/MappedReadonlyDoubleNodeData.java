package org.absorb.node.read.number.mapped;

import org.absorb.node.NodeData;
import org.absorb.node.number.DoubleNodeData;
import org.absorb.node.read.MappedReadonlyNodeData;

import java.util.function.Function;

public class MappedReadonlyDoubleNodeData<O> extends MappedReadonlyNodeData<O, Double>
		implements DoubleNodeData, MappedReadonlyNumberNodeData<Double> {

	public MappedReadonlyDoubleNodeData(NodeData<O> data, Function<O, Double> map) {
		super(data, map);
	}
}
