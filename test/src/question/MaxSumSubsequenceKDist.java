/**
 * Given an array and a number k, find a subsequence such that:
 * 1. Sum of elements in subsequence is maximum
 * 2. Indices of elements of subsequence differ at least by k
 */
package question;

public class MaxSumSubsequenceKDist {
	static int maxSum = 0;
	public static void main(String[] args) {
		int arr[] = {50, 70, 40, 50, 90, 70, 60, 
                40, 70, 50};
		maxSumSubKDist(arr, 0, arr.length, 2, 0);
		System.out.println(maxSum);
	}
	
	public static void maxSumSubKDist(int[] arr, int i, int end, int k, int sum) {
		if(i>=end){
			if( sum > maxSum)
				maxSum = sum;
			return;
		}
		maxSumSubKDist(arr, i+k+1, end, k, sum+arr[i]);
		maxSumSubKDist(arr, i+1, end, k, sum);
	}
}
