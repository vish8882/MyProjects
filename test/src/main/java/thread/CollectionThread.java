package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import datastructures.linkedlist.LinkedList;

public class CollectionThread implements Runnable{

	static int count;
	static ConcurrentLinkedQueue<Integer> queue=  new ConcurrentLinkedQueue<Integer>();
	static List list = new ArrayList();
	@Override
	public void run() {
		
	try {
	
			System.out.println(Thread.currentThread());
			list.add(queue.poll()*2);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
	
	public static void main(String[] args) throws Exception{
		
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.add(6);
		queue.add(7);
		//System.out.println(queue);
		ExecutorService executor= Executors.newFixedThreadPool(5);
		int i;
		int l=queue.size();
		for (i = 0; i < l; i++) {
			Runnable thread = new CollectionThread();
			executor.execute(thread);}
		System.out.println("I" +i);
		executor.shutdown();
		 while (!executor.isTerminated()) {  
			 
		 } 
		 System.out.println(list);
	}

}
