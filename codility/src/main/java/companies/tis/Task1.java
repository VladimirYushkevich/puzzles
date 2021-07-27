package companies.tis;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Task1 {

    public int solution(String S) {
        TreeSet<String> substrings = new TreeSet<>();
        // get all substrings
        for (int i = 0; i < S.length(); i++) {
            substrings.add(Character.toString(S.charAt(i)));
        }

        StringBuilder temp;
        for (int i = 0; i < S.length(); i++) {
            temp = new StringBuilder();
            for (int j = i + 1; j < S.length(); j++) {
                temp.append(S.charAt(j));
                substrings.add(temp.toString());
            }

        }

        int minLength = 200;
        for (String substring : substrings) {
            Set<Character> uppers = new HashSet<>();
            Set<Character> lowers = new HashSet<>();

            for (Character ch : substring.toCharArray()) {
                char charToAdd = Character.toLowerCase(ch);
                if (Character.isUpperCase(ch)) {
                    uppers.add(charToAdd);
                } else {
                    lowers.add(charToAdd);
                }
            }

            boolean isBalanced = true;
            int length = 0;
            for (Character ch : substring.toCharArray()) {
                char charToAdd = Character.toLowerCase(ch);
                if (uppers.contains(charToAdd) && lowers.contains(charToAdd)) {
                    length++;
                } else {
                    isBalanced = false;
                    break;
                }
            }

            if (isBalanced) {
                if (length < minLength) {
                    minLength = length;
                }
            }
        }

        return minLength;
    }
}
