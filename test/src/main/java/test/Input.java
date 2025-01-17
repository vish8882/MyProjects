package test;

import java.io.*;  
class Input{  
  public static void main(String args[]){  
   try{  
	   String[] a = {"D:/Users/lidnl0t/Downloads/Test/Test1.txt","D:/Users/lidnl0t/Downloads/Test/Test2.txt"};
	   
	   for (String i : a)
	   {
	   String file = i;
	   
     FileOutputStream fout=new FileOutputStream(file);
     FileOutputStream fout1=new FileOutputStream(file); 
     BufferedOutputStream buffout = new BufferedOutputStream(fout);
    // FileWriter fwrite = new FileWriter(new File("D:/Users/lidnl0t/Downloads/Test/Test1.txt"));
     String s="Multiple write example2";  
     byte b[]=s.getBytes(); //converting string into byte array  
     fout.write(b);  
    // fwrite.write(s);
    // fwrite.close();
     //buffout.flush();
     fout.close();
     //fout.close();  
     System.out.println("success...");  
	   }
    }catch(Exception e){System.out.println(e);}  
  }  
}  