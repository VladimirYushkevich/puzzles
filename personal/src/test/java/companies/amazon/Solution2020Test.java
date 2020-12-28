package companies.amazon;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class Solution2020Test {

    private Solution2020 solution2020;

    @Before
    public void setUp() {
        solution2020 = new Solution2020();
    }

    @Test
    public void reorderLines1() {
        solution2020.reorderLines(5, Arrays.asList(
                "a1 9 2 3 1",
                "[g1 act car]",
                "[zo4 4 7]",
                "[ab1 off key dog]",
                "[a8 act zoo]"
        )).forEach(System.out::println);

    }

    @Test
    public void reorderLines2() {
        solution2020.reorderLines(6, Arrays.asList(
                "[a1 9 2 3 1]",
                "[g1 act car]",
                "[zo4 4 7]",
                "[ab1 off key dog]",
                "[a8 act zoo]",
                "[a2 1 zoo]"
        ));
    }
}
