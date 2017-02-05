package hackerrank.tendaysofstats;

import java.util.*;

public class DayOneInterquartileRange {

    public static void main(String[] args) {
        new DayOneInterquartileRange().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        CompressedArray array = new CompressedArray(readTree(scanner, n));

        double q3, q1 = median(array.subList(0, array.size()/2));
        if (array.size() % 2 == 1) {
            q3 = median(array.subList(array.size()/2+1, array.size()));
        } else { // even
            q3 = median(array.subList(array.size()/2, array.size()));
        }
        print(q3-q1);
    }

    private TreeMap<Integer, Integer> readTree(Scanner scanner, int n) {

        List<Integer> x = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            x.add(scanner.nextInt());
        }
        TreeMap<Integer, Integer> result = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            result.put(x.get(i), scanner.nextInt());
        }
        return result;
    }

    private double median(CompressedArray array) {

        if (array.size() % 2 == 1) {
            return array.get(array.size() / 2);
        } else {
            int a = array.get(array.size() / 2);
            int b = array.get(array.size() / 2 - 1);
            return Double.valueOf(a+b)/2.0;
        }
    }



    static class CompressedArray {
        private final TreeMap<Integer, Integer> t;
        private final int size;

        public CompressedArray(TreeMap<Integer, Integer> t) {
            this.t = t;
            this.size = t.values().stream().reduce(0, (a, b) -> a + b);
        }

        public int get(int n) {

            int sum = -1;
            Iterator<Map.Entry<Integer, Integer>> it = t.entrySet().iterator();
            Map.Entry<Integer, Integer> e = null;
            while (it.hasNext() && sum < n) {
                e = it.next();
                sum += e.getValue();
            }
            return e.getKey();
        }

        @Override
        public String toString(){
            return t.toString();
        }

        public int size() {
            return size;
        }

        public CompressedArray subList(int start, int end) {
            TreeMap<Integer, Integer> newTree = new TreeMap<>();

            for (int i = start; i < end ; i++) {
                int x_i = get(i);
                int cnt = newTree.getOrDefault(x_i, 0);
                newTree.put(x_i, cnt + 1);
            }

            return new CompressedArray(newTree );
        }
    }

    private void print(double n) {
        System.out.printf(Locale.ENGLISH, "%.1f\n", n);
    }

}
