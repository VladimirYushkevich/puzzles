package companies.token;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class StringReductionTest {

    @Test
    public void testGetMinDeletions() {
        assertThat(StringReduction.getMinDeletions("abab"), is(2));
        assertThat(StringReduction.getMinDeletions("abcab"), is(2));
    }
}
