package searches;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class FirstNonRepeatingChar {
	
	
	public static void main(String[] args) {
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		List<Character> list= new LinkedList<Character>();
		Set<Character> sm = new TreeSet<Character>(list);
		String word="aaabbccffaabbxbkkllffjjqqeerraannbbccuuppll";
		for(int i=0;i<word.length();i++){
			char sub=word.charAt(i);
			if(map.containsKey(sub)){
				map.put(sub,null);
				list.remove((Character)sub);
				
			} else {
				map.put(sub,1);
				list.add(sub);
			}	
		}
		if(list.size()!=0)
	System.out.println("First non repeating character = "+list.get(0));
		else
			System.out.println("No non repeating character");	
	}

}
