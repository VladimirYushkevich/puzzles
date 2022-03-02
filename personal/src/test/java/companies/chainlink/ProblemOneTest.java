package companies.chainlink;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProblemOneTest {

    @Test
    public void testSolution() {
        assertThat(ProblemOne.minMoves(10, 0, 0, 0, 2), is(2));
    }
}
