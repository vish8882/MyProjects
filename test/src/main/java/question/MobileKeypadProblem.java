/**
 * Given the mobile numeric keypad. 
 * You can only press buttons that are up, left, right or down to the current button. 
 * You are not allowed to press bottom row corner buttons (i.e. * and # ).
 */
package question;

import java.util.ArrayList;
import java.util.List;

public class MobileKeypadProblem {
	public static void main(String[] args) {
		char arr[][] = {{'1','2','3'}, 
                {'4','5','6'}, 
                {'7','8','9'}, 
                {'*','0','#'}}; 
		for(int i =0; i<4; i++) {
			for(int j=0; j<3 ; j++) {
				if(arr[i][j]!='*' || arr[i][j]!='#'){
					countNumber(arr, i, j, 5, 1);
					list.clear();
				}
				
			}
		}
		System.out.println(sum);
	}
	static int sum = 0;
	static int row[] = {0, 0, -1, 0, 1}; 
	static int col[] = {0, -1, 0, 1, 0};
	static List<String> list = new ArrayList<>();
	public static boolean countNumber (char[][]arr, int i, int j, int n, int count) {
		//Base cases
		if( (i<0 || j<0) || (i >= arr.length || j>= 3))
			return false;
		if(arr[i][j]=='*' || arr[i][j]=='#')
			return false;
		list.add(arr[i][j]+"");
		if(count == n){
			for(String c : list)
				System.out.print(c+" ");
			sum++;
			System.out.println();
			return true;
		}
		for(int k=0;k<=4;k++) {
			if(countNumber(arr, i+row[k], j+col[k], n, count+1))
				list.remove(list.size()-1);
		}
		return true;
	}
}
