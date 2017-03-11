package algorithms.strings;

import org.junit.Test;

import static algorithms.strings.CamelCase.numberOfWords;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CamelCaseTest {

    @Test
    public void testNumberOfWords() throws Exception {
        assertThat(numberOfWords("saveChangesInTheEditor"), is(5));
    }
}
