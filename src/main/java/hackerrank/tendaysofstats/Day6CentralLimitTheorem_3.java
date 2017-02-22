package hackerrank.tendaysofstats;

import java.util.Locale;

import static java.lang.Math.sqrt;

public class Day6CentralLimitTheorem_3 {

    public static void main(String[] args) {

        double mean = 500;
        double stdDev = 80;
        double n = 100;
        double z_score = 1.96;

        double margin = z_score * stdDev / sqrt(n);
        System.out.printf(Locale.ENGLISH, "%.2f\n", mean - margin);
        System.out.printf(Locale.ENGLISH, "%.2f\n", mean + margin);

    }
}