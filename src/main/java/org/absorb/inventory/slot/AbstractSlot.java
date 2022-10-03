package org.absorb.inventory.slot;

import org.absorb.inventory.Inventory;
import org.absorb.inventory.InventoryType;
import org.absorb.inventory.item.ItemStack;
import org.absorb.node.write.viewer.NullableViewerNodeData;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.math.vector.Vector2i;

import java.util.Optional;
import java.util.OptionalInt;

public class AbstractSlot implements Slot {

	private final @Nullable Inventory parent;
	private final int networkId;
	private final NullableViewerNodeData<ItemStack> stack = new NullableViewerNodeData<>();
	private final @Nullable Vector2i position;

	public AbstractSlot(int networkId, @Nullable Inventory inventory) {
		this(networkId, inventory, null);
	}

	public AbstractSlot(int networkId, @Nullable Inventory inventory, @Nullable ItemStack stack) {
		this(networkId, inventory, stack, null);
	}

	public AbstractSlot(int networkId, @Nullable Inventory inventory, @Nullable ItemStack stack,
			@Nullable Vector2i vector2i) {
		this.parent = inventory;
		this.stack.setValue(stack);
		this.networkId = networkId;
		this.position = vector2i;
	}

	public int getNetworkId() {
		return this.networkId;
	}

	public void setItem(@Nullable ItemStack stack) {
		this.stack.setValue(stack);
	}

	public void removeItem() {
		this.setItem(null);
	}

	@Override
	public OptionalInt getIndex() {
		return OptionalInt.of(this.networkId);
	}

	@Override
	public Optional<Vector2i> getGridPosition() {
		return Optional.ofNullable(this.position);
	}

	@Override
	public NullableViewerNodeData<ItemStack> item() {
		return this.stack;
	}

	@Override
	public Optional<Inventory> getParent() {
		return Optional.ofNullable(this.parent);
	}


	@Override
	public Optional<InventoryType> getType() {
		return Optional.empty();
	}


}
