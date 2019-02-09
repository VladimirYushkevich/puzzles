package cci;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CountingInversions {

    private static final Scanner scanner = new Scanner(System.in);

    /**
     * [2, 4, 1] -> [2, 1, 4] -> [1, 2, 4] => 2
     *
     * @param arr Input array
     * @return Number of inversions
     */
    static String countInversions(int[] arr) {
        return String.valueOf(mergeSort(arr, new int[arr.length], 0, arr.length - 1, 0));
    }

    private static long mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd, long inversions) {
        if (leftStart >= rightEnd) {
            return inversions;
        }

        int middle = (leftStart + rightEnd) / 2;
        inversions = mergeSort(arr, temp, leftStart, middle, inversions);
        inversions = mergeSort(arr, temp, middle + 1, rightEnd, inversions);
        return merge(arr, temp, leftStart, rightEnd, inversions);
    }

    private static long merge(int[] arr, int[] temp, int leftStart, int rightEnd, long inversions) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (arr[left] <= arr[right]) {
                temp[index] = arr[left];
                left++;
            } else {
                temp[index] = arr[right];
                inversions += (right - index);
                right++;
            }
            index++;
        }

        System.arraycopy(arr, left, temp, index, leftEnd - left + 1);
        System.arraycopy(arr, right, temp, index, rightEnd - right + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, size);

        return inversions;
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            String result = countInversions(arr);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
