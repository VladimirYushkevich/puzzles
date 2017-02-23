package freetests.lesson6;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MaxProductOfThreeTest {

    private MaxProductOfThree maxProductOfThree;

    @Before
    public void setUp() {
        maxProductOfThree = new MaxProductOfThree();
    }

    @Test
    public void testMaxProductOfThree() {
        assertThat(maxProductOfThree.solution(new int[]{-3, 1, 2, -2, 5, 6}), is(60));
        assertThat(maxProductOfThree.solution(new int[]{6, 1, 2, -2, 5, -3}), is(60));
        assertThat(maxProductOfThree.solution(new int[]{-5, 5, -5, 4}), is(125));
    }
}
