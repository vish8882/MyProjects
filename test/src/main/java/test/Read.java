package test;
import java.io.*;  
class Read{  
 public static void main(String args[]){  
  try{  
    FileInputStream fin=new FileInputStream("D:/Users/lidnl0t/Downloads/Test/Test1.txt");  
    FileInputStream fin1=new FileInputStream("D:/Users/lidnl0t/Downloads/Test/Test2.txt");
//    BufferedInputStream buffin = new BufferedInputStream(fin);
    FileWriter fout=new FileWriter("D:/Users/lidnl0t/Downloads/Test/Test3.txt"); 
      int i=0;  
//    long sysdate = System.currentTimeMillis();
//    while((i=buffin.read())!=-1){  
//     System.out.print((char)i);     
//         } 
//    
//    System.out.println("BufferedInputStream takes :" + (System.currentTimeMillis() - sysdate) + "ms");
//    System.out.println();
//    sysdate = System.currentTimeMillis();
//    while((i=fin1.read())!=-1){  
//        System.out.print((char)i);     
//            } 
//    System.out.println("FileInputStream takes :" + (System.currentTimeMillis() - sysdate) + "ms");
//       System.out.println();
    SequenceInputStream fread = new SequenceInputStream(fin, fin1);
   // FileReader fread = new FileReader("D:/Users/lidnl0t/Downloads/Test/Test.txt");
    while(( i =fin.read()) != -1)
    {
    System.out.print((char)i);
    
    }
    
//     while((i=fread.read()) != -1)
//    {
//    	 System.out.print((char)i);
//    	 fout.write((char)i);
//    	 
//    }
     
     fout.close();
//    FileOutputStream fos = new FileOutputStream("D:/Users/lidnl0t/Downloads/Test/Test1.txt");
//    FileInputStream fins = new FileInputStream("D:/Users/lidnl0t/Downloads/Test/Test1.txt");
//    while((i = fins.read()) != -1)
//    {
//    	System.out.print((char)i);
//    }
//    
//    System.out.println();
//    ByteArrayOutputStream bout = new ByteArrayOutputStream();
//    String b = "this is third test for Bytebuffer";
//    byte b1[]= b.getBytes();
//    bout.write(b1);
//    bout.writeTo(fos);
//    byte[] b2 = bout.toByteArray();
//    ByteArrayInputStream bos= new ByteArrayInputStream(b2);
//    while((i = (bos.read())) != -1)
//    {
//    	System.out.print((char)i);
//    }
    
  }
  catch(Exception e){System.out.println(e);}  
  
 }  
}  