package org.absorb.inventory.entity.client;

import org.absorb.inventory.Inventory;
import org.absorb.inventory.InventoryType;
import org.absorb.inventory.slot.Slot;
import org.absorb.utils.colllection.ConnectedCollection;

import java.util.Collection;
import java.util.Optional;

public class ClientInventory implements Inventory {

    private ClientHotbar hotbar;
    private ClientCraftingInventory crafting;
    private ClientMainInventory main;

    public ClientInventory() {
        this.crafting = new ClientCraftingInventory(this);
        this.hotbar = new ClientHotbar(this);
        this.main = new ClientMainInventory(this);
    }

    public ClientHotbar getHotbar() {
        return this.hotbar;
    }

    public ClientCraftingInventory getCrafting() {
        return this.crafting;
    }

    public ClientMainInventory getMain() {
        return this.main;
    }

    @Override
    public int getSize() {
        return this.hotbar.getSize() + this.crafting.getSize() + this.main.getSize();
    }

    @Override
    public Collection<Inventory> getChildren() {
        ConnectedCollection<Inventory> slots = new ConnectedCollection<>();
        slots.addConnection(this.crafting.getChildren());
        slots.addConnection(this.hotbar.getChildren());
        slots.addConnection(this.main.getChildren());
        return slots;
    }

    @Override
    public Optional<Inventory> getParent() {
        return Optional.empty();
    }

    @Override
    public Collection<Slot> getImmediateSlots() {
        ConnectedCollection<Slot> slots = new ConnectedCollection<>();
        slots.addConnection(this.crafting.getImmediateSlots());
        slots.addConnection(this.hotbar.getImmediateSlots());
        slots.addConnection(this.main.getImmediateSlots());
        return slots;
    }

    @Override
    public Optional<InventoryType> getType() {
        return Optional.of(InventoryType.PLAYER_INVENTORY);
    }
}
