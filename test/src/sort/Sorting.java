package sort;

public class Sorting {
	
	public static void main(String[] args) {
		int arr[]={5,6,1,3,4,0};
		
		for(int i=0; i<arr.length;i++)
		{
			for(int j=i;j<arr.length;j++){
				if(arr[i]>arr[j]){
					int tmp=arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				}
			}
		}
		
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
		}
	}

}
