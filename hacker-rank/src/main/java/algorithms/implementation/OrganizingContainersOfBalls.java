package algorithms.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class OrganizingContainersOfBalls {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int a0 = 0; a0 < q; a0++) {
            int n = in.nextInt();
            int[][] M = new int[n][n];
            for (int M_i = 0; M_i < n; M_i++) {
                for (int M_j = 0; M_j < n; M_j++) {
                    M[M_i][M_j] = in.nextInt();
                }
            }
            System.out.println(checkQuery(M, n));
        }
    }

    static String checkQuery(int[][] M, int n) {
        int[] types = new int[n];
        int[] containers = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                types[i] = types[i] + M[i][j];
                containers[i] = containers[i] + M[j][i];
            }
        }

        Arrays.sort(types);
        Arrays.sort(containers);

        for (int i = 0; i < n; i++) {
            if (types[i] != containers[i]) {
                return "Impossible";
            }
        }
        return "Possible";
    }
}
