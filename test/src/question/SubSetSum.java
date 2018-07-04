package question;

import java.util.LinkedList;



public class SubSetSum {
	static int globalSum =10;
	static LinkedList<String> list = new LinkedList<String>();
	
	public static void subSet(int[] arr, int n , int sum){
		
		if(sum > globalSum)
			return ;
		if(sum == globalSum){
			for(String a : list)
				System.out.print(a+",");
				System.out.println();
			return;
		}
		if(n == arr.length)
			return ;
		list.add(String.valueOf(arr[n]));
		subSet(arr, n+1, sum+arr[n]);
		list.remove(String.valueOf(arr[n]));
		subSet(arr, n+1, sum);
		list.remove(String.valueOf(arr[n]));
		
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1,2,5,7,8};
		subSet(arr, 0, 0);
		
	}

}
