package algorithms.warmup;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class PlusMinusTest {

    @Test
    public void plusMinusTest() throws Exception {
        assertArrayEquals(PlusMinus.solution(6, new int[]{-4, 3, -9, 0, 4, 1}),
                new String[]{"0.500000", "0.333333", "0.166667"});
    }
}
