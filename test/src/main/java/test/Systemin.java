package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Systemin {
public static void main(String[] args) {
	
	System.out.println("Enter your name");
	BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
	try {
		String name = buff.readLine();
		System.out.println(name);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
