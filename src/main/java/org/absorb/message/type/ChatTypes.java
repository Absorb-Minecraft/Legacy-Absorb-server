package org.absorb.message.type;

import org.absorb.register.AbsorbKey;
import org.absorb.utils.Identifiable;

public enum ChatTypes implements ChatType {
    /*
     *  "minecraft:chat_type": {
    "type": "minecraft:chat_type",
    "value": [
      {
        "element": {
          "chat": {
            "parameters": [
              "target",
              "content"
            ],
            "style": {
              "color": "gray",
              "italic": {
                "value": 1
              }
            },
            "translation_key": "commands.message.display.outgoing"
          },
          "narration": {
            "parameters": [
              "sender",
              "content"
            ],
            "translation_key": "chat.type.text.narrate"
          }
        },
        "id": {
          "value": 3
        },
        "name": "minecraft:msg_command_outgoing"
      },
      {
        "element": {
          "chat": {
            "parameters": [
              "target",
              "sender",
              "content"
            ],
            "translation_key": "chat.type.team.text"
          },
          "narration": {
            "parameters": [
              "sender",
              "content"
            ],
            "translation_key": "chat.type.text.narrate"
          }
        },
        "id": {
          "value": 4
        },
        "name": "minecraft:team_msg_command_incoming"
      },
      {
        "element": {
          "chat": {
            "parameters": [
              "target",
              "sender",
              "content"
            ],
            "translation_key": "chat.type.team.sent"
          },
          "narration": {
            "parameters": [
              "sender",
              "content"
            ],
            "translation_key": "chat.type.text.narrate"
          }
        },
        "id": {
          "value": 5
        },
        "name": "minecraft:team_msg_command_outgoing"
      },
      {
        "element": {
          "chat": {
            "parameters": [
              "sender",
              "content"
            ],
            "translation_key": "chat.type.emote"
          },
          "narration": {
            "parameters": [
              "sender",
              "content"
            ],
            "translation_key": "chat.type.emote"
          }
        },
        "id": {
          "value": 6
        },
        "name": "minecraft:emote_command"
      }
    ]
  },
     */



    CHAT(0,
         new AbsorbKey(Identifiable.MINECRAFT_HOST, "chat"),
         ChatTypeSectors.CHAT_TYPE_TEXT,
         ChatTypeSectors.CHAT_TYPE_TEXT_NARRATE),
    SAY_COMMAND(1,
                new AbsorbKey(Identifiable.MINECRAFT_HOST, "say_command"),
                ChatTypeSectors.CHAT_TYPE_ANNOUNCEMENT,
                ChatTypeSectors.CHAT_TYPE_TEXT_NARRATE),
    MSG_COMMAND_INCOMING(2,
                         new AbsorbKey(Identifiable.MINECRAFT_HOST, "msg_command_incoming"),
                         ChatTypeSectors.COMMANDS_MESSAGE_DISPLAY_INCOMING,
                         ChatTypeSectors.CHAT_TYPE_TEXT_NARRATE);

    private final AbsorbKey name;
    private final ChatTypeSector[] sectors;
    private final int id;

    ChatTypes(int id, AbsorbKey name, ChatTypeSector... sectors) {
        this.id = id;
        this.name = name;
        this.sectors = sectors;
    }

    @Override
    public AbsorbKey getName() {
        return this.name;
    }

    @Override
    public ChatTypeSector[] getSectors() {
        return this.sectors;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
