package question;


public class NMazePath {

	public static void main(String[] args) {
		
		int[] a={1,1,1,1,0};
		int[] b={0,0,1,0,0};
		int[] c={1,0,1,0,0};
		int[] d={0,1,1,0,1};
		int[] e={0,0,1,1,1};
		int[][] arr={a,b,c,d,e};
		int n=5;
		System.out.println(findPath(arr, 0, 0,n));
		
	}
	
	
	public static boolean isSafe(int[][] arr,int row, int column,int n){
		if(row<n&&column<n&&arr[row][column]==1)
			return true;
	return false;
	}
	
	public static boolean findPath(int[][] arr,int row,int column,int n){
		
		if(isSafe(arr,row, column,n)){
		if(row==n-1&&column==n-1&&arr[row][column]==1)
			return true;
		
	
			if(findPath(arr, row, column+1,n))
				return true;
	
			if(findPath(arr, row+1, column,n))
				return true;
	
		
		return false;
		}
		return false;
				
	}
	
}
