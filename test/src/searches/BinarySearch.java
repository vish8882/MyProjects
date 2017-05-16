package searches;

public class BinarySearch {
	
	public static void main(String[] args) 
	{
		int array[]={5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
		int numberToFind=19;
		int arrayLength=array.length;
		int start=0, end=array.length;
		for(int i=0;i<array.length;i++)
		{
			if(arrayLength%2==0)
			{
				arrayLength=((end-start)/2);
			}
			else{
				arrayLength=((end+1-start)/2);
			}
			arrayLength=arrayLength+start;
			if(numberToFind==array[arrayLength]){
				System.out.println("Number "+array[arrayLength] +" is at index "+arrayLength);
				System.exit(0);
			}
			else if(numberToFind<array[arrayLength]){
				end=arrayLength-1;
				//arrayLength=end-1-start;
			}
			else if(numberToFind>array[arrayLength]){
				start=arrayLength+1;
				//arrayLength=end-1-start;
			}
			
			
		}
		

	}
	
	
	
	 void searchBinary(){

int [] arr={1,2,3,4,5,6,7,8,9,14,19,20,24,25,29,33,35,39};
	int number=1;
	int mid=0;
	int start=0;
	int end=arr.length-1;
	for(int i=0; i<arr.length; i++){
		mid=(end+start)/2;
		
		
		if(number==arr[mid]){
			System.out.println("Number found at :"+mid);
			break;
		}
		if(number<arr[mid]){
			end=mid-1;
		}
		
		if(number>arr[mid]){
			start=mid+1;
		}
	}
	
	
	 }
}
