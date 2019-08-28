package companies.olx;

import org.junit.Test;

import static companies.olx.RunLengthEncoding.encode;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RunLengthEncodingTest {

    @Test
    public void testEncode() {
        assertThat(encode("aaaabbbcca"), is("a4b3c2a1"));
        assertThat(encode("aaaabbbcc"), is("a4b3c2"));
        assertThat(encode(""), is(""));
    }
}
