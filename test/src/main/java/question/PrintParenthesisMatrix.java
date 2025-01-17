package question;

import java.util.*;

public class PrintParenthesisMatrix {
	static Map<String,String> map = new HashMap<String,String>();
	public static void main(String[] args) {
		int arr[] = new int[] {40, 20, 30, 10, 30}; 
		int n = arr.length; 
		char c = 'A';
		for(int i=0;i<arr.length-1 ; i++){
			map.put(i+","+(i+1), String.valueOf(c++));
		}
		Pair pair = printParenthesis(arr, 0, n-1);
		System.out.println(pair.count + " "+ pair.matrix);
	}
	static class Pair {
		int count;
		String matrix;
		public Pair(int count, String matrix) {
			this.count = count;
			this.matrix = matrix;
		}
	}
	
	public static Pair addAndParanthesize(Pair l, Pair r) {
		int count = l.count + r.count;
		String matrix = "("+l.matrix+r.matrix+")";
		return new Pair(count,matrix);
	}
	public static int multiplyAndParanthesize(int l, int m, int r, int[] p) {
		return p[l]*p[m]*p[r];
	}
	
	
	public static Pair printParenthesis(int[] arr, int start, int end) {
		if(start == end-1)
			return new Pair(0, map.get(start+","+end));
		Pair minPair = new Pair(Integer.MAX_VALUE, "");
		for(int i=start+1; i<end; i++) {
			Pair pL = printParenthesis(arr, start, i);
			Pair pR	= printParenthesis(arr, i, end) ;
			Pair fPair = addAndParanthesize(pL, pR);
			fPair.count = fPair.count+multiplyAndParanthesize(start, i, end, arr);
			if(fPair.count < minPair.count){
				minPair = fPair;
			}
		}
		return minPair;
	}
}
