package org.klim405;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.klim405.task3.Achievement;
import org.klim405.task3.FeatureLevel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AchievementTest {
    @DisplayName("Проверка FeatureLevel")
    @ParameterizedTest
    @ValueSource(ints = {0, 20, 100})
    public void testFeatureLevel(int value) {
        FeatureLevel level = new FeatureLevel(value);
        assertEquals(level.getValue(), value);
    }

    @DisplayName("Проверка превышения нижнего предела значения FeatureLevel")
    @ParameterizedTest
    @ValueSource(ints = {-1000, -1})
    public void testMinValFeatureLevel(int value) {
        FeatureLevel level = new FeatureLevel(value);
        assertEquals(level.getValue(), 0);
    }

    @DisplayName("Проверка превышения верхнего предела значения FeatureLevel")
    @ParameterizedTest
    @ValueSource(ints = {1000, 101})
    public void testMaxValFeatureLevel(int value) {
        FeatureLevel level = new FeatureLevel(value);
        assertEquals(level.getValue(), 100);
    }

    @Test
    @DisplayName("Проверка вычисления KindnessLevel")
    public void testGetKindnessLevel() {
        Achievement level = new Achievement(100, 100, 100, 100, "name");
        assertEquals(level.getKindnessLevel().getValue(), 0);

        level = new Achievement(1000, -1000, 1000, 1000, "name");
        assertEquals(level.getKindnessLevel().getValue(), 100);

        level = new Achievement(10, 20, 15, 30, "name");
        assertEquals(level.getKindnessLevel().getValue(), 30 + 15 - 10 - 20);
    }
}
