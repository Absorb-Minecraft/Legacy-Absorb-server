package org.absorb.inventory.action.click;

import org.absorb.utils.Builder;
import org.jetbrains.annotations.NotNull;

public class ClickButtonBuilder implements Builder<AbstractClickButton> {

    private String name;
    private int networkId;
    private ClickSlotType clickSlotType;

    public ClickSlotType getClickSlotType() {
        return this.clickSlotType;
    }

    public ClickButtonBuilder setClickSlotType(ClickSlotType clickSlotType) {
        this.clickSlotType = clickSlotType;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public ClickButtonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public int getNetworkId() {
        return this.networkId;
    }

    public ClickButtonBuilder setNetworkId(int networkId) {
        this.networkId = networkId;
        return this;
    }

    @Override
    public @NotNull AbstractClickButton build() {
        return new AbstractClickButton(this);
    }

    @Override
    public @NotNull Builder<AbstractClickButton> reset() {
        this.name = null;
        this.networkId = 0;
        return this;
    }

    @Override
    public @NotNull Builder<AbstractClickButton> copy() {
        return new ClickButtonBuilder().setName(this.name).setNetworkId(this.networkId);
    }
}
