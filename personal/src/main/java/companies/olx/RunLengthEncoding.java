package companies.olx;

import java.util.stream.Stream;

public class RunLengthEncoding {

    static String encode(String input) {
        if (input.isEmpty()) {
            return "";
        }
        char currentChar = input.charAt(0);
        int counter = 0;
        StringBuilder res = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (currentChar == c) {
                counter++;
            } else {
                res.append(currentChar).append(counter);
                currentChar = c;
                counter = 1;
            }
        }
        res.append(currentChar).append(counter);

        return res.toString();
    }
}
