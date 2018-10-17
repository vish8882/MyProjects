package question;

import java.util.*;
//A recursive solution for subset sum
//problem
public class CFG {
	static int maxsum = 1;
	static int count=0;
	static List<String> list = new ArrayList<String>();
	// Returns true if there is a subset
	// of set[] with sum equal to given sum
	static boolean isSubsetSum(int set[], int n, int sum) {
		// Base Cases
		count++;
		if (sum == maxsum){
			System.out.print("[");
			for(String i:list)
				System.out.print(i+" ");
			System.out.print("]");
			return true;
		}
		if(n < set.length)
			list.add(String.valueOf(set[n]));
		if (n == set.length && sum != maxsum)
			return false;

		// If last element is greater than
		// sum, then ignore it
		/*if (set[n] > maxsum){
			list.remove(String.valueOf(set[n]));
			return isSubsetSum(set, n + 1, sum);
		}*/
		/*
		 * else, check if sum can be obtained by any of the following (a)
		 * including the last element (b) excluding the last element
		 */
		boolean b= isSubsetSum(set, n + 1, sum + set[n]);
		list.remove(String.valueOf(set[n]));
		boolean a= isSubsetSum(set, n + 1, sum);
		list.remove(String.valueOf(set[n]));
		return a||b;
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		int set[] = { 3, 34, -4, 12, 5, 2};
		int n = set.length;
		isSubsetSum(set, 0, 0) ;
	}
}
