package companies.amazon;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
        Queue<Integer> dispensers = Stream.of(X, Y, Z).filter(d -> d > 0).collect(Collectors.toCollection(LinkedList::new));
        Queue<Integer> occupied = IntStream.of(new int[dispensers.size()]).boxed().collect(Collectors.toCollection(LinkedList::new));
        Queue<Integer> cars = Arrays.stream(A).boxed().collect(Collectors.toCollection(LinkedList::new));

        Iterator<Integer> carIterator = cars.iterator();
        while (carIterator.hasNext() && !dispensers.isEmpty()) {
            int capacity = carIterator.next();

            if (dispensers.peek() >= capacity) {
                carIterator.remove();

                if (cars.size() == 0) {
                    return occupied.peek();
                } else {
                    // always reset to the beginning of the queue
                    carIterator = cars.iterator();
                }

                int dispenserCapacity = dispensers.poll();
                dispenserCapacity -= capacity;
                dispensers.add(dispenserCapacity);

                int occupiedCapacity = occupied.poll();
                occupiedCapacity += capacity;
                occupied.add(occupiedCapacity);
            }

            // dispenser has not enough fuel for the rest cars, remove it
            if (!carIterator.hasNext()) {
                dispensers.poll();
                occupied.poll();
                carIterator = cars.iterator();
            }
        }

        return -1;
    }
}
