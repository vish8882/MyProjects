package question;

public class DutchFlagProblem {

	public static void main(String[] args) {
		int[] arr = {2,2,2,2,2,1,1, 1, 1, 0, 1, 2, 1, 2 , 2, 2,2, 1,1};
		int i=0,j=1,k=arr.length-1;
		while(i < j && j < k) {
			if(arr[i] == 0){
				i++;j++;
			}
			if(arr[k] ==2)
				k--;
			if(arr[j]!=0 && arr[j]!=2)
				j++;
			if(arr[i]!=0 && arr[j] == 0 && j > i){
				swap(arr, i, j);
			}
			if(arr[k]!=2 && arr[j] == 2 && j < k){
				swap(arr, k, j);
			}
		}
		for(int a : arr)
			System.out.print(a);
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
