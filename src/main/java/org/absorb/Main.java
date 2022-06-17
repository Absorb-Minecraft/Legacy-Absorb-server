package org.absorb;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.absorb.command.CommandManager;
import org.absorb.command.Commands;
import org.absorb.console.ConsoleSource;
import org.absorb.event.EventManager;
import org.absorb.files.ServerProperties;
import org.absorb.message.channel.ChannelManager;
import org.absorb.module.ModuleManager;
import org.absorb.module.loader.ModuleLoaders;
import org.absorb.module.loader.absorb.AbsorbModule;
import org.absorb.module.loader.absorb.AbsorbModuleLoader;
import org.absorb.module.version.ModuleVersion;
import org.absorb.module.version.StandardVersion;
import org.absorb.net.Client;
import org.absorb.net.NetManager;
import org.absorb.net.handler.NetHandler;
import org.absorb.register.AbsorbKey;
import org.absorb.register.RegistryManager;
import org.absorb.schedule.Schedule;
import org.absorb.schedule.ScheduleManager;
import org.absorb.utils.Identifiable;
import org.absorb.world.AbsorbWorld;
import org.absorb.world.AbsorbWorldBuilder;
import org.absorb.world.AbsorbWorldData;
import org.absorb.world.AbsorbWorldManager;
import org.absorb.world.type.WorldTypes;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3i;

import java.io.*;
import java.net.ServerSocket;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static boolean IS_RUNNING;
    public static final ModuleVersion VERSION;

    static {
        LocalDateTime date = LocalDateTime.now(Clock.systemUTC());
        ModuleVersion version = new StandardVersion(date.getYear(), date.getDayOfYear(),
                date.get(ChronoField.SECOND_OF_DAY), StandardVersion.DEV);

        InputStream stream = Main.class.getClassLoader().getResourceAsStream("META-INF/absorb_version.csv");
        if (stream!=null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String line = reader.lines().collect(Collectors.joining(""));
            String[] split = line.split(",");
            if (split.length==3) {
                version = new StandardVersion(Integer.parseInt(split[0]), Integer.parseInt(split[1]),
                        Integer.parseInt(split[2]));
            } else {
                version = new StandardVersion(Integer.parseInt(split[1]), Integer.parseInt(split[2]),
                        Integer.parseInt(split[3]), split[0]);
            }
        }

        VERSION = version;
    }

    public static void init(String[] args) throws IOException {
        IS_RUNNING = true;
        AbsorbManagers.instance = new AbsorbManagers();
        AbsorbManagers.instance.console = new ConsoleSource();
        AbsorbManagers.getConsole().sendProgress(0, 5);
        AbsorbManagers.instance.registryManager = new RegistryManager();
        AbsorbManagers.instance.eventManager = new EventManager();
        AbsorbManagers.instance.moduleManager = new ModuleManager();
        AbsorbManagers.instance.scheduleManager = new ScheduleManager();
        AbsorbManagers.instance.channelManager = new ChannelManager();
        AbsorbManagers.instance.commandManager = new CommandManager();

        Commands.getAll();
        AbsorbManagers.getConsole().sendProgress(1, 5);


        AbsorbManagers.instance.properties = new ServerProperties();
        AbsorbWorld world =
                new AbsorbWorldBuilder()
                        .setBlockMax(new Vector3i(600, 20, 600))
                        .setBlockMin(new Vector3i(-200, 0, -200))
                        .setWorldData(new AbsorbWorldData()
                                .setType(WorldTypes.OVERWORLD)
                                .setSeed(0)
                                .setKey(new AbsorbKey(Identifiable.MINECRAFT_HOST, "temp")))
                        .build();
        AbsorbManagers.instance.worldManager = new AbsorbWorldManager(world);

        AbsorbManagers.getConsole().sendMessage(Component.text("Loaded world: " + world.getWorldData().getKey().asFormatted()));
        AbsorbManagers.getConsole().sendProgress(1, 4);

        AbsorbModuleLoader absorbModuleLoader = ModuleLoaders.ABSORB_MODULE;
        if (!AbsorbModuleLoader.MODULE_FOLDER.exists()) {
            AbsorbModuleLoader.MODULE_FOLDER.mkdirs();
        }
        @NotNull Collection<File> canLoad = absorbModuleLoader.getCanLoad();
        AbsorbManagers.getConsole().sendMessage(Component.text("Found " + canLoad.size() + " compatible files"));
        AbsorbManagers.getConsole().sendProgress(2, 4);

        Set<AbsorbModule> loaded = canLoad.parallelStream().flatMap(load -> {
            try {
                return absorbModuleLoader.create(load).parallelStream();
            } catch (IOException e) {
                e.printStackTrace();
                //noinspection ReturnOfNull
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toSet());
        AbsorbManagers.getConsole().sendProgress(3, 4);

        loaded.parallelStream().forEach(module -> {
            try {
                absorbModuleLoader.load(module);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        ServerSocket socket = new ServerSocket(AbsorbManagers.getProperties().getPort());

        NetHandler handler = new NetHandler(socket);
        AbsorbManagers.instance.netManager = new NetManager(handler);

        AbsorbManagers.getConsole().runCommandRunner();

        AbsorbManagers.getConsole().sendMessage(Component.text("Ready to accept players").color(NamedTextColor.GREEN));
        handler.start();
        RegistryManager.getVanillaValues(Schedule.class).parallelStream().forEach(schedule -> AbsorbManagers.instance.scheduleManager.register(schedule));
        AbsorbManagers.getScheduleManager().runSchedulers();
    }

    public static void stop() {
        stop(Component.text("Server is shutting down."));
    }

    public static void stop(@NotNull Component disconnectMessage) {
        stop(LocalTime.now().plus(1, ChronoUnit.MICROS), disconnectMessage);
    }

    public static void stop(@NotNull LocalTime exitAt, @NotNull Component disconnectMessage) {
        AbsorbManagers.getConsole().sendMessage(Component.text("stopping server: ").append(disconnectMessage));
        Collection<Client> clients = AbsorbManagers.getNetManager().getClients();
        AbsorbManagers.getConsole().sendMessage(Component.text("Disconnecting clients"));

        int i = 0;
        for (Client client : clients) {
            AbsorbManagers.getConsole().sendProgress(i, clients.size());
            client.disconnect(disconnectMessage);
            i++;
        }
        AbsorbManagers.getConsole().sendProgress(clients.size(), clients.size());


        Main.IS_RUNNING = false;
        AbsorbManagers.getConsole().sendMessage(Component.text("Shutting down network"));
        AbsorbManagers.getNetManager().getHandler().end();
        AbsorbManagers.getConsole().sendMessage(Component.text("Disconnecting threads"));
        while (true) {
            LocalTime time = LocalTime.now();
            if (time.isAfter(exitAt)) {
                break;
            }
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        try {
            init(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
