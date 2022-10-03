package org.absorb.node.read;

import org.absorb.node.NodeContext;
import org.absorb.node.NodeData;

import java.util.Collection;
import java.util.concurrent.LinkedTransferQueue;
import java.util.function.Consumer;
import java.util.function.Function;

public class MappedReadonlyNodeData<V, T> implements ReadOnlyNodeData<T> {

	private final NodeData<V> original;
	private final Function<V, T> mapped;
	private final Collection<Consumer<NodeContext<T>>> onChange = new LinkedTransferQueue<>();

	public MappedReadonlyNodeData(NodeData<V> data, Function<V, T> map) {
		this.mapped = map;
		this.original = data;
		this.original.onChange(context -> {
			NodeContext<T> contextMapped = context.mapTo(map).withPass(MappedReadonlyNodeData.this);
			this.onChange.forEach(consumer -> {
				NodeContext<T> copy = contextMapped.copy();
				consumer.accept(copy);
			});
		});
	}

	@Override
	public T getValue() {
		return this.mapped.apply(this.original.getValue());
	}

	@Override
	public void onChange(Consumer<NodeContext<T>> onChange) {
		this.onChange.add(onChange);
	}
}
