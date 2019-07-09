/*
 * the program is to print all the valid possibilities of ()[]
 * For eg: [()] ()() [][] ()[] []()
 */ 
package recursion;

import com.oracle.webservices.internal.api.databinding.Databinding.Builder;

public class BalancedParenthesis {
	static StringBuilder builder = new StringBuilder();
	public static void main(String[] args) {
		int n = 4;
		char[] str = new char[n * 2];
		balancedParathesis(str, 0, 0, n, 0, 0);
	}

	public static void balancedParathesis(char[] str, int open, int close, int n, int pos, int prevPos) {
		if (close == n) {
			for (int i = 0; i < n * 2; i++) {
				builder.append(str[i]);
				System.out.print(str[i]);
			}
			builder = new StringBuilder();
			System.out.println();
			str = new char[n * 2];
		}
		if (open < n) {
			str[pos] = '(';
			balancedParathesis(str, open + 1, close, n, pos + 1, pos + 1);
		}
		if (open < n) {
			str[pos] = '[';
			balancedParathesis(str, open + 1, close, n, pos + 1, pos + 1);
		}
		if (close < open) {
			if (str[prevPos - 1] == '(')
				str[pos] = ')';
			else if (str[prevPos - 1] == '[')
				str[pos] = ']';
			balancedParathesis(str, open, close + 1, n, pos + 1, prevPos - 1);
		}
	}
}
