package algorithms.implementation;

import java.util.Scanner;

public class SockMerchant {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for (int c_i = 0; c_i < n; c_i++) {
            c[c_i] = in.nextInt();
        }

        System.out.println(numberOfPairs(c, n));
    }

    static int numberOfPairs(int[] colors, int numberOfSocks) {
        final boolean bitSet[] = new boolean[101];
        int counter = 0;
        for (int i = 0; i < numberOfSocks; i++) {
            final int color = colors[i];
            if (bitSet[color]) {
                bitSet[color] = false;
                counter++;
            } else {
                bitSet[color] = true;
            }
        }

        return counter;
    }
}
