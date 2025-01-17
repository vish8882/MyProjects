package question;

import java.util.ArrayList;

/*
 * Given a 2D array of 3*3 with each index having some weight. For a given value k
 * find the path that starts from 0,0 and ends at 3,3 such that the sum of the weights in the path exactly equals k.
 */
public class PathWithGivenWeight {

	static int count=0;

	public static void main(String[] args) {
		int k = 37;
		int[] a = { 1, 4, 3, 4 };
		int[] b = { 4, 5, 9, 8 };
		int[] c = { 7, 8, 9, 10};
		int[][] array = { a, b, c };
		boolean[][][] arrayCount = new boolean[3][4][k+1];
		traverseDynamic(k, array, 0, 0, arrayCount, 0);
		//traverseDynamic(k, array, 0, 0, arrayCount, 0);
		System.out.println(count);
	}

	public static boolean traverse(int k, int[][] array, int i, int j,
			int totslWeight) {

		if (i < 3 && j < 3) {
			totslWeight = totslWeight + array[i][j];
			if (traverse(k, array, i, j + 1, totslWeight)
					|| traverse(k, array, i + 1, j, totslWeight)) {
				System.out.print(array[i][j] + " ");
				return true;
			}
			return false;
		} else if (totslWeight == k)
			return true;
		else
			return false;

	}
	
	public static int traverseDynamic(int k, int[][] array, int i, int j,
			boolean[][][] arrayCount, int totalWeight) {
		if (i < 3 && j < 4) {
			totalWeight = totalWeight + array[i][j];
			if (totalWeight < k && arrayCount[i][j][totalWeight]) {
				count++;
				return totalWeight - array[i][j];
			}
			if (i == 2 && j == 3) {
				if (totalWeight == k) {
					count++;
				}
				return k-array[i][j];
			}
			 int value1 = traverseDynamic(k, array, i+1, j, arrayCount, totalWeight);
			 if(value1 > 0)
				 arrayCount[i][j][value1]=true;
			 int value2 =  traverseDynamic(k, array, i, j+1, arrayCount,
							totalWeight);
			 if(value2 > 0)
				arrayCount[i][j][value2] = true;
				return (value2>0)?value2 - array[i][j]:value1 - array[i][j];
			}
			return 0;
		} 
}
