package question;

public class MatrixChainMultiplication {
	
	static int multiply(int l , int m, int r, int[] p){
		return p[l]*p[m]*p[r];
	}
	static int[][] dp ;
	static int matrixChainOrder(int p[], int start, int end) 
	{
		if(start == end-1) {
			return 0;
		}
		int miniVal = Integer.MAX_VALUE;
		if(dp[start][end] > 0)
			return dp[start][end];
		for(int i= start+1 ; i< end ; i++) {
			int l = matrixChainOrder(p, start, i);
			int r = matrixChainOrder(p, i, end);
			int count = l+r;
			count+=multiply(start, i, end, p);
			if(miniVal > count){
				dp[start][end] = count;
				miniVal = count;
			}
		}
	return miniVal;
	} 

	// Driver program to test above function 
	public static void main(String args[]) 
	{ 
		int arr[] = new int[] {1, 2, 3, 4, 3}; 
		int n = arr.length; 
		dp = new int[n][n];
		System.out.println("Minimum number of multiplications is "+ 
						matrixChainOrder(arr, 0, n-1)); 
	} 
}
