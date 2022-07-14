package org.absorb;

import com.simtechdata.waifupnp.UPnP;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.absorb.command.CommandManager;
import org.absorb.command.Commands;
import org.absorb.console.ConsoleSource;
import org.absorb.event.EventManager;
import org.absorb.files.ServerProperties;
import org.absorb.message.MessageManager;
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
import org.absorb.threaded.Awaitable;
import org.absorb.utils.Identifiable;
import org.absorb.world.World;
import org.absorb.world.WorldBuilder;
import org.absorb.world.WorldData;
import org.absorb.world.WorldManager;
import org.absorb.world.type.WorldTypes;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3i;

import java.io.*;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
    public static final String ARGUMENT_SELF_UPDATE = "-Self-Update";
    public static final ModuleVersion VERSION;

    static {
        LocalDateTime date = LocalDateTime.now(Clock.systemUTC());
        ModuleVersion version = new StandardVersion(date.getYear(),
                                                    date.getDayOfYear(),
                                                    date.get(ChronoField.SECOND_OF_DAY),
                                                    StandardVersion.DEV);

        InputStream stream = Main.class.getClassLoader().getResourceAsStream("META-INF/absorb_version.csv");
        if (stream != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            String line = reader.lines().collect(Collectors.joining(""));
            String[] split = line.split(",");
            if (split.length == 3) {
                version = new StandardVersion(Integer.parseInt(split[0]),
                                              Integer.parseInt(split[1]),
                                              Integer.parseInt(split[2]));
            } else {
                version = new StandardVersion(Integer.parseInt(split[1]),
                                              Integer.parseInt(split[2]),
                                              Integer.parseInt(split[3]),
                                              split[0]);
            }
        }

        VERSION = version;
    }

    public static void openUPnP(ServerSocket socket) {
        if (!AbsorbManagers.getProperties().isUsingPlugAndPlay()) {
            AbsorbManagers
                    .getConsole()
                    .sendMessage(Component.text(
                            "Starting network connection: Allowing from " + socket.getInetAddress().getHostAddress()
                                    + ":" + socket.getLocalPort()));
            return;
        }
        AbsorbManagers.getConsole().sendMessage(Component.text("uPnP opening port: " + socket.getLocalPort()));
        if (!UPnP.openPortTCP(socket.getLocalPort())) {
            AbsorbManagers
                    .getConsole()
                    .sendMessage(Component
                                         .text("uPnP failed to open port: " + socket.getLocalPort())
                                         .color(NamedTextColor.RED));

            return;
        }
        AbsorbManagers.getConsole().sendMessage(Component.text("uPnP opened port: " + socket.getLocalPort()));
        String external = UPnP.getExternalIP();
        AbsorbManagers
                .getConsole()
                .sendMessage(Component.text(
                        "Starting network connection: Allowing from " + external + ":" + socket.getLocalPort()));


    }

    public static void init(String[] args) throws IOException {
        IS_RUNNING = true;
        AbsorbManagers.instance = new AbsorbManagers();
        AbsorbManagers.instance.console = new ConsoleSource();

        ConsoleSource console = AbsorbManagers.getConsole();
        console.sendProgress(0, 5);
        AbsorbManagers.instance.messageManager = new MessageManager();
        AbsorbManagers.instance.registryManager = new RegistryManager();
        AbsorbManagers.instance.eventManager = new EventManager();
        AbsorbManagers.instance.moduleManager = new ModuleManager();
        AbsorbManagers.instance.scheduleManager = new ScheduleManager();
        AbsorbManagers.instance.channelManager = new ChannelManager();
        AbsorbManagers.instance.commandManager = new CommandManager();

        Commands.getAll();
        console.sendProgress(1, 5);

        AbsorbManagers.instance.properties = new ServerProperties();
        AbsorbManagers.instance.properties.updateFile();

        World world = loadDefaultWorld();
        AbsorbManagers.instance.worldManager = new WorldManager(world);

        console.sendMessage(Component.text("Loaded world: " + world.getWorldData().getKey().asFormatted()));
        console.sendProgress(1, 4);

        AbsorbModuleLoader absorbModuleLoader = ModuleLoaders.ABSORB_MODULE;
        if (!AbsorbModuleLoader.MODULE_FOLDER.exists()) {
            AbsorbModuleLoader.MODULE_FOLDER.mkdirs();
        }
        @NotNull Collection<File> canLoad = absorbModuleLoader.getCanLoad();
        console.sendMessage(Component.text("Found " + canLoad.size() + " compatible files"));
        console.sendProgress(2, 4);

        Set<AbsorbModule> loaded = canLoad.parallelStream().flatMap(load -> {
            try {
                return absorbModuleLoader.create(load).parallelStream();
            } catch (IOException e) {
                e.printStackTrace();
                //noinspection ReturnOfNull
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toSet());
        console.sendProgress(3, 4);

        loaded.parallelStream().forEach(module -> {
            try {
                absorbModuleLoader.load(module);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        InetAddress address = AbsorbManagers.getProperties().getIpAddress().orElse(null);
        int port = AbsorbManagers.getProperties().getPort();
        ServerSocket socket;
        try {
            socket = new ServerSocket(port, -1, address);
        } catch (BindException e) {
            console.sendMessage(Component
                                        .text("This is typically caused due to another program using the port "
                                                      + "specified. Either close the program using the port (check for other servers) or change the port"
                                                      + " number")
                                        .color(NamedTextColor.RED));
            throw e;
        }

        new Thread(() -> openUPnP(socket)).start();

        NetHandler handler = new NetHandler(socket);
        AbsorbManagers.instance.netManager = new NetManager(handler);

        AbsorbManagers.getConsole().runCommandRunner();
        new Awaitable<>(() -> AbsorbManagers.getRegistryManager().isReady(), true).await();
        console.sendMessage(Component.text("Ready to accept players").color(NamedTextColor.GREEN));
        handler.start();
        startScheduler();
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
        if (AbsorbManagers.getProperties().isUsingPlugAndPlay()) {
            int port = AbsorbManagers.getProperties().getPort();
            AbsorbManagers.getConsole().sendMessage(Component.text("uPnP closing port: " + port));
            if (UPnP.openPortTCP(port)) {
                AbsorbManagers.getConsole().sendMessage(Component.text("uPnP closed port: " + port));
            } else {
                AbsorbManagers
                        .getConsole()
                        .sendMessage(Component.text("uPnP failed to close port: " + port).color(NamedTextColor.RED));
            }
        }
        while (true) {
            LocalTime time = LocalTime.now();
            if (time.isAfter(exitAt)) {
                break;
            }
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        for (String arg : args) {
            if (arg.equalsIgnoreCase(ARGUMENT_SELF_UPDATE)) {
                runUpdateCommand(args);
                return;
            }
        }

        File updateFile = new File("Updates/Absorb.jar");
        if (updateFile.exists() && updateFile.canExecute()) {
            try {
                Runtime.getRuntime().exec("java -jar " + updateFile.getPath());
                return;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


        try {
            init(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static World loadDefaultWorld() {
        return new WorldBuilder()
                .setBlockMax(new Vector3i(600, 20, 600))
                .setBlockMin(new Vector3i(-200, 0, -200))
                .setWorldData(new WorldData()
                                      .setType(WorldTypes.FLAT)
                                      .setSeed(0)
                                      .setKey(new AbsorbKey(Identifiable.MINECRAFT_HOST, "temp")))
                .build();
    }

    private static void startScheduler() {
        RegistryManager
                .getVanillaValues(Schedule.class)
                .parallelStream()
                .forEach(schedule -> AbsorbManagers.instance.scheduleManager.register(schedule));
        AbsorbManagers.getScheduleManager().runSchedulers();
    }

    private static void runUpdateCommand(String... args) {
        String[] argsWithoutUpdate = new String[args.length - 1];
        boolean pastUpdate = false;
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            if (arg.equalsIgnoreCase(ARGUMENT_SELF_UPDATE)) {
                pastUpdate = true;
                continue;
            }
            int a = pastUpdate ? i - 1 : i;
            argsWithoutUpdate[a] = arg;
        }

        URL url = Main.class.getProtectionDomain().getCodeSource().getLocation();
        File file = new File(url.getFile());
        if (!file.getParentFile().getName().equalsIgnoreCase("Update")) {
            throw new RuntimeException("Cannot self update (Updated file cannot find its own location)");
        }
        File[] files = file
                .getParentFile()
                .listFiles((file1, s) -> s.toLowerCase().startsWith("absorb") && s.toLowerCase().endsWith(".jar"));
        if (files == null || files.length != 1) {
            throw new RuntimeException("Cannot self update (Cannot find the file to update)");
        }

        File oldVersion = files[0];

        try {
            Files.copy(file.toPath(), oldVersion.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        oldVersion.setExecutable(true);
        file.deleteOnExit();

        System.out.println("Absorb updated, can run again (press the up key and then enter)");
        System.exit(0);
    }
}
