package companies.twilio;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Real {

    static List<Integer> customSort(List<Integer> arr) {
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (Integer elem : arr) {
            Integer frequency = frequencies.getOrDefault(elem, 0);
            frequencies.put(elem, ++frequency);
        }

        final List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequencies.entrySet());

        entries.sort(Comparator.comparingInt((ToIntFunction<Map.Entry<Integer, Integer>>) Map.Entry::getValue)
                .thenComparingInt(Map.Entry::getKey));

        return entries.stream()
                .flatMap(e -> Collections.nCopies(e.getValue(), e.getKey()).stream())
                .collect(Collectors.toList());
    }

    static int fourthBit(int num) {
        return (num >> 4) & 1;
    }

    static List<String> missingWords(String s, String t) {
        Map<String, Long> stringToCountT = Arrays.stream(t.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<String> res = new ArrayList<>();
        for (String elem : s.split(" ")) {
            Long countT = stringToCountT.get(elem);

            if (countT == null) {
                res.add(elem);
            } else if (countT > 1) {
                stringToCountT.put(elem, --countT);
            } else {
                stringToCountT.remove(elem);
            }
        }

        return res;
    }

    /**
     * https://www.geeksforgeeks.org/count-sub-arrays-sum-divisible-k/
     * <p>
     * Let there be a subarray (i, j) whose sum is divisible by k
     * sum(i, j) = sum(0, j) - sum(0, i-1)
     * Sum for any subarray can be written as q*k + rem where q
     * is a quotient and rem is remainder
     * Thus,
     * sum(i, j) = (q1 * k + rem1) - (q2 * k + rem2)
     * sum(i, j) = (q1 - q2)k + rem1-rem2
     * <p>
     * We see, for sum(i, j) i.e. for sum of any subarray to be
     * divisible by k, the RHS should also be divisible by k.
     * (q1 - q2)k is obviously divisible by k, for (rem1-rem2) to
     * follow the same, rem1 = rem2 where
     * rem1 = Sum of subarray (0, j) % k
     * rem2 = Sum of subarray (0, i-1) % k
     *
     * @param input Array of integers
     * @param k     number for sum of elements in sub arrays to be divisible
     * @return number of sub arrays
     */
    static int numberOfDivisibleSubsequencesOptimal(List<Integer> input, int k) {
        // create auxiliary hash array to count frequency of remainders
        int[] mod = new int[k];
        Arrays.fill(mod, 0);

        // Traverse original array and compute cumulative
        // sum take remainder of this current cumulative
        // sum and increase count by 1 for this remainder
        // in mod[] array
        int sum = 0;
        for (Integer integer : input) {
            sum += integer;

            // as the sum can be negative, taking modulo twice
            int index = ((sum % k) + k) % k;
            mod[index]++;
        }

        // Initialize result
        int result = 0;

        // Traverse mod[]
        for (int i = 0; i < k; i++)

            // If there are more than one prefix subarrays with a particular mod value.
            if (mod[i] > 1)
                result += (mod[i] * (mod[i] - 1)) / 2;

        // add the elements which are divisible by k itself
        // i.e., the elements whose sum = 0
        result += mod[0];

        return result;
    }
}
