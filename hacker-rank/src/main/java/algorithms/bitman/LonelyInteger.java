package algorithms.bitman;

import java.util.Scanner;

public class LonelyInteger {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        System.out.println(lonelyInteger(a, n));
    }

    static int lonelyInteger(int[] a, int size) {
        int lonelyValue = a[0];
        for (int i = 1; i < size; i++) {
            lonelyValue = lonelyValue ^ a[i];
        }
        return lonelyValue;
    }
}
