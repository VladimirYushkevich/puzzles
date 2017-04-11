package algorithms.implementation;

import java.util.Scanner;

public class BiggerIsGreater {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            System.out.println(nextPermutation(in.next()));
        }
    }

    static String nextPermutation(String word) {
        final char[] chars = word.toCharArray();

        // Find longest non-increasing suffix
        int i = chars.length - 1;
        while (i > 0 && chars[i - 1] >= chars[i]) {
            i--;
        }
        // Now i is the head index of the suffix

        // Are we at the last permutation already?
        if (i <= 0) {
            return "no answer";
        }

        // Let array[i - 1] be the pivot
        // Find rightmost element that exceeds the pivot
        int j = chars.length - 1;
        while (chars[j] <= chars[i - 1]) {
            j--;
        }
        // Now the value array[j] will become the new pivot

        // Swap the pivot with j
        char temp = chars[i - 1];
        chars[i - 1] = chars[j];
        chars[j] = temp;

        // Reverse the suffix
        j = chars.length - 1;
        while (i < j) {
            temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

        if (word.equals(String.valueOf(chars))) {
            return "no answer";
        }

        return String.valueOf(chars);
    }
}
