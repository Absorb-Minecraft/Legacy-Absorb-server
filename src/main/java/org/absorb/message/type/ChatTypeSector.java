package org.absorb.message.type;

import me.nullicorn.nedit.type.NBTCompound;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public interface ChatTypeSector {

    ChatParameter[] getParameters();

    String[] getTranslationKey();

    String getSectorName();

    Optional<NamedTextColor> getTextColour();

    Optional<TextDecoration> getTextStyle();

    default String getTranslationKeyString() {
        return String.join(".", this.getTranslationKey());
    }

    default NBTCompound asCompound() {
        Map<String, Object> compound = new NBTCompound();
        compound.put("translation_key", this.getTranslationKeyString());
        compound.put("parameters", Arrays.stream(this.getParameters()).map(par -> par.name().toLowerCase()).toList());

        Optional<NamedTextColor> opTextColour = this.getTextColour();
        Optional<TextDecoration> opTextDecoration = this.getTextStyle();
        if (opTextDecoration.isPresent() || opTextColour.isPresent()) {
            NBTCompound text = new NBTCompound();
            opTextColour.ifPresent(namedTextColor -> text.put("color", namedTextColor.toString()));
            opTextDecoration.ifPresent(decoration -> text.put(decoration.name(), Map.of("value", 1)));
            compound.put("style", text);
        }

        NBTCompound ret = new NBTCompound();
        ret.put(this.getSectorName().toLowerCase(), compound);
        return ret;
    }
}
