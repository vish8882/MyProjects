package question;



public class SortingQuicly {
	
	public static int pivot(int[] arr, int low, int high){
		int pivot=arr[high];
		int i= (low-1);
		for(int j=low;j<=high-1;j++)
		{
			if(arr[j]<=pivot){
				i++;
				int tmp=arr[j];
				arr[j]=arr[i];
				arr[i]=tmp;
			}
		}
		
		int tmp=arr[high];
		arr[high]=arr[i+1];
		arr[i+1]=tmp;
		
		return i+1;
		
		
	}
	
	public static void sort(int[] arr, int low,int high){
		if(low<high)
		{
			int pi=pivot(arr,low,high);
			
			sort(arr,low,pi-1);
			sort(arr,pi+1,high);
		}
		
	}
	
	public static void main(String[] args) {
		int arr[] = {1,9,3,7,5,3,1,6,2,9};
		SortingQuicly.sort(arr,0,(arr.length)-1);
		
		for (int i=0; i<arr.length; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
	}

}
