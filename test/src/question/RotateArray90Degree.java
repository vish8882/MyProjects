package question;

public class RotateArray90Degree {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, 
						{ 5, 6, 7, 8 }, 
						{ 9, 10, 11, 12},
						{ 13, 14, 15, 16}};
		rotateArray(arr);
		for(int i = 0; i < arr.length; i++){
			for(int j=0; j <arr.length; j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void rotateArray (int[][] arr) {
		for(int i=0 ; i < arr.length ; i++){
			for( int j=i; j< arr.length-1; j++){
				int temp = arr[i][j+1];
				arr[i][j+1] = arr[j+1][i];
				arr[j+1][i]=temp;
			}
		}
		for (int i=0; i <= arr.length/2-1; i++){
			for(int j=0; j<arr.length ; j++){
				int temp=arr[j][i];
				arr[j][i] = arr[j][arr.length-1-i];
				arr[j][arr.length-1-i] = temp;
			}
		}
	}

}
