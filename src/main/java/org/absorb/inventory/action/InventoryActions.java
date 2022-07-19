package org.absorb.inventory.action;

import org.absorb.inventory.action.click.ClickButtons;

public interface InventoryActions {

    InventoryAction STANDARD = new AbstractInventoryAction(0,
                                                           ClickButtons.LEFT,
                                                           ClickButtons.RIGHT,
                                                           ClickButtons.LEFT_OUTSIDE,
                                                           ClickButtons.RIGHT_OUTSIDE);
    InventoryAction SHIFT = new AbstractInventoryAction(1, ClickButtons.SHIFT_LEFT, ClickButtons.SHIFT_RIGHT);
    InventoryAction NUMPAD = new AbstractInventoryAction(2,
                                                         ClickButtons.NUMPAD_1,
                                                         ClickButtons.NUMPAD_2,
                                                         ClickButtons.NUMPAD_3,
                                                         ClickButtons.NUMPAD_4,
                                                         ClickButtons.NUMPAD_5,
                                                         ClickButtons.NUMPAD_6,
                                                         ClickButtons.NUMPAD_7,
                                                         ClickButtons.NUMPAD_8,
                                                         ClickButtons.NUMPAD_9,
                                                         ClickButtons.OFFHAND);
    InventoryAction MIDDLE = new AbstractInventoryAction(3, ClickButtons.MIDDLE);
    InventoryAction DROP = new AbstractInventoryAction(4, ClickButtons.DROP, ClickButtons.DROP_CTRL);
    InventoryAction DRAG = new AbstractInventoryAction(5,
                                                       ClickButtons.ADD_LEFT_DRAG,
                                                       ClickButtons.ADD_RIGHT_DRAG,
                                                       ClickButtons.ADD_MIDDLE_DRAG,
                                                       ClickButtons.START_LEFT_DRAG,
                                                       ClickButtons.START_RIGHT_DRAG,
                                                       ClickButtons.START_MIDDLE_DRAG,
                                                       ClickButtons.END_LEFT_DRAG,
                                                       ClickButtons.END_RIGHT_DRAG,
                                                       ClickButtons.END_MIDDLE_DRAG);
    InventoryAction DOUBLE = new AbstractInventoryAction(6, ClickButtons.DOUBLE);

}
