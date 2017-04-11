package algorithms.implementation;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ModifiedKaprekarNumbers {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        int q = in.nextInt();

        System.out.println(getKaprekar(p, q));
    }

    static String getKaprekar(int min, int max) {
        final StringBuilder result = new StringBuilder();
        int counter = 0;
        for (int i = min; i <= max; i++) {
            if (isKaprekar(i)) {
                result.append(i + " ");
                counter++;
            }
        }

        if (counter == 0) {
            return "INVALID RANGE";
        }

        return result.toString().trim();
    }

    static boolean isKaprekar(int value) {
        if (value == 1) {
            return true;
        }

        final LinkedList<Character> chars = new LinkedList<>(String.valueOf((long) value * value).chars().mapToObj(e -> (char) e).collect(Collectors.toList()));
        final LinkedList<Character> right = new LinkedList<>();

        while (!chars.isEmpty()) {
            final long l = Long.valueOf(chars.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining())
            );

            long r;
            if (!right.isEmpty()) {
                r = Long.valueOf(right.stream()
                        .map(Object::toString)
                        .collect(Collectors.joining())
                );

                if (r > 0 && !(right.peek() == '0' && right.size() != chars.size()) && r + l == value) {
                    return true;
                }
            }

            right.addFirst(chars.removeLast());
        }

        return false;
    }
}
