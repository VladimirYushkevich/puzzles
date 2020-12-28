package companies.zalando;

import org.junit.Test;

import java.util.Random;

import static companies.zalando.Technetium2019.solution;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Technetium2019Test {

    @Test
    public void testSolutionCommon() {
        assertThat(solution(new int[][]{{9, 9, 7}, {9, 7, 2}, {6, 9, 5}, {9, 1, 2}}), is("997952"));
    }

    /*
     * 6|6|6
     * 6|6|7
     * 6|6|6
     * the function should return "66676"
     */
    @Test
    public void testSolutionVerySimple() {
        assertThat(solution(new int[][]{{6, 6, 6}, {6, 6, 7}, {6, 6, 6}}), is("66676"));
    }

    /*
     * 6|6|6|6
     * 6|6|6|6
     * 6|6|6|6
     * 6|7|6|6
     * the function should return "6666766"
     */
    @Test
    public void testSolutionSimple() {
        assertThat(solution(new int[][]{{6, 6, 6, 6}, {6, 6, 6, 6}, {6, 6, 6, 6}, {6, 7, 6, 6}}), is("6666766"));
    }

    /*
     * 7|9|1
     * 3|4|7
     * 2|3|3
     * the function should return "79473"
     */
    @Test
    public void testSolutionSimpleFirst() {
        assertThat(solution(new int[][]{{7, 9, 1}, {3, 4, 7}, {2, 3, 3}}), is("79473"));
    }

    /*
     * 7|2|1
     * 3|4|7
     * 2|3|3
     * the function should return "73473"
     */
    @Test
    public void testCustomFirst() {
        assertThat(solution(new int[][]{{7, 2, 1}, {3, 4, 7}, {2, 3, 3}}), is("73473"));
    }

    /*
     * 7|2|1
     * 3|4|7
     * 5|3|3
     * the function should return "73533"
     */
    @Test
    public void testCustomThird() {
        assertThat(solution(new int[][]{{7, 2, 1}, {3, 4, 7}, {5, 3, 3}}), is("73533"));
    }

    /*
     * 7|2|1
     * 3|4|4
     * 4|4|3
     * the function should return "73443"
     */
    @Test
    public void testCustomFourth() {
        assertThat(solution(new int[][]{{7, 2, 1}, {3, 4, 4}, {4, 4, 3}}), is("73443"));
    }

    /*
     * 9|9|4
     * 8|5|2
     * 6|9|5
     * 9|1|2
     * the function should return "995952"
     */
    @Test
    public void testSolution() {
        assertThat(solution(new int[][]{{9, 9, 4}, {8, 5, 2}, {6, 9, 5}, {9, 1, 2}}), is("995952"));
    }

    @Test
    public void testTimingSolutionFirst() {
        long start = System.currentTimeMillis();
        assertThat(solution(new int[][]{{7, 7, 7, 7, 7}, {7, 7, 7, 7, 7}, {7, 7, 7, 7, 7}, {7, 7, 7, 7, 7}, {7, 7, 7, 7, 7},
                {7, 7, 7, 7, 7}, {7, 7, 7, 7, 7}, {7, 7, 7, 7, 7}, {7, 7, 7, 7, 7}, {7, 7, 7, 7, 7}}), is("77777777777777"));
        System.out.printf("Technetium2019Test 'testTimingSolutionFirst' finished after [%s] s%n",
                (System.currentTimeMillis() - start) / 1000.0d);
    }

    @Test
    public void testTimingSolutionSecond() {
        long start = System.currentTimeMillis();
        assertThat(solution(new int[][]{{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, {9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, {9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
                {9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, {9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, {9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
                {9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, {9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, {9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
                {9, 9, 9, 9, 9, 9, 9, 9, 9, 9}}), is("9999999999999999999"));
        System.out.printf("Technetium2019Test 'testTimingSolutionSecond' finished after [%s] s%n",
                (System.currentTimeMillis() - start) / 1000.0d);
    }

    /*
     * 6|6|6|6
     * 6|6|6|6
     * 6|6|7|6
     * 6|6|6|6
     * the function should return "6666766"
     */
    @Test
    public void testTimingSolutionThird() {
        assertThat(solution(new int[][]{{6, 6, 6, 6}, {6, 6, 6, 6}, {6, 6, 7, 6}, {6, 6, 6, 6}}), is("6666766"));
    }

    @Test
    public void testSameValuesExceptOneSecond() {
        assertThat(solution(new int[][]{{2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, {2, 2, 2, 7, 2, 2, 2, 2, 2, 2},
                        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}}),
                is("2222222722222222"));
    }

    @Test
    public void testSimpleOverflow() {
        assertThat(solution(new int[][]{{2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, {2, 2, 2, 2, 2, 2, 2, 2, 2, 7},
                        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}}),
                is("2222222222222722"));
    }

    /*
     * 6|6|6|8
     * 6|6|6|6
     * 6|6|7|6
     * 6|6|6|6
     * the function should return "6668666"
     */
    @Test
    public void testCustomSecond() {
        assertThat(solution(new int[][]{{6, 6, 6, 8}, {6, 6, 6, 6}, {6, 6, 7, 6}, {6, 6, 6, 6}}), is("6668666"));
    }

    /**
     * 9|2|9|3|5
     * 5|3|9|5|1
     * 5|6|4|9|1
     * 4|3|8|4|5
     * 1|4|3|5|3
     * the function should return "955649453"
     */
    @Test
    public void testRandomSmallTestsThird() {
        assertThat(solution(new int[][]{{9, 2, 9, 3, 5}, {5, 3, 9, 5, 1}, {5, 6, 4, 9, 1}, {4, 3, 8, 4, 5}, {1, 4, 3, 5, 3}}),
                is("955649453"));
    }

    @Test
    public void testBigMatrixSizeFirst() {
        int[][] A = new int[100][1000];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                int value = 4;
                if (i == 60 && j == 30) {
                    value = 8;
                }
                A[i][j] = value;
            }
        }
        long start = System.currentTimeMillis();
        assertThat(solution(A), is("44444444444444444444444444444444444444444444444444444444444444444444444444444" +
                "444444444444484444444444444444444444444444444444444444444444444444444444444444444444444444444444444444" +
                "444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444" +
                "444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444" +
                "444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444" +
                "444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444" +
                "444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444" +
                "444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444" +
                "444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444" +
                "444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444" +
                "444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444444" +
                "44"));
        System.out.printf("Technetium2019Test 'testBigMatrixSizeFirst' finished after [%s] s%n",
                (System.currentTimeMillis() - start) / 1000.0d);
    }

    @Test
    public void testRandomSmallTest() {
        assertThat(solution(new int[][]{{3, 6, 3, 8, 5, 3, 9, 8, 8, 6, 2, 4, 3, 8, 1}, {5, 6, 8, 3, 3, 7, 5, 4, 4, 3, 2, 6, 9, 7, 6},
                        {9, 2, 9, 3, 5, 9, 4, 5, 2, 9, 9, 2, 2, 5, 5}, {5, 3, 9, 5, 1, 7, 1, 2, 1, 6, 8, 6, 3, 8, 8},
                        {5, 6, 4, 9, 1, 9, 7, 8, 8, 2, 8, 6, 2, 8, 4}, {4, 3, 8, 4, 5, 5, 4, 6, 9, 1, 6, 3, 6, 6, 1},
                        {1, 4, 3, 5, 3, 8, 6, 7, 9, 5, 5, 2, 8, 1, 4}, {1, 7, 9, 4, 9, 4, 6, 9, 2, 1, 2, 1, 4, 2, 1},
                        {7, 9, 7, 9, 1, 6, 4, 3, 8, 3, 9, 4, 5, 7, 8}, {7, 1, 2, 6, 3, 9, 8, 8, 4, 8, 6, 8, 3, 5, 4}}),
                is("366899594558679552968354"));
    }

    @Test
    public void testBigValuesFirst() {
        Random r = new Random();
        int[][] A = new int[1000][1000];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                A[i][j] = r.nextInt(9) + 1;
            }
        }
        long start = System.currentTimeMillis();
        solution(A);
        System.out.printf("Technetium2019Test 'testBigValuesFirst' finished after [%s] s%n",
                (System.currentTimeMillis() - start) / 1000.0d);
    }

}
