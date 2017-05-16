package interfaces;

public class Test3 extends Thread {

	public static void main(String[] args) {
		
		Test3 t1 = new Test3();
		t1.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(" vola");
		
	}


	
	
}
