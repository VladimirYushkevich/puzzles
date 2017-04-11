package algorithms.bitman;

import org.junit.Test;

import static algorithms.bitman.LonelyInteger.lonelyInteger;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LonelyIntegerTest {

    @Test
    public void testLonelyInteger() throws Exception {
        assertThat(lonelyInteger(new int[]{1}, 1), is(1));
        assertThat(lonelyInteger(new int[]{1, 1, 2}, 3), is(2));
        assertThat(lonelyInteger(new int[]{0, 0, 1, 2, 1}, 5), is(2));
    }
}
