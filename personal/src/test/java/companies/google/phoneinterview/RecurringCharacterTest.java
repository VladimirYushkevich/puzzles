package companies.google.phoneinterview;

import org.junit.Test;

import static companies.google.phoneinterview.RecurringCharacter.getFirstNonRecurringCharacter;
import static companies.google.phoneinterview.RecurringCharacter.getFirstRecurringCharacter;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

public class RecurringCharacterTest {

    @Test
    public void fistRecurringCharacter() {
        assertThat(getFirstRecurringCharacter("ABCA"), is('A'));
        assertThat(getFirstRecurringCharacter("BCABA"), is('B'));
        assertNull(getFirstRecurringCharacter("ABC"));
    }

    @Test
    public void firstNonRecurringCharacter() {
        assertThat(getFirstNonRecurringCharacter("ABCA"), is('B'));
        assertThat(getFirstNonRecurringCharacter("BCABA"), is('C'));
        assertThat(getFirstNonRecurringCharacter("BABAC"), is('C'));
        assertThat(getFirstNonRecurringCharacter("CBABA"), is('C'));
        assertThat(getFirstNonRecurringCharacter("ACBABA"), is('C'));
        assertThat(getFirstNonRecurringCharacter("CABABA"), is('C'));
        assertNull(getFirstNonRecurringCharacter("BABA"));
    }
}
