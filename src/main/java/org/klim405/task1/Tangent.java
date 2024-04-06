package org.klim405.task1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tangent {
    private static final List<BigDecimal> factorials = new ArrayList<>(
            Arrays.asList(BigDecimal.ONE, BigDecimal.ONE)
    );
    static final int iterations = 15;

    public static BigDecimal fact(int n) {
        int lastN = factorials.size() - 1;
        BigDecimal lastValue = factorials.get(lastN);
        while (lastN < n) {
            lastValue = lastValue.multiply(BigDecimal.valueOf(++lastN));
            factorials.add(lastValue);
        }

        return factorials.get(n);
    }

    public static double normalizeX(double x) {
        double PI2 = Math.PI * 2;

        if (x >= 0) {
            while (x > PI2) {
                x -= PI2;
            }
        } else if (x < 0){
            while (x < -PI2) {
                x += PI2;
            }
        }

        return x;
    }

    public static BigDecimal bigDecimalSin(double x) {
        BigDecimal bigX = BigDecimal.valueOf(normalizeX(x));
        BigDecimal sign, numerator, denominator;

        BigDecimal res = BigDecimal.ZERO;
        for (int n = 1; n <= iterations; n++) {
            sign = BigDecimal.valueOf(Math.pow(-1, n-1));
            numerator = bigX.pow(2*n-1);
            denominator = fact(2*n-1);
            res = res.add(
                    sign.multiply(numerator.divide(denominator, RoundingMode.HALF_UP))
            );
        }
        return res;
    }

    public static double sin(double x) {
        return bigDecimalSin(x).doubleValue();
    }

    public static BigDecimal bigDecimalCos(double x) {
        BigDecimal bigX = BigDecimal.valueOf(x);
        BigDecimal sign, numerator, denominator;

        BigDecimal res = BigDecimal.ZERO;
        for (int n = 0; n <= iterations; n++) {
            sign = BigDecimal.valueOf(Math.pow(-1, n));
            numerator = bigX.pow(2*n);
            denominator = fact(2*n);
            res = res.add(
                    sign.multiply(numerator.divide(denominator, RoundingMode.HALF_UP))
            );
        }
        return res;
    }

    public static double cos(double x) {
        return bigDecimalCos(x).doubleValue();
    }

    public static double calc(double x) {
        return bigDecimalSin(x).divide(bigDecimalCos(x), RoundingMode.HALF_UP).doubleValue();
    }
}
