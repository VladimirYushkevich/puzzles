package companies.zalando;

/**
 * You are given a matrix A consisting of N rows and M columns, where each cell contains a digit. Your task is to find
 * a continuous sequence of neighbouring cells, starting in the top-left corner and ending in the bottom-right corner
 * (going only down and right), that creates the biggest possible integer by concatenation of digits on the path.
 * By neighbouring cells we mean cells that have exactly one common side.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public String solution(int[][] A); }
 * <p>
 * that, given matrix A consisting of N rows and M columns, returns a string which represents the sequence of cells that
 * we should pick to obtain the biggest possible integer.
 * <p>
 * For example, given the following matrix A:
 * 9|9|7
 * 9|7|2
 * 6|9|5
 * 9|1|2
 * the function should return "997952"
 */
public class Technetium2019 {

    static String solution(int[][] A) {
        final int m = A.length;
        final int n = A[0].length;

        MutableInteger[] result = new MutableInteger[m];
        result[0] = new MutableInteger(A[0][0], m + n + 1);

        // initial raw from up to down
        for (int i = 1; i < m; i++) {
            result[i] = new MutableInteger(result[i - 1]).append(A[i][0]);
        }

        for (int j = 1; j < n; j++) {
            // top row we only can reach from left
            result[0].append(A[0][j]);
            // moving down
            for (int i = 1; i < m; i++) {
                MutableInteger previous = result[i - 1];
                MutableInteger current = result[i];
                // only replace if previous is bigger
                if (previous.compareTo(current) > 0) {
                    result[i].copy(previous);
                }
                result[i].append(A[i][j]);
            }
        }

        return result[m - 1].toString();
    }

    private static class MutableInteger {
        int[] digits;
        int position;
        int sum;
        int capacity;
        int maxIndex;

        private MutableInteger(int digit, int capacity) {
            this.digits = new int[capacity];
            digits[0] = digit;
            sum = digit;
            this.capacity = capacity;
            position++;
        }

        private MutableInteger(MutableInteger value) {
            digits = value.digits.clone();
            position = value.position;
            capacity = value.capacity;
            sum = value.sum;
            maxIndex = value.maxIndex;
        }

        private MutableInteger append(int value) {
            digits[position] = value;
            position++;
            sum = Math.abs(sum * 10 + value); // here integer overflow to compare exact digits efficient
            return this;
        }

        private void copy(MutableInteger value) {
            digits = value.digits.clone();
            position = value.position;
            capacity = value.capacity;
            sum = value.sum;
        }

        private int compareTo(MutableInteger other) {
            // optimization for long arrays comparison
            if (this.sum != other.sum) {
                int start = Math.min(this.maxIndex, other.maxIndex);
                for (int i = start; i < this.position; i++) {
                    int left = this.digits[i];
                    int right = other.digits[i];
                    if (left != right) {
                        other.maxIndex = i; // don't change this.maxIndex, it will be used in next iteration
                        return Integer.compare(left, right);
                    }
                }
            }
            return 0;
        }

        @Override
        public String toString() {
            StringBuilder out = new StringBuilder(position);
            for (int i = 0; i < position; i++) {
                out.append(digits[i]);
            }
            return out.toString();
        }
    }
}
