package org.absorb.command.node.parser;

import java.util.Optional;

public class ParserResult<T> {

    private final String original;
    private final int taken;
    private final T value;

    public ParserResult(String original, int taken, T value) {
        this.value = value;
        this.taken = taken;
        this.original = original;
    }

    public String getOriginalText() {
        return this.original;
    }

    public String getLeftText() {
        return this.original.substring(this.taken);
    }

    public Optional<ParserResult<String>> getNextWord() {
        String left = this.getLeftText();
        String[] result = left.split(" ", 2);
        if (result.length==0) {
            return Optional.empty();
        }
        return Optional.of(this.appendFrom(result[0].length(), result[0]));
    }

    public Optional<ParserResult<String>> getNextQuote() {
        String left = this.getLeftText();
        if (!left.startsWith("\"")) {
            return Optional.empty();
        }
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i)=='"') {
                return Optional.of(this.appendFrom(i + 1, left.substring(1, i)));
            }
        }
        return Optional.empty();
    }

    public int getTaken() {
        return this.taken;
    }

    public T getValue() {
        return this.value;
    }

    public <R> ParserResult<R> appendFrom(int taken, R value) {
        return new ParserResult<>(this.original, this.taken + taken, value);
    }

    public <R> ParserResult<R> createFrom(int newTake, R value) {
        return new ParserResult<>(this.original, newTake, value);
    }
}
