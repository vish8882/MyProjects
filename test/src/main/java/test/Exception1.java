package test;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class Exception1 {
	
	public void finalize(){System.out.println("finalize called");}  
	public static void main(String[] args){  
	Exception1 f1=new Exception1();  
	Exception1 f2=new Exception1();  
	f1=null;  
	f2=null;
	System.gc();  
	   
}
}
