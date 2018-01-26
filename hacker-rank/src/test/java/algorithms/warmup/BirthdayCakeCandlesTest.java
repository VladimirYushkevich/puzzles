package algorithms.warmup;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BirthdayCakeCandlesTest {

    @Test
    public void birthdayCakeCandlesTest() {
        assertThat(BirthdayCakeCandles.solution(4, new int[]{3, 2, 1, 3}), is(2));
        assertThat(BirthdayCakeCandles.solution(4, new int[]{2, 3, 1, 3}), is(2));
    }
}
