package org.absorb.console;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.absorb.AbsorbManagers;
import org.absorb.Main;
import org.absorb.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.SortedSet;
import java.util.UUID;

public class ConsoleSource implements CommandSender {

    private Integer progress;
    private int maxProgress;

    private static final char PROGRESS = '█';
    private static final char NO_PROGRESS = '░';

    public void setProgress(int amount, int max) {
        this.progress = amount;
        this.maxProgress = max;
        double percent = (amount * 100.0) / max;
        StringBuilder percentBlocks = new StringBuilder();
        for (int a = 0; a < 100; a++) {
            if (a <= ((int) percent)) {
                percentBlocks.append(PROGRESS);
            } else {
                percentBlocks.append(NO_PROGRESS);
            }
        }

        String com = "%|" + percent + "|" + percentBlocks + "|";
        System.out.print(com + "\r");
    }

    public void removeProgress() {
        this.progress = null;
    }

    @Override
    public void sendMessage(@Nullable UUID uuid, @NotNull Component component) {
        System.out.println(PlainTextComponentSerializer.plainText().serialize(component));
        if (this.progress!=null) {
            this.setProgress(this.progress, this.maxProgress);
        }
    }

    public void sendOverridableMessage(String message) {
        System.out.print(message + "\r");
    }

    public void runCommandScanner() {
        new Thread(() -> {
            StringBuilder builder = new StringBuilder();
            while (Main.IS_RUNNING) {
                try {
                    char input = (char) System.in.read();
                    if (input=='\n') {
                        String rawCommand = builder.toString();
                        this.sendMessage(Component.text("Commands not implemented yet: '" + rawCommand + "'"));
                        builder = new StringBuilder();
                        continue;
                    }
                    if (input=='\t' || input==' ' || input=='\b') {
                        SortedSet<String> results = AbsorbManagers.getCommandManager().getTabComplete(builder.toString());
                        String result = String.join("\t", results);
                        this.sendOverridableMessage(result);
                        continue;
                    }
                    builder.append(input);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
