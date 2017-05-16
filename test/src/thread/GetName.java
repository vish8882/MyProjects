package thread;

public class GetName  {
	 Runnable r = new Runnable(){
	public void run(){  
		   System.out.println("running..."+ Thread.currentThread());
//		   try {
//			Thread.sleep(500);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
		  };  
		 public static void main(String args[]){  
		  GetName g1= new GetName();
		  Thread t1=new Thread();  
		  Thread t2=new Thread(); 		  
		  System.out.println("Name of t1:"+t1.getName());  
		  System.out.println("Name of t2:"+t2.getName());  
		  System.out.println("id of t1:"+t1.getId());  
		  
		  t1.start();  
		  t2.start();  
		  
		  t1.setName("Sonoo Jaiswal");  
		  System.out.println("After changing name of t1:"+t1.getName());  
		  t2.setName("Miku Jaiswal");  
		  System.out.println("After changing name of t1:"+t2.getName());
		  System.out.println(t1.getName());
		 } 
}
