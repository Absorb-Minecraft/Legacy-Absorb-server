package org.absorb.node.write.viewer.number;

import org.absorb.node.number.DoubleNodeData;
import org.absorb.node.write.viewer.NotNullableViewerNodeData;

import java.util.function.Function;

public class ViewerDoubleNodeData extends NotNullableViewerNodeData<Double> implements DoubleNodeData {

	public ViewerDoubleNodeData() {
		this(0.0);
	}

	public ViewerDoubleNodeData(double value) {
		super(value);
	}

	public ViewerDoubleNodeData(double value,
			Function<Double, IllegalArgumentException> function) {
		super(value, function);
	}
}
