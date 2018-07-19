package companies.amazon;

public class Solution1 {

    int solution(int[] A) {
        int beginningOfSlice = 0;
        int sliceSize = 1;
        int maxSize = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] > A[i - 1]) {
                sliceSize++;
            }
            if (sliceSize >= maxSize) {
                maxSize = sliceSize;
                beginningOfSlice = i - maxSize + 1;
                sliceSize = 1;
            }
        }
        return beginningOfSlice;
    }
}
