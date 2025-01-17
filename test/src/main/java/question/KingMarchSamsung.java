/**
 * Reach e starting from s and find all the paths which gives the maximum points avoiding the obstacles x
 */
package question;

import java.util.Arrays;

public class KingMarchSamsung {

	public static void main(String[] args) {
		char[][] arr = {{'e','1','2'},
						{'1','x','1'},
						{'2','1','s'}};
			findPathIterative(arr);
	}
	static int maxPoints = 0;
	static int numOfPaths = 0 ;
	public static void findPath(char[][] arr, int i, int j, int value) {
		if(i < 0 || j < 0) {
			return;
		}
		if(arr[i][j] == 'e') {
			if(value > maxPoints) {
				maxPoints = value;
				numOfPaths = 1;
			}
			else if(value == maxPoints)
				numOfPaths++;
		}
		if(arr[i][j] == 'x') {
			return;
		}
		if(i==arr.length-1 && j==arr.length-1){
			value=0;
		}
		else {
			value = arr[i][j]-48 + value;
		}
		findPath(arr,  i-1, j, value);
		findPath(arr, i-1, j-1, value);
		findPath(arr,  i, j-1, value);
	}
	
	
	public static void findPathIterative(char[][] arr) {
		int [] [] tempArr = new int[arr.length][arr.length];
		int [] [] count = new int[arr.length][arr.length];
		for(int[] c : count)
			Arrays.fill(c, 1);
		for(int i=arr.length-1; i>=0 ; i--) {
			for(int j=arr.length-1; j >=0 ; j--) {
				if(i==arr.length-1&&j==arr.length-1){
					tempArr[i][j] = 0;
					count[i][j] =1;
				}
					
				else {
					if(arr[i][j] == 'x') {
						tempArr[i][j] = Integer.MIN_VALUE;
						count[i][j]=0;
						continue;
					}
					int value1=Integer.MIN_VALUE, value2=Integer.MIN_VALUE, value3=Integer.MIN_VALUE;
					int count1 =0, count2=0, count3=0;
					if(i < arr.length-1){
						value1 = tempArr[i+1][j];
						count1 = count[i+1][j];
					}
					if(i < arr.length-1 && j<arr.length-1) {
						value2 = tempArr[i+1][j+1];
						count2 = count[i+1][j+1];
					}
					if( j < arr.length-1) {
						value3 = tempArr[i][j+1];
						count3 = count[i][j+1];
					}
					if(i ==0 && j==0) {
						count[i][j] = findCount(count1, count2, count3, value1, value2, value3);
						tempArr[i][j] = Math.max(value1, Math.max(value2, value3));
						if(tempArr[i][j] < 0 || count[i][j] == 0){
							tempArr[i][j] = 0;
						}
						break;
					}
					count[i][j] = findCount(count1, count2, count3, value1, value2, value3);
					tempArr[i][j] = Math.max(value1, Math.max(value2, value3))+arr[i][j]-48 ;
				}
			}
		}
		System.out.println(tempArr[0][0] +" "+ count[0][0]);
	}
	
	public static int findCount(int count1, int count2, int count3, int value1, int value2, int value3) {
		int value = Math.max(value1, Math.max(value2, value3));
		if(value == value1 && value == value2 && value==value3)
			return count1+count2+count3;
		else if(value==value1 && value==value2)
			return count1+count2;
		else if(value==value1 && value == value3)
			return count1+count3;
		else if(value==value2 && value == value3)
			return count2+count3;
		else if(value==value1)
			return count1;
		else if(value==value2)
			return count2;
		else
			return count3;
	}
}
