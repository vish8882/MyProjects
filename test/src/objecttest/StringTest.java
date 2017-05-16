package objecttest;

public class StringTest {
	
	
	
	public static void main(String[] args) {
		String z="Hello";
		String a = new String("Hello");
		String b = new String("Hello");
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		System.out.println(z.hashCode());
	}

}
