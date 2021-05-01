package companies.token;

import java.util.HashMap;

public class StringReduction {

    /**
     * "abab" -> "ab", "ba"
     * "abcab" ->
     */
    public static int getMinDeletions(String s) {
        // Assumption: string has all different substrings only if it contains different characters
        HashMap<Character, Integer> counts = new HashMap<>();
        char[] chars = s.toCharArray();
        int res = 0;
        // we need to count number of repetitions of each character greater than 1
        for (int i = 0; i < s.length(); i++) {
            char bucket = chars[i];
            Integer numberOfRepetitions = counts.getOrDefault(bucket, 0);
            if (numberOfRepetitions > 0) res++;
            counts.put(bucket, ++numberOfRepetitions);
        }

        return res;
    }
}
