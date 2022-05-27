package org.absorb;

import org.absorb.event.EventManager;
import org.absorb.files.ServerProperties;
import org.absorb.module.Module;
import org.absorb.module.ModuleManager;
import org.absorb.module.loader.ModuleLoaders;
import org.absorb.module.loader.absorb.AbsorbModule;
import org.absorb.module.loader.absorb.AbsorbModuleLoader;
import org.absorb.net.NetManager;
import org.absorb.net.handler.NetHandler;
import org.absorb.register.AbsorbKey;
import org.absorb.register.RegistryManager;
import org.absorb.utils.Identifiable;
import org.absorb.world.AbsorbWorld;
import org.absorb.world.AbsorbWorldBuilder;
import org.absorb.world.AbsorbWorldData;
import org.absorb.world.AbsorbWorldManager;
import org.absorb.world.type.WorldTypes;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.math.vector.Vector3i;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void init() throws IOException {
        ServerProperties properties = new ServerProperties();
        AbsorbWorld world =
                new AbsorbWorldBuilder()
                        .setBlockMax(new Vector3i(600, 20, 600))
                        .setBlockMin(new Vector3i(-200, 0, -200))
                        .setWorldData(new AbsorbWorldData()
                                .setType(WorldTypes.OVERWORLD)
                                .setSeed(0)
                                .setKey(new AbsorbKey(Identifiable.MINECRAFT_HOST, "temp")))
                        .build();
        RegistryManager registryManager = new RegistryManager();
        AbsorbWorldManager worldManager = new AbsorbWorldManager(world);
        System.out.println("Loaded world: " + world.getWorldData().getKey().asFormatted());
        EventManager eventManager = new EventManager();
        ModuleManager moduleManager = new ModuleManager();
        AbsorbModuleLoader absorbModuleLoader = ModuleLoaders.ABSORB_MODULE;
        if(!AbsorbModuleLoader.MODULE_FOLDER.exists()){
            AbsorbModuleLoader.MODULE_FOLDER.mkdirs();
        }
        @NotNull Collection<File> canLoad = absorbModuleLoader.getCanLoad();
        System.out.println("Found " + canLoad.size() + " compatible files");
        Set<AbsorbModule> loaded = canLoad.parallelStream().map(load -> {
            try {
                return absorbModuleLoader.create(load);
            } catch (IOException e) {
                e.printStackTrace();
                //noinspection ReturnOfNull
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toSet());
        System.out.println("Loading modules");
        loaded.parallelStream().forEach(module -> {
            try {
                System.out.println("Loading " + module.getDisplayName() + " Version: " + module.getVersion());
                absorbModuleLoader.load(module);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        ServerSocket socket = new ServerSocket(properties.getPort());

        NetHandler handler = new NetHandler(socket);
        NetManager netManager = new NetManager(handler);

        AbsorbManagers.instance = new AbsorbManagers(netManager, registryManager, worldManager, eventManager, moduleManager);

        System.out.println("Ready to accept players");
        handler.start();
    }

    public static void main(String[] args) {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
