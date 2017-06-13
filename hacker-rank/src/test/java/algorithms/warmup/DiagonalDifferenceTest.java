package algorithms.warmup;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DiagonalDifferenceTest {

    @Test
    public void diagonalDifferenceTest() throws Exception {
        assertThat(DiagonalDifference.solution(3, new long[][]{{11, 2, 4}, {4, 5, 6}, {10, 8, -12}}),
                is(15L));
    }
}
