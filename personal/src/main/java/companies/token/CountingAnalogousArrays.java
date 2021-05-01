package companies.token;

import java.util.ArrayList;
import java.util.List;

public class CountingAnalogousArrays {

    /**
     * -2, -1, -2, 5
     * 1, 3, 2 [2, 8]
     */
    public static int countAnalogousArrays(List<Integer> consecutiveDifference, int lowerBound, int upperBound) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        List<Integer> analogousArray = new ArrayList<>();
        if (consecutiveDifference.get(0) < 0) {
            analogousArray.add(lowerBound); // value should grow
            min = lowerBound;
        } else {
            analogousArray.add(upperBound); // value should decrease
            max = upperBound;
        }

        for (int i = 1; i < consecutiveDifference.size() + 1; i++) {

            int next = analogousArray.get(i - 1) - consecutiveDifference.get(i - 1);
            if (next < min) min = next;
            if (next > max) max = next;
            analogousArray.add(next);
        }

        // left overflow
        if (min < lowerBound && max < upperBound) {
            int shift = min - lowerBound;
            max = max - shift;
            min = min - shift;
        }

        // right overflow
        if (min > lowerBound && max > upperBound) {
            int shift = max - min;
            max = lowerBound + shift;
            min = lowerBound;
        }

        if (min >= lowerBound && max <= upperBound) {
            return Math.max(upperBound - max, Math.abs(lowerBound - min)) + 1;
        } else {
            return 0;
        }
    }

}
