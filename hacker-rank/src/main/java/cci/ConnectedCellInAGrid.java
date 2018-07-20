package cci;

import java.util.LinkedList;
import java.util.Scanner;

public class ConnectedCellInAGrid {

    static int maxRegion(int[][] grid, int n, int m) {
        boolean visited[][] = new boolean[n][m];


        int max = 0;
        LinkedList<Node> nextToVisit = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    nextToVisit.add(new Node(i, j));
                    int count = DFS(grid, visited, max, n, m, nextToVisit);
                    max = count > max ? count : max;
                }
            }
        }

        return max;
    }

    private static boolean isSafe(int M[][], int row, int col, int n, int m, boolean[][] visited) {
        return (row >= 0) && (row < n) &&
                (col >= 0) && (col < m) &&
                (M[row][col] == 1 && !visited[row][col]);
    }

    private static int DFS(int M[][], boolean visited[][], int max, int n, int m, LinkedList<Node> nextToVisit) {
        // These arrays are used to get row and column numbers
        // of 8 neighbors of a given cell
        int rowNbr[] = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int colNbr[] = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        int count = 0;
        // Recur for all connected neighbours
        while (!nextToVisit.isEmpty()) {
            Node nextNode = nextToVisit.removeLast();
            final int row = nextNode.row;
            final int col = nextNode.col;

            if (visited[row][col]) {
                continue;
            } else {
                count++;
            }

            // Mark this cell as visited
            visited[row][col] = true;

            for (int k = 0; k < 8; k++) {
                final int newRow = row + rowNbr[k];
                final int newCol = col + colNbr[k];
                if (isSafe(M, newRow, newCol, n, m, visited)) {
                    nextToVisit.add(new Node(newRow, newCol));
                }
            }
        }

        return count;
    }

    private static class Node {
        int row;
        int col;

        Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] gridRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < m; j++) {
                int gridItem = Integer.parseInt(gridRowItems[j]);
                grid[i][j] = gridItem;
            }
        }

        scanner.close();

        System.out.println(maxRegion(grid, n, m));
    }
}
