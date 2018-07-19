package companies.amazon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2 {
    boolean solution(String S, String T) {
        List<Character> firstChars = getString(S);
        List<Character> secondChars = getString(T);

        for (int i = 0; i < firstChars.size(); i++) {
            Character first = firstChars.get(i);
            Character second = secondChars.get(i);
            if (first.equals('#') || second.equals('#')) {
                continue;
            }
            if (!first.equals(second)) {
                return false;
            }
        }

        return true;
    }

    private List<Character> getString(String input) {
        List<Character> chars = new ArrayList<>();
        StringBuilder number = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                number.append(c);
                continue;
            }

            if (number.length() > 0) {
                chars.addAll(Collections.nCopies(Integer.parseInt(number.toString()), '#'));
                number = new StringBuilder();
            }

            chars.add(c);
        }
        if (number.length() > 0) {
            chars.addAll(Collections.nCopies(Integer.parseInt(number.toString()), '#'));
        }

        return chars;
    }
}
