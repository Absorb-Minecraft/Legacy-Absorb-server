package org.absorb;

import org.absorb.files.ServerProperties;
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
import org.spongepowered.math.vector.Vector3i;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    private static AbsorbWorld createTestWorld() {
        return new AbsorbWorldBuilder().setWorldData(new AbsorbWorldData()).setBlockMin(new Vector3i(0, 0, 0)).setBlockMax(new Vector3i(16 * 20, 255, 16 * 20)).build();
    }

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


        //ServerSocket socket = new ServerSocket(properties.getPort(), 0, properties.getIpAddress());


        ServerSocket socket = new ServerSocket(properties.getPort());

        NetHandler handler = new NetHandler(socket);
        NetManager netManager = new NetManager(handler);
        RegistryManager registryManager = new RegistryManager();

        AbsorbWorldManager worldManager = new AbsorbWorldManager(world);


        //Guice.createInjector(new SpongeInjector());
        AbsorbManagers.instance = new AbsorbManagers(netManager, registryManager, worldManager);

        /*WorldManager worldManager = Sponge.server().worldManager();
        if(worldManager instanceof AbsorbWorldManager manager){
            AbsorbWorld world = createTestWorld();
            manager.setDefaultWorld(world);
        }*/


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
