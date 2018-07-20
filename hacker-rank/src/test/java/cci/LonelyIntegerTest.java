package cci;

import org.junit.Test;

import java.util.Arrays;

import static cci.LonelyInteger.findLonely;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LonelyIntegerTest {

    @Test
    public void lonelyInteger() {
        assertThat(findLonely(Arrays.asList(1, 1, 2, 3, 2)), is(3));
        assertThat(findLonely(Arrays.asList(1, 1, 2)), is(2));
        assertThat(findLonely(Arrays.asList(0, 0, 1, 2, 1)), is(2));
    }
}
