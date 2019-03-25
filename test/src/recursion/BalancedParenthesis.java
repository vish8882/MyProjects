/*
 * the program is to print all the valid possibilities of ()[]
 * For eg: [()] ()() [][] ()[] []()
 */ 
package recursion;

public class BalancedParenthesis {

	public static void main(String[] args) {
		int n = 2;
		char[] str = new char[n * 2];
		balancedParathesis(str, 0, 0, n, 0, 0);
	}

	public static void balancedParathesis(char[] str, int open, int close, int n, int pos, int prevPos) {
		if (close == n) {
			for (int i = 0; i < n * 2; i++) {
				System.out.print(str[i]);
			}
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
