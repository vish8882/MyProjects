package question;

import java.util.*;

import javafx.util.Pair;

public class WordBreak {

	public static void main(String[] args) {
		String[] dictionaryArray = {"small","smaller","big","bigg","erb","nee","need"};
		HashSet<String> dictionary = new HashSet<String>();
		String word = "smallerbneedbigg";
		for(int i=0; i<dictionaryArray.length; i++)
			dictionary.add(dictionaryArray[i]);
		WordBreak wordBreak = new WordBreak();
		System.out.println(wordBreak.wordBreaker(word, dictionary, 0, new Stack(), false));
	}
	
	public boolean wordBreaker(String word, HashSet<String> dictionary, int indexStart, Stack<Pair<Integer,Integer>> stack, boolean found){
		
		for(int i=indexStart+1;i <=word.length()+1;i++){
			if(i>word.length()){
				if(stack.size()>0){
					Pair<Integer,Integer> p=stack.pop();
					indexStart=p.getKey();
					i=p.getValue();
				}
				else break;
				continue;
			}
			if(dictionary.contains(word.substring(indexStart, i))){
				if(i+1>word.length()){
					found=true;
					break;
				}
				stack.push(new Pair(indexStart,i));
				indexStart= i;
			}
		}
		
		return found;
		 
	}

}
