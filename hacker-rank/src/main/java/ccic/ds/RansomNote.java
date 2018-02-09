package ccic.ds;

import java.util.HashMap;
import java.util.Scanner;

import static java.util.Objects.isNull;

public class RansomNote {

    static boolean solve(String magazine[], String ransom[]) {
        int magazineLength = magazine.length;
        int ransomLength = ransom.length;
        HashMap<String, Integer> counts = new HashMap<>(magazineLength);

        for (String key : magazine) {
            Integer cnt = counts.getOrDefault(key, 0);
            counts.put(key, ++cnt);
        }
        for (String key : ransom) {
            Integer cnt = counts.get(key);
            if (isNull(cnt) || cnt == 0) {
                return false;
            } else {
                counts.put(key, --cnt);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for (int magazine_i = 0; magazine_i < m; magazine_i++) {
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for (int ransom_i = 0; ransom_i < n; ransom_i++) {
            ransom[ransom_i] = in.next();
        }

        if (solve(magazine, ransom))
            System.out.println("Yes");
        else System.out.println("No");
    }
}
