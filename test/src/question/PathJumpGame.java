package question;

/**
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 */
public class PathJumpGame {

  static int[] nums = {10,9,8,7,6,5,4,3,2,1,1,0};
  public static void main(String[] args) {
    int count = jump();
    System.out.println(count);
  }

  public static int jump() {
    int size = nums.length;
    if (size == 1) {
      return 0;
    }
    int i = 0;
    int count = 0;
    boolean check = true;
    while (check) {
      int valueAtIndex = nums[i];
      int maxIndex = 0;
      int currIndex = 0;
      for (int k = i; k <= i + valueAtIndex; k++) {
        if (k == (size - 1)) {
          check = false;
          break;
        }
        if (k + nums[k] >= maxIndex) {
          currIndex = k;
          maxIndex = k + nums[k];
        }
      }
      i = currIndex;
      count++;
    }
    return count;
  }

}
