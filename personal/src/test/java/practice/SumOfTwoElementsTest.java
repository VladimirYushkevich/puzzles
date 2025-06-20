package practice;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SumOfTwoElementsTest {

  @Test
  public void testSum() {
    assertTrue(SumOfTwoElements.isTheSumExistingNaive(new int[]{1, 2, 3, 4}, 6));
    assertTrue(SumOfTwoElements.isTheSumExistingLinear(new int[]{-1, 2, 2, 3, 4, 7}, 6));
    assertFalse(SumOfTwoElements.isTheSumExistingLinear(new int[]{-2, 2, 2, 3, 7}, 6));
    assertTrue(SumOfTwoElements.isTheSumExisting(new int[]{1, 2, 3, 4}, 6));
    assertTrue(SumOfTwoElements.isTheSumExisting(new int[]{1, 2, 2, 4, 5, 6}, 9));
    assertFalse(SumOfTwoElements.isTheSumExisting(new int[]{1, 2}, 9));
    assertFalse(SumOfTwoElements.isTheSumExisting(new int[]{9}, 9));
  }
}
