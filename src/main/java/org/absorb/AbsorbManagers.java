package org.absorb;

import org.absorb.event.EventManager;
import org.absorb.module.ModuleManager;
import org.absorb.net.NetManager;
import org.absorb.register.RegistryManager;
import org.absorb.world.AbsorbWorldManager;

public class AbsorbManagers {

    public static AbsorbManagers instance;

    private final NetManager netManager;
    private final RegistryManager registryManager;
    private final AbsorbWorldManager worldManager;
    private final EventManager eventManager;
    private final ModuleManager moduleManager;

    public AbsorbManagers(NetManager netManager, RegistryManager registryManager,
                          AbsorbWorldManager worldManager, EventManager eventManager, ModuleManager moduleManager) {
        this.netManager = netManager;
        this.registryManager = registryManager;
        this.worldManager = worldManager;
        this.eventManager = eventManager;
        this.moduleManager = moduleManager;
    }

    public static EventManager getEventManager() {
        return instance.eventManager;
    }

    public static ModuleManager getModuleManager() {
        return instance.moduleManager;
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
