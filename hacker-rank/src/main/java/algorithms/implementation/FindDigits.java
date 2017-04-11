package algorithms.implementation;

import java.util.Scanner;

public class FindDigits {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(checkDigits(in.nextInt()));
        }
    }

    static int checkDigits(int original) {
        int counter = 0;
        final char[] chars = String.valueOf(original).toCharArray();
        for (char charDigit : chars) {
            final Integer digit = Integer.valueOf(String.valueOf(charDigit));
            if (digit != 0 && original % digit == 0) {
                counter++;
            }
        }

        return counter;
    }
}
