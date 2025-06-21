package practice;

import java.util.LinkedList;

/*
 * Given a sorted array, remove the duplicates such that each element appears only once,
 * and return the length of the updated array.
 * Example: [1, 1, 2, 2, 3] -> length: 3, modified array: [1, 2, 3]
 */
public class RemoveDuplicates {

  public int removeDuplicates(int[] nums) {
    int uniqueIndex = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[uniqueIndex]) {
        uniqueIndex++;
        nums[uniqueIndex] = nums[i];
      }
    }

    return uniqueIndex + 1;
  }

  public int removeDuplicatesNaive(int[] nums) {
    int n = nums.length;
    LinkedList<Integer> res = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      // last element
      if (i == n - 1) {
        int last = res.getLast();
        if (last != nums[i]) {
          res.add(nums[i]);
        }
        break;
      }

      if (nums[i] != nums[i + 1]) {
        res.add(nums[i]);
      }
    }

    return res.size();
  }
}
