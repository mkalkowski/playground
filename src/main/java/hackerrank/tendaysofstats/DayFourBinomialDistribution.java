package hackerrank.tendaysofstats;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class DayFourBinomialDistribution {

    public static void main(String[] args) {
        new DayFourBinomialDistribution().run();
    }

    private void run() {
        double p = 1.09;
        double q = 1.0;

        p = p/(p+q);

        double r=0.0;

        for (int i=3; i<=6; i++) {
            r += b(i, 6, p);
        }

        print(r);
    }

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
