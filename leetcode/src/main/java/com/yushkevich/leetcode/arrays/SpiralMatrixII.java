package com.yushkevich.leetcode.arrays;

public class SpiralMatrixII {

    static String solution(int n) {
        final int[][] res = generateMatrix(n);

        StringBuilder output = new StringBuilder();
        output.append("[");
        int k = 1;
        for (int[] x : res) {
            output.append("\n");
            output.append(" [ ");
            for (int y : x) {
                String s = k % 3 == 0 ? " ]," : ", ";
                if (k < n * n) {
                    output.append(y + s);
                } else {
                    output.append(y + " ]\n");
                }
                k++;
            }
        }
        output.append("]");

        return output.toString();
    }

    static int[][] generateMatrix(int n) {
        final int[][] res = new int[n][n];

        int m = n, l = n, i, row = 0, column = 0, index = 0;
        /*  row - starting row index
        m - ending row index
        column - starting column index
        l - ending column index
        i - iterator
        */
        while (row < m && column < l) {
            // Print the first row from the remaining rows
            for (i = column; i < l; ++i) {
                res[row][i] = ++index;
            }
            row++;

            // Print the last column from the remaining columns
            for (i = row; i < m; ++i) {
                res[i][l - 1] = ++index;
            }
            l--;

            // Print the last row from the remaining rows */
            if (row < m) {
                for (i = l - 1; i >= column; --i) {
                    res[m - 1][i] = ++index;
                }
                m--;
            }

            // Print the first column from the remaining columns */
            if (column < l) {
                for (i = m - 1; i >= row; --i) {
                    res[i][column] = ++index;
                }
                column++;
            }
        }
        return res;
    }
}
