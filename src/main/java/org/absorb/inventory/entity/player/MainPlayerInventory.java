package org.absorb.inventory.entity.player;

import org.absorb.inventory.Inventory;
import org.absorb.inventory.InventoryType;
import org.absorb.inventory.grid.GridInventory;
import org.absorb.inventory.slot.AbstractSlot;
import org.absorb.inventory.slot.Slot;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

public class MainPlayerInventory implements GridInventory {

    private final @NotNull AbstractSlot[] slots;
    private final @NotNull PlayerInventory parent;

    public MainPlayerInventory(@NotNull PlayerInventory inventory) {
        this.parent = inventory;
        this.slots = new AbstractSlot[this.getSize()];
        for (int i = 0; i < this.slots.length; i++) {
            this.slots[i] = new AbstractSlot(i + 9, inventory);
        }
    }

    @Override
    public int getSize() {
        return 27;
    }

    @Override
    public Collection<Inventory> getChildren() {
        return Arrays.asList(this.slots);
    }

    @Override
    public Optional<Inventory> getParent() {
        return Optional.of(this.parent);
    }

    @Override
    public Collection<Slot> getImmediateSlots() {
        return Arrays.asList(this.slots);
    }

    @Override
    public Optional<InventoryType> getType() {
        return Optional.empty();
    }

    @Override
    public int getHeight() {
        return 3;
    }

    @Override
    public int getWidth() {
        return 9;
    }

    @Override
    public Slot getSlot(int x, int y) {
        int index = (x * this.getWidth()) + y;
        return this.slots[index];
    }
}
