package question;

public class NonContiguousSum {
	
public static void main(String[] args) {
	int [] a = {5,6,10,45,50,60,35};
	NonContiguousSum sum = new NonContiguousSum();
	int arr[] = new int[]{6,  5,10, 40, 50, 35};
    System.out.println(sum.FindMaxSum(arr, arr.length));
}

int FindMaxSum(int arr[], int n)
{
	int include=arr[0];
	int excluded=0;
	int ex_new;
	
	for(int i=1; i <n ;i++){
		ex_new=max(include,excluded);
		include=excluded+arr[i];
		excluded=ex_new;
		
	}
	
	
	return max(include,excluded);
}

static int max(int i, int e){
	if(e>i)
		return e;
		else return i;
}
}
