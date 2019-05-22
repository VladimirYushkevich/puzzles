package cci.book;

import org.junit.Test;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;

public class StringPermutationTest {

    private StringPermutation testee = new StringPermutation();

    @Test
    public void findAllPermutations() {
        assertThat(testee.findAllPermutations("a"), containsInAnyOrder("a"));
        assertThat(testee.findAllPermutations("ab"), containsInAnyOrder("ab", "ba"));
        assertThat(testee.findAllPermutations("abc"), containsInAnyOrder("cab", "acb", "abc", "cba", "bca", "bac"));
    }
}
