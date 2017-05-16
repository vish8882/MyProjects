package test;

public class NextNumber {
	
	public static void main(String[] args) {
		int a=218765; //251678
		int n=2;
		NextNumber next = new NextNumber();
		
		//separating number to array
		int[] array=next.seperateNumber(a);
		
		//finding the next Nth number
		array=next.findNextNumber(array,n);
		
		//printing the number
		for(int i=0; i<array.length; i++){
			System.out.print(array[i]);
		}
		
	}
	
	public  int[] seperateNumber(int a){
		int len=String.valueOf(a).length();
		int[] array = new int[len];
		
		int rem;
		int i=0;
		while(a!=0){
			rem=a%10;
			array[len-1]=rem;
			a=a/10;
			len--;
		}
		
		return array;
	}
	public int[] findNextNumber(int[] array,int n){
		boolean asc=false, desc=true;
		int smallest=10, smallestIndex=-1, nextSmall , nexSmallIndex;
		int len=array.length;
		int i;
		
		//moving to the last index and finding a number less than the previous starting from last.
			for(i=len-1;i>0;i--){
				//
				if(array[i-1]<array[i]){
					smallest=array[i-1];
					smallestIndex=i-1;
					desc=false;
					break;
				}
			}
			//if the number is in descending cannot find a number greater than that
			
			if(desc){
				System.out.println("Cannot find a greater number");
				System.exit(0);
			}
			
			//from the right of the previously found number find the smallest number greater than the previously found number
			nextSmall=array[i];
			nexSmallIndex=i;
			for(int j=i;j<len;j++){
				if(array[j]<nextSmall)
					nexSmallIndex=j;
			}
			
			//swap the above two numbers
			array=swap(array, smallestIndex, nexSmallIndex);
			
			//sort the numbers right to the previous number
			for(int j=i;j<len;j++){
				for(int k=j;k<len;k++){
					if(array[j]>array[k]){
						int tmp=array[k];
						array[k]=array[j];
						array[j]=tmp;
					}
				}
			}
		
		
		if(n!=1){
			n--;
			findNextNumber(array,n);
		}
			
		
		
		return array;
	}
	
	public int[] swap (int[] arr, int i, int j){
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
		return arr;
	}
	
}
