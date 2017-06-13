package ccic.ds.strings;

import java.util.Scanner;

public class MakingAnagrams {

    public static int numberNeeded(String first, String second) {
        int[] counts = new int[26];
        for (char c : first.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c : second.toCharArray()) {
            counts[c - 'a']--;
        }
        int result = 0;
        for (int i : counts) {
            result += Math.abs(i);
        }
        return result;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
