package hackerrank.tendaysofstats;

import java.util.Locale;

public class Day5PoissonDistribution {
    public static void main1(String[] args) {

        double mean = 2.5;
        double k = 5;
        double result = Math.pow(mean, k)*Math.pow(Math.E, -mean)/120;
        System.out.printf(Locale.ENGLISH, "%.3f\n", result);
    }


    public static void main(String[] args) {

        double meanX = 0.88;
        double meanY = 1.55;

        double costX = meanX + Math.pow(meanX, 2);
        double costY = meanY + Math.pow(meanY, 2);

        System.out.printf(Locale.ENGLISH, "%.3f\n", 160+40*costX);
        System.out.printf(Locale.ENGLISH, "%.3f\n", 128+40*costY);
    }

}
