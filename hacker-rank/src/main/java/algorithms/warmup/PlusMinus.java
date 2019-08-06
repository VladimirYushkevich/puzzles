package algorithms.warmup;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

import static java.math.RoundingMode.HALF_UP;

public class PlusMinus {

    static String[] solution(int n, int[] ar) {
        double posCount = 0.0d;
        double negCount = 0.0d;
        double zeroCount = 0.0d;

        for (int a : ar) {
            if (a > 0) {
                posCount++;
            } else if (a < 0) {
                negCount++;
            } else {
                zeroCount++;
            }
        }

        return new String[]{
                new BigDecimal(posCount / n).setScale(6, RoundingMode.HALF_UP).toString(),
                new BigDecimal(negCount / n).setScale(6, RoundingMode.HALF_UP).toString(),
                new BigDecimal(zeroCount / n).setScale(6, RoundingMode.HALF_UP).toString()};
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        String[] result = solution(n, ar);
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
    }
}
