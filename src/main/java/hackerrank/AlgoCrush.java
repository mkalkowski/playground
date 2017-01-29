package hackerrank;

import java.util.*;

public class AlgoCrush {

    public static void main(String[] args) {
        new AlgoCrush().run();
    }

    private void run() {
        Scanner scaner = new Scanner(System.in);
        String[] args = scaner.nextLine().split(" ");
        int m = Integer.parseInt(args[1]);
        MergeResult opHolder = new MergeResult();

        while (m-- != 0) {

            String[] opArgs = scaner.nextLine().split(" ");
            int a = Integer.parseInt(opArgs[0]);
            int b = Integer.parseInt(opArgs[1]);
            long k = Integer.parseInt(opArgs[2]);

            opHolder.add(a, b, k);
        }

        System.out.println(opHolder.resolveMax());

    }

    static class MergeResult {
        TreeMap<Integer, Long> ops = new TreeMap<>();

        public void add(int a, int b, long k) {
            add(a, k);
            add(b+1, -k);
        }

        private void add(int x, long k) {
            if (ops.containsKey(x)) {
                ops.put(x, k + ops.get(x));
            } else {
                ops.put(x, k);
            }
        }

        public long resolveMax() {
            Long max = null;
            long current = 0;

            for (Map.Entry<Integer, Long> op : ops.entrySet()) {
                current += op.getValue();

                if (max == null || current > max) {
                    max = current;
                }
            }
            return max;
        }
    }
}
