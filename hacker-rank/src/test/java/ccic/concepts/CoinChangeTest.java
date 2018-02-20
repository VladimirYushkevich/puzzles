package ccic.concepts;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

import static ccic.concepts.CoinChange.coinChange;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CoinChangeTest {

    @Test
    public void testCoinChange() {
        assertThat(coinChange(4, new LinkedList(Arrays.asList(1, 2, 3)), 3, new HashMap<>()), is(4L));
        assertThat(coinChange(10, new LinkedList(Arrays.asList(2, 5, 3, 6)), 4, new HashMap<>()), is(5L));
        assertThat(coinChange(166, new LinkedList(Arrays.asList(5, 37, 8, 39, 33, 17, 22, 32, 13, 7, 10, 35, 40,
                2, 43, 49, 46, 19, 41, 1, 12, 11, 28)), 23, new HashMap<>()), is(96190959L));
    }
}
