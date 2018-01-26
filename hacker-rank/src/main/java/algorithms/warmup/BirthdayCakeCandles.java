package algorithms.warmup;

import java.util.Scanner;

public class BirthdayCakeCandles {

    static int solution(int n, int[] ar) {
        int maxHeight = 0;
        int count = 0;
        for (int a : ar) {
            if (a > maxHeight) {
                maxHeight = a;
                count = 0;
            }
            if (a == maxHeight) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int ar_i = 0; ar_i < n; ar_i++) {
            ar[ar_i] = in.nextInt();
        }
        int result = solution(n, ar);
        System.out.println(result);
    }
}
