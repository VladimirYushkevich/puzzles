package algorithms.implementation;

import java.util.Scanner;

public class TaumBday {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            long b = in.nextLong();
            long w = in.nextLong();
            long x = in.nextLong();
            long y = in.nextLong();
            long z = in.nextLong();

            System.out.println(getMinimumPrice(b, w, x, y, z));
        }
    }

    static long getMinimumPrice(long b, long w, long x, long y, long z) {
        final long min = Math.min(x, y);
        long minBlackPrice = (min + z < x) ? min + z : x;
        long minWhitePrice = (min + z < y) ? min + z : y;

        return b * minBlackPrice + w * minWhitePrice;
    }
}
