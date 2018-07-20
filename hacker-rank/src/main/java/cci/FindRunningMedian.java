package cci;

import java.util.Scanner;

public class FindRunningMedian {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BinaryHeap heap = new BinaryHeap(n);
        for (int a_i = 0; a_i < n; a_i++) {
            heap.add(in.nextInt());

            System.out.println(heap.getMedian());
        }
    }

    static class BinaryHeap {

        final int[] items;
        int size;

        BinaryHeap(int capacity) {
            this.items = new int[capacity];
        }

        void swap(int one, int two) {
            int temp = items[one];
            items[one] = items[two];
            items[two] = temp;
        }

        void add(int item) {
            items[size] = item;

            int index = size;
            for (int i = size - 1; i >= 0; i--) {
                if (item < items[i]) {
                    swap(index, i);
                    index--;
                } else {
                    break;
                }
            }

            size++;
        }

        double getMedian() {
            if (size % 2 == 0) {
                return (items[size / 2 - 1] + items[size / 2]) / 2.0d;
            } else {
                return items[size / 2];
            }
        }
    }
}
