package org.absorb.node.write.viewer;

import org.absorb.node.CollectionNodeData;
import org.absorb.node.NodeContext;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.function.Function;
import java.util.function.Supplier;

public class ViewerCollectionNodeData<V, C extends Collection<V>> extends NotNullableViewerNodeData<C> implements
		CollectionNodeData<V, C> {

	private final @NotNull Function<? super C, ? extends C> newInstance;

	public ViewerCollectionNodeData(@NotNull Supplier<? extends C> newInstance) {
		this(newInstance.get(), (f) -> {
			C collection = newInstance.get();
			collection.addAll(f);
			return collection;
		});
	}

	public ViewerCollectionNodeData(@NotNull C collection, @NotNull Function<? super C, ? extends C> newInstance) {
		super(collection);
		this.newInstance = newInstance;
	}

	@Override
	public void add(V value) {
		C updated = this.newInstance.apply(this.value);
		updated.add(value);
		NodeContext<C> context = new NodeContext<C>(this.value, updated, this);
		this.callEvent(context);
		this.value = updated;
	}

	@Override
	public void remove(V value) {
		C updated = this.newInstance.apply(this.value);
		updated.remove(value);
		NodeContext<C> context = new NodeContext<C>(this.value, updated, this);
		this.callEvent(context);
		this.value = updated;
	}
}
