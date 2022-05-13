package org.absorb.inventory.grid;

import org.absorb.inventory.Inventory;
import org.absorb.inventory.InventoryType;
import org.absorb.inventory.slot.Slot;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

public class Grid2x2Inventory implements GridInventory {

    private final @NotNull Slot grid1x1;
    private final @NotNull Slot grid2x1;
    private final @NotNull Slot grid1x2;
    private final @NotNull Slot grid2x2;
    private final @Nullable Inventory inventory;

    public Grid2x2Inventory(@Nullable Inventory inventory, @NotNull Slot grid1x1, @NotNull Slot grid1x2,
                            @NotNull Slot grid2x1,
                            @NotNull Slot grid2x2) {
        this.grid1x2 = grid1x2;
        this.grid1x1 = grid1x1;
        this.grid2x1 = grid2x1;
        this.grid2x2 = grid2x2;
        this.inventory = inventory;
    }

    @Override
    public int getSize() {
        return 4;
    }

    @Override
    public Collection<Inventory> getChildren() {
        return Arrays.asList(this.grid1x1, this.grid1x2, this.grid2x1, this.grid2x2);
    }

    @Override
    public Optional<Inventory> getParent() {
        return Optional.ofNullable(this.inventory);
    }

    @Override
    public Collection<Slot> getImmediateSlots() {
        return Arrays.asList(this.grid1x1, this.grid1x2, this.grid2x1, this.grid2x2);
    }

    @Override
    public Optional<InventoryType> getType() {
        return Optional.empty();
    }

    @Override
    public int getHeight() {
        return 2;
    }

    @Override
    public int getWidth() {
        return 2;
    }

    @Override
    public Slot getSlot(int x, int y) {
        return switch (x) {
            case 0 -> switch (y) {
                case 0 -> this.grid1x1;
                case 1 -> this.grid1x2;
                default -> throw new IndexOutOfBoundsException("Y cannot be greater then 1");
            };
            case 1 -> switch (y) {
                case 0 -> this.grid2x1;
                case 1 -> this.grid2x2;
                default -> throw new IndexOutOfBoundsException("Y cannot be greater then 1");
            };
            default -> throw new IndexOutOfBoundsException("X cannot be greater then 1");
        };
    }
}
