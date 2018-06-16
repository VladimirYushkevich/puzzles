package ccic;

import org.junit.Test;

import static ccic.RansomNote.solve;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RansomNoteTest {

    @Test
    public void testRansomNote() {
        assertTrue(solve(new String[]{"give", "me", "one", "grand", "today", "night"},
                new String[]{"give", "one", "grand", "today"}));
        assertFalse(solve(new String[]{"give", "me", "one", "grand", "today", "night"},
                new String[]{"give", "one", "grand", "today", "today"}));
        assertTrue(solve(new String[]{"give", "me", "one", "grand", "today", "night", "today"},
                new String[]{"give", "one", "grand", "today", "today"}));
        assertFalse(solve(new String[]{"give", "me", "one", "grand", "today", "night", "today"},
                new String[]{"give", "one", "grand", "two", "today"}));
    }
}
