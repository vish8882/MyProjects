package lambda;

import java.util.*;

public class Calculate {

	public static void main(String[] args) {

		Calculator add = (x,y) -> (x + y);
		Calculator subtract = (x,y) -> (x - y);
		Calculator multiply = (x,y) -> (x * y);
		Calculator divide = (x,y) -> (x / y);
		Calculator compare = (x,y) -> {
			if(x>y)
				return x;
			else
				return y;};
		System.out.println(add.calculate(2, 6));
		System.out.println(subtract.calculate(2, 6));
		System.out.println(multiply.calculate(2, 6));
		System.out.println(divide.calculate(6, 2));
		System.out.println(compare.calculate(6, 2));
		
		
		List<String> list = new ArrayList<>();
		list.add("hell");
		list.add("hello");
		
		list.forEach(x->  System.out.println(x));
	}

}
