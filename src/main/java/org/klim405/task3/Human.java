package org.klim405.task3;

import java.util.List;

public class Human extends Unit {
    public Human(List<Achievement> achievements) {
        super(achievements);
    }

    @Override
    public String toString() {
        return "Человек - " + calcKindness().toString();
    }
}
