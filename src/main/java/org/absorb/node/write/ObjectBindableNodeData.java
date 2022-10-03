package org.absorb.node.write;

import org.absorb.node.NodeContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.concurrent.LinkedTransferQueue;
import java.util.function.Consumer;

public class ObjectBindableNodeData<V> implements BindableNodeData<V> {

	private @Nullable V value;
	private final Collection<Consumer<NodeContext<V>>> onChange = new LinkedTransferQueue<>();

	public ObjectBindableNodeData() {
		this(null);
	}

	public ObjectBindableNodeData(@Nullable V value) {
		this.value = value;
	}

	@Override
	public @Nullable V getValue() {
		return this.value;
	}

	@Override
	public void onChange(@NotNull Consumer<NodeContext<V>> onChange) {
		this.onChange.add(onChange);
	}

	@Override
	public void setValue(@Nullable V value) {
		NodeContext<V> context = new NodeContext<>(this.value, value, this);
		this.value = value;
		this.onChange.forEach(consumer -> consumer.accept(context.copy()));
	}

	@Override
	public void setValue(@NotNull NodeContext<V> context) {
		this.value = context.getNewData();
		this.onChange.forEach(consumer -> consumer.accept(context.withPass(ObjectBindableNodeData.this)));
	}
}
