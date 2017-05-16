package thread;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


class ProducerBlock implements Runnable{
	private BlockingQueue<Integer> product;
	public void run(){
		for(int i =1;i<=10;i++)
		{
			System.out.println("Producer is producing "+i);
			product.add(i);
		}
	}
	
	public ProducerBlock(BlockingQueue<Integer> product)
	{
		this.product=product;
	}
}

class ConsumerBlock implements Runnable{

	private BlockingQueue<Integer> product;
	public static boolean continueRun=true;
	public void run(){
		while(continueRun)
		{
			System.out.println("Consumer is consuming");
			try {
				product.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ConsumerBlock(BlockingQueue<Integer> product)
	{
		this.product=product;
	}

}

public class ConsumerProducerBlockingQueue  {

	public static void main(String[] args) {
		BlockingQueue<Integer> product= new LinkedBlockingQueue<Integer>();
		ConsumerBlock consumer = new ConsumerBlock(product);
		ProducerBlock producer = new ProducerBlock(product);
		
		Thread t1= new Thread(producer, "Producer");
		Thread t2= new Thread(consumer, "Consumer");
		t1.start();
		t2.start();
		try {
			method();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
public static void method() throws Exception{
	throw new IOException();
}
}
