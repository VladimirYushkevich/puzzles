package algorithms.implementation;

import org.junit.Test;

import static algorithms.implementation.ModifiedKaprekarNumbers.getKaprekar;
import static algorithms.implementation.ModifiedKaprekarNumbers.isKaprekar;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ModifiedKaprekarNumbersTest {

    @Test
    public void testIsKaprekar() throws Exception {
        assertTrue(isKaprekar(1));
        assertTrue(isKaprekar(9));
        assertTrue(isKaprekar(4950));
        assertFalse(isKaprekar(10));
        assertFalse(isKaprekar(19));
        assertFalse(isKaprekar(4879));
        assertTrue(isKaprekar(9999));
        assertFalse(isKaprekar(46341));
    }

    @Test
    public void testPrintKaprekar() throws Exception {
        assertThat(getKaprekar(1, 100), is("1 9 45 55 99"));
        assertThat(getKaprekar(1000, 10000), is("2223 2728 4950 5050 7272 7777 9999"));
        assertThat(getKaprekar(1, 99999), is("1 9 45 55 99 297 703 999 2223 2728 4950 5050 7272 7777 9999 17344 22222 77778 82656 95121 99999"));
    }
}
