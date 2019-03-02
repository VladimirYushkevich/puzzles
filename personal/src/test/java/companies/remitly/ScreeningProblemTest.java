package companies.remitly;

import org.junit.Test;

import static companies.remitly.ScreeningProblem.find;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ScreeningProblemTest {

    @Test
    public void testIsWord() {
        assertTrue(find("greateris"));
        assertTrue(find("isisis"));
        assertTrue(find("thisisawesome"));

        assertFalse(find("greaterisz"));
        assertFalse(find("thisisawesomez"));
        assertFalse(find("zasdf"));
        assertFalse(find("the2"));
    }
}
