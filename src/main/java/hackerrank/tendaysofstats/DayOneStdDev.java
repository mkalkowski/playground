package hackerrank.tendaysofstats;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class DayOneStdDev {

    public static void main(String[] args) {
        new DayOneStdDev().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        double avg = 0;
        List<Integer> array = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int x_i = scanner.nextInt();
            array.add(x_i);
            avg += (double)x_i/n;
        }

        final double mi = avg;
        double sum = array.stream().
                map(x -> (((double) x - mi) * ((double) x - mi))).
                mapToDouble(Double::valueOf).
                sum();

        final double result = Math.sqrt(sum / n);

        print(result);
    }


    private void print(double n) {
        System.out.printf(Locale.ENGLISH, "%.1f", n);
    }
}
