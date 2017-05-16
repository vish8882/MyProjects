package collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MapComparator {
	
	public static void main(String[] args) {
		MapComparator map= new MapComparator();
		LinkedList list = new LinkedList();
		list.add(1);
		Map<String, Integer> unsortMap = new HashMap<String, Integer>();
        unsortMap.put("z", 10);
        unsortMap.put("b", 5);
        unsortMap.put("a", 6);
        unsortMap.put("c", 20);
        unsortMap.put("d", 1);
        unsortMap.put("e", 7);
        unsortMap.put("y", 8);
        unsortMap.put("n", 99);
        unsortMap.put("j", 50);
        unsortMap.put("m", 2);
        unsortMap.put("f", 9);

        System.out.println("Unsorted Map......");
        System.out.println(unsortMap);
        List <Map.Entry<String, Integer>> enrtyList = 
        		new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());
        
        Collections.sort(enrtyList,map.new MapSort());
        
        Map<String, Integer> sortedMap= new LinkedHashMap<String, Integer>();
        for(Map.Entry<String, Integer> entry : enrtyList){
        sortedMap.put(entry.getKey(),entry.getValue());	
        }
        System.out.println("Sorted Map......");
       System.out.println(sortedMap); 
        
        
	}

	public class MapSort implements Comparator<Map.Entry<String, Integer>>{

		@Override
		public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
			return o1.getValue().compareTo(o2.getValue());
		}
		
	}
}
