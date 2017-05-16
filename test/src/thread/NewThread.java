package thread;

public class NewThread extends Thread{
	static int count=0;
	 public void run(){
		for(int i=0;i<1000;i++)
		{
			count++;
		}
		System.out.println(count);
	}
	
public static void main(String[] args) {
	Thread t1= new Thread();
	Thread t2= new Thread();
	
	t1.start();
	t2.start();
	
	try {
		t1.join();
		t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
System.out.println(count);
}

}
