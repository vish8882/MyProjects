package Inheritance;

import java.io.*;

class SuperInheritance{
	public SuperInheritance (){
		System.out.println("First First cons");
	}
	{
		System.out.println("First First");
	}
	
	static {
		System.out.println("First First static");
	}
}

class Inheritance extends SuperInheritance{
	{
		System.out.println("First");
	}

	static {
		System.out.println("First  static");
	}
	public Inheritance()
	{
		System.out.println("Super Class");
	}
	
	static void method () throws RuntimeException
	{
		System.out.println("------------");
		System.out.println("Super method");
	}
}

 class child extends Inheritance {
	 {
			System.out.println("Second");
		}
	 static {
			System.out.println("Second static");
		}
public child()
{
	System.out.println("Child class");
}

static void method ()throws RuntimeException
{
	System.out.println("Child method");
}
public static void main(String[] args) throws ArithmeticException {
	Inheritance I = new child();
	I.method();

	}

}