
public class ShutDownHookImpl {

	public static void main(String[] args) {
		System.out.println("Normal program");
		Runtime.getRuntime().addShutdownHook(new Thread(new Process()));
		Runtime.getRuntime().addShutdownHook(new Thread(new ProcessNew()));
		System.exit(0);
		System.out.println("YOYO");
	}
	
	
}

class Process implements Runnable{
	
	public void run(){
		System.out.println("ShutDown Hook started");
	}
}


class ProcessNew implements Runnable{
	
	public void run(){
		
		System.out.println("Second ShutDown Hook started");
	}
}