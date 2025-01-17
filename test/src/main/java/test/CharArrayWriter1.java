package test;

import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class CharArrayWriter1 {
public static void main(String[] args) {
	 try{
	CharArrayWriter out=new CharArrayWriter();  
	ByteArrayOutputStream bufout = new ByteArrayOutputStream();
	String s = "My project is";
	byte[] b1 = s.getBytes();
	bufout.write(b1);
	  out.write("my name is");  
	  
	  FileWriter f1=new FileWriter("D:/Users/lidnl0t/Downloads/Test/Test1.txt");  
	  FileWriter f2=new FileWriter("D:/Users/lidnl0t/Downloads/Test/Test2.txt");  
	  FileOutputStream f3=new FileOutputStream("D:/Users/lidnl0t/Downloads/Test/Test3.txt");
	  FileOutputStream f4=new FileOutputStream("D:/Users/lidnl0t/Downloads/Test/Test4.txt");
	  
	  out.writeTo(f1); 
	  out.write("Vishal");
	  out.writeTo(f2); 
	  
	  bufout.writeTo(f3); 
	  String s1 = "Highmark";
	  byte[] b2 = s1.getBytes();
	  bufout.write(b2);
	  bufout.writeTo(f4);
	  
	  
	  f1.close();  
	  f2.close();  
	  f3.close();
	  f4.close();  
	 }
	 catch(IOException i)
	 {
		 
	 }
	 }
}
