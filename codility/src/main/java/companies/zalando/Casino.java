package companies.zalando;

public class Casino {

    public int solution(int N, int K) {
        int rounds = 0;

        while (N > 1) {
            if (K > 0 && N % 2 == 0) {
                N = N / 2;
                K--;
            } else {
                N--;
            }

            rounds++;
        }

        return rounds;
    }
}
