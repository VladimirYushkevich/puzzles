package cci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class IceCreamParlor {

    private static final HashMap<Integer, Integer> complements = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    static void whatFlavors(int[] cost, int money) {
        int[] flavors = findFlavors(cost, money);

        StringBuilder output = new StringBuilder(flavors.length);
        output.append(flavors[0]);
        for (int i = 1; i < flavors.length; i++) {
            output.append(" " + flavors[i]);
        }

        System.out.println(output.toString());
    }

    static int[] findFlavors(int[] cost, int money) {
        complements.clear();
        for (int i = 0; i < cost.length; i++) {
            int costItem = cost[i];
            int complement = money - costItem;
            if (complements.containsKey(complement)) {
                final int[] res = {complements.get(complement), i + 1};
                Arrays.sort(res);
                return res;
            }
            complements.put(costItem, i + 1);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            complements.clear();

            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;

                int complement = money - costItem;
                if (complements.containsKey(complement)) {
                    final int[] res = {complements.get(complement), i + 1};
                    Arrays.sort(res);
                    System.out.println(res[0] + " " + res[1]);
                }
                complements.put(costItem, i + 1);
            }
        }

        scanner.close();
    }
}
