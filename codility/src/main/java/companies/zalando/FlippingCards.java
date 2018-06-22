package companies.zalando;

/**
 * [1, 2, 4, 3] -> [0, 1, 1, 1, 1]
 * [1, 3, 2, 3] -> [0, 1, 1, 1, 0]
 * <p>
 * [1, 3, 4, 3] -> [0, 1, 0, 1, 1]
 */
public class FlippingCards {

    public int solution(int[] A, int[] B) {
        int bitSize = 100_000;
        boolean[] bitSet = new boolean[bitSize];

        for (int i = 0; i < A.length; i++) {
            int indexA = A[i];
            int indexB = B[i];
            if (indexA != indexB) {
                int min = Math.min(indexA, indexB);
                bitSet[min] = true;
            }
        }

        for (int i = 1; i < bitSize; i++) {
            if (bitSet[i]) {
                return i;
            }
        }

        return A.length + 1;
    }
}