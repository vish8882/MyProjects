package thread;

public class IncrementNumber implements Runnable{
	
	int j =0;
	static IncrementNumber number ;
	public static void main(String[] args) {
		number = new IncrementNumber();
		Thread t1 = new Thread(number);
		Thread t2 = new Thread(number);
		t1.start();
		t2.start();
	}

	@Override
	public void run() {
		for(int i=0; i<5 ; i++)
		{	
			synchronized (number) {
				if(j %2 ==0){
					incrementNumber();
					try {
						number.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
					number.notify();
				
				}
			
		
		
			synchronized(number) {
				if(j%2 != 0) {
					incrementNumber();
					try {
						number.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else
				number.notify();
				
			}
		}
	}
	
	public void incrementNumber(){
		j=j+1;
		
		System.out.print(j);
		System.out.println(" "+Thread.currentThread().getName());
		
	}

}
