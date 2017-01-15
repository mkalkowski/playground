package hackerrank;

import java.util.Scanner;

/**
 * Created by michal on 15.01.17.
 */
public class Encryption {

    public static void main(String[] args) {
        new Encryption().run();
    }

    private void run() {

        String line = new Scanner(System.in).nextLine();

        int len = line.length();

        double rows = Math.floor(Math.sqrt(len));
        double columns = Math.ceil(Math.sqrt(len));

        printMatrix(line, len, rows, columns);
    }

    private void printMatrix(String line, int len, double rows, double columns) {
        int index = 0;
        for (int i = 0, currentColumn=0; i<len; i++) {
            System.out.print(line.charAt(index));
            index += columns;
            if (index >= len) {
                index = ++currentColumn;
                System.out.print(" ");
            }
        }
        System.out.print(System.lineSeparator());
    }

}
