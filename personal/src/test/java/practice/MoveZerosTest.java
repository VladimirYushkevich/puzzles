package practice;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MoveZerosTest {

  @Test
  public void testMoveZerosNaive() {
    assertArrayEquals(new int[]{1, 3, 12, 0, 0},
        new MoveZeros().moveZeroesNaive(new int[]{0, 1, 0, 3, 12}));
  }

  @Test
  public void testMoveZeros() {
    assertArrayEquals(new int[]{1, 3, 12, 0, 0},
        new MoveZeros().moveZeroes(new int[]{0, 1, 0, 3, 12}));
  }
}
