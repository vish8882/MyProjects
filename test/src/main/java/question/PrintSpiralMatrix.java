package question;

public class PrintSpiralMatrix {
	public static void main(String[] args) {
		int arr[][] = { { 1, 2 ,3}, 
						{ 7, 8,9}, 
						{ 13, 14,15 },
						{ 19, 20, 21},
						{22,23,24}};
		int n = 5;
		int k = 3;
		int up = 0, down = n-1, left = 0, right = k-1;
		int j = 0;
		boolean start =true; 
		while (up <= down && left <= right) {
			start=false;
			for (int i = left; i <= right; i++) {
				System.out.print(arr[up][i] + " ");
			}
			up++;
			for (int i = up; i <=down; i++) {
				System.out.print(arr[i][right] + " ");
			}
			right--;
			if(up<down){
				for (int i = right; i >= left; i--) {
					System.out.print(arr[down][i] + " ");
				}
			down--;
			}
			if (left < right) {
				for (int i = down; i >= up; i--)
					System.out.print(arr[i][left] + " ");
				left++;
			}
		}
	}
}
