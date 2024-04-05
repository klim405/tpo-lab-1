package org.klim405.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tangent {
    private static final List<Integer> factorials = new ArrayList<>(Arrays.asList(1, 1));

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

    public static Integer binominal(int n, int m) {
        return fact(n) / (fact(m) * fact(n-m));
    }

    public static double bernoulliNumber(int n) {
        if (n == 0) return 1d;
        if (n == 1) return -0.5d;

        double res = 0;
        for (int k = 0; k <= n; k++) {
            for (int v = 0; v <= k; v++) {
                res += ((v % 2 == 0) ? 1 : -1) * binominal(k, v) * Math.pow(v, n) / (k + 1);
            }
        }
        return res;
    }

    public static double calc(double x) {
        double res = 0;
        int iterations = 6;
        for (int n = 1; n <= iterations; n++) {
            res += ((n % 2 != 0) ? 1 : -1) * Math.pow(2, 2*n) * (Math.pow(2, 2*n) - 1) * bernoulliNumber(2*n) / fact(2*n) * Math.pow(x, 2*n - 1);
        }
        return res;
    }
}
