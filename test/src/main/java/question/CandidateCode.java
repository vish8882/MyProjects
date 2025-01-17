package question;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CandidateCode {
	
	
    public static int prisonEscape(int total,int startIndex,int[] dest,String[] way)
    {
    
    Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
    List<Integer> destList = new LinkedList<Integer>();
    int count;
    int timeTaken=0;
    for(int i=0;i<dest.length;i++){
        destList.add(dest[i]);
    }
    
    for(int i=0;i<way.length;i++){
        String pair=way[i];
        String[] pairArray=pair.split(" ");
        List<Integer> list ;
        if(map.containsKey(Integer.valueOf(pairArray[0]))){
        	list=map.get(Integer.valueOf(pairArray[0]));
        	list.add(Integer.valueOf(pairArray[1]));
        	map.put(Integer.valueOf(pairArray[0]), list);
        }
        else{
        	list= new LinkedList<Integer>();
        	list.add(Integer.valueOf(pairArray[1]));
        	map.put(Integer.valueOf(pairArray[0]),list);	
        }
        if(map.containsKey(Integer.valueOf(pairArray[1]))){
        	list=map.get(Integer.valueOf(pairArray[1]));
        	list.add(Integer.valueOf(pairArray[0]));
        	map.put(Integer.valueOf(pairArray[1]),list);
        }
        
        else{
        	list= new LinkedList<Integer>();
        	list.add(Integer.valueOf(pairArray[0]));
        	map.put(Integer.valueOf(pairArray[1]),list);	
        }
    }
  
    List<Integer> list= map.get(startIndex);
    count=0;
    Iterator<Integer> itr= list.iterator();
    while(itr.hasNext()){
    	int index=itr.next();
    	if(destList.contains(index)){
    		count++;
    		if(count>timeTaken)
    			timeTaken=count;
    		destList.remove(Integer.valueOf(index));
    		count=0;
    	}
    }
    if(destList.size()==0)
    	return timeTaken;
    
    
    
    System.out.println("hello");
    
return 0;
    }
    
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        int output = 0;
        int ip1 = Integer.parseInt(in.nextLine().trim());
        int ip2 = Integer.parseInt(in.nextLine().trim());
        int ip3_size = 0;
        ip3_size = Integer.parseInt(in.nextLine().trim());
        int[] ip3 = new int[ip3_size];
        int ip3_item;
        for(int ip3_i = 0; ip3_i < ip3_size; ip3_i++) {
            ip3_item = Integer.parseInt(in.nextLine().trim());
            ip3[ip3_i] = ip3_item;
        }
        int ip4_size = 0;
        ip4_size = Integer.parseInt(in.nextLine().trim());
        String[] ip4 = new String[ip4_size];
        String ip4_item;
        for(int ip4_i = 0; ip4_i < ip4_size; ip4_i++) {
            try {
        ip4_item = in.nextLine();
            } catch (Exception e) {
        ip4_item = null;
            }
            ip4[ip4_i] = ip4_item;
        }
        output = prisonEscape(ip1,ip2,ip3,ip4);
        System.out.println(String.valueOf(output));
    }
}