package org.absorb;

import org.absorb.event.EventManager;
import org.absorb.files.ServerProperties;
import org.absorb.module.ModuleManager;
import org.absorb.net.NetManager;
import org.absorb.register.RegistryManager;
import org.absorb.schedule.ScheduleManager;
import org.absorb.world.AbsorbWorldManager;
import org.jetbrains.annotations.Nullable;

public class AbsorbManagers {

    public static AbsorbManagers instance;

    NetManager netManager;
    RegistryManager registryManager;
    AbsorbWorldManager worldManager;
    EventManager eventManager;
    ModuleManager moduleManager;
    ServerProperties properties;
    ScheduleManager scheduleManager;

    public static ServerProperties getProperties(){
        return instance.properties;
    }

    public static EventManager getEventManager() {
        return get(instance.eventManager);
    }

    public static ModuleManager getModuleManager() {
        return get(instance.moduleManager);
    }

    public static AbsorbWorldManager getWorldManager() {
        return get(instance.worldManager);
    }

    public static NetManager getNetManager() {
        return get(instance.netManager);
    }

    public static RegistryManager getRegistryManager() {
        return get(instance.registryManager);
    }

    public static ScheduleManager getScheduleManager() {
        return get(instance.scheduleManager);
    }

    private static <T> T get(@Nullable T value) {
        if (value==null) {
            throw new RuntimeException("Manager has not booted yet");
        }
        return value;
    }
}
