package org.klim405.task3;

public class KindnessLevel {
    final protected int value;

    public KindnessLevel(int value) {
        if (value < -200) {
            this.value = -200;
        } else {
            this.value = Math.min(value, 200);
        }
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        if (value < -175) {
            return "Демоническое существо";
        } else if (value < -125) {
            return "Чудовещное существо";
        } else if (value < -75) {
            return "Убийственное существо";
        } else if (value < -50) {
            return "Плохое существо";
        } else if (value < 0) {
            return "Недоброжелательное существо";
        } else if (value == 0) {
            return "Нейтральное существо";
        } else if (value < 25) {
            return "Хорошее существо";
        } else if (value < 75) {
            return "Доброе существо";
        } else if (value < 125) {
            return "Альтруистическое существо";
        } else if (value < 175) {
            return "Сверх доброе существо";
        } else {
            return "Божий одуванчик";
        }
    }
}
