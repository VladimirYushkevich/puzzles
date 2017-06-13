package algorithms.warmup;

import java.util.Arrays;
import java.util.Scanner;

public class MiniMaxSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for (int arr_i = 0; arr_i < 5; arr_i++) {
            arr[arr_i] = in.nextInt();
        }

        Arrays.sort(arr);

        long sum = 0L;
        for (int i = 1; i < 4; i++) {
            sum += arr[i];
        }

        long minSum = arr[0] + sum;
        long maxSum = arr[4] + sum;
        System.out.println(minSum + " " + maxSum);
    }
}
