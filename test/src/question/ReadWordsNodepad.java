package question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.*;
import java.util.Map.Entry;

/*
 * Reading words from notepad and telling the words that are duplicate and their count
 */
public class ReadWordsNodepad {
	public static void main(String[] args) throws Exception {
		Map<String, Integer> wordCountMap = new HashMap<>();
		FileReader reader = new FileReader("C://Users//Vish//Desktop//file.txt");
		BufferedReader buff = new BufferedReader(reader);
		String line;
		while ((line = buff.readLine()) != null) {
			String[] words = line.split(" ");
			for (String word : words) {
				Integer wordCount = wordCountMap.get(word.toLowerCase());
				if (wordCount == null) {
					wordCount = 0;
				}
				wordCountMap.put(word.toLowerCase(), wordCount + 1);
			}
		}
		for(Entry<String,Integer> entry : wordCountMap.entrySet()){
			if(entry.getValue() > 1)
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

	}
}
