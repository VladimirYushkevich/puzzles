package companies.amazon;

import java.util.ArrayList;
import java.util.List;

public class Result {

    /*
     * Complete the 'countPossibleSegments' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY weights
     */

    public static long countPossibleSegments(int k, List<Integer> weights) {
        // Write your code here
        int size = weights.size();
        long res = 0;
        for (int i = 0; i < size; i++) {
            int max = weights.get(i);
            int min = weights.get(i);
            for (int j = i; j < size; j++) {
                if (i == j) {
                    res++;
                } else {
                    if (weights.get(j) > max) max = weights.get(j);
                    if (weights.get(j) < min) min = weights.get(j);
                    int diff = max - min;
                    if (diff <= k) {
                        res++;
                    } else break;
                }
            }
        }

        return res;
    }

}
