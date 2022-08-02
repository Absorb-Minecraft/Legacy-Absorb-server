package org.absorb.net.register;

import org.absorb.Main;
import org.absorb.block.type.BlockType;
import org.absorb.register.RegistryManager;
import org.absorb.register.registry.Registry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.jackson.JacksonConfigurationLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class BlockRegisterTests {

    public boolean canFindFile() {
        InputStream stream = Main.class.getResourceAsStream("/burger.json");
        if (stream != null) {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return stream != null;
    }


    @Test
    public void blockTypeIds() {
        Assumptions.assumeTrue(this.canFindFile());
        InputStream stream = Main.class.getResourceAsStream("/burger.json");
        if (stream == null) {
            throw new RuntimeException("Assume true passed when shouldn't");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        String line = br.lines().collect(Collectors.joining("\n"));
        ConfigurationNode rootNode;
        try {
            rootNode = JacksonConfigurationLoader.builder().buildAndLoadString(line);
        } catch (ConfigurateException e) {
            throw new RuntimeException(e);
        }


        Set<Registry<BlockType>> types = RegistryManager.getVanillaRegisters(BlockType.class);
        Assertions.assertFalse(types.isEmpty());


        ConfigurationNode blockNodes = rootNode.node(0, "blocks", "block");
        for (ConfigurationNode blockNode : blockNodes.childrenMap().values()) {
            int networkId = blockNode.node("numeric_id").getInt();
            String keyId = blockNode.node("text_id").getString("");

            Optional<BlockType> opBlock = types
                    .parallelStream()
                    .filter(type -> type.getResourceKey().value().equals(keyId))
                    .findAny()
                    .map(Supplier::get);

            if (opBlock.isEmpty()) {
                Assertions.fail("Could not find block: " + keyId);
                continue;
            }

            if (networkId != opBlock.get().getNetworkId()) {
                Assertions.fail(
                        "Network Id did not match for block: " + keyId + "[Json: " + networkId + " vs Block: " + opBlock
                                .get()
                                .getNetworkId() + "]");
            }

        }

    }

}
