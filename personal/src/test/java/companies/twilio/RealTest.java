package companies.twilio;

import org.junit.Test;

import java.util.Arrays;

import static companies.twilio.Real.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;

public class RealTest {

    @Test
    public void shouldCustomSort() {
        assertArrayEquals(customSort(Arrays.asList(4, 5, 6, 5, 4, 3)).toArray(), Arrays.asList(3, 6, 4, 4, 5, 5).toArray());
    }

    @Test
    public void shouldFindFourthBit() {
        assertThat(fourthBit(32), is(0));
        assertThat(fourthBit(23), is(1));
    }

    @Test
    public void shouldFindMissingWords() {
        assertArrayEquals(missingWords("I am using HackerRank to improve programming",
                "am HackerRank to improve").toArray(), Arrays.asList("I", "using", "programming").toArray());
        assertArrayEquals(missingWords("A B C D A", "A C").toArray(), Arrays.asList("B", "D", "A").toArray());
        assertArrayEquals(missingWords("A B C D A", "A C A").toArray(), Arrays.asList("B", "D").toArray());
    }

    @Test
    public void shouldFindNumberOfDivisibleSubsiquences() {
//        assertThat(numberOfDivisibleSubsequencesQuadratic(Arrays.asList(4, 5, 0, -2, -3, 1), 5), is(7));
        assertThat(numberOfDivisibleSubsequencesOptimal(Arrays.asList(4, 5, 0, -2, -3, 1), 5), is(7));
        // there are 7 sub-arrays whose is divisible by K
        // {4, 5, 0, -2, -3, 1}
        // {5}
        // {5, 0}
        // {5, 0, -2, -3}
        // {0}
        // {0, -2, -3}
        // {-2, -3}
    }
}
