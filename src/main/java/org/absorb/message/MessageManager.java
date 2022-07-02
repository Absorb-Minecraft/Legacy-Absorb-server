package org.absorb.message;

import me.nullicorn.nedit.type.NBTCompound;
import me.nullicorn.nedit.type.NBTList;
import me.nullicorn.nedit.type.TagType;
import org.absorb.utils.AsJson;
import org.spongepowered.configurate.ConfigurateException;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MessageManager {

    //TODO -> do this correctly
    public Collection<NBTCompound> getAllChatTypes() {
        Collection<NBTCompound> collection = new LinkedList<>();

        //chat
        NBTCompound chatCompound = new NBTCompound();
        chatCompound.put("name", "minecraft:chat");
        chatCompound.put("id", 0);

        //chats section in chat
        Map<String, Object> chatChatCompound = new NBTCompound();

        //decoration for chat in the chat section
        Map<String, Object> chatChatDecoration = new NBTCompound();
        List<Object> parameterList = new NBTList(TagType.STRING);
        parameterList.addAll(List.of("sender", "content"));

        chatChatDecoration.put("parameters", parameterList);
        chatChatDecoration.put("style", "\\s");
        chatChatDecoration.put("translation_key", "chat.type.text");
        chatChatCompound.put("decoration", chatChatDecoration);

        chatCompound.put("chat", chatChatCompound);

        Map<String, Object> chatNarrationCompound = new NBTCompound();
        Map<String, Object> chatNarrationDecorationCompound = new NBTCompound();
        chatNarrationDecorationCompound.put("parameters", parameterList);
        chatNarrationDecorationCompound.put("style", "\\s");
        chatNarrationDecorationCompound.put("translation_key", "chat.type.text.narrate");

        chatNarrationCompound.put("decoration", chatNarrationDecorationCompound);
        chatChatCompound.put("narration", chatNarrationCompound);
        chatChatCompound.put("priority", "chat");

        try {
            System.out.println(AsJson.asJson(chatCompound));
        } catch (ConfigurateException e) {

        }

        collection.add(chatCompound);
        return collection;
    }
}
