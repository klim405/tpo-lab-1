package org.klim405;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.klim405.task3.KindnessLevel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KindnessLevelTest {
    @DisplayName("Проверка toString")
    @ParameterizedTest
    @CsvFileSource(resources = "/KindnessLevel_testToString.csv", numLinesToSkip = 1)
    void testToString(int value, String string) {
        assertEquals(new KindnessLevel(value).toString(), string);
    }

    @DisplayName("Проверка значений в диапазоне")
    @ParameterizedTest
    @ValueSource(ints = {-200, -100, 0, 76, 200})
    void testKindnessLevel(int value) {
        assertEquals(new KindnessLevel(value).getValue(), value);
    }

    @DisplayName("Проверка превышения нижнего предела значений KindnessLevel")
    @ParameterizedTest
    @ValueSource(ints = {-2000, -1000, -201})
    void testMinValKindnessLevel(int value) {
        assertEquals(new KindnessLevel(value).getValue(), -200);
    }

    @DisplayName("Проверка превышения верхнего предела значений KindnessLevel")
    @ParameterizedTest
    @ValueSource(ints = {2000, 1000, 201})
    void testMaxValKindnessLevel(int value) {
        assertEquals(new KindnessLevel(value).getValue(), 200);
    }
}
