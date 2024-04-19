package org.klim405.task3;

import java.util.List;

public abstract class Unit {
    final private List<Achievement> achievements;

    public Unit(List<Achievement> achievements) {
        this.achievements = achievements;
    }

    void addAchievement(Achievement achievement) {
        achievements.add(achievement);
    }

    KindnessLevel calcKindness() {
        int sum = achievements.stream()
                .map(achievement -> achievement.getKindnessLevel().getValue())
                .reduce(0, Integer::sum);
        return new KindnessLevel(sum / achievements.size());
    }
}
