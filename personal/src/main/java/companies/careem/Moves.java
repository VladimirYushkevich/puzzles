package companies.careem;

import java.io.IOException;
import java.util.Scanner;

public class Moves {

    static int moves(int[] a) {
        int moves = 0;

        int numberOfEvens = 0;
        int lastEvenIndex = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0) {
                numberOfEvens++;
                lastEvenIndex = i;
            }
        }

        if (lastEvenIndex == numberOfEvens - 1) {
            return moves;
        }

        int oddSwap = 0;
        int evenSwap = 0;
        int oddIndex = 0;
        int evenIndex = 0;
        for (int i = 0; i < a.length; i++) {
            System.out.println("i: " + i);
            if (a[i] % 2 == 0 && evenSwap == 0 && i >= numberOfEvens) {
                evenSwap = a[i];
                evenIndex = i;
            } else if (a[i] % 2 != 0 && oddSwap == 0) {
                oddSwap = a[i];
                oddIndex = i;

                evenSwap = 0;
            }

            if (oddSwap > 0 && evenSwap > 0) {
                a[oddIndex] = evenSwap;
                a[evenIndex] = oddSwap;

                moves++;

                oddSwap = 0;
                evenSwap = 0;

                i = oddIndex;
                if (evenIndex >= numberOfEvens - 1) {
                    break;
                }
            }
        }

        return moves;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
//        final String fileName = System.getenv("OUTPUT_PATH");
//        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        int res;

        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine().trim());
        int[] _a = new int[_a_size];
        int _a_item;
        for (int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine().trim());
            _a[_a_i] = _a_item;
        }

        res = moves(_a);
//        bw.write(String.valueOf(res));
//        bw.newLine();
//
//        bw.close();
        System.out.println(res);
    }
}
