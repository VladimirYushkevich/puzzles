package companies.google.phoneinterview;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class PairSumTest {

    private PairSum pairSum;

    @Before
    public void setUp() {
        pairSum = new PairSum();
    }

    @Test
    public void scenario1() {
        pairSum.add(4);
        pairSum.add(1);
        pairSum.add(3);
        pairSum.add(3);

        assertTrue(pairSum.test(6));
    }
}
