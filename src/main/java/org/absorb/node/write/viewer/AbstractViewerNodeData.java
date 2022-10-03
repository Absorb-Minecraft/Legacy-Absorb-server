package org.absorb.node.write.viewer;

import org.absorb.node.NodeContext;
import org.absorb.node.write.WritableNodeData;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.concurrent.LinkedTransferQueue;
import java.util.function.Consumer;
import java.util.function.Function;

public class AbstractViewerNodeData<T> implements WritableNodeData<T> {

	private final Collection<Consumer<NodeContext<T>>> onChange = new LinkedTransferQueue<>();
	private final Function<T, IllegalArgumentException> onSet;
	protected T value;

	public AbstractViewerNodeData(T value, Function<T, IllegalArgumentException> onSet) {
		this.value = value;
		this.onSet = onSet;
	}

	@Override
	public T getValue() {
		return this.value;
	}

	@Override
	public void onChange(@NotNull Consumer<NodeContext<T>> onChange) {
		this.onChange.add(onChange);
	}

	protected void callEvent(NodeContext<T> context) {
		this.onChange.forEach(consumer -> consumer.accept(context.copy()));
	}

	@Override
	public void setValue(T value) {
		IllegalArgumentException ex = this.onSet.apply(value);
		if (ex != null) {
			throw ex;
		}
		NodeContext<T> context = new NodeContext<>(this.value, value, this);
		this.value = value;
		this.callEvent(context);
	}
}
