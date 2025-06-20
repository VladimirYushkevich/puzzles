package practice;

/*
 * Create a function that merges two sorted arrays and returns a single sorted array.
 * The result should also be sorted in ascending order.
 * Example: [1, 3, 5], [2, 4, 6] -> [1, 2, 3, 4, 5, 6]
 */
public class MergeTwoSortedArrays {

  public static int[] merge(int[] sortedInA, int[] sortedInB) {
    int[] res = new int[sortedInA.length + sortedInB.length];

    int indexA = 0;
    int indexB = 0;
    for (int i = 0; i < res.length; i++) {
      if (indexA >= sortedInA.length) {
        res[i] = sortedInB[indexB++];
        continue;
      }

      if (indexB >= sortedInB.length) {
        res[i] = sortedInA[indexA];
        indexA++;
        continue;
      }

      if (sortedInA[indexA] < sortedInB[indexB]) {
        res[i] = sortedInA[indexA];
        indexA++;
      } else {
        res[i] = sortedInB[indexB];
        indexB++;
      }
    }

    return res;
  }
}
