package org.klim405;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.klim405.task1.Tangent;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TangentTest {
    @ParameterizedTest(name = "cos({0})")
    @DisplayName("Проверка значений косинуса")
    @ValueSource(doubles = {-2 * Math.PI, -Math.PI, -0.5 * Math.PI, 0, 0.5 * Math.PI, Math.PI, 1.5 * Math.PI, 2 * Math.PI})
    public void testCos(double param) {
        assertEquals(Math.cos(param), Tangent.cos(param), 1E-7);
    }

    @ParameterizedTest(name = "sin({0})")
    @DisplayName("Проверка значений синуса")
    @ValueSource(doubles = {-2 * Math.PI, -Math.PI, -0.5 * Math.PI, 0, 0.5 * Math.PI, Math.PI, 1.5 * Math.PI, 2 * Math.PI})
    public void testSin(double param) {
        assertEquals(Math.sin(param), Tangent.sin(param), 1E-7);
    }

    @ParameterizedTest(name = "tan({0})")
    @DisplayName("Проверка значений котангенса")
    @ValueSource(doubles = {-2 * Math.PI, -Math.PI, 0, Math.PI, Math.PI / 6, Math.PI / 4, 2 * Math.PI})
    public void testTan(double param) {
        assertEquals(Math.tan(param), Tangent.calc(param), 1E-7);
    }
}
