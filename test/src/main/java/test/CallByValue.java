package test;

public class CallByValue {
	  
		 int data=50;  
		  
		 void change(int data){  
		 data=data+100;//changes will be in the local variable only  
		 }  
		     
		 public static void main(String args[]){  
		   CallByValue op=new CallByValue();  
		  
		   System.out.println("before change "+op.data);  
		   op.change(500);  
		   System.out.println("after change "+op.data);  
		  String i = "Java";
		  i = "Java1";
		  System.out.println(i);
		  String s = new String("Welcome");
		  String s1 = new String("Welcome");
		  System.out.println(s1.getClass().getName()+" "+s.getClass().getName());
		 }  
		}  