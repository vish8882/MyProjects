package question;

public class PrintSubSet {
	
	public static void main(String[] args) {
		int [] arr = {1,2,2};
		printSubSet(arr, 0, arr.length, new StringBuilder("{"),true);
	}

	public static void printSubSet(int[] arr, int i, int end, StringBuilder sub, boolean print) {
		if(print)
			System.out.println(sub+"}");
		if(i==end)
			return;
		if(sub.length()==1)
			printSubSet(arr, i+1, end, sub.append(arr[i]), true);
		else
			printSubSet(arr, i+1, end, sub.append(", "+arr[i]), true);
		if(sub.length()!=2)
			sub.delete(sub.length()-3, sub.length());
		else
			sub.deleteCharAt(sub.length()-1);
		printSubSet(arr, i+1, end, sub, false);
	}
}
