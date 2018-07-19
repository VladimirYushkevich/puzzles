package companies.amazon;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Solution2Test {

    private Solution2 solution2;

    @Before
    public void setUp() {
        solution2 = new Solution2();
    }

    @Test
    public void test() {
        assertThat(solution2.solution("A2Le", "2pL1"), is(true));
        assertThat(solution2.solution("ba1", "1Ad"), is(false));
        assertThat(solution2.solution("10a", "9aa"), is(true));
    }
}
