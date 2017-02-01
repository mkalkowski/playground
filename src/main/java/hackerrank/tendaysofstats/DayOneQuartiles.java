package hackerrank.tendaysofstats;

import java.util.*;

public class DayOneQuartiles {

    public static void main(String[] args) {
        new DayOneQuartiles().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        List<Integer> array = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            array.add(scanner.nextInt());
        }
        Collections.sort(array);

        if (array.size() % 2 == 1) {
            System.out.println(median(array.subList(0, array.size()/2)));
            System.out.println(median(array));
            System.out.println(median(array.subList(array.size()/2+1, array.size())));
        } else { // even
            System.out.println(median(array.subList(0, array.size()/2)));
            System.out.println(median(array));
            System.out.println(median(array.subList(array.size()/2, array.size())));

        }
    }

    private int median(List<Integer> array) {


        if (array.size() % 2 == 1) {
            return array.get(array.size() / 2);
        } else {
            int a = array.get(array.size() / 2);
            int b = array.get(array.size() / 2 - 1);
            return (a+b)/2;
        }
    }
}
