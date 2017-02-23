package companies.careem;

import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

public class SubarrayProducts {

    private static void populateSubarray(int[] data, int prevIndex, int fromIndex, int endIndex, Stack<Integer> stack, int sumInStack,
                                         int target, AtomicInteger count) {
        int prevIndexLocal = prevIndex;

        if (sumInStack >= target) {
            return;
        } else if (!stack.isEmpty()) {
            count.incrementAndGet();
        }

        for (int currentIndex = fromIndex; currentIndex < endIndex; currentIndex++) {
            if (sumInStack * data[currentIndex] <= target && (currentIndex - prevIndexLocal) < 2) {
                if (stack.isEmpty()) {
                    prevIndexLocal = currentIndex;
                }

                stack.push(data[currentIndex]);
                sumInStack *= data[currentIndex];

                populateSubarray(data, prevIndexLocal, currentIndex + 1, endIndex, stack, sumInStack, target, count);
                Integer value = stack.pop();
                sumInStack = sumInStack / value;
            }
        }
    }

    private static void print(Stack<Integer> stack, int target) {
        StringBuilder sb = new StringBuilder();
        sb.append(target).append(" > ");
        for (Integer i : stack) {
            sb.append(i).append("*");
        }
        System.out.println("stack: " + stack + ", " + sb.deleteCharAt(sb.length() - 1).toString());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int k = in.nextInt();

        AtomicInteger counter = new AtomicInteger(0);
        populateSubarray(a, 0, 0, n, new Stack<>(), 1, k, counter);

        System.out.println(counter);
    }
}
