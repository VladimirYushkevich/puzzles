package algorithms.implementation;

import java.util.Scanner;

public class TheHurdleRace {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] heights = new int[n];
        for (int height_i = 0; height_i < n; height_i++) {
            heights[height_i] = in.nextInt();
        }

        System.out.println(getNumberOfBeverages(heights, k));
    }

    static int getNumberOfBeverages(int[] heights, int maxHeight) {
        int numberOfBeverages = 0;
        for (int height : heights) {
            if (height > maxHeight) {
                int newNumberOfBeverages = height - maxHeight;
                if (newNumberOfBeverages > numberOfBeverages) {
                    numberOfBeverages = newNumberOfBeverages;
                }
            }
        }

        return numberOfBeverages;
    }
}
