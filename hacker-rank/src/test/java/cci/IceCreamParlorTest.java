package cci;

import org.junit.Test;

import static cci.IceCreamParlor.findFlavors;
import static org.junit.Assert.assertArrayEquals;

public class IceCreamParlorTest {

    @Test
    public void iceCreamParlor() {
        assertArrayEquals(new int[]{1, 4}, findFlavors(new int[]{1, 4, 5, 3, 2}, 4));
        assertArrayEquals(new int[]{1, 4}, findFlavors(new int[]{3, 4, 5, 1, 2}, 4));
        assertArrayEquals(new int[]{1, 2}, findFlavors(new int[]{2, 2, 4, 3}, 4));
    }
}
