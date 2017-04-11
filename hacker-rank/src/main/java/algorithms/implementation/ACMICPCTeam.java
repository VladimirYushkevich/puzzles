package algorithms.implementation;

import java.util.Scanner;

public class ACMICPCTeam {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numberOfPeople = in.nextInt();
        int numberOfTopics = in.nextInt();
        byte a[][] = new byte[numberOfPeople][numberOfTopics];
        for (int i = 0; i < numberOfPeople; i++) {
            String s = in.next();
            for (int j = 0; j < numberOfTopics; j++)
                a[i][j] = (byte) Character.getNumericValue(s.charAt(j));
        }

        final int[][] result = getMaxNumberOfTeamPairs(a, numberOfPeople, numberOfTopics);
        System.out.println(result[0][0]);
        System.out.println(result[0][1]);
    }


    static int[][] getMaxNumberOfTeamPairs(byte a[][], int numberOfPeople, int numberOfTopics) {
        int maxNumberOfTeamPairs = 0;
        int maxNumberOfTopics = 0;

        for (int i = 0; i < numberOfPeople; i++) {
            byte[] topicsOne = a[i];
            for (int j = i + 1; j < numberOfPeople; j++) {
                byte[] topicsTwo = a[j];

                final int numberOfTopicsForTeam = getNumberOfTopicsForTeam(topicsOne, topicsTwo, numberOfTopics);
                if (numberOfTopicsForTeam > maxNumberOfTopics) {
                    maxNumberOfTopics = numberOfTopicsForTeam;
                    maxNumberOfTeamPairs = 1;
                } else if (numberOfTopicsForTeam == maxNumberOfTopics) {
                    maxNumberOfTeamPairs++;
                }
            }
        }

        return new int[][]{{maxNumberOfTopics, maxNumberOfTeamPairs}};
    }

    private static int getNumberOfTopicsForTeam(byte a[], byte b[], int numberOfTopics) {
        int numberOfTopicsForTeam = 0;

        for (int i = 0; i < numberOfTopics; i++) {
            if ((a[i] | b[i]) == 1) {
                numberOfTopicsForTeam++;
            }
        }

        return numberOfTopicsForTeam;
    }
}
