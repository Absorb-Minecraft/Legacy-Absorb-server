package org.absorb.state.type.bool;

import org.absorb.state.AbsorbBooleanStateType;
import org.absorb.utils.Identifiable;

public class PoweredStateType implements AbsorbBooleanStateType {
    @Override
    public String getName() {
        return "Powered";
    }

    @Override
    public String getKey() {
        return "powered";
    }

    @Override
    public String getHost() {
        return Identifiable.MINECRAFT_HOST;
    }
}
