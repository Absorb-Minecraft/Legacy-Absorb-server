package org.absorb.inventory.action;

import org.absorb.inventory.action.click.ClickButton;

import java.util.Arrays;
import java.util.Collection;

public class AbstractInventoryAction implements InventoryAction {

    private final int id;
    private final Collection<ClickButton> acceptableButtons;

    AbstractInventoryAction(int id, ClickButton... buttons) {
        this.id = id;
        this.acceptableButtons = Arrays.asList(buttons);
    }

    @Override
    public Collection<ClickButton> getAcceptableClicks() {
        return this.acceptableButtons;
    }

    @Override
    public int getNetworkId() {
        return this.id;
    }
}
