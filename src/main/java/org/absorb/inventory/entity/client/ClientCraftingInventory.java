package org.absorb.inventory.entity.client;

import org.absorb.inventory.Inventory;
import org.absorb.inventory.InventoryType;
import org.absorb.inventory.grid.Grid2x2Inventory;
import org.absorb.inventory.slot.InputSlot;
import org.absorb.inventory.slot.OutputSlot;
import org.absorb.inventory.slot.Slot;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

public class ClientCraftingInventory implements Inventory {

    private final @NotNull Grid2x2Inventory craftingSlot;
    private final @NotNull OutputSlot result;
    private final @NotNull ClientInventory parent;

    public ClientCraftingInventory(@NotNull ClientInventory parent) {
        this.parent = parent;
        this.result = new OutputSlot(0, parent);
        this.craftingSlot = new Grid2x2Inventory(parent, new InputSlot(1, parent), new InputSlot(2, parent),
                new InputSlot(3, parent), new InputSlot(4, parent));
    }


    @Override
    public int getSize() {
        return 5;
    }

    @Override
    public Collection<Inventory> getChildren() {
        return Arrays.asList(this.craftingSlot.getSlot(0, 0), this.craftingSlot.getSlot(1, 0),
                this.craftingSlot.getSlot(0, 1), this.craftingSlot.getSlot(1, 1), this.result);
    }

    @Override
    public Optional<Inventory> getParent() {
        return Optional.of(this.parent);
    }

    @Override
    public Collection<Slot> getImmediateSlots() {
        return Arrays.asList(this.craftingSlot.getSlot(0, 0), this.craftingSlot.getSlot(1, 0),
                this.craftingSlot.getSlot(0, 1), this.craftingSlot.getSlot(1, 1), this.result);
    }

    @Override
    public Optional<InventoryType> getType() {
        return Optional.empty();
    }
}
