package algorithms.warmup;

import java.util.Scanner;

public class SherlockAndWatson {

    private static int shiftRight(int[] initial, int shift, int index) {
        int size = initial.length;
        if (shift == size) {
            return initial[index];
        }

        if (shift > size) {
            shift = shift % size;
        }

        //last shifted from end
        if (index < shift) {
            return initial[size - shift + index];
        } else {
            return initial[index - shift];
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        int[] m = new int[q];
        for (int i = 0; i < q; i++) {
            m[i] = shiftRight(a, k, in.nextInt());
        }

        for (int i = 0; i < q; i++) {
            System.out.println(m[i]);
        }
    }
}
