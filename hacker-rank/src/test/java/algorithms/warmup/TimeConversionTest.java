package algorithms.warmup;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TimeConversionTest {

    @Test
    public void birthdayCakeCandlesTest() {
        assertThat(TimeConversion.solution("07:05:45PM"), is("19:05:45"));
        assertThat(TimeConversion.solution("07:05:45AM"), is("07:05:45"));
        assertThat(TimeConversion.solution("12:40:22AM"), is("00:40:22"));
        assertThat(TimeConversion.solution("12:45:54PM"), is("12:45:54"));
    }
}
