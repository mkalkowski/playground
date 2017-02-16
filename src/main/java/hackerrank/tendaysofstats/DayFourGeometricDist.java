package hackerrank.tendaysofstats;

import java.util.Locale;

public class DayFourGeometricDist {
    public static void main(String[] args) {
        double p = 1.0/3;

        double result =
                Math.pow(1-p, 4) * p +
                Math.pow(1-p, 3) * p +
                Math.pow(1-p, 2) * p +
                Math.pow(1-p, 1) * p +
                p;

        System.out.printf(Locale.ENGLISH, "%.3f", result);
    }


    public static void main2(String[] args) {
        double p = 1.0/3;

        double result = Math.pow(1-p, 4) * p;

        System.out.printf(Locale.ENGLISH, "%.3f", result);
    }

}
