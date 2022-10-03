package org.absorb.node;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class NodeContext<V> {

	private final V oldData;
	private final V newData;
	private final List<? extends NodeData<?>> passed;

	public NodeContext(V old, V newData, @NotNull NodeData<?> node) {
		this(old, newData, Collections.singletonList(node));
	}

	public NodeContext(V old, V newData, List<? extends NodeData<?>> passed) {
		this.newData = newData;
		this.oldData = old;
		this.passed = passed;
	}

	public V getOldData() {
		return this.oldData;
	}

	public V getNewData() {
		return this.newData;
	}

	public List<NodeData<?>> getPassed() {
		return Collections.unmodifiableList(this.passed);
	}

	public <T> NodeContext<T> mapTo(Function<V, T> map) {
		return new NodeContext<>(map.apply(this.oldData), map.apply(this.newData), this.passed);
	}

	public NodeContext<V> copy() {
		return withPass(null);
	}

	public NodeContext<V> withPass(@Nullable NodeData<?> node) {
		List<NodeData<?>> array = new LinkedList<>(this.passed);
		if (node != null) {
			array.add(node);
		}
		return new NodeContext<>(this.oldData, this.newData, array);
	}


}
