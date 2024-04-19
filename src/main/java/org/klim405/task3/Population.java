package org.klim405.task3;

import java.util.ArrayList;
import java.util.List;

public class Population {
    final private List<Unit> units;

    public Population(List<Unit> units) {
        this.units = units;
    }

    public Population() {
        units = new ArrayList<>();
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    public KindnessLevel getPopulationKindness() {
        int sum = units.stream().map(unit -> unit.calcKindness().getValue()).reduce(0, Integer::sum);
        return new KindnessLevel(sum / units.size());
    }

    public Population whoIsBetter(Population otherPopulation) {
        int selfKindness = this.getPopulationKindness().value;
        int otherKindness = otherPopulation.getPopulationKindness().value;
        if (selfKindness == otherKindness) {
            return null;
        } else if (selfKindness > otherKindness) {
            return this;
        } else {
            return otherPopulation;
        }
    }
}
