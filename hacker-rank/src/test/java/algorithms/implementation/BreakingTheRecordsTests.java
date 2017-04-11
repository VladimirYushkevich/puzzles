package algorithms.implementation;

import org.junit.Test;

import static algorithms.implementation.BreakingTheRecords.getRecords;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BreakingTheRecordsTests {

    @Test
    public void testGetRecords() throws Exception {
        final int[][] records1 = getRecords(new int[]{10, 5, 20, 20, 4, 5, 2, 25, 1});
        assertThat(records1[0][0], is(2));
        assertThat(records1[0][1], is(4));

        final int[][] records2 = getRecords(new int[]{3, 4, 21, 36, 10, 28, 35, 5, 24, 42});
        assertThat(records2[0][0], is(4));
        assertThat(records2[0][1], is(0));
    }
}
