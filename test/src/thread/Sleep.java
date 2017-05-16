package thread;

public class Sleep extends Thread {
	public void run(){  
		  for(int i=1;i<5;i++){  
		    
		    	try {
					Thread.sleep(500);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
				}
		    	  
		    System.out.println(i+" "+ getName());  
		  }  
		 }  
		 public static void main(String args[]){  
		  Sleep t1=new Sleep();  
		  Sleep t2=new Sleep();
		  Sleep t3=new Sleep();  
		   
		  t1.start(); 
		  try {
				t1.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  t2.start(); 
		  t3.start();
		  
		 
		 }  
}
