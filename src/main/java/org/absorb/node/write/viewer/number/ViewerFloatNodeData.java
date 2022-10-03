package org.absorb.node.write.viewer.number;

import org.absorb.node.number.FloatNodeData;
import org.absorb.node.write.viewer.NotNullableViewerNodeData;

import java.util.function.Function;

public class ViewerFloatNodeData extends NotNullableViewerNodeData<Float> implements FloatNodeData {

	public ViewerFloatNodeData() {
		this(0.0f);
	}

	public ViewerFloatNodeData(float value) {
		super(value);
	}

	public ViewerFloatNodeData(float value,
			Function<Float, IllegalArgumentException> function) {
		super(value, function);
	}
}
