package org.absorb.node.write;

import org.absorb.node.NodeContext;
import org.absorb.node.NodeData;
import org.jetbrains.annotations.NotNull;

public interface BindableNodeData<V> extends WritableNodeData<V> {

	void setValue(@NotNull NodeContext<V> context);

	default void bind(@NotNull NodeData<V> data) {
		data.onChange(this::setValue);
	}

	default void bindBidirectional(BindableNodeData<V> node) {
		this.onChange(context -> {
			if (context.getPassed().contains(node)) {
				return;
			}
			node.setValue(context);
		});
		node.onChange(context -> {
			if (context.getPassed().contains(BindableNodeData.this)) {
				return;
			}
			this.setValue(context);
		});
	}
}
