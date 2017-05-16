package thread;

import java.util.LinkedList;
import java.util.List;

class Producer implements Runnable{
	
	List<Integer> product;
	 public Producer(List<Integer> product)
	 {
		 this.product=product;
	 }
	public void run (){
		int i;
		for( i=1;i<=10;i++){
			try{
				
			produce(i);
			}
			catch(Exception e)
			{
			System.out.println(e);	
			}
			
		}
		if(i==10&&product.isEmpty())
		{
			Consumer.continueRun=false;
		}
		
	}
	 void produce(int i) throws Exception
	 {
		 synchronized (product) {
			 
			if(product.size()==2)
			{
			System.out.println("Waiting for the consumer to consume");
			product.wait();
			}
			
			synchronized (product){
			System.out.println("Producer is adding"+i);
				product.add(i);
				Thread.sleep((long)(Math.random() * 1000));
			product.notify();
			}
		}
	 }
	
}
 class Consumer implements Runnable{
	List<Integer> product;
	public static boolean continueRun=true;
	 public Consumer(List<Integer> product)
	 {
		 this.product=product;
	 }
	 
	 public void run (){
		 while(continueRun){
		try {
			consume();
			Thread.sleep(100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 }
	}
	 void consume() throws Exception
	 {
		 synchronized (product) {
			if(product.size()==0)
			{
				System.out.println("Queue is empty: Consumer waiting for the producer to produce");
				product.wait();
			}
		}
		 
		 synchronized (product) {
			 System.out.println("Consumer has consumed"+ product.get(0));
			 Thread.sleep((long)(Math.random() * 2000));
			 product.remove(0);
			 product.notify();
		}
		 
	 }
	
}

public class ConsumerProducerProblem {

	public static void main(String[] args) {
		List<Integer> product = new LinkedList<Integer>();
	Consumer consumer = new Consumer(product);
	Producer producer = new Producer(product);
	Thread t2= new Thread(consumer);
	Thread t1= new Thread(producer);
	t1.start();
	t2.start();	

	}

}
