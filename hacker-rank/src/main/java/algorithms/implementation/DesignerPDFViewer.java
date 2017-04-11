package algorithms.implementation;

import java.util.Scanner;

public class DesignerPDFViewer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] letterHeights = new int[26];
        for (int h_i = 0; h_i < 26; h_i++) {
            letterHeights[h_i] = in.nextInt();
        }
        String word = in.next();

        System.out.println(getWordSquare(word, letterHeights));
    }

    static int getWordSquare(String word, int[] letterHeights) {
        int maxLetterHeight = 0;
        for (char letter : word.toCharArray()) {
            final int newLetterHeight = letterHeights[letter - 'a'];
            if (newLetterHeight > maxLetterHeight) {
                maxLetterHeight = newLetterHeight;
            }
        }

        return word.length() * maxLetterHeight;
    }
}
