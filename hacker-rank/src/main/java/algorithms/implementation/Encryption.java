package algorithms.implementation;

import java.util.Scanner;

public class Encryption {

    public static void main(String[] args) {
        System.out.println(encode(new Scanner(System.in).next()));
    }

    static String encode(String original) {
        final String trimmed = original.replaceAll("\\s", "");
        final int length = trimmed.length();

        int rows = (int) Math.floor(Math.sqrt(length));
        int columns = (int) Math.ceil(Math.sqrt(length));
        if (rows * columns < length) {
            rows++;
        }

        final StringBuffer encoded = new StringBuffer();
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                final int index = i + j * columns;
                if (index >= length) {
                    break;
                }
                encoded.append(trimmed.charAt(index));
            }
            encoded.append(' ');
        }

        return encoded.toString().trim();
    }
}
