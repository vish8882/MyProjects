public class MyClass {
    
    static  int x = 0, y = 0;
    
    static void method1() throws Exception{
    	Thread.sleep(50);
           x++; y++;
    }
    static void method2()throws Exception {
    	Thread.sleep(100);
           System.out.println("x=" + x + " y=" + y);
    }
    
    public static int hashCode(String a){
    	int code=17;
    	for(int i=0; i < a.length();i++){
    		code=code+(int)a.charAt(i);
    	}
    	return code;
    }
    
    public static void main(String[] args) throws Exception{
    	String a="bc";
    	String b= "ad";
    	System.out.println(hashCode(a));
    	System.out.println(hashCode(b));
    	System.out.println((int)'a');
    	System.out.println((long)'a');
    	
    }
}