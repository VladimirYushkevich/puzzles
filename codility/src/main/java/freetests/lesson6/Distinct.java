package freetests.lesson6;

/**
 * Write a function
 * <p>
 * class Solution { public int solution(int[] A); }
 * that, given a zero-indexed array A consisting of N integers, returns the number of distinct values in array A.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [0..100,000];
 * each element of array A is an integer within the range [−1,000,000..1,000,000].
 * For example, given array A consisting of six elements such that:
 * <p>
 * A[0] = 2    A[1] = 1    A[2] = 1
 * A[3] = 2    A[4] = 3    A[5] = 1
 * the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.
 * <p>
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N*log(N));
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 * Elements of input arrays can be modified.
 */
public class Distinct {

    public int solution(int[] A) {
        final int length = A.length;

        if (length == 0) {
            return 0;
        }

        return mergesort(A, 0, length - 1);
    }

    private int mergesort(int[] original, int start, int end) {
        int count = 1;
        // check if low is smaller then high, if not then the array is sorted
        if (start < end) {
            // Get the index of the element which is in the middle
            int middle = (end + start) / 2;
            // Sort the left side of the array
            mergesort(original, start, middle);
            // Sort the right side of the array
            mergesort(original, middle + 1, end);
            // Combine them both
            count = merge(count, original, start, middle, end);
        }

        return count;
    }

    private int merge(int count, int[] original, int start, int middle, int end) {
        //stores the starting position of both parts in temporary variables.
        int left = start;
        int right = middle + 1;
        int index = 0;
        boolean last = (start == 0 && right >= original.length / 2.0);

        int[] aux = new int[end - start + 1];

        for (int i = start; i <= end; i++) {
            if (left > middle) { //checks if first part comes to an end or not
                aux[index++] = original[right++];
            } else if (right > end) { //checks if second part comes to an end or not
                aux[index++] = original[left++];
            } else if (original[left] < original[right]) { //checks which part has smaller element.
                aux[index++] = original[left++];
            } else {
                aux[index++] = original[right++];
            }
        }

        //Now the real array has elements in sorted manner including both parts
        for (int i = 0; i < index; i++) {
            original[start++] = aux[i];
            if (last && i > 0 && aux[i - 1] != aux[i]) {
                count++;
            }
        }

        return count;
    }
}
