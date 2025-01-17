package question;

import java.io.Serializable;

public class SingletonClass implements Serializable {
	
	private SingletonClass(){
		System.out.println("Example");
	}
	private static class SingletonHelperClass {
		public static SingletonClass instance = new SingletonClass();
		}
		public static SingletonClass getInstance(){
			return SingletonHelperClass.instance;
		}
		
	/*	protected Object readResolve(){
			return getInstance();
		}*/
	}
	
	


