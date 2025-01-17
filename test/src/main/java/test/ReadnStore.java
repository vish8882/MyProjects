package test;


import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadnStore {
public static void main(String[] args) {
	try {
		int[] data = new int[100];
		int j = 0;
		StringBuilder str1 = new StringBuilder();
		FileInputStream fin  = new FileInputStream("D:/Users/lidnl0t/Downloads/Test/Test1.txt");
		FileOutputStream fout1 = new FileOutputStream("D:/Users/lidnl0t/Downloads/Test/Test2.txt");
		FileOutputStream fout2 = new FileOutputStream("D:/Users/lidnl0t/Downloads/Test/Test3.txt");
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		int i = 0;
		
			while((i=fin.read())!=-1)
			{
				System.out.print((char)i);
				bout.write(i);
			}
			
			
		fin.close();
		bout.writeTo(fout1);
		bout.writeTo(fout2);
		bout.flush();
		bout.close();
		fout1.close();
		fout2.close();
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	catch (IOException i){
		
	}
}
}
