package algorithms.implementation;

import java.util.*;

public class MatrixLayerRotation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int r = in.nextInt();

        int[][] input = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                input[i][j] = in.nextInt();
            }
        }

        int numberOfQueues = m <= n ? m / 2 : n / 2;

        List<Queue<Integer>> queues = new ArrayList<>(numberOfQueues);
        for (int i = 0; i < numberOfQueues; i++) {
            Queue<Integer> layer = getLayer(i, input, m, n, r);
            queues.add(layer);
        }

        for (int i = 0; i < numberOfQueues; i++) {
            constructArray(i, input, queues.get(i), m, n);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(input[i][j] + " ");
            }
            System.out.print('\n');
        }
    }

    private static void constructArray(int layerNumber, int[][] input, Queue<Integer> queue, int m, int n) {
        final Iterator<Integer> iterator = queue.iterator();
        //top raw
        for (int i = layerNumber; i < n - layerNumber; i++) {
            input[layerNumber][i] = iterator.next();
        }
        //right column
        for (int i = layerNumber + 1; i < m - layerNumber; i++) {
            input[i][n - 1 - layerNumber] = iterator.next();
        }
        //bottom raw
        for (int i = n - layerNumber - 2; i >= layerNumber; i--) {
            input[m - 1 - layerNumber][i] = iterator.next();
        }
        //left column reverse order
        for (int i = m - layerNumber - 2; i > layerNumber; i--) {
            input[i][layerNumber] = iterator.next();
        }
    }

    private static Queue<Integer> getLayer(int layerNumber, int[][] input, int m, int n, int r) {
        Queue<Integer> layer = new LinkedList<>();
        //top raw
        for (int i = layerNumber; i < n - layerNumber; i++) {
            layer.add(input[layerNumber][i]);
        }
        //right column
        for (int i = layerNumber + 1; i < m - layerNumber; i++) {
            layer.add(input[i][n - 1 - layerNumber]);
        }
        //bottom raw(reverse order)
        for (int i = n - layerNumber - 2; i >= layerNumber; i--) {
            layer.add(input[m - 1 - layerNumber][i]);
        }
        //left column reverse order
        for (int i = m - layerNumber - 2; i > layerNumber; i--) {
            layer.add(input[i][layerNumber]);
        }

        //rotate
        final int size = layer.size();
        if (r > size) {
            r = r % size;
        }

        if (r > 0) {
            for (int i = 0; i < r; i++) {
                int head = layer.poll();
                layer.add(head);
            }
        }

        return layer;
    }
}
