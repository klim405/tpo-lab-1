package org.klim405.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tangent {
    private static final List<Integer> factorials = new ArrayList<>(Arrays.asList(1, 1));
    static final int iterations = 6;

    public static Integer fact(int n) {
        if (n > 12) throw new RuntimeException("Max factorial value is 12");

        int lastN = factorials.size() - 1;
        Integer lastValue = factorials.get(lastN);
        while (lastN < n) {
            lastValue = lastValue * (++lastN);
            factorials.add(lastValue);
        }

        return factorials.get(n);
    }

    public static double sin(double x) {
        double res = 0;
        for (int n = 1; n <= iterations; n++) {
            res += Math.pow(-1, n-1) * Math.pow(x, 2*n-1) / fact(2*n-1);
        }
        return res;
    }

    public static double cos(double x) {
        double res = 0;
        for (int n = 0; n <= iterations; n++) {
            res += Math.pow(-1, n) * Math.pow(x, 2*n) / fact(2*n);
        }
        return res;
    }

    public static double calc(double x) {
        return sin(x) / cos(x);
    }
}
