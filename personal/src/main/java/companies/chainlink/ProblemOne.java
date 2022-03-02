package companies.chainlink;

import java.util.LinkedList;
import java.util.Queue;

public class ProblemOne {

    public static int minMoves(int n, int startRow, int startCol, int endRow, int endCol) {
        if (startRow == endRow && startCol == endCol)
            return -1;

        return minStepToReachTarget(new int[]{startRow, startCol}, new int[]{endRow, endCol}, n);
    }

    static int minStepToReachTarget(
            int[] knightPos, int[] targetPos,
            int N) {
        // x and y direction, where a knight can move
        int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        // queue for storing states of knight in board
        Queue<Cell> cells = new LinkedList<>();

        // push starting position of knight with 0 distance
        cells.add(new Cell(knightPos[0], knightPos[1], 0));

        boolean[][] visited = new boolean[N][N];

        // visit starting state
        visited[knightPos[0]][knightPos[1]] = true;

        int x, y;
        // loop until we have one element in queue
        while (!cells.isEmpty()) {
            Cell current = cells.poll();

            // return its distance
            if (current.x == targetPos[0] && current.y == targetPos[1])
                return current.distance;

            // loop for all reachable states
            for (int i = 0; i < 8; i++) {
                x = current.x + dx[i];
                y = current.y + dy[i];

                // If reachable state is not yet visited and
                // inside board, push that state into queue
                if (isInside(x, y, N) && !visited[x][y]) {
                    visited[x][y] = true;
                    cells.add(new Cell(x, y, current.distance + 1));
                }
            }
        }
        return -1;
    }

    static boolean isInside(int x, int y, int N) {
        return x >= 0 && x < N && y > 0 && y < N;
    }

    static class Cell {
        int x, y;
        int distance;

        public Cell(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
