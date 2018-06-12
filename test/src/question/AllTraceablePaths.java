package question;

import java.util.*;

/*
 * Given a 2D array find all the paths from 0,0 to 3,3
 */

public class AllTraceablePaths {
	
	public static void main(String[] args) {
		int count = 1;
		int k = 29;
		int[] a={1,2,3};
		int[] b={4,5,6};
		int[] c={7,8,9};
		int[][]array={a,b,c};
		List<Integer> list = new LinkedList<Integer>();
		//traverse(array, 0, 0,list,3,3);
		//System.out.println(pathCount(array, 0, 0,list,3,3));
		int[][] arrayCount=new int[3][3];
		System.out.println(pathCountDynamic(array, 0, 0, arrayCount, 3, 3));
		

	}
	
	public static void traverse(int[][] array ,int i,int j, List<Integer> list,int row, int col){
		
		if(i < row && j <col )
		{	list.add(array[i][j]);
			if(i ==row-1 && j==col-1){
				for(Integer x : list){
					System.out.print(x+"->");
				}
				System.out.println();
			}
			traverse(array , i,j+1 ,list,row,col); 
			traverse(array, i+1 , j, list,row,col);
			list.remove(list.size()-1);
			return;
		}
		else{
			return;
		}
		
	}
	
	public static int pathCountDynamic(int[][] array, int i, int j,
			int[][] arrayCount, int row, int col) {

		if (i == row - 1 && j == col - 1)
			return 1;
		if (i < row && j < col) {
			if (arrayCount[i][j] > 0)
				return arrayCount[i][j];
			arrayCount[i][j] = pathCountDynamic(array, i + 1, j, arrayCount, row, col)
					+ pathCountDynamic(array, i, j + 1, arrayCount, row, col);
			System.out.println(arrayCount[i][j]);
			return arrayCount[i][j];
		} else
			return 0;

	}
	
public static int pathCount(int[][] array ,int i,int j, List<Integer> list,int row, int col){
		if(i==row-1 && j==col-1)
			return 1;
		if(i < row && j <col )
		{
			return pathCount(array , i+1,j ,list,row,col)+
			pathCount(array, i , j+1, list,row,col);
		}
		else{
			return 0;
		}
		
	}

}
