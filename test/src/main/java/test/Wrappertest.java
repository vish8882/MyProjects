package test;

public class Wrappertest {
	public static void main(String args[]){  
		//Converting int into Integer  
		char a='A';  
		Character i=Character.valueOf(a);//converting char into Character  
		Character j=a;//autoboxing, now compiler will write Integer.valueOf(a) internally  
		  
		System.out.println(a+" "+i+" "+j);  
		
		Object c =j.getClass();
		String name = c.toString();
		System.out.println(name);
		
		}
}
