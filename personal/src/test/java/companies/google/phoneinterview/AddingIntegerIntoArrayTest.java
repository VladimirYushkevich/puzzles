package companies.google.phoneinterview;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class AddingIntegerIntoArrayTest {

    @Test
    public void shouldAddInt() {
        assertArrayEquals(new int[]{5, 3, 2}, AddingIntegerIntoArray.addInt(new int[]{5, 3, 1}));
        assertArrayEquals(new int[]{5, 4, 0}, AddingIntegerIntoArray.addInt(new int[]{5, 3, 9}));
        assertArrayEquals(new int[]{5, 4, 1}, AddingIntegerIntoArray.addInt(new int[]{5, 4, 0}));
        assertArrayEquals(new int[]{5, 4, 0, 0}, AddingIntegerIntoArray.addInt(new int[]{5, 3, 9, 9}));
        assertArrayEquals(new int[]{1, 0, 0, 0}, AddingIntegerIntoArray.addInt(new int[]{9, 9, 9}));
    }
}
