package org.absorb.files;

import org.absorb.files.json.DefaultNode;
import org.absorb.files.json.SimpleDefaultNode;
import org.spongepowered.configurate.CommentedConfigurationNode;
import org.spongepowered.configurate.serialize.SerializationException;
import org.spongepowered.configurate.yaml.NodeStyle;
import org.spongepowered.configurate.yaml.YamlConfigurationLoader;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.util.Arrays;

public class ServerProperties {

    private final SimpleDefaultNode<InetAddress> ipAddress = new SimpleDefaultNode<InetAddress>(
            "The IPAddress to bind to. This can either be a IPv4, IPv6 or a hostname"
                    + ". Leave blank to use this computers",
            InetAddress.class,
            value -> {
                String stringValue = value.getString();
                if (stringValue == null) {
                    throw new SerializationException("Cannot find value");
                }
                try {
                    return InetAddress.getByName(stringValue);
                } catch (UnknownHostException e) {
                    throw new SerializationException(e);
                }
            },
            (node, value) -> {
                try {
                    if (value.equals(InetAddress.getLocalHost())) {
                        return;
                    }
                } catch (UnknownHostException e) {
                    throw new RuntimeException(e);
                }
                node.set(value.getHostAddress());
            },
            () -> {
                try {
                    return InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    throw new RuntimeException(e);
                }
            },
            "Network",
            "IPAddress");

    private final DefaultNode<Integer> port = SimpleDefaultNode.asInt(
            "This must be above the number 0 and a whole number. The port number allows you to run multiple "
                    + "servers on the same computer whereby to join a specified server, you include the port "
                    + "number after the IP/Hostname such as 'localhost:25555'",
            25565,
            "Network",
            "Port");

    private final DefaultNode<Boolean> usePlugAndPlay = SimpleDefaultNode.asBoolean(
            "uPnP (Universal Plug and Play) is a feature that will port forward this server"
                    + " for you, as well as close the port when you're done. Please note that "
                    + "uPnP is only supported by some routers and is typically disabled "
                    + "by default for security reasons (any program on your network (Wi-Fi,"
                    + " ethernet, etc) can open a port and then let anything in). While the "
                    + "security risk is on the routers side and not on the servers side, we "
                    + "have disabled it by default for peace of mind. While we recommend manually "
                    + "port forwarding, this option is here for those who can't port forward, those who trust every "
                    + "program on the network or really don't care about the security risk of having it enabled on the router.",
            false,
            "Network",
            "uPnP");
    private final DefaultNode<Integer> ticksPerSecond = SimpleDefaultNode.asInt(
            "The amount of Minecraft ticks per second. This is typically 20, however you can "
                    + "increase this to increase the game speed or decrease it to slow down the"
                    + " game speed. Please note unlike vanilla Minecraft whereby if the tick"
                    + " speed goes below 20, Player's start to lag, Absorb does not connect the "
                    + "players to tick speed, meaning that lowering this will only change the games speed",
            20,
            "Game",
            "Ticks",
            "PerSecond");

    private final YamlConfigurationLoader loader;
    private final CommentedConfigurationNode rootNode;

    public static final File SERVER_PROPERTIES_FILE = new File("properties.yml");

    public ServerProperties() throws IOException {
        if (!SERVER_PROPERTIES_FILE.exists()) {
            Files.createFile(SERVER_PROPERTIES_FILE.toPath());
        }
        this.loader = YamlConfigurationLoader
                .builder()
                .file(SERVER_PROPERTIES_FILE)
                .nodeStyle(NodeStyle.BLOCK)
                .indent(2)
                .build();
        this.rootNode = this.loader.load();
    }

    public void updateFile() throws IOException {
        Arrays
                .stream(ServerProperties.class.getDeclaredFields())
                .parallel()
                .filter(field -> Modifier.isFinal(field.getModifiers()))
                .filter(field -> Modifier.isPrivate(field.getModifiers()))
                .filter(field -> field.getType().isAssignableFrom(SimpleDefaultNode.class))
                .map(field -> {
                    try {
                        return (SimpleDefaultNode<?>) field.get(this);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                })
                .forEach(node -> {
                    CommentedConfigurationNode valueNode = this.rootNode.node(node.getNodePath());
                    if (valueNode.empty()) {
                        try {
                            node.setDefault(this.rootNode);
                        } catch (SerializationException e) {
                            e.printStackTrace();
                        }
                    }
                    if (!valueNode.empty()) {
                        valueNode.comment(node.getComment());
                    }
                });

        this.loader.save(this.rootNode);
    }

    public InetAddress getIpAddress() {
        return this.ipAddress.getValueOrElse(this.rootNode);
    }

    public boolean isUsingPlugAndPlay() {
        return this.usePlugAndPlay.getValueOrElse(this.rootNode);

    }

    public int getPort() {
        return this.port.getValueOrElse(this.rootNode);
    }

    public long getNanoPerTick() {
        return 1000000000L / this.getTicksPerSecond();
    }

    public int getTicksPerSecond() {
        return this.ticksPerSecond.getValueOrElse(this.rootNode);
    }
}
