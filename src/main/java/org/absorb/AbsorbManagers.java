package org.absorb;

import org.absorb.command.CommandManager;
import org.absorb.console.ConsoleSource;
import org.absorb.event.EventManager;
import org.absorb.files.ServerProperties;
import org.absorb.message.MessageManager;
import org.absorb.message.channel.ChannelManager;
import org.absorb.module.ModuleManager;
import org.absorb.net.NetManager;
import org.absorb.register.RegistryManager;
import org.absorb.schedule.ScheduleManager;
import org.absorb.world.WorldManager;
import org.jetbrains.annotations.Nullable;

public class AbsorbManagers {

    ConsoleSource console;
    NetManager netManager;
    MessageManager messageManager;
    RegistryManager registryManager;
    WorldManager worldManager;
    EventManager eventManager;
    ModuleManager moduleManager;
    ServerProperties properties;
    ScheduleManager scheduleManager;
    ChannelManager channelManager;
    CommandManager commandManager;
    public static AbsorbManagers instance;

    public static MessageManager getMessageManager() {
        return get(instance.messageManager);
    }

    public static CommandManager getCommandManager() {
        return get(instance.commandManager);
    }

    public static ConsoleSource getConsole() {
        return get(instance.console);
    }

    public static ChannelManager getChannelManager() {
        return get(instance.channelManager);
    }

    public static ServerProperties getProperties() {
        return instance.properties;
    }

    public static EventManager getEventManager() {
        return get(instance.eventManager);
    }

    public static ModuleManager getModuleManager() {
        return get(instance.moduleManager);
    }

    public static WorldManager getWorldManager() {
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
        if (value == null) {
            throw new RuntimeException("Manager has not booted yet");
        }
        return value;
    }
}
