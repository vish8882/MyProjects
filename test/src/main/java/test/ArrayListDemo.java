package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;


public class ArrayListDemo {
	   public static void main(String[] args) {
		   
		   String str="1,2,3,4,5,6,7,8,9,10";
	         String[] stra=str.split(",");
	         Arrays.asList(stra);
	      
	   // create an empty array list with an initial capacity
	   ArrayList<Integer> arrlist = new ArrayList<Integer>(5);

	   // use add() method to add elements in the list
	   arrlist.add(15);
	   arrlist.add(22);
	   arrlist.add(30);
	   arrlist.add(40);
	   arrlist.add(40);
	   arrlist.add(40);
	   arrlist.add(40);
	   arrlist.add(40);
	   arrlist.add(40);
	   
	   
	   System.out.println(arrlist);
	   Collections.swap(arrlist, 1, 6);
	   System.out.println(arrlist);
	  Iterator<Integer> e= arrlist.iterator();
	   while(e.hasNext()){
		 System.out.println("Enumeration= "+e.next());
		// e.remove();
	   }
	   ArrayList<Integer> arr = new ArrayList<Integer>(5);
	   arr.add(25);
	   arr.add(4);
	   Collections.sort(arrlist);
	   System.out.println(Collections.nCopies(3, 34));
	   System.out.println(Collections.disjoint(arrlist,arr));
	  // arrlist.retainAll(arr);
	   System.out.println("Binary Search "+Collections.binarySearch(arrlist, 40));
	   // let us print all the elements available in list
	   for (Integer number : arrlist) {
	   System.out.println("Number = " + number);
	   } 
		
	   // retrieves element at 4th postion
	   int retval=arrlist.get(0);
	   System.out.println("Retrieved element is = " + retval);	   
	   }
	}   