package classloader;

public class AnotherClass extends SuperClass{
	static {
		System.out.println("hello another loading");
	}
	 {
		System.out.println("hello another initialized");
	}
	static String testVar;
	
	static void method(){
		System.out.println("method");
	}

}
