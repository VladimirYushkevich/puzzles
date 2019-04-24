package companies.google.phoneinterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Real phone interview
 */
class PairSum {

    private ArrayList<Integer> addedNumbers = new ArrayList<>();

    void add(int number) {
        addedNumbers.add(number);
    }


    /**
     * Check if any of two previously added numbers has <code>sum</code>
     *
     * @param sum Possible sum of any two previously added values
     * @return result
     */
    boolean test(int sum) {
        return linear(sum);
    }

    private boolean linear(int sum) {
        Set<Integer> complements = new HashSet<>();
        for (int value : addedNumbers) {
            if (complements.contains(sum - value)) {
                return true;
            }

            complements.add(value);
        }

        return false;
    }

    private boolean logarithmic(int sum) {
        Collections.sort(addedNumbers);
        int size = addedNumbers.size();
        for (int i = 0; i < size - 1; i++) {
            int pairOne = addedNumbers.get(i);
            int pairTwo = addedNumbers.get(i + 1);
            if (pairOne + pairTwo == sum) {
                return true;
            }
        }

        return false;
    }

    private boolean quadratic(int sum) {
        for (Integer pairOne : addedNumbers) {
            for (Integer pairTwo : addedNumbers) {
                if (pairOne + pairTwo == sum) {
                    return true;
                }
            }
        }
        return false;
    }
}
