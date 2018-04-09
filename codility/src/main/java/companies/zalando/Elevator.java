package companies.zalando;

import java.util.HashSet;
import java.util.Set;

public class Elevator {

    public int solution(int[] A, int[] B, int M, int X, int Y) {

        int stops = 0;
        int numberOfPassengers = 0;
        int capacity = A[0];
        Set<Integer> floors = new HashSet<>();
        int length = A.length;
        for (int i = 0; i < length; i++) {
            ++numberOfPassengers;
            int currentCapacity = i < length - 1 ? A[i + 1] : 0;
            capacity += currentCapacity;
            floors.add(B[i]);

            if (numberOfPassengers == X || capacity > Y || i == length - 1) {
                stops += floors.size() + 1;

                numberOfPassengers = 0;
                capacity = currentCapacity;
                floors.clear();
            }
        }

        return stops;
    }
}
