package org.absorb.net.packet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

public class WikiUtils {

    public static class WikiEntry {

        private final String title;
        private final PacketState state;
        private final int id;

        public WikiEntry(int id, String title, PacketState state) {
            this.id = id;
            this.title = title;
            this.state = state;
        }

        public String getTitle() {
            return this.title;
        }

        public PacketState getState() {
            return this.state;
        }

        public int getId() {
            return this.id;
        }
    }

    public static WikiEntry getEntry(Object obj) throws IOException {
        return getEntry(obj.getClass());
    }

    public static WikiEntry getEntry(Class<?> clazz) throws IOException {
        OnWiki wiki = clazz.getAnnotation(OnWiki.class);
        if (wiki == null) {
            throw new RuntimeException("OnWiki is missing");
        }
        return getEntry(wiki.urlTitle(), wiki.state());
    }

    public static WikiEntry getEntry(String title, PacketState state) throws IOException {
        InputStream is = new URL("https://wiki.vg/Protocol").openStream();
        String html = new String(is.readAllBytes());
        is.close();

        String[] split = html.split("\n");
        Integer start = null;
        Integer end = null;
        for (int line = 0; line < split.length; line++) {
            String textLine = split[line];
            if (textLine.contains("id=\"" + title + "\"")) {
                if (textLine.startsWith("<h4>")) {
                    start = line;
                    continue;
                }
            }
            if (start != null) {
                if (textLine.startsWith("<h4>")) {
                    end = line;
                    break;
                }
            }
        }
        if (start == null) {
            throw new IllegalStateException("Cannot find start");
        }
        if (end == null) {
            end = split.length;
        }

        String[] between = Arrays.copyOfRange(split, start, end);

        for (String textLine : between) {
            if (!textLine.startsWith("<td")) {
                continue;
            }
            String[] hexSplit = textLine.split(">");
            if (hexSplit.length < 2) {
                continue;
            }
            String hexIdText = hexSplit[1];
            if (!hexIdText.startsWith("0x")) {
                continue;
            }
            int hex = Integer.parseInt(hexIdText.substring(2), 16);
            return new WikiEntry(hex, title, state);

        }
        throw new IllegalStateException("No Id found");
    }

    public static void main(String[] args) {
        try {
            getEntry("Login_.28play.29", PacketState.PLAY);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
