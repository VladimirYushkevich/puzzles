package practice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RemoveDuplicatesTest {

  @Test
  public void testRemoveDuplicatesNaive() {
    assertEquals(3, new RemoveDuplicates().removeDuplicatesNaive(new int[]{1, 1, 2, 2, 3}));
    assertEquals(2, new RemoveDuplicates().removeDuplicatesNaive(new int[]{1, 1, 2}));
    assertEquals(5,
        new RemoveDuplicates().removeDuplicatesNaive(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
  }

  @Test
  public void testRemoveDuplicates() {
    assertEquals(3, new RemoveDuplicates().removeDuplicates(new int[]{1, 1, 2, 2, 3}));
//    assertEquals(2, new RemoveDuplicates().removeDuplicates(new int[]{1, 1, 2}));
//    assertEquals(5,
//        new RemoveDuplicates().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
  }
}
