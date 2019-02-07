package companies.olx;

import java.util.ArrayList;
import java.util.List;

class PrimeNumberSearcher {

    static List<Integer> findAllPrimeNumbers(int limit) {
        List<Integer> output = new ArrayList<>();

        for (int i = 0; i < limit; i++) {
            long count = 0L;
            for (int n = i; n > 0; n--) {
                if (i % n == 0) {
                    count++;
                }
                if (count > 2) {
                    break;
                }
            }
            if (count == 2) {
                output.add(i);
            }
        }

        return output;
    }

    static List<Integer> sieveOfEratosthenes(int limit) {
        List<Integer> output = new ArrayList<>();

        boolean prime[] = new boolean[limit + 1];
        for (int i = 0; i < limit; i++) {
            prime[i] = true;
        }

        for (int p = 2; p * p <= limit; p++) {
            // If prime[p] is not changed, then it is a prime
            if (prime[p]) {
                // Update all multiples of p
                for (int i = p * p; i <= limit; i += p) {
                    prime[i] = false;
                }
            }
        }

        for (int i = 2; i <= limit; i++) {
            if (prime[i]) {
                output.add(i);
            }
        }

        return output;
    }
}
