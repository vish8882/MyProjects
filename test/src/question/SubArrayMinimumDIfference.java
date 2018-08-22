package question;

import java.util.*;

public class SubArrayMinimumDIfference {
	static int[] arr = {1,6,11,5};
	static int diff=0;
	static List<List<String>> finalList = null;
	static List<String> list1 = new LinkedList<String>();
	static List<String> list2 = new LinkedList<String>();
	public static void main(String[] args) {
		int sum2=0;
		for(int i=0; i < arr.length; i++){
			list2.add(String.valueOf(arr[i]));
			if(i!=0)
				sum2=sum2+arr[i];
		}
		diff=sum2;
		findMinimumDifference(0, arr[0], sum2, true);
		for(List<String> list: finalList){
			for(String j : list){
				System.out.print(j+" ");
			}
			System.out.println();
		}
		System.out.println("Difference = "+ diff);
		System.out.println(dp(0, 0, 0));
	}
	
	public static void findMinimumDifference(int n, int sum1, int sum2,boolean include){		
		if(include){
			list1.add(String.valueOf(arr[n]));
			if(list2.size()>0)
				list2.remove(String.valueOf(arr[n]));
		}else{
			list2.add(String.valueOf(arr[n]));
			if(list2.size()>0)
				list1.remove(String.valueOf(arr[n]));
		}
		if(Math.abs(sum1-sum2)<diff){
			diff=Math.abs(sum1-sum2);
			finalList = new ArrayList<List<String>>();
			finalList.add(new LinkedList<String>(list1));
			finalList.add(new LinkedList<String>(list2));
		}
		if(arr.length<=n+1)
			return;
		findMinimumDifference(n+1, sum1+arr[n+1], sum2-arr[n+1], true);
		findMinimumDifference(n+1, sum1, sum2, false);
	}
	public static int dp(int n, int sum1, int sum2){
		if(n>=arr.length) 
			return Math.abs(sum1-sum2);
		return Math.min(dp(n+1, sum1+arr[n], sum2), dp(n+1, sum1, sum2+arr[n]));
	}
}
