package algorithms.warmup;

import java.util.Scanner;

public class DiagonalDifference {

    static long solution(int n, long[][] a) {
        long diagonalOne = 0L;
        long diagonalTwo = 0L;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    diagonalOne += a[i][j];
                }
                if (j + i == n - 1) {
                    diagonalTwo += a[i][j];
                }
            }
        }
        return Math.abs(diagonalOne - diagonalTwo);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long[][] a = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = in.nextLong();
            }
        }
        long result = solution(n, a);
        System.out.println(result);
    }
}
