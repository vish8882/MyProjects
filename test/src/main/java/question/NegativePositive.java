package question;

public class NegativePositive {
	
	public static void main(String[] args) {
		int[] arr = {1,2,9,-2,-9,3,8,-1,-5,11,4,-12};
		int neg=0;
		int pos=0;
		while(neg < arr.length) {
			if(arr[neg] < 0 ) {
				int temp = arr[pos];
				arr[pos] = arr[neg];
				arr[neg] = temp;
				neg++;pos++;
			}
			else
				neg++;
		}
		for(int a : arr)
			System.out.print(a+" ");
	}

}
