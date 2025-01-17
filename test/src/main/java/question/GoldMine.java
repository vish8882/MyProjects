package question;

public class GoldMine {
	static int n=3, m=3;
	static int maxSum = 0;
	static int count=0;
	public static void main(String[] args) {
		int[][] arrayDP = new int [n+1][m+1];
		int[][] array =  {{10, 33, 13, 15},
                {22, 21, 04, 1},
                {5, 0, 2, 3},
                {0, 6, 14, 2}};
		for(int i=0;i<n;i++){
			findMaxGold(array,i,0,0,arrayDP);
		}
		System.out.println(count);
		System.out.println(maxSum);

	}
	
	public static boolean findMaxGold(int[][] array, int i, int j, int sum){
		count++;
		if(i > n || i > m || i < 0)
			return false;
		if(j > n || j > m)
			return false;
		sum = sum + array[i][j];
		if(sum > maxSum)
			maxSum= sum;
		
		return findMaxGold(array, i, j+1, sum) || findMaxGold(array, i+1, j+1, sum)||findMaxGold(array, i-1, j+1, sum);
		
	}
	public static boolean findMaxGold(int[][] array, int i, int j, int sum,
			int[][] arrayDP) {
		count++;
		if (i > n || i > m || i < 0)
			return false;
		if (j > n || j > m)
			return false;
		sum = sum + array[i][j];
		if(arrayDP[i][j] != 0 && arrayDP[i][j]>sum)
			return false;
		if (sum > maxSum)
			maxSum = sum;

		boolean a = findMaxGold(array, i, j + 1, sum, arrayDP)
				|| findMaxGold(array, i + 1, j + 1, sum, arrayDP)
				|| findMaxGold(array, i - 1, j + 1, sum, arrayDP);
		arrayDP[i][j] = sum;
		return a;
	}

}
