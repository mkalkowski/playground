package hackerrank.tendaysofstats;

import java.util.Locale;

import static java.lang.Math.exp;
import static java.lang.Math.sqrt;

public class Day5NormalDistribution {


    public static void main(String[] args) {

        double mean = 20.0;
        double stdDev = 2.0;

        System.out.printf(Locale.ENGLISH, "%.3f\n", cdf(19.5, mean, stdDev));
        System.out.printf(Locale.ENGLISH, "%.3f\n", cdf(22, mean, stdDev) - cdf(20, mean, stdDev));
    }

    private static double cdf(double x, double mean, double stdDev) {

        return 0.5 * (1 + erf((x - mean) / (stdDev * sqrt(2))));
    }

    public static double erf(double z) {
        double t = 1.0 / (1.0 + 0.5 * Math.abs(z));

        // use Horner's method
        double ans = 1 - t * Math.exp(-z * z - 1.26551223 +
                t * (1.00002368 +
                t * (0.37409196 +
                t * (0.09678418 +
                t * (-0.18628806 +
                t * (0.27886807 +
                t * (-1.13520398 +
                t * (1.48851587 +
                t * (-0.82215223 +
                t * (0.17087277))))))))));
if (z >= 0) return ans;
        else return -ans;
    }

}
