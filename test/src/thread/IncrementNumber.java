package thread;


public class IncrementNumber {

    volatile int j = 1;

    public static void main(String[] args) {
        IncrementNumber number = new IncrementNumber();
        OddIncrement t1 = new OddIncrement(number);
        EvenIncrement t2 = new EvenIncrement(number);
        t1.start();
        t2.start();
    }

    public void incrementNumber(String name) {
        System.out.print(j);
        System.out.println(" " + name);
        j = j + 1;
    }

}

class OddIncrement extends Thread {

 IncrementNumber number;

 public OddIncrement(IncrementNumber number) {
     this.number = number;
 }

	public void run() {
		synchronized (number) {
			while (number.j <= 10) {
				if (number.j % 2 != 0) {
					number.incrementNumber("Odd");
					number.notify();
				} 
					try {
						number.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
	}
}
class EvenIncrement extends Thread {

    IncrementNumber number;

    public EvenIncrement(IncrementNumber number) {
        this.number = number;
    }

	public void run() {

		synchronized (number) {
			while (number.j <= 10) {
				if (number.j % 2 == 0) {
					number.incrementNumber("Even");
					number.notify();
				}
				try {
					number.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
