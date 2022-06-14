package org.absorb.entity.living.human;

import net.kyori.adventure.text.Component;
import org.absorb.entity.EntityTypes;
import org.absorb.entity.living.AbstractLivingEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class Human extends AbstractLivingEntity {

    private @NotNull Gamemode gamemode = Gamemodes.CREATIVE;
    private @Nullable Component tabDisplayName;
    private Boolean isFlyingAllowed;

    public Human() {
        super(EntityTypes.HUMAN);
    }

    public Optional<Component> getTabName() {
        return Optional.ofNullable(this.tabDisplayName);
    }

    public void setTabDisplayName(@Nullable Component component) {
        this.tabDisplayName = component;
    }

    public @NotNull Gamemode getGamemode() {
        return this.gamemode;
    }

    public boolean isFlyingAllowed() {
        if (this.isFlyingAllowed==null) {
            if (this.gamemode==Gamemodes.CREATIVE) {
                return true;
            }
            return false;
        }
        return this.isFlyingAllowed;
    }

    public void setFlyingAllowed(boolean check) {
        this.isFlyingAllowed = check;
    }

    public void setGamemodeFlyingRequirements() {
        this.isFlyingAllowed = null;
    }

    public void setGamemode(@NotNull Gamemode mode) {
        this.gamemode = mode;
    }

}
