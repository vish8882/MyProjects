package hackerrank;

import java.util.*;

public class StringMatch {
	
	public static void main(String[] args) {
		String a = "aassaSUVO";
		String b = "$$$$SUVOJIT$$$";
		String c = "SUVBBHSUVO^%SUVOJITYYYSUVOJIT";
		String match = "SUVO";
		String match2 = "SUVOJIT";
		int suvoCount=0;
		int suvoJitCount=0;
				
		List<String> list = new ArrayList<String>();
		list.add(a);
		list.add(b);
		list.add(c);
		for(String s: list){
			for(int i=0; i <s.length(); i ++){
				if(s.length()>=i+4 && s.substring(i, i+4).equals(match))
					suvoCount++;
				if(s.length()>=i+7&&s.substring(i, i+7).equals(match2))
					suvoJitCount++;
					
			}
			System.out.println(suvoCount+" "+ suvoJitCount);
			suvoCount=0;
			suvoJitCount=0;
		}
	}

}
