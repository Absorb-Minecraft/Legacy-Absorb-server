package org.absorb.inventory.slot;

import org.absorb.inventory.Inventory;
import org.absorb.inventory.InventoryType;
import org.absorb.inventory.item.ItemStack;
import org.absorb.node.read.BasicReadonlyNodeData;
import org.absorb.node.read.ReadOnlyNodeData;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.math.vector.Vector2i;

import java.util.Optional;
import java.util.OptionalInt;

public class UnknownSlot implements Slot {

	private final ReadOnlyNodeData<ItemStack> stack;
	private final @Nullable Inventory parent;

	public UnknownSlot(@Nullable Inventory parent, @Nullable ItemStack stack) {
		this.parent = parent;
		this.stack = new BasicReadonlyNodeData<>(stack);
	}

	@Override
	public Optional<Inventory> getParent() {
		return Optional.ofNullable(this.parent);
	}

	@Override
	public Optional<InventoryType> getType() {
		return Optional.empty();
	}

	@Override
	public OptionalInt getIndex() {
		return OptionalInt.empty();
	}

	@Override
	public Optional<Vector2i> getGridPosition() {
		return Optional.empty();
	}

	@Override
	public ReadOnlyNodeData<ItemStack> item() {
		return this.stack;
	}
}
