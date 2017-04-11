package algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class EqualizeArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for (int c_i = 0; c_i < n; c_i++) {
            c[c_i] = in.nextInt();
        }

        System.out.println(getMinNumberOfDeletion(c, n));
    }

    static int getMinNumberOfDeletion(int[] elements, int size) {
        Arrays.sort(elements);

        int currentElement = elements[0];
        int numberOfDuplicates = 1;
        int maxNumberOfDuplicates = 1;
        for (int i = 1; i < size; i++) {
            final int element = elements[i];
            if (currentElement != element) {
                numberOfDuplicates = 1;
            } else {
                numberOfDuplicates++;

                if (numberOfDuplicates > maxNumberOfDuplicates) {
                    maxNumberOfDuplicates = numberOfDuplicates;
                }
            }

            currentElement = element;
        }

        return (size - maxNumberOfDuplicates);
    }
}
