package cci;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Primality {

    private static final Scanner scanner = new Scanner(System.in);

    static List<String> primality(List<Integer> input) {
        List<String> output = new ArrayList<>();

        for (Integer index : input) {
            output.add(getPrime(index));
        }

        return output;

    }

    private static String getPrime(Integer value) {
        if (value == 1) {
            return "Not prime";
        }

        int sqrt = (int) Math.sqrt(value);
        for (int i = 2; i <= sqrt; i++) {
            if (value % i == 0) {
                return "Not prime";
            }
        }

        return "Prime";
    }

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int pItr = 0; pItr < p; pItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            bufferedWriter.write(getPrime(n));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
