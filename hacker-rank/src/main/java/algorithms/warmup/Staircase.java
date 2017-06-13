package algorithms.warmup;

import java.util.Scanner;

public class Staircase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(new String(new char[n - i - 1]).replace('\0', ' ') +
                    new String(new char[i + 1]).replace('\0', '#'));
        }
    }
}
