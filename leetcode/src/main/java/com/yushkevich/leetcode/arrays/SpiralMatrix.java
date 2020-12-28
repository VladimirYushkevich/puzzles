package com.yushkevich.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix.length == 0) {
            return res;
        }

        int m = matrix.length, l = matrix[0].length, i, row = 0, column = 0, index = 0;
        /*  row - starting row index
        m - ending row index
        column - starting column index
        l - ending column index
        i - iterator
        */
        while (row < m && column < l) {
            for (i = column; i < l; ++i) {
                res.add(matrix[row][i]);
            }
            row++;

            for (i = row; i < m; ++i) {
                res.add(matrix[i][l - 1]);
            }
            l--;

            if (row < m) {
                for (i = l - 1; i >= column; --i) {
                    res.add(matrix[m - 1][i]);
                }
                m--;
            }

            if (column < l) {
                for (i = m - 1; i >= row; --i) {
                    res.add(matrix[i][column]);
                }
                column++;
            }
        }
        return res;
    }
}
