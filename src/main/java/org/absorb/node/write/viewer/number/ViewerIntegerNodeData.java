package org.absorb.node.write.viewer.number;

import org.absorb.node.number.IntegerNodeData;
import org.absorb.node.write.viewer.NotNullableViewerNodeData;

import java.util.function.Function;

public class ViewerIntegerNodeData extends NotNullableViewerNodeData<Integer> implements IntegerNodeData {

	public ViewerIntegerNodeData() {
		this(0);
	}

	public ViewerIntegerNodeData(int value) {
		super(value);
	}

	public ViewerIntegerNodeData(int value,
			Function<Integer, IllegalArgumentException> function) {
		super(value, function);
	}
}
