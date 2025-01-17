package question;

/**
 * Given an integer array nums, find a contiguous non-empty subarray within the array
 * that has the largest product, and return the product
 */
public class MaximumProductSubArray {

  public static void main(String[] args) {
    int [] nums = {-2,0,-1};
    System.out.println(maxProduct(nums));
  }

  public static int maxProduct(int[] nums) {
    int product =1;
    int prod1 = 1;
    int negCount = 0;
    int maxProduct =-11;
    if(nums.length == 1) {
      return nums[0];
    }
    for(int i=0; i < nums.length; i++) {
      if(nums[i] == 0) {
        product = 1;
        prod1 = 1;
        negCount = 0;
        if(maxProduct < nums[i]) {
          maxProduct = nums[i];
        }
        continue;
      }
      if(nums[i] < 0) {
        negCount ++;
        if(negCount == 1) {
          prod1 = product * nums[i];
        }
      }
      if (nums[i] > 0 || negCount != 1 &&  negCount % 2 !=0) {
        int tmp = (product / prod1) * nums[i];
        if(tmp > maxProduct) {
          maxProduct =tmp;
        }
      }
      product = product * nums[i];
      if(product > maxProduct) {
        maxProduct = product;
      }
    }
    return maxProduct;
  }

}
