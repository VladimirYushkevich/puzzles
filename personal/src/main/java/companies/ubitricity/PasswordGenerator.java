package companies.ubitricity;

import java.util.Random;

public class PasswordGenerator {

    public static String generatePassword(String input) {
        StringBuilder output = new StringBuilder();

        Random random = new Random();

        int digitCnt = 0;
        int letterCnt = 0;
        int specialCnt = 0;
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCnt++;
            }
            if (Character.isLetter(c)) {
                letterCnt++;
            } else {
                specialCnt++;
            }
            char encoded = (char) random.nextInt(100);
            if (Character.isLetter(encoded)) {
                output.append(encoded);
            }
            System.out.println(Character.getNumericValue(c));
        }

        if (digitCnt < 3 || letterCnt < 3 || specialCnt < 3) {
            throw new IllegalArgumentException("password is too weak");
        }


        return output.toString();
    }


    public static void main(String[] args) {
        System.out.println(PasswordGenerator.generatePassword("hello5e4@3@!!!fwefwfweefewfw"));
    }
}
