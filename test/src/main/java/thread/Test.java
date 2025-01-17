package thread;

public class Test extends Thread1 {
 void run(){
	 System.out.println("Test Class");
 }
	
	public static void main(String[] args) {
	Thread1 t1= new Test();
	t1.start();
}
}
