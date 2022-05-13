package org.absorb.register;


public record AbsorbKey(String host, String value) {

    public String asFormatted() {
        return this.host + ":" + this.value;
    }

    public static AbsorbKey resolve(String value) {
        String[] split = value.split(":", 2);
        return new AbsorbKey(split[0], split[1]);
    }
}
