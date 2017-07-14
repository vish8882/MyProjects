package java_array;

public class RotateArray {
	
	public static void main(String[] args) {
		int [] arr= {1,2,3,4,5,6,7};
		Object[] a = new Object[5];
		int l=a.length;
		int k=2;
		long timeS= System.nanoTime();
		rotateLeft(arr, k);
		rotateRight(arr, k);
		System.out.println(System.nanoTime()-timeS);
		
		for(int i=0; i< arr.length ; i++){
			System.out.print(arr[i]);
		}
	}
	
	public static void doubleRotate(int[] arr, int k){
		int len= arr.length;
		int i=0;
		while(i<len-k){
			
			for(int j=i; j < i+k ; j++){
				if(j+2<len){
				swap(arr, j, j+2);
				}
				else{
					swap(arr, j, j+1);
				}
			}
			i=i+2;
		}
	}
	
	public static void rotateLeft(int[] arr, int k){
		int len=arr.length;
		int[] newArr = new int[k];
		for (int i=0; i<k ;i++){
			newArr[i]=arr[i];
		}
		for(int i=0; i<len-k; i++){
			arr[i]=arr[i+k];
		}
		for (int i = len-k; i <len ; i++){
			arr[i]=newArr[i-(len-k)];
		}
	}
	
	public static void rotateRight(int[] arr, int k){
		int len=arr.length;
		int[] newArr = new int[k];
		
		for (int i = len-k; i <len ; i++){
			newArr[i-(len-k)]=arr[i];
		}
		for(int i=len-1; i>=k; i--){
			arr[i]=arr[i-k];
		}
		for (int i=0; i<k ;i++){
			arr[i]=newArr[i];
		}
		
		
	}
	
	
	public static void singleRotate(int[] arr, int k){
		int len= arr.length;
		int i=0;
		while(i<len-k){
			for(int j=i; j < i+k ; j++){
				swap(arr, i, j+1);
			}
			i++;
		}
	}
	
	public static void swap(int[] arr, int i, int j){
		int tmp= arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
}
