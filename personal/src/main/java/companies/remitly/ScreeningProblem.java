package companies.remitly;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a function that returns if a string is a word, can you write a function to determine if a given string is
 * composed entirely of words?  This means that each of the letters is used one time, in order, to create words.
 * ie "thisisawesome", "isisis", "a" should return true
 * "thisisawesomez", "zasdf", "the2" should return false
 * <p>
 * Another way to think about this problem: Is there a way we could add spaces to the input string such that
 * every word is valid?  ie "this is a we so me"
 */

public class ScreeningProblem {

    static Set<String> words;

    static {
        words = new HashSet<>();
        words.add("this");
        words.add("is");
        words.add("a");
        words.add("we");
        words.add("so");
        words.add("me");
        words.add("awesome");
        words.add("greater");
        words.add("great");
        words.add("error");
    }

    /* Here is your helper function */
    static boolean isWord(String candidate) {
        return candidate != null && words.contains(candidate.toLowerCase());
    }

    static boolean find(String input) {
        if (isWord(input)) {
            return true;
        }

        char[] chars = input.toCharArray();
        boolean isWord = false;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            result.append(chars[i]);

            if (isWord(result.toString())) {
                isWord = find(input.substring(i + 1));
            }
        }

        return isWord;
    }
}
