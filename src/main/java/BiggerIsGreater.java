import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by michal on 08.01.17.
 */
public class BiggerIsGreater {

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();

        while (tests -- != 0) {
            handleCase(scanner);
        }
    }

    private static void handleCase(Scanner scanner) {

        Integer[] ints = getInts(scanner);

        increment(ints);

        print(ints);

    }

    private static Integer[] getInts(Scanner scanner) {
        final String word = scanner.next();

        byte[] bytes = word.getBytes();

        Integer[] ints = new Integer[bytes.length];

        for (int i=0; i<ints.length; i++) {
            ints[i] = (int) bytes[i];
        }
        return ints;
    }

    private static void increment(Integer[] ints) {

        if (ints.length == 1) return ;

        Integer max = null;
        for (int i=1; i<ints.length; i++) {
            if (ints[i] > ints[0]) {
                if (max == null || ints[i] > ints[max]) {
                    max = i;
                }
            }
        }

        if (max == null)
            return;
        swap(ints, 0, max);

        Arrays.sort(ints, 1, ints.length-1);

    }

    private static void swap(Integer[] ints, int i, int i1) {
        int tmp = ints[i];
        ints[i] = ints[i1];
        ints[i1] = tmp;
    }

    private static void print(Integer[] ints) {

        byte[] bytes = new byte[ints.length];
        for (int i=0; i<bytes.length; i++) {
            bytes[i] = ints[i].byteValue();
        }

        final String result = new String(bytes);
        System.out.println(result);
    }
}
