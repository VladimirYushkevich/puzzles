package algorithms.implementation;

import org.junit.Test;

import static algorithms.implementation.FindDigits.checkDigits;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FindDigitsTest {

    @Test
    public void testCheckDigits() throws Exception {
        assertThat(checkDigits(12), is(2));
        assertThat(checkDigits(1012), is(3));
        assertThat(checkDigits(111), is(3));
    }
}
