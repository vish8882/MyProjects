package java8;

interface Java8{

	default void print(String str) {
		if (!isNull(str))
			System.out.println("MyData Print::" + str);
	}

	static boolean isNull(String str) {
		System.out.println("Interface Null Check");

		return str == null ? true : "".equals(str) ? true : false;
	}}

interface Java8_2{
	
	public  static  void method(){
		System.out.println("Hello 2");
	}
}

public class JavaTest implements Java8 {

	public boolean isNull(String str) {
		System.out.println("Impl Null Check");

		return str == null ? true : false;
	}
	
	public static void main(String args[]){
		JavaTest obj = new JavaTest();
		obj.print("");
		obj.isNull("abc");
	}
	}
