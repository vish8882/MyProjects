/**
 * GIven an array of size n and a value K find a sum of the numbers in the array equal size K. Also these numbers should 
 * appear in sequence.
 */
package question;

import java.util.HashSet;
import java.util.Set;

/**
 * find sum of all subsets of size K
 * @author 1022176
 *
 */
public class SubsetSumSizeK {
	public static void main(String[] args) {
		int[] arr = {1,4,1,2,3};
		Set<Integer> set = new HashSet<>();	
		findSubSetSizeK(arr, 0, 3, 0,0);
		System.out.println(maxSum);
	}
	static int maxSum = 0;
	public static void findSubSetSizeK (int[] arr, int i, int k, int sum, int numOfDigits) {
		if(i>arr.length)
			return;
		if(numOfDigits == k) {
			if(sum  >maxSum)
				maxSum = sum;
			return;
		}
		for(int j=i;j<arr.length;j++) {
			findSubSetSizeK(arr, j+1, k, sum*10 + arr[j], numOfDigits+1);
		}
			
	}
}
