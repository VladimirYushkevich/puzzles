package practice;

/*
 * Given an array of integers, move all 0s to the end while maintaining the relative order
 * of the non-zero elements.
 * Example: [0, 1, 0, 3, 12] -> [1, 3, 12, 0, 0]
 * Example: [1, 0, 3, 12] -> [1, 3, 12, 0]
 */

public class MoveZeros {

  public int[] moveZeroes(int[] nums) {
      int lastNonZeroIndex = 0;
      for (int i = 0; i < nums.length; i++) {
          if (nums[i] != 0) {
             int temp = nums[lastNonZeroIndex];
             nums[lastNonZeroIndex] = nums[i];
             nums[i] = temp;
             lastNonZeroIndex++;
          }
      }

      return nums;
  }

  public int[] moveZeroesNaive(int[] nums) {
      int[] res = new int[nums.length];
      int index = 0;
      for (int num : nums) {
        if (num != 0) {
          res[index++] = num;
        }
      }

      System.arraycopy(res, 0, nums, 0, nums.length);

      return res;
  }

}
