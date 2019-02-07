package companies.twilio;

import org.junit.Test;

import java.util.Arrays;

import static companies.twilio.Sample.findNumber;
import static companies.twilio.Sample.oddNumbers;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class SampleTest {

    @Test
    public void shouldFindNumber() {
        assertThat(findNumber(Arrays.asList(1, 2, 3, 4, 5), 3), is("YES"));
    }

    @Test
    public void shouldFindOddNumbers() {
        assertArrayEquals(oddNumbers(2, 5).toArray(), Arrays.asList(3, 5).toArray());
    }
}
