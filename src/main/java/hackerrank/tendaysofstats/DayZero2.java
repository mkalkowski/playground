package hackerrank.tendaysofstats;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.IntStream;

public class DayZero2 {

    public static void main(String[] args) {
        new DayZero2().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> array = new ArrayList<>(n);
        List<Integer> weights = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int x_i = scanner.nextInt();
            array.add(x_i);
        }
        for (int i = 0; i < n; i++) {
            int w_i = scanner.nextInt();
            weights.add(w_i);
        }
        print(findWAvg(array, weights));
    }

    private double findWAvg(List<Integer> array, List<Integer> weights) {

        double wavg = 0;
        double wsum = 0;
        for (int i=0; i<array.size(); i++) {
            wavg += array.get(i) * weights.get(i);
            wsum += weights.get(i);
        }

        return wavg/wsum;
    }

    private void print(double n) {
        System.out.printf(Locale.ENGLISH, "%.1f", n);
    }
}
