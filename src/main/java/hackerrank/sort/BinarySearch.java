package hackerrank.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BinarySearch {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        scanner.nextLine();
        List<Integer> array = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        System.out.println(binarySearch(array, n));
    }

    private static int binarySearch(List<Integer> array, int n) {

        int low=0, high = array.size()-1;

        while (low <= high) {

            int center = (high+low)/2;

            int cmp = array.get(center).compareTo(n);

            if (cmp == 0) {
                return center;
            } else if (cmp > 0) {
                high = center-1;
            } else {
                low = center+1;
            }

        }

        return -1;
    }


}
