package com.parking.lot.util;

public class Pair<U, V> {
    private U first;
    private V second;
    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}
