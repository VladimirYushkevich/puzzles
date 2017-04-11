package algorithms.implementation;

import org.junit.Test;

import static algorithms.implementation.ACMICPCTeam.getMaxNumberOfTeamPairs;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ACMICPCTeamTest {

    @Test
    public void testMaxNumberOfTeamPairs() throws Exception {
        final int[][] result1 = getMaxNumberOfTeamPairs(new byte[][]{
                {1, 0, 1, 0, 1},
                {1, 1, 1, 0, 0},
                {1, 1, 0, 1, 0},
                {0, 0, 1, 0, 1}
        }, 4, 5);
        assertThat(result1[0][0], is(5));
        assertThat(result1[0][1], is(2));

        final int[][] result2 = getMaxNumberOfTeamPairs(new byte[][]{
                {1, 0, 1, 0, 1},
                {1, 1, 1, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 1}
        }, 4, 5);
        assertThat(result2[0][0], is(4));
        assertThat(result2[0][1], is(4));

        final int[][] result3 = getMaxNumberOfTeamPairs(new byte[][]{
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
        }, 4, 5);
        assertThat(result3[0][0], is(4));
        assertThat(result3[0][1], is(3));

    }
}
