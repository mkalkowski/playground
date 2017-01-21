package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GridSearch {

    public static void main(String[] args) {

        new GridSearch().run();
    }

    private void run() {

        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());
        while (testCases -- != 0) {
            runTestCase(scanner);
        }
    }

    private void runTestCase(Scanner scanner) {

        Matrix m1 = new Matrix().read(scanner);
        Matrix m2 = new Matrix().read(scanner);


        System.out.println(m1.contains(m2));
    }

    class Matrix {

        private int x;
        private int y;

        List<String> lines = new ArrayList<>();

        Matrix read(Scanner scanner) {
            String[] args = scanner.nextLine().split(" ");
            this.x = Integer.parseInt(args[0]);
            this.y = Integer.parseInt(args[1]);

            for (int i=0; i<x; i++) {
                lines.add(scanner.nextLine());
            }
            return this;
        }

        String at(int i) {
            return lines.get(i);
        }

        String contains(Matrix pattern) {

            for(int i=0; i<x-pattern.x+1; i++) {
                if (checkLine(pattern, i)) {
                    return "YES";
                }

            }

            return "NO";

        }

        private boolean checkLine(Matrix pattern, int i) {
            int shift = 0;
            int index;
            do {

                index = at(i).indexOf(pattern.at(0), shift);
                if (index == -1) {
                    return false;
                }

                shift = index + 1;
            } while (checkOccurence(i, index, pattern) == false);

            return true;
        }

        private boolean checkOccurence(int line, int index, Matrix pattern) {

            for (int i=1; i<pattern.x; i++) {
                String substring = at(line + i).substring(index, index + pattern.y);
                if (substring.equals(pattern.at(i))== false) {
                    return false;
                }
            }
            return true;
        }


    }
}
