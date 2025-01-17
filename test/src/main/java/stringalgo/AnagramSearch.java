package stringalgo;

import java.util.HashMap;
import java.util.Map;

public class AnagramSearch {
	
	public static void main(String[] args) {
		System.out.println(appearanceCount(2,6,"bc","AbcBcb"));
	}

    public static int appearanceCount(int input1,int input2,String input3,String input4)
    {
    int count=0;
	if(!input3.matches("[A-Za-z]+")){
		return 0;
		}
		if(!input4.matches("[A-Za-z]+")){
		return 0;
		}
	Map patternMap =frequencyMap(input3);
	for(int i= 0; i <= input2 - input1 ; i++)
    {
        String checkSub = input4.substring(i, i + input1);
        if(frequencyMap(checkSub).equals(patternMap))
         count++;
    }
    
    return count;
    }
private static Map<Character, Integer> frequencyMap(String str)
{
    Map<Character, Integer> source = new HashMap<Character,Integer>();
    for(int i = 0; i < str.length(); i++)
    {

        if(str.charAt(i) != ' ')
        {
source.put(str.charAt(i), source.containsKey(str.charAt(i)) ?
                source.get(str.charAt(i)) + 1 : 1);
}
}
    return source;
}


}
