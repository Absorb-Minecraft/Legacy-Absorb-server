package org.absorb.inventory.action.click;

import org.absorb.inventory.slot.Slot;

import java.util.OptionalInt;
import java.util.function.Predicate;

public enum ClickSlotType {

    REQUIRED_SLOT(s -> s > 0),
    OUTSIDE_SLOT(s -> s == -999),
    NEVER(s -> true);

    private final Predicate<Short> slotCheck;

    ClickSlotType(Predicate<Short> predicate) {
        this.slotCheck = predicate;
    }

    public boolean isAcceptable(Slot slot) {
        OptionalInt opIndex = slot.getIndex();
        if (opIndex.isPresent()) {
            return this.isAcceptable((short) opIndex.getAsInt());
        }
        return false;
    }

    public boolean isAcceptable(short slotId) {
        return this.slotCheck.test(slotId);
    }
}
