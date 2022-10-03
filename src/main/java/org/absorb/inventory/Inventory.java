package org.absorb.inventory;


import org.absorb.inventory.slot.Slot;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;

public interface Inventory {

	int getSize();

	Collection<Inventory> getChildren();

	Optional<Inventory> getParent();

	Collection<Slot> getImmediateSlots();

	Optional<InventoryType> getType();

	default Collection<Slot> getSlots() {
		Collection<Slot> slots = new HashSet<>();
		this.getChildren().forEach(inv -> {
			slots.addAll(inv.getSlots());
			if (inv instanceof Slot slot) {
				slots.add(slot);
			}
		});
		return Collections.unmodifiableCollection(slots);
	}

	default Slot getSlot(int index) {
		return this
				.getSlots()
				.parallelStream()
				.filter(slot -> slot.getIndex().isPresent())
				.filter(slot -> slot.getIndex().getAsInt() == index)
				.findAny()
				.orElseThrow(() -> new IndexOutOfBoundsException(
						"No slot with index of '" + index + "' can be found in this inventory"));
	}


}
