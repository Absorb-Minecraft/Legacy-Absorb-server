package org.absorb.block.type;

import org.absorb.block.temp.Air;
import org.absorb.block.temp.Bedrock;
import org.absorb.register.registry.FileRegistry;
import org.jetbrains.annotations.NotNull;

public class BlockTypeRegistry extends FileRegistry<AbsorbBlockType> {

    public BlockTypeRegistry(@NotNull String host, @NotNull String key, @NotNull String name) {
        super(host, key, name);
    }

    @Override
    protected AbsorbBlockType getSingleton() {
        //TODO - remove to just file
        if (this.getKey().equals("bedrock")) {
            return Bedrock.getType();
        }
        if (this.getKey().equals("air")) {
            return Air.getType();
        }
        return super.getSingleton();
    }
}
