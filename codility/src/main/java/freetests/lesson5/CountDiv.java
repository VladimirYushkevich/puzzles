package freetests.lesson5;

/**
 * Write a function:
 * <p>
 * class Solution { public int solution(int A, int B, int K); }
 * that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:
 * <p>
 * { i : A ≤ i ≤ B, i mod K = 0 }
 * For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.
 * <p>
 * Assume that:
 * <p>
 * A and B are integers within the range [0..2,000,000,000];
 * K is an integer within the range [1..2,000,000,000];
 * A ≤ B.
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(1);
 * expected worst-case space complexity is O(1).
 */
public class CountDiv {

    public int solution(int A, int B, int K) {
        if (K == 1) {
            return B - A + 1;
        } else if (K == B) {
            if (A == 0) {
                return 2;
            } else {
                return 1;
            }
        } else {
            int count = K > A ? B / K : (B - A) / K;
            // if the signs are different and modulo not zero, round down
            if ((B ^ K) < 0 && (count * K != B)) {
                count--;
            }

            if (A % K == 0 || B % K == 0) {
                count++;
            }

            return count;
        }
    }
}
