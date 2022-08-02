package org.absorb.inventory.action;

import org.absorb.inventory.action.click.ClickButton;

import java.util.Collection;

public interface InventoryAction {

    Collection<ClickButton> getAcceptableClicks();

    int getNetworkId();

}
