package algorithms.warmup;

import java.util.Scanner;

public class CompareTheTriplets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();

        int sumA = 0;
        int sumB = 0;

        if (a0 > b0) {
            sumA++;
        } else if (b0 > a0) {
            sumB++;
        }

        if (a1 > b1) {
            sumA++;
        } else if (b1 > a1) {
            sumB++;
        }

        if (a2 > b2) {
            sumA++;
        } else if (b2 > a2) {
            sumB++;
        }

        System.out.println(sumA + " " + sumB);
    }
}
