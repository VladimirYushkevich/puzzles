package companies.amazon;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2019 {

    public int testTask(int[] A) {
        int elementRange = 1_000_001;
        boolean[] bitSet = new boolean[elementRange];

        for (int elem : A) {
            if (elem > 0) {
                bitSet[elem] = true;
            }
        }

        for (int i = 1; i <= elementRange; i++) {
            if (!bitSet[i]) {
                return i;
            }
        }

        return 1;
    }

    public int solution1(int N) {
        List<Integer> sublings = String.valueOf(N).chars()
                .map(Character::getNumericValue)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        String maxSublingResult = sublings.stream().map(String::valueOf).collect(Collectors.joining(""));

        return Integer.parseInt(maxSublingResult);
    }

    public int solution2(int n) {
        int[] d = new int[30];
//        int[] d = new int[]{1,1,0,0,1,1,0};
        int l = 0;
//        int l =7;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
//        IntStream.of(d).forEach(System.out::println);
        for (p = l / 2; p > 0; p--) {
            int i;
            boolean ok = true;
            for (i = 0; i < (l - l / 2); i++) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }

    public int solution3(int[] A, int X, int Y, int Z) {
        int numberOfDispensers = 3;
        int numberOfCars = A.length;

        Queue<Integer> occupied = new LinkedList<>(Arrays.asList(0, 0, 0));
        Queue<Integer> dispensers = new LinkedList<>(Arrays.asList(X, Y, Z));

        for (int i = 0; i < numberOfCars; i++) {
            int capacity = A[i];

            for (int j = 0; j < numberOfDispensers; j++) {
                if (dispensers.peek() >= capacity) {
                    if (i == numberOfCars - 1) {
                        return occupied.peek();
                    }

                    int dispenserCapacity = dispensers.poll();
                    dispenserCapacity -= capacity;
                    dispensers.add(dispenserCapacity);

                    int occupiedCapacity = occupied.poll();
                    occupiedCapacity += capacity;
                    occupied.add(occupiedCapacity);
                } else {
                    // not enough fuel for current car
                    if (j == numberOfDispensers - 1) {
                        return -1;
                    }

                    //allow next car from queue
                    if (i < numberOfCars - 1) {
                        int next = A[i + 1];
                        A[i + 1] = A[i];
                        A[i] = next;
                        i--;
                    }
                }

                break;
            }

        }
        return -1;
    }
}
