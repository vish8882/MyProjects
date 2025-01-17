package question;

import java.util.List;
import java.util.Vector;

public class ParanthesisForExpressions {
	static int eval(int a, char op, int b) 
	{ 
		if (op == '+') 
		{ 
			return a + b; 
		} 
		if (op == '-') 
		{ 
			return a - b; 
		} 
		if (op == '*') 
		{ 
			return a * b; 
		} 
		return Integer.MAX_VALUE; 
	} 

	// This function evaluates all possible values and 
	// returns a list of evaluated values. 
	static Vector<Integer> evaluateAll(String expr, 
									int low, int high) 
	{ 
		// To store result (all possible evaluations of 
		// given expression 'expr') 
		Vector<Integer> res = new Vector<Integer>(); 

		// If there is only one character, it must 
		// be a digit (or operand), return it. 
		if (low == high) 
		{ 
			res.add(expr.charAt(low) - '0'); 
			return res; 
		} 

		// If there are only three characters, middle 
		// one must be operator and corner ones must be 
		// operand 
		if (low == (high - 2)) 
		{ 
			int num = eval(expr.charAt(low) - '0', 
						expr.charAt(low + 1), 
						expr.charAt(low + 2) - '0'); 

			res.add(num); 
			return res; 
		} 

		// every i refers to an operator 
		for (int i = low + 1; i <= high; i += 2) 
		{ 
			
			// l refers to all the possible values 
			// in the left of operator 'expr[i]' 
			Vector<Integer> l = evaluateAll(expr, low, i - 1); 

			// r refers to all the possible values 
			// in the right of operator 'expr[i]' 
			Vector<Integer> r = evaluateAll(expr, i + 1, high); 

			// Take above evaluated all possible 
			// values in left side of 'i' 
			for (int s1 = 0; s1 < l.size(); s1++) 
			{ 
				
				// Take above evaluated all possible 
				// values in right side of 'i' 
				for (int s2 = 0; s2 < r.size(); s2++) 
				{ 
					
					// Calculate value for every pair 
					// and add the value to result. 
					int val = eval(l.get(s1), expr.charAt(i), r.get(s2)); 
					res.add(val); 
				} 
			} 
		} 
		return res; 
	} 

	// Driver program 
	public static void main(String[] args) 
	{ 
		String expr = "1*2+3*4"; 
		int len = expr.length(); 
		List<Integer> ans = evaluateAll(expr, 0, len - 1); 

		for (int i = 0; i < ans.size(); i++) 
		{ 
			System.out.println(ans.get(i)); 
		} 
	} 
}
