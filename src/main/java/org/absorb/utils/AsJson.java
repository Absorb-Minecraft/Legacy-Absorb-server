package org.absorb.utils;

import me.nullicorn.nedit.type.NBTCompound;
import me.nullicorn.nedit.type.NBTList;
import me.nullicorn.nedit.type.TagType;
import org.spongepowered.configurate.ConfigurateException;
import org.spongepowered.configurate.ConfigurationNode;
import org.spongepowered.configurate.jackson.JacksonConfigurationLoader;

import java.util.*;

public class AsJson {

    private static String indent(int amount) {
        StringBuilder builder = new StringBuilder();
        for (int a = 0; a < amount; a++) {
            builder.append("\t");
        }
        return builder.toString();
    }

    public static String asTypedJson(NBTCompound compound) {
        Set<Map.Entry<String, Object>> set = compound.entrySet();

        String result = "NBTFile: {" + set.size() + " Entries}\n{";
        int indent = 1;
        for (Map.Entry<String, Object> entry : set) {
            List<Map.Entry<Integer, String>> typed = asTypedJson(entry.getKey(), entry.getValue());
            for (Map.Entry<Integer, String> entry2 : typed) {
                result = result + "\n" + indent(indent + entry2.getKey()) + entry2.getValue();
            }
        }
        result = result + "\n}";
        return result;
    }

    private static List<Map.Entry<Integer, String>> asTypedJson(String key, Object value) {
        return asTypedJsonUnformatted("('" + key + "')", value);
    }

    private static String formatType(String type) {
        if (type.isBlank()) {
            return "";
        }
        return type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase();
    }

    private static List<Map.Entry<Integer, String>> asTypedJsonUnformatted(String key, Object value) {
        if (value instanceof NBTList list) {
            List<Map.Entry<Integer, String>> map = new ArrayList<>();
            map.add(new AbstractMap.SimpleImmutableEntry<>(0,
                    "TAG_List" + key + ": [" + list.size() + " TAG_" + formatType(list.getContentType().name()) +
                            "(s)]"));
            map.add(new AbstractMap.SimpleImmutableEntry<>(0, "{"));
            for (int a = 0; a < list.size(); a++) {
                List<Map.Entry<Integer, String>> result = asTypedJsonUnformatted("", list.get(a));
                result.forEach(entry2 -> map.add(new AbstractMap.SimpleImmutableEntry<>(entry2.getKey() + 1,
                        entry2.getValue())));
            }
            map.add(new AbstractMap.SimpleImmutableEntry<>(0, "}"));
            return map;
        }

        if (value instanceof NBTCompound compound) {
            List<Map.Entry<Integer, String>> map = new ArrayList<>();
            map.add(new AbstractMap.SimpleImmutableEntry<>(0, "TAG_Compound" + key + ": {" + compound.size() +
                    " Entries}"));
            map.add(new AbstractMap.SimpleImmutableEntry<>(0, "{"));
            for (Map.Entry<String, Object> entry : compound.entrySet()) {
                List<Map.Entry<Integer, String>> typed = asTypedJson(entry.getKey(), entry.getValue());
                typed.forEach(entry2 -> map.add(new AbstractMap.SimpleImmutableEntry<>(entry2.getKey() + 1,
                        entry2.getValue())));
            }
            map.add(new AbstractMap.SimpleImmutableEntry<>(0, "}"));
            return map;
        }
        String type = formatType(TagType.fromObject(value).name());


        return List.of(new AbstractMap.SimpleImmutableEntry<>(0,
                "TAG_" + type + key + ": " + value.toString()));
    }

    public static ConfigurationNode asJsonNode(NBTCompound compound) throws ConfigurateException {
        JacksonConfigurationLoader loader = JacksonConfigurationLoader.builder().build();
        ConfigurationNode node = loader.createNode();
        for (Map.Entry<String, Object> entry : compound.entrySet()) {
            ConfigurationNode childNode = node.node(entry.getKey());
            addTo(childNode, entry.getValue());
        }
        return node;
    }

    private static void addTo(ConfigurationNode node, Object obj) throws ConfigurateException {
        if (obj instanceof NBTCompound nbtCompound) {
            ConfigurationNode parsed = asJsonNode(nbtCompound);
            node.set(parsed);
            return;
        }
        if (obj instanceof NBTList list) {
            for (Object element : list) {
                ConfigurationNode appendNode = node.appendListNode();
                if (element instanceof NBTCompound) {
                    addTo(appendNode, element);
                    continue;
                }
                if (element instanceof NBTList) {
                    addTo(appendNode, element);
                    continue;
                }
                appendNode.set(element);
            }
            return;
        }
        node.set(obj);
    }

    public static String asJson(NBTCompound compound) throws ConfigurateException {
        return JacksonConfigurationLoader.builder().buildAndSaveString(asJsonNode(compound));
    }
}
