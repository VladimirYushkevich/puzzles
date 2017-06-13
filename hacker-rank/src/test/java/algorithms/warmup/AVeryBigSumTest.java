package algorithms.warmup;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AVeryBigSumTest {

    @Test
    public void aVeryBigSumTest() throws Exception {
        assertThat(AVeryBigSum.solution(5, new long[]{1000000001, 1000000002, 1000000003, 1000000004, 1000000005}),
                is(5000000015L));
    }
}
