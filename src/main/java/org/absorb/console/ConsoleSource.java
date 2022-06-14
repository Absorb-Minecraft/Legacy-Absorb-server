package org.absorb.console;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.absorb.AbsorbManagers;
import org.absorb.Main;
import org.absorb.command.CommandSender;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.reader.impl.DefaultParser;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.spongepowered.math.vector.Vector3i;

import java.io.IOException;
import java.util.*;

public class ConsoleSource implements CommandSender {

    private static final char PROGRESS = '█';
    private static final char NO_PROGRESS = '░';

    public static final Map<Vector3i, Ansi.Color> COLOURS;

    static {
        Map<Vector3i, Ansi.Color> colours = new HashMap<>();
        colours.put(new Vector3i(0, 0, 0), Ansi.Color.BLACK);
        colours.put(new Vector3i(255, 255, 255), Ansi.Color.WHITE);
        colours.put(new Vector3i(0, 0, 255), Ansi.Color.BLUE);
        colours.put(new Vector3i(0, 255, 0), Ansi.Color.GREEN);
        colours.put(new Vector3i(255, 0, 0), Ansi.Color.RED);
        colours.put(new Vector3i(255, 255, 0), Ansi.Color.YELLOW);
        colours.put(new Vector3i(0, 255, 255), Ansi.Color.CYAN);
        colours.put(new Vector3i(255, 0, 255), Ansi.Color.MAGENTA);
        COLOURS = Collections.unmodifiableMap(colours);
    }

    private boolean removeNextLine;

    public ConsoleSource() {
        AnsiConsole.systemInstall();
    }

    private Ansi.Color getClosesColour(int red, int green, int blue) {
        Map.Entry<Vector3i, Ansi.Color> ret = null;
        for (Map.Entry<Vector3i, Ansi.Color> entry : COLOURS.entrySet()) {
            if (ret==null) {
                ret = entry;
                continue;
            }
            double current = ret.getKey().distance(red, green, blue);
            double now = entry.getKey().distance(red, green, blue);
            if (now < current) {
                ret = entry;
            }
        }
        if (ret==null) {
            return Ansi.Color.DEFAULT;
        }
        return ret.getValue();
    }

    private Ansi toAnsi(Component component) {
        Ansi ret = Ansi.ansi();
        List<Component> children = List.of(component);
        List<Component> next = new ArrayList<>();

        while (!children.isEmpty()) {
            for (Component child : children) {
                ret.reset();
                TextColor colour = child.color();
                if (colour!=null) {
                    ret.fg(this.getClosesColour(colour.red(), colour.green(), colour.blue()));
                }
                Map<TextDecoration, TextDecoration.State> style = child.decorations();
                for (Map.Entry<TextDecoration, TextDecoration.State> entry : style.entrySet()) {
                    if (entry.getKey()==TextDecoration.BOLD) {
                        if (entry.getValue()!=TextDecoration.State.TRUE) {
                            ret.a(Ansi.Attribute.UNDERLINE_OFF);
                            continue;
                        }
                        ret.a(Ansi.Attribute.UNDERLINE);
                    }
                }
                if (child instanceof TextComponent textComponent) {
                    ret = ret.a(textComponent.content());
                }
                next.addAll(child.children());
            }
            children = next;
            next = new ArrayList<>();
        }
        ret.reset();
        return ret;
    }

    public void sendProgress(double value, double max) {
        this.sendProgress((value * 100.0) / max);
    }

    public void sendProgress(double percent) {
        String progress = "";
        String left = "";
        for (int i = 0; i < 100; i++) {
            if (i > percent) {
                left = left + NO_PROGRESS;
                continue;
            }
            progress = progress + PROGRESS;
        }
        removeNextLine = true;

        this.sendMessage(Component.text(progress).color(TextColor.color(255, 255, 255)).append(Component.text(left).color(TextColor.color(200,
                200, 200))));

    }

    @Override
    public void sendMessage(@Nullable UUID uuid, @NotNull Component component) {
        if (this.removeNextLine) {
            System.out.print(toAnsi(component) + "\r");
            this.removeNextLine = false;
            return;
        }
        System.out.println(toAnsi(component));
    }

    public void runCommandRunner() {
        new Thread(() -> {
            Terminal terminal;
            try {
                terminal = TerminalBuilder.terminal();
            } catch (IOException e) {
                System.out.println("Cannot find out what console you are using. Blocking console commands");
                e.printStackTrace();
                return;
            }
            LineReader lineReader =
                    LineReaderBuilder.builder().appName("Absorb").terminal(terminal).completer(new AbsorbLineCompleter()).parser(new DefaultParser()).build();
            while (Main.IS_RUNNING) {
                try {
                    String line = lineReader.readLine();
                    AbsorbManagers.getCommandManager().execute(this, line);
                }catch (UserInterruptException e){
                    String line = "stop host forced shutdown";
                    AbsorbManagers.getCommandManager().execute(this, line);
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }).start();
    }
}