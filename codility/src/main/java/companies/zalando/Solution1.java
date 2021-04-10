package companies.zalando;

public class Solution1 {

    public int solution(int[] A) {
        int negativeCnt = 0;
        for (int number : A) {
            if (number == 0) return 0;
            if (number < 0) negativeCnt++;
        }

        if (negativeCnt % 2 == 0) return 1;
        else return -1;
    }
}
