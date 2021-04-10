package companies.amazon;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Solution2021TwoTest {

    private Solution2021Two solution = new Solution2021Two();


    @Test
    public void testBst() {
        assertThat(solution.solution(new int[]{5, 6, 3, 1, 2, 4}), is(0));
    }
}
