package practice;

import java.util.HashSet;
import java.util.Set;

/*
 * For given sorted array of integers and "sum" element create a function which checks if there
 * are 2 elements witch sum equals to the "sum" element
 * Example: [1, 2, 3, 4], 6 -> true
 */
public class SumOfTwoElements {

  public static boolean isTheSumExisting(int[] sortedIn, int sum) {
    int left = 0;
    int right = sortedIn.length - 1;
    while (left < right) {
      int currentSum = sortedIn[left] + sortedIn[right];
      if (currentSum == sum) {
        return true;
      } else if (currentSum < sum) {
        left++;
      } else {
        right--;
      }
    }

    return false;
  }

  public static boolean isTheSumExistingNaive(int[] sortedIn, int sum) {
    for (int i = 0; i < sortedIn.length; i++) {
      for (int j = i + 1; j < sortedIn.length; j++) {
        if (sortedIn[i] + sortedIn[j] == sum) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean isTheSumExistingLinear(int[] sortedIn, int sum) {
    Set<Integer> complements = new HashSet<>();
    for (int value : sortedIn) {
      if (complements.contains(value)) {
        return true;
      }
      complements.add(sum - value);
    }

    return false;
  }

}
