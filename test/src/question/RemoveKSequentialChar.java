/*
 * Given a character array and a value K you should remove all the characters that appear K or more time in a a sequence.
 * You should do it till all such sequence of characters are removed.
 */
package question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import javafx.util.Pair;

public class RemoveKSequentialChar {
	public static void main(String[] args) {
    	String[] a= {"a","b","c","c","d","d","e","e", "e","e","d", "c","b", "f","g","f"};
    	List<String> inputArray = new ArrayList<String>(Arrays.asList(a));
    	int burstLength =3;
    	removeKSequenceUsingPair(inputArray, burstLength);
    	for(String aa : inputArray)
    		System.out.println(aa);
	}
	
	public static void removeKSequqnce(List<String> inputArray, int burstLength) {
		Stack<String> output = new Stack<>();
		String start = inputArray.get(0);
		int count = 1;
		output.push(inputArray.get(0));
		for (int i = 1; i < inputArray.size(); i++) {
			if (start.equals(inputArray.get(i))) {
				count++;
				output.push(inputArray.get(i));
			} else {
				start = inputArray.get(i);
				if (count >= burstLength) {
					while (count > 0) {
						output.pop();
						count--;
					}
					count = 1;
					if (!output.isEmpty() && start.equals(output.peek())) {
						for (int j = output.size() - 1; j > 0; j--) {
							if (output.get(j) != start)
								break;
							count++;
						}
					}
				} else
					count = 1;
				output.push(inputArray.get(i));
			}
		}
		inputArray.clear();
		while (!output.isEmpty()) {
			inputArray.add(output.pop());
		}
	}
	
	public static void removeKSequenceUsingPair(List<String> inputArray, int burstLength) {
		Stack<Pair<String,Integer>> output = new Stack<>();
		String start = inputArray.get(0);
		int count = 1;
		output.push(new Pair<String, Integer>(inputArray.get(0), count));
		for (int i = 1; i < inputArray.size(); i++) {
			if (start.equals(inputArray.get(i))) {
				count++;
				output.pop();
				Pair<String,Integer> pair = new Pair<String, Integer>(inputArray.get(i), count);
				output.push(pair);
			} else {
				start = inputArray.get(i);
				if (count >= burstLength) {
					if (count > 0) {
						output.pop();
					}
					count = 1;
					if (!output.isEmpty() && start.equals(output.peek().getKey())) {
						count= output.peek().getValue()+count;
						Pair<String, Integer> pair = new Pair<String, Integer>(output.peek().getKey(), count);
						output.pop();
						output.push(pair);
						continue;
					}
				} else
					count = 1;
				output.push(new Pair<String, Integer>(inputArray.get(i), count));
			}
		}
		inputArray.clear();
		for(int i = 0; i < output.size(); i++){
			Pair<String, Integer> pair = output.get(i);
			String key = pair.getKey();
			Integer value = pair.getValue();
			for(int j=0; j< value; j ++) {
				inputArray.add(key);
			}
		}
		
	}
}
