package hackerrank.tendaysofstats;

import java.util.Locale;

public class DayFourBinomialDistribution2 {

    public static void main(String[] args) {
        new DayFourBinomialDistribution2().run();
    }

    private void run() {
        final double q = 0.12;
        final double p = 1-q;
        final int n = 10;

        binomialRange(p, n, 8, 10);
        binomialRange(p, n, 0, 8);
    }

    private void binomialRange(double p, int n, int from, int to) {
        double r=0.0;

        for (int x=from; x<=to; x++) {
            r += b(x, n, p);
        }
        print(r);
    }

    // x successes out of n trials, with p = success probability
    private double b(int x, int n, double p) {

        int f = factorial(n)/(factorial(x)*(factorial(n-x)));
        return f*Math.pow(p, x)*Math.pow(1-p, n-x);
    }

    int factorial(int n) {
        if (n==2) return 2;
        else if (n==1) return 1;
        else if (n==0) return 1;
        return n * factorial(n - 1);
    }

    private void print(double n) {
        System.out.printf(Locale.ENGLISH, "%.3f\n", n);
    }
}
