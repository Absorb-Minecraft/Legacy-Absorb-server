package org.absorb;

import org.absorb.net.NetManager;
import org.absorb.register.RegistryManager;
import org.absorb.world.AbsorbWorldManager;

public class AbsorbManagers {

    public static AbsorbManagers instance;

    private final NetManager netManager;
    private final RegistryManager registryManager;
    private final AbsorbWorldManager worldManager;

    public AbsorbManagers(NetManager netManager, RegistryManager registryManager,
                          AbsorbWorldManager worldManager) {
        this.netManager = netManager;
        this.registryManager = registryManager;
        this.worldManager = worldManager;
    }

    public static AbsorbWorldManager getWorldManager() {
        return instance.worldManager;
    }

    public static NetManager getNetManager() {
        return instance.netManager;
    }

    public static RegistryManager getRegistryManager() {
        return instance.registryManager;
    }
}
