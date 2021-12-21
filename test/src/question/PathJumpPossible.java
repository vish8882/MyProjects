package question;

/**
 * You are given an integer array nums. You are initially positioned at the array's first index,
 * and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 */
public class PathJumpPossible {

  public static void main(String[] args) {

  }

  public boolean canJump(int[] nums) {
    if(nums.length == 1) {
      return true;
    }
    boolean canJump = false;
    int maxIndex = 0;
    for(int i =0; i< nums.length; i++) {
      if(maxIndex == i && nums[i]+i == i) {
        break;
      }
      if(nums[i]+i >= maxIndex) {
        maxIndex = nums[i]+i;
      }
      if(maxIndex >= (nums.length -1)) {
        canJump = true;
        break;
      }
    }
    return canJump;
  }

  
}
