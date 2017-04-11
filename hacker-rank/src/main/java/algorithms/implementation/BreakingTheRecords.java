package algorithms.implementation;

import java.util.Scanner;

public class BreakingTheRecords {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];
        for (int score_i = 0; score_i < n; score_i++) {
            scores[score_i] = in.nextInt();
        }

        final int[][] records = getRecords(scores);
        System.out.println(records[0][0] + " " + records[0][1]);
    }

    static int[][] getRecords(int[] scores) {
        int numberOfBestRecords = 0;
        int numberOfWorstRecords = 0;

        int bestScore = scores[0];
        int worstScore = scores[0];

        for (int score : scores) {
            if (score > bestScore) {
                numberOfBestRecords++;
                bestScore = score;
            }

            if (score < worstScore) {
                numberOfWorstRecords++;
                worstScore = score;
            }
        }

        return new int[][]{{numberOfBestRecords, numberOfWorstRecords}};
    }
}
