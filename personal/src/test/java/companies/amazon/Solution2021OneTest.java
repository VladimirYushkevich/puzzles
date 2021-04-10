package companies.amazon;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Solution2021OneTest {

    @Test
    public void testConnectedSum() {
        assertThat(Solution2021One.connectedSum(4, Arrays.asList("1 2", "1 4")), is(3));
        assertThat(Solution2021One.connectedSum(8, Arrays.asList("8 1", "5 8", "7 3", "8 6")), is(6));
        assertThat(Solution2021One.connectedSum(10, Arrays.asList("1 2", "1 3", "2 4", "3 5", "7 8")), is(8));
    }
}
