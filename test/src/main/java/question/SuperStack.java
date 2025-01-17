/**
 * Design a stack with push pop and increment method. Increment method will increment the bottom k values with v.
 */
package question;

import java.math.BigInteger;
import java.util.Stack;

public class SuperStack {
	public static void main(String[] args) {

		String[] operations = { "push 4", "pop", "push 3", "push 5", "push 2", "inc 3 1", "pop", "push 1", "inc 2 2",
				"push 4", "pop", "pop" };
		Stack<BigInteger> stack = new Stack<BigInteger>();
		Stack<BigInteger> stack2 = new Stack<BigInteger>();

		for (String s : operations) {
			String[] arr = s.split(" ");
			if (arr[0].equals("pop"))
				pop(stack, stack2);
			if (arr[0].equals("push"))
				push(stack, stack2, (arr[1]));
			if (arr[0].equals("inc"))
				inc(stack, stack2, Integer.valueOf(arr[1]) - 1, (arr[2]));
		}

	}

	public static void push(Stack<BigInteger> s, Stack<BigInteger> s1, String i) {
		s.push(new BigInteger(i));
		s1.push(new BigInteger("0"));
		if (!s.isEmpty())
			System.out.println(s.peek().add(s1.peek()));
		else
			System.out.println("EMPTY");
	}

	public static void pop(Stack<BigInteger> s, Stack<BigInteger> s1) {
		s.pop();
		BigInteger b1 = s1.pop();
		if (!s.isEmpty()) {
			s1.push(b1.add(s1.pop()));
			System.out.println(s.peek().add(s1.peek()));
		} else
			System.out.println("EMPTY");
	}

	public static void inc(Stack<BigInteger> s, Stack<BigInteger> s1, Integer index, String i) {
		s1.set(index, s1.get(index).add(new BigInteger(i)));
		if (!s.isEmpty())
			System.out.println(s.peek().add(s1.peek()));
		else
			System.out.println("EMPTY");
	}
}
