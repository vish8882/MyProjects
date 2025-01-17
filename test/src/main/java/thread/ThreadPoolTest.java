package thread;

import java.util.List;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingQueue;

class ThreadPooling {
	List<ThreadPoolMain> threadPool = new LinkedList<ThreadPoolMain> ();
	BlockingQueue<Runnable> queue = null;
	private boolean isStopped = false;
	
	ThreadPooling (int numberOfThread, int maxNumberOfThreads){
		queue= new LinkedBlockingQueue<Runnable>(maxNumberOfThreads);
		for(int i=0; i <numberOfThread;i++){
			threadPool.add(new ThreadPoolMain(queue));
		}
		for(ThreadPoolMain thread : threadPool){
			thread.start();
		}
		System.out.println("Thread Pool Created");
	}
	
	public synchronized void  execute(Runnable task) throws Exception{
        if(this.isStopped) throw
            new IllegalStateException("ThreadPool is stopped");
      //  System.out.println("Before take"+queue.size());
        if(!this.queue.offer(task))
        {
        	Thread.sleep(1000);
        	this.queue.put(task);
        }
    }
	public synchronized void stop(){
        this.isStopped = true;
        for(ThreadPoolMain thread : threadPool){
           thread.doStop();
        }
    }
	
}
class ThreadPoolMain extends Thread{
	private boolean       isStopped = false;
	BlockingQueue<Runnable> queue=null;
	ThreadPoolMain(BlockingQueue<Runnable> queue){
		this.queue=queue;
	}
	
	public synchronized void doStop(){
        isStopped = true;
        this.interrupt(); //break pool thread out of dequeue() call.
    }
	public void run(){
		try{
			System.out.println("Threads created");
		while(true){
			Runnable task = queue.take();
			task.run();
			//System.out.println("After take"+queue.size());
		}
		} catch(InterruptedException e){
		}
	}
	
}


public class ThreadPoolTest implements Runnable{
	
	static CyclicBarrier b = new CyclicBarrier(2,new Runnable() {
		
		@Override
		public void run() {
			System.out.println("Ended program");
			//System.exit(0);
			
		}
	});
	static CountDownLatch latch ;
	public BlockingQueue<Employee> empQueue;
	public int number=6;
	ThreadPoolTest(int numbers){
		this. number=numbers;
	}
	
	ThreadPoolTest(BlockingQueue<Employee> empQueue){
		this.empQueue=empQueue;
	
	}
	
	public void run(){
		 try {	
		Employee e= empQueue.take();
			if(e.getName().equalsIgnoreCase("Stud"))
				e.setPlace("GGN");
			if(e.getName().equalsIgnoreCase("Archit"))
				e.setPlace("ChandaNagar");
			if(e.getName().equalsIgnoreCase("Shivam"))
				e.setPlace("Whitefield");
			
		 System.out.println(e.getName()+ " " + e.getPlace());
	            Thread.sleep(1000);
	           // latch.countDown();
	            System.out.println("Waiting for barrier");
	            b.await();
	            System.out.println("Crossed the barrier");
	        } catch (InterruptedException ex) {
	            ex.printStackTrace();
	        } catch (BrokenBarrierException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
	}
	
	public static void main(String[] args) throws Exception {
	
		ThreadPooling threadPool = new ThreadPooling(2, 2);
		Employee e1= new Employee("Vishal", "Whitefield");
		Employee e2= new Employee("Harshit", "Whitefield");
		Employee e3= new Employee("Archit", "Whitefield");
		Employee e4= new Employee("Stud", "Whitefield");
		Employee e5= new Employee("Lalit", "Whitefield");
		Employee e6= new Employee("Shivam", "Pune");
		BlockingQueue<Employee> empQueue= new LinkedBlockingQueue<Employee> ();
		empQueue.put(e1);
		empQueue.put(e2);
/*		empQueue.put(e3);
		empQueue.put(e4);
		empQueue.put(e5);
		empQueue.put(e6);*/
		int size=empQueue.size();
		latch  = new CountDownLatch(size);
		for(int i=0; i <size; i++){
			ThreadPoolTest t= new ThreadPoolTest(empQueue);
			threadPool.execute(t);
			//System.out.println("executed");
		}	
		latch.await();
		System.out.println("Program Ended");
		//System.exit(0);
	}
}

class Employee {
	private String name;
	private String place;
	
	Employee(String name, String place){
		this.name=name;
		this.place=place;
	}
	
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	
}


