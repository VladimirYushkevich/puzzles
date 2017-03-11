package algorithms.strings;

import java.util.Scanner;

public class CamelCase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        System.out.println(numberOfWords(s));
    }

    static int numberOfWords(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        int numberOfWords = 1;
        for (char letter : input.toCharArray()) {
            if (!Character.isLowerCase(letter)) {
                numberOfWords++;
            }
        }

        return numberOfWords;
    }
}
