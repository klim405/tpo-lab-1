package org.klim405.task3;

public class FeatureLevel {
    final protected int value;

    public FeatureLevel(int value) {
        if (value < 0) {
            this.value = 0;
        } else {
            this.value = Math.min(value, 100);
        }
    }

    public int getValue() {
        return value;
    }
}
