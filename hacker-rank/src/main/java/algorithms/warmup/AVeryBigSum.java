package algorithms.warmup;

import java.util.Scanner;

public class AVeryBigSum {

    static long solution(int n, long[] ar) {
        long sum = 0L;
        for (long a : ar) {
            sum += a;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[] ar = new long[n];
        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = in.nextLong();
        }
        long result = solution(n, ar);
        System.out.println(result);
    }
}
