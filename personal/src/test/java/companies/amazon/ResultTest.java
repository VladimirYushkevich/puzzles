package companies.amazon;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ResultTest {

    @Test
    public void testResult() {
        assertThat(Result.countPossibleSegments(3, List.of(1, 3, 6)), is(5L));
        assertThat(Result.countPossibleSegments(3, List.of(1, 5, 4)), is(4L));
        assertThat(Result.countPossibleSegments(9, List.of(1, 10, 2)), is(6L));
    }
}
