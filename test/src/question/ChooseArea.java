package question;

import java.util.*;
import java.util.Map.Entry;

/*
 * Consider a game, in which you have two types of powers, A and B and there are 3 types of Areas 
 * X, Y and Z. Every second you have to switch between these areas, each area has specific properties
 * by which your power A and power B increase or decrease. We need to keep choosing areas in such a 
 * way that our survival time is maximized. Survival time ends when any of the powers, A or B reaches 
 * less than 0.
 */
public class ChooseArea {
	static int globalCount=0;
	static List<String> list = new ArrayList();
	static Set<String> countR = new HashSet();
	public static void main(String[] args) {
		LinkedHashMap<String,int[]> map = new LinkedHashMap<String,int[]>();
		map.put("X",new int[]{3,2});
		map.put("Y",new int[]{-5,-10});
		map.put("Z",new int[]{-20,5});
		maxSurvival(map.entrySet(),0,20,8,map.entrySet().iterator(),0);
		System.out.println(globalCount);
	}
	
	public static void maxSurvival(Set<Map.Entry<String, int[]>> map, int n, int A, int B,Iterator<Entry<String, int[]>> itr, int count){
		if(A<=0 || B<=0)
			return;
		if(count> globalCount){
			globalCount=count;
			System.out.print(list.get(list.size()-1)+" -> ");
		}
		if(countR.size()==3)
			return;
		if(n==3){
			n=0;
			itr=map.iterator();
		}
		Map.Entry<String, int[]> e = itr.next();
		if(list.size()>0 && list.get(list.size()-1)==e.getKey())
			return;
		list.add(e.getKey());
		countR.remove(e.getKey());
		int[] a = e.getValue();
		maxSurvival(map, n+1, A+a[0], B+a[1], itr, count+1);
		list.remove(list.size()-1);
		countR.add(e.getKey());
		maxSurvival(map, n+1, A, B, itr, count);
		
	}
}
