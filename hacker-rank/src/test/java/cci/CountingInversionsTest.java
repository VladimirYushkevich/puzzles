package cci;

import commons.BaseTest;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static cci.CountingInversions.countInversions;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CountingInversionsTest extends BaseTest {

    private static final String PATH = "cci/inversions";

    @Test
    public void shouldCountInversions() {
        assertThat(countInversions(new int[]{2, 4, 1}), is("2"));
        assertThat(countInversions(new int[]{2, 1, 3, 1, 2}), is("4"));
    }

    @Test
    public void test() throws IOException {
        runTestCase(7);
    }

    private void runTestCase(int id) throws IOException {
        List<String> inputs = getParameters(PATH, "input", id);
        List<String> outputs = getParameters(PATH, "output", id);

        long start = System.currentTimeMillis();

        Integer numberOfArrays = Integer.valueOf(inputs.get(0));
        int pairIndex = 2;
        for (int i = 0; i < numberOfArrays; i++) {
            final int[] arr = Arrays.stream(inputs.get(pairIndex).split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            assertThat(countInversions(arr), is(outputs.get(i)));
            pairIndex += 2;
        }

        System.out.println(String.format("CountingInversionsTest Test Case [%s] finished after [%s] s", id,
                (System.currentTimeMillis() - start) / 1000.0d));
    }
}
