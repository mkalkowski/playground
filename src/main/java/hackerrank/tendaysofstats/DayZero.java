package hackerrank.tendaysofstats;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class DayZero {

    public static void main(String[] args) {
        new DayZero().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> array = new ArrayList<>(n);
        double avg = 0;
        for (int i = 0; i < n; i++) {
            int x_i = scanner.nextInt();
            array.add(x_i);
            avg += ((double)x_i)/n;
        }

        print(avg);
        print(findMedian(array));
        print(findMode(array));

    }

    private double findMode(List<Integer> array) {
        TreeMap<Integer, Integer> occurences = new TreeMap<>();

        array.forEach(i -> {
            if (occurences.containsKey(i)) {
                Integer cnt = Integer.valueOf(occurences.get(i) + 1);
                occurences.put(i, cnt);
            } else {
                occurences.put(i, 1);
            }
        });

        Integer max = occurences.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue();
        return occurences.entrySet().stream().
                filter(e -> e.getValue() == max).
                sorted(Comparator.comparing(Map.Entry::getKey)).
                map(Map.Entry::getKey).
                min(Integer::compareTo).
                get();
    }

    private double findMedian(List<Integer> array) {

        Collections.sort(array);

        if (array.size() % 2 == 1) {
            return array.get(array.size() / 2);
        } else {
            int a = array.get(array.size() / 2);
            int b = array.get(array.size() / 2 - 1);
            return ((double)a + (double)b)/2;
        }
    }

    private void print(double n) {
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.HALF_EVEN);
        System.out.println(df.format(n));
    }
}
