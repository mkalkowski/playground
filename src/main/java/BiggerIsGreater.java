import java.util.Arrays;
import java.util.Scanner;

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
        Integer[] clone = Arrays.copyOf(ints, ints.length);

        increment(ints);

        print(ints, clone);

    }


    private static void increment(Integer[] ints) {

        if (ints.length == 1) return ;
        int pivot = -1;
        for (int i=ints.length-1; i>=1; i--) {

            if (ints[i] > ints[i-1]) {
                pivot = i-1;
                break;
            }
        }

        if (pivot == -1) return;

//        System.out.println("pivot = " + pivot + " - > " + new String(new byte[] { ints[pivot].byteValue()}));

        int justAbovePivot = -1;
        for (int i=ints.length-1; i>pivot; i--) {
            if (ints[i] > ints[pivot]) {
                if (justAbovePivot == -1 || ints[justAbovePivot] > ints[i]) {
                    justAbovePivot = i;
                }
            }
        }
//        System.out.println("justAbove = " + justAbovePivot + " - > " + new String(new byte[] { ints[justAbovePivot].byteValue()}));

        swap(ints, justAbovePivot, pivot);

        Arrays.sort(ints, pivot + 1, ints.length);

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

    private static void swap(Integer[] ints, int i, int i1) {
        int tmp = ints[i];
        ints[i] = ints[i1];
        ints[i1] = tmp;
    }

    private static void print(Integer[] ints, Integer[] clone) {

        byte[] bytes = new byte[ints.length];
        for (int i=0; i<bytes.length; i++) {
            bytes[i] = ints[i].byteValue();
        }

        final String result = new String(bytes);
        System.out.println(Arrays.equals(clone, ints) ? "no answer" : result);
    }
}