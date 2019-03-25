/*
 * the program is to print all the valid possibilities of ()[]
 * For eg: [()] ()() [][] ()[] []()
 * 
 * The following solution takes all the permutation of the string ()[] and checks a condition with the 
 * valid parenthesis by checking each string everytime
 */

package recursion;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class OpenCloseBracket {
	public static void main(String[] args) {
		String str = "()()";
		String str1 = "[][]";
		String str2 = "()[]";
		Set<String> set = new HashSet<String>();
		OpenCloseBracket bracket = new OpenCloseBracket();
		bracket.validPattern(str, 0, str.length(), set);
		bracket.validPattern(str1, 0, str1.length(), set);
		bracket.validPattern(str2, 0, str2.length(), set);
	}

	public void validPattern(String str, int initial, int end, Set<String> set) {
		if (initial == end) {
			int[] openClose = checkOpenClose(str);
			if (openClose[0] >= openClose[1]){
				if(set.add(str))
					System.out.println(str);
			}
		}
		for (int i = initial; i < end; i++) {
			str = swap(str, initial, i);
			validPattern(str, initial + 1, end, set);
		}
	}

	public int[] checkOpenClose(String str) {
		Stack<Character> stack =  new Stack<Character>();
		int[] returnArray = new int[2];
		int open = 0;
		int close = -1;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(' || str.charAt(i) == '[') {
				stack.push(str.charAt(i));
				if (close > open) {
					open = 0;
					close = 1;
					break;
				} else
					open++;

			}
			else {
				if(stack.isEmpty()){
					open = 0;
					close = 1;
					break;
				}
				char bracket = stack.pop();
				if (bracket == '(' && str.charAt(i) == ')') {
					if (close == -1)
						close = 0;
					close++;
				}
				else if (bracket == '[' && str.charAt(i) == ']') {
					if (close == -1)
						close = 0;
					close++;
				}
				else {
					open = 0;
					close = 1;
					break;
				}
			}
		}
		returnArray[0] = open;
		returnArray[1] = close;
		return returnArray;
	}

	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}
}
