package practice;

import static org.junit.Assert.assertArrayEquals;
import static practice.MergeTwoSortedArrays.merge;

import org.junit.Test;

public class MergeTwoSortedArraysTest {

  @Test
  public void testMergeTwoSortedArrays() {
    assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, merge(new int[]{1, 3, 5}, new int[]{2, 4, 6}));
  }
}
