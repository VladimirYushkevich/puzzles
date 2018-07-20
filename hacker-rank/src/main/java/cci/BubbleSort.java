package cci;

public class BubbleSort {

    static int[] solution(int[] a) {
        int[] res = new int[3];

        int length = a.length;

        int swapCount = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int next = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = next;
                    swapCount++;
                }
            }
        }

        res[0] = swapCount;
        res[1] = a[0];
        res[2] = a[length - 1];

        return res;
    }

    static void countSwaps(int[] a) {
        int[] res = solution(a);

        System.out.println(String.format("Array is sorted in %s swaps.", res[0]));
        System.out.println(String.format("First Element: %s", res[1]));
        System.out.println(String.format("Last Element: %s", res[2]));
    }
}
