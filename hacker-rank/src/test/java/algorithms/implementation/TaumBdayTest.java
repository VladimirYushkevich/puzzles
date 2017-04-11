package algorithms.implementation;

import org.junit.Test;

import static algorithms.implementation.TaumBday.getMinimumPrice;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TaumBdayTest {

    @Test
    public void testGetMinimumPrice() throws Exception {
        assertThat(getMinimumPrice(10L, 10L, 1L, 1L, 1L), is(20L));
        assertThat(getMinimumPrice(5L, 9L, 2L, 3L, 4L), is(37L));
        assertThat(getMinimumPrice(3L, 6L, 9L, 1L, 1L), is(12L));
        assertThat(getMinimumPrice(7L, 7L, 4L, 2L, 1L), is(35L));
        assertThat(getMinimumPrice(3L, 3L, 1L, 9L, 2L), is(12L));
    }
}
