package ccic;

import java.util.Scanner;

public class LeftRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        rotateAndPrint(a, n, k);
    }

    static void rotateAndPrint(int[] a, int arraySize, int numberOfRotations) {
        String output = "";
        for (int i = 0; i < arraySize; i++) {
            int shiftRight = i + numberOfRotations;
            int inOrderRotatedIndex = shiftRight >= arraySize ? shiftRight - arraySize : shiftRight;

            if (i == 0) {
                System.out.print(output + a[inOrderRotatedIndex]);
            } else {
                System.out.print(output + " " + a[inOrderRotatedIndex]);
            }
        }
    }
}
