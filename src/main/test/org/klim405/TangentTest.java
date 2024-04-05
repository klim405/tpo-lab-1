package org.klim405;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.klim405.task1.Tangent;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TangentTest {
    @ParameterizedTest(name = "cos({0})")
    @DisplayName("Проверка значений косинуса")
    @ValueSource(doubles = {1.5, 1, 0.5, 0, -0.5, -1, -1.5})
    public void testCos(double param) {
        assertEquals(Math.cos(param), Tangent.cos(param), 1E-7);
    }

    @ParameterizedTest(name = "sin({0})")
    @DisplayName("Проверка значений синуса")
    @ValueSource(doubles = {1.57, 1, 0.5, 0, -0.5, -1, -1.57})
    public void testSin(double param) {
        assertEquals(Math.sin(param), Tangent.sin(param), 1E-7);
    }

    @ParameterizedTest(name = "tan({0})")
    @DisplayName("Проверка значений котангенса")
    @ValueSource(doubles = {1.5, 1, 0.5, 0, -0.5, -1, -1.5})
    public void testTan(double param) {
        assertEquals(Math.tan(param), Tangent.calc(param), 1E-5);
    }
}
