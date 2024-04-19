package org.klim405.task3;

import java.util.List;

public class Delphin extends Unit {
    public Delphin(List<Achievement> achievements) {
        super(achievements);
    }

    @Override
    public String toString() {
        return "Дельфин - " + calcKindness().toString();
    }
}
