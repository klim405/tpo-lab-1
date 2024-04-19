package org.klim405.task3;

public class Achievement {
    // Разрушительность
    final private FeatureLevel destructiveness;
    // Смертоносность
    final private FeatureLevel lethality;
    // Целительность
    final private FeatureLevel healing;
    // Жертвенность
    final private FeatureLevel sacrifice;
    final private String name;

    public Achievement(int destructiveness, int lethality, int healing, int sacrifice, String name) {
        this.destructiveness = new FeatureLevel(destructiveness);
        this.lethality = new FeatureLevel(lethality);
        this.healing = new FeatureLevel(healing);
        this.sacrifice = new FeatureLevel(sacrifice);
        this.name = name;
    }

    public KindnessLevel getKindnessLevel() {
        return new KindnessLevel(
                getHealing() + getSacrifice() - getDestructiveness() - getLethality()
        );
    }

    public int getDestructiveness() {
        return destructiveness.getValue();
    }

    public int getLethality() {
        return lethality.getValue();
    }

    public int getHealing() {
        return healing.getValue();
    }

    public int getSacrifice() {
        return sacrifice.getValue();
    }

    public String getName() {
        return name;
    }
}
