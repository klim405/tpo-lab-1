package org.klim405;

import org.junit.jupiter.api.Test;
import org.klim405.task3.Achievement;
import org.klim405.task3.Delphin;
import org.klim405.task3.Human;
import org.klim405.task3.Population;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PopulationTest {
    @Test
    void testPopulation() {
        Population pd = new Population();
        Population ph = new Population();
        ph.addUnit(new Human(List.of(
                new Achievement(30, 30, 60, 60, "открытие атома"),
                new Achievement(0, 0, 60, 60, "открытие атомной энергии"),
                new Achievement(70, 90, 0, 0, "открытие атомной бомбы")
        )));
        ph.addUnit(new Human(List.of(
                new Achievement(0, 0, 60, 30, "помощь бедным"),
                new Achievement(0, 0, 60, 30, "участие в красном кресте")
        )));
        pd.addUnit(new Delphin(List.of(
                new Achievement(0, 0, 20, 10, "спасение утопающих")
        )));
        pd.addUnit(new Delphin(List.of(
                new Achievement(0, 0, 50, 100, "запрет войне")
        )));
        assertEquals(pd.whoIsBetter(ph), pd);
    }
}
