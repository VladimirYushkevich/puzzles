package algorithms.strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Main idea: if second string is reversed then solution is to find longest common substring between two strings. And longest
 * palindrome after it from both strings.
 */
public class BuildAPalindrome {

    private static String longestPalindrome;

    private static int minCommonFirstIndex;
    private static int minCommonSecondIndex;
    private static int maxCommonLength;

    static String solution(String first, String second) {
        longestPalindrome = "";
        minCommonFirstIndex = first.length();
        minCommonSecondIndex = second.length();
        maxCommonLength = 0;

        String reversed = new StringBuilder(second).reverse().toString();
        Manacher fistManacher = new Manacher(first);
        Manacher secondManacher = new Manacher(reversed);

        findLongestPalindrome(first, reversed, fistManacher.pal, secondManacher.pal);

        return longestPalindrome.isEmpty() ? "-1" : longestPalindrome;
    }

    private static boolean getLongestPalindrome(String pal, String toCheck) {
        return toCheck.length() > pal.length() || pal.compareTo(toCheck) > 0 && toCheck.length() >= pal.length();
    }

    /**
     * Returns the longest palindromic string of the two specified strings. By using predefined Manacher'first structures
     *
     * @param first        one string
     * @param second       the other string
     * @param manPalFirst  Array of palindromic indexes for one string
     * @param manPalSecond Array of palindromic indexes for other string
     *                     in both {@code first} and {@code second}; the empty string
     *                     if no such string
     */
    private static void findLongestPalindrome(String first, String second, int[] manPalFirst, int[] manPalSecond) {
        SuffixArray suffixFirst = new SuffixArray(first);
        SuffixArray suffixSecond = new SuffixArray(second);

        int firstLength = first.length();
        int secondLength = second.length();
        int i = 0, j = 0;
        while (i < firstLength && j < secondLength) {
            int firstSuffixIndex = suffixFirst.index(i);
            int secondSuffixIndex = suffixSecond.index(j);
            if (LongestCommonSubstring.compare(first, firstSuffixIndex, second, secondSuffixIndex, manPalFirst, manPalSecond) < 0) {
                i++;
                if (j > 0) {
                    j--;
                }
            } else {
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            String first = in.next();
            String second = in.next();

            result[i] = solution(first, second);
        }

        for (String s : result) {
            System.out.println(s);
        }
    }

    /**
     * https://algs4.cs.princeton.edu/63suffix/SuffixArray.java.html
     */
    private static class SuffixArray {
        private Suffix[] suffixes;

        /**
         * Initializes a suffix array for the given {@code text} string.
         *
         * @param text the input string
         */
        SuffixArray(String text) {
            int n = text.length();
            this.suffixes = new Suffix[n];
            for (int i = 0; i < n; i++)
                suffixes[i] = new Suffix(text, i);
            Arrays.sort(suffixes);
        }

        /**
         * Returns the index into the original string of the <em>i</em>th smallest suffix.
         * That is, {@code text.substring(sa.index(i))} is the <em>i</em>th smallest suffix.
         *
         * @param i an integer between 0 and <em>n</em>-1
         * @return the index into the original string of the <em>i</em>th smallest suffix
         * @throws IllegalArgumentException unless {@code 0 <= i < n}
         */
        int index(int i) {
            if (i < 0 || i >= suffixes.length) throw new IllegalArgumentException();
            return suffixes[i].index;
        }

        private static class Suffix implements Comparable<Suffix> {
            private final String text;
            private final int index;

            private Suffix(String text, int index) {
                this.text = text;
                this.index = index;
            }

            private int length() {
                return text.length() - index;
            }

            private char charAt(int i) {
                return text.charAt(index + i);
            }

            public int compareTo(Suffix that) {
                if (this == that) return 0;  // optimization
                int n = Math.min(this.length(), that.length());
                for (int i = 0; i < n; i++) {
                    if (this.charAt(i) < that.charAt(i)) return -1;
                    if (this.charAt(i) > that.charAt(i)) return +1;
                }
                return this.length() - that.length();
            }

            public String toString() {
                return text.substring(index);
            }
        }
    }

    /**
     * Modification of {@code LongestCommonSubstring} class provides a {@link SuffixArray}
     * client for computing the longest common substring that appears in two
     * given strings.
     * <p>
     * This implementation computes the suffix array of each string and applies a
     * merging operation to determine the longest common substring.
     * For an alternate implementation, see
     * <a href = "https://algs4.cs.princeton.edu/63suffix/LongestCommonSubstringConcatenate.java.html">LongestCommonSubstringConcatenate.java</a>.
     * <p>
     * For additional documentation,
     * see <a href="https://algs4.cs.princeton.edu/63suffix">Section 6.3</a> of
     * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
     * <p>
     */
    private static class LongestCommonSubstring {

        private static void updatePalindrome(int n, String s, int p, String t, int q, int[] palS, int[] palT) {
            int psLength = p + n < palS.length ? palS[p + n] : 0;
            int ptLength = q + n < palT.length ? palT[q + n] : 0;

            int pLength = Math.max(psLength, ptLength);
            if (2 * n + pLength > longestPalindrome.length()) {
                String ps = psLength > 0 ? s.substring(p + n, p + n + psLength) : "";
                String pt = ptLength > 0 ? t.substring(q + n, q + n + ptLength) : "";

                String substring = s.substring(p, p + n);
                if (!substring.isEmpty()) {
                    String palindrome = getLongestPalindrome(ps, pt) ? pt : ps;
                    String res = substring + palindrome + new StringBuilder(substring).reverse();
                    if (getLongestPalindrome(longestPalindrome, res)) {
                        longestPalindrome = res;
                    }
                }
            }
        }

        /**
         * compare suffix s[p..] and suffix t[q..] and update palindrome
         * 0 1 2 3 4 5 6 7 8 9 => maxCommonLength: 4
         * x y z p w a b c d q => first: [5,8]
         * t g l i a b c d p o => second: [4,7]
         * When p - q = minFirst - minSecond
         * Case1 (p < minFirst && q < minSecond): p=3, q=2 => p-q=1, nP:[3;5], nQ:[2;4] or i:[0,2]
         * Case2 (maxFirst > p > minFirst && maxSecond > q > minSecond): p=6, q=5 => p-q=1, nP=8, nQ=7 or i=2
         **/
        private static int compare(String s, int p, String t, int q, int[] palS, int[] palT) {
            int n = Math.min(s.length() - p, t.length() - q);

            if (p - q == minCommonFirstIndex - minCommonSecondIndex && p > minCommonFirstIndex && q > minCommonSecondIndex) {
                updatePalindrome(minCommonFirstIndex + maxCommonLength - p, s, p, t, q, palS, palT);
                return Integer.compare(s.length() - p, t.length() - q);
            }

            for (int i = 0; i < n; i++) {
                if (s.charAt(p + i) != t.charAt(q + i)) {
                    if (i > maxCommonLength) {
                        minCommonFirstIndex = p;
                        minCommonSecondIndex = q;
                        maxCommonLength = i;
                    }

                    updatePalindrome(i, s, p, t, q, palS, palT);
                    return s.charAt(p + i) - t.charAt(q + i);
                }
            }

            updatePalindrome(n, s, p, t, q, palS, palT);
            return Integer.compare(s.length() - p, t.length() - q);
        }
    }

    /**
     * http://www.leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
     */
    static class Manacher {
        public int[] pal;  // length of palindromic substring of t, started at i
        private int[] p;  // p[i] = length of longest palindromic substring of t, centered at i
        private String s;  // original string
        private char[] t;  // transformed string

        Manacher(String s) {
            this.s = s;
            preprocess();

            p = new int[t.length];
            pal = new int[s.length()];

            int center = 0, right = 0;
            for (int i = 1; i < t.length - 1; i++) {
                int mirror = 2 * center - i;

                if (right > i) {
                    p[i] = Math.min(right - i, p[mirror]);
                }

                // attempt to expand palindrome centered at i
                int cnt = 0;
                while (t[i + (1 + p[i])] == t[i - (1 + p[i])]) {
                    // important for smallest palindromes which are a part of big ones
                    if (!Character.valueOf('#').equals(t[i - (1 + p[i])]) && i > 3) {
                        cnt++;
                        pal[(i - (1 + p[i]) - 2) / 2] = 2 * cnt + 1;
                    }
                    p[i]++;
                }

                // if palindrome centered at i expands past right,
                // adjust center based on expanded palindrome.
                if (i + p[i] > right) {
                    center = i;
                    right = i + p[i];
                }

                if (p[i] < 1) {
                    pal[(i - 2) / 2] = 1;
                } else {
                    pal[(i - 1 - p[i]) / 2] = p[i];
                }
            }
        }

        // Transform s into t.
        // For example, if s = "abba", then t = "$#a#b#b#a#@"
        // the # are interleaved to avoid even/odd-length palindromes uniformly
        // $ and @ are prepended and appended to each end to avoid bounds checking
        private void preprocess() {
            t = new char[s.length() * 2 + 3];
            t[0] = '$';
            t[s.length() * 2 + 2] = '@';
            for (int i = 0; i < s.length(); i++) {
                t[2 * i + 1] = '#';
                t[2 * i + 2] = s.charAt(i);
            }
            t[s.length() * 2 + 1] = '#';
        }
    }
}