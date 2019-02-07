package companies.yilu;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class QuestionsTest {

    private Questions questions = new Questions();

    @Test
    public void findFirstNonRepeatedCharacter() {
        assertThat(questions.findFirstNonRepeatedCharacter("ABCA").get(), is('B'));
        assertThat(questions.findFirstNonRepeatedCharacter("BCABA").get(), is('C'));
        assertThat(questions.findFirstNonRepeatedCharacter("BABAC").get(), is('C'));
        assertThat(questions.findFirstNonRepeatedCharacter("CBABA").get(), is('C'));
        assertThat(questions.findFirstNonRepeatedCharacter("ACBABA").get(), is('C'));
        assertThat(questions.findFirstNonRepeatedCharacter("CABABA").get(), is('C'));
        assertFalse(questions.findFirstNonRepeatedCharacter("BABA").isPresent());
    }

    @Test
    public void isRotation() {
        assertTrue(questions.isRotation("ABCA", "ACBA"));
        assertFalse(questions.isRotation("ABCC", "ACBA"));
        assertFalse(questions.isRotation("DBCA", "ACBA"));
        assertFalse(questions.isRotation("DBCA", "AC"));
    }

    @Test
    public void sum() {
        assertThat(questions.sum(Arrays.asList(1, 2, 0, 3)), is(6));
    }

    @Test
    public void product() {
        assertThat(questions.product(Arrays.asList(1, 2, 0, 3)), is(0));
        assertThat(questions.product(Arrays.asList(1, 2, 3)), is(6));
    }

    @Test
    public void addNumber() {
        assertArrayEquals(questions.addNumber(Arrays.asList(1, 2, 3), 5).toArray(), Arrays.asList(6, 7, 8).toArray());
    }

    @Test
    public void flattenAndAddNumber() {
        Map<String, List<Integer>> input = new HashMap<>();
        input.put("one", Arrays.asList(1, 2, 3));
        input.put("two", Arrays.asList(3, 4, 5));

        assertArrayEquals(questions.flattenAndAddNumber(input, 5).toArray(),
                Arrays.asList(6, 7, 8, 8, 9, 10).toArray());
    }
}
