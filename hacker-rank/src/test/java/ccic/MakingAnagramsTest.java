package ccic;

import ccic.MakingAnagrams;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MakingAnagramsTest {

    @Test
    public void testNumberNeeded() {
        assertThat(MakingAnagrams.numberNeeded("cde", "abc"), is(4));
        assertThat(MakingAnagrams.numberNeeded("cd", "ab"), is(4));
        assertThat(MakingAnagrams.numberNeeded("cd", "adc"), is(1));
        assertThat(MakingAnagrams.numberNeeded("cd", "dc"), is(0));
        assertThat(MakingAnagrams.numberNeeded("bcde", "adckg"), is(5));
        assertThat(MakingAnagrams.numberNeeded("bccde", "accd"), is(3));
    }
}
