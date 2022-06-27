package org.absorb.inventory.entity.client;

import org.absorb.inventory.Inventory;
import org.absorb.inventory.InventoryType;
import org.absorb.inventory.slot.Slot;
import org.absorb.inventory.slot.SpecificInputSlot;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

public class ClientEquipment implements Inventory {

    private final @NotNull SpecificInputSlot helmetSlot;
    private final @NotNull SpecificInputSlot armorSlot;
    private final @NotNull SpecificInputSlot leggingSlot;
    private final @NotNull SpecificInputSlot feetSlot;
    private final @NotNull SpecificInputSlot packSlot;
    private final @NotNull ClientInventory parent;

    public ClientEquipment(@NotNull ClientInventory inventory) {
        this.helmetSlot = new SpecificInputSlot(5, inventory, 1);
        this.armorSlot = new SpecificInputSlot(6, inventory, 1);
        this.leggingSlot = new SpecificInputSlot(7, inventory, 1);
        this.feetSlot = new SpecificInputSlot(8, inventory, 1);
        this.packSlot = new SpecificInputSlot(45, inventory, 1);
        this.parent = inventory;

    }

    @Override
    public int getSize() {
        return 5;
    }

    @Override
    public Collection<Inventory> getChildren() {
        return Arrays.asList(this.armorSlot, this.feetSlot, this.packSlot, this.helmetSlot, this.feetSlot, this.leggingSlot);
    }

    @Override
    public Optional<Inventory> getParent() {
        return Optional.of(this.parent);
    }

    @Override
    public Collection<Slot> getImmediateSlots() {
        return Arrays.asList(this.armorSlot, this.feetSlot, this.packSlot, this.helmetSlot, this.feetSlot, this.leggingSlot);
    }

    @Override
    public Optional<InventoryType> getType() {
        return Optional.empty();
    }
}
