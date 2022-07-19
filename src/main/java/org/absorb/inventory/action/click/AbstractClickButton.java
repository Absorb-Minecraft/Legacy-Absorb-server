package org.absorb.inventory.action.click;

import org.jetbrains.annotations.NotNull;

public class AbstractClickButton implements ClickButton {

    private final @NotNull String name;
    private final int networkId;
    private final @NotNull ClickSlotType clickSlotType;

    AbstractClickButton(ClickButtonBuilder builder) {
        this.networkId = builder.getNetworkId();
        this.name = builder.getName();
        this.clickSlotType = builder.getClickSlotType();
    }

    @Override
    public @NotNull String getName() {
        return this.name;
    }

    @Override
    public int getNetworkId() {
        return this.networkId;
    }

    @Override
    public @NotNull ClickSlotType getType() {
        return this.clickSlotType;
    }
}
