package classloader;

public class SuperClass {
	static {
		System.out.println("hello super loading");
	}
	 {
			System.out.println("hello super initialized");
		}
	public  static String sth="s";
	public static void methods(){
		
	}

}
