package org.absorb.net.data;

public record NetEntryData<T>(int originalPosition, int endingPosition, T value) {

    @Override
    public String toString() {
        return this.originalPosition + " - " + this.value.toString() + " - " + this.endingPosition;
    }
}
