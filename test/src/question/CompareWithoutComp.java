package question;

import java.util.HashSet;
import java.util.Set;

public class CompareWithoutComp {
	
	public static void main(String[] args) throws Exception{

		int arr1[]={2,5,6,8,10,2,2,4,1};
		int arr2[]={1,2,5,2,4,8,10,2,6};
		
		
		if(arr1.length!=arr2.length){
			System.out.println("Not same");
		System.exit(0);}
		Set set = new HashSet();
		for(int i=0; i <arr1.length;i++){
			if(!set.add(arr1[i])){
				set.remove(arr1[i]);
			}
			if(!set.add(arr2[i])){
				set.remove(arr2[i]);
			}
			//System.out.println(set);
		}
		if(set.size()==0){
			System.out.println("same");
		}else {
			System.out.println("Not Same");
		}
	
	}

}
