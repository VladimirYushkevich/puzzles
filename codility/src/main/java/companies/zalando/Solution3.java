package companies.zalando;

public class Solution3 {

    public int solution(int[] A, int K) {
        int n = A.length;
        int best = 0;
        int count = 1;
        for (int i = 0; i < n - 1; i++) {
            if (A[i] == A[i + 1] || A[i] + K == A[i + 1])
                count = count + 1;
            else
                count = 1;
            if (count > best)
                best = count;
        }

        return Math.max(best, count);
    }
}
