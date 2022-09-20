package org.absorb.message.type;

import me.nullicorn.nedit.type.NBTCompound;
import org.absorb.register.AbsorbKey;

import java.util.Arrays;
import java.util.Map;

public interface ChatType {

    AbsorbKey getName();

    ChatTypeSector[] getSectors();

    int getId();

    default NBTCompound asCompound() {
        NBTCompound compound = new NBTCompound();

        compound.put("element", Arrays.stream(this.getSectors()).map(ChatTypeSector::asCompound).toList());
        compound.put("name", this.getName().value());
        compound.put("id", Map.of("value", this.getId()));
        
        return compound;
    }
}
