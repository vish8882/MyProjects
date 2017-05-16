package thread;

public class threadtest implements Runnable{
	
	
	
	    public void run(){
	        System.out.println("satheesh");
	        for(int i=1;i<5;i++)
	        {
	            try{
	                System.out.println("satheesh");
	                Thread.sleep(1000);
	                System.out.print(Thread.currentThread().getId());
	            }
	            catch(Exception e)
	            {
	                System.out.println(e);
	            }
	        }
	    }

    public threadtest(threadtest name)
    {
        System.out.println("satheesh");
        System.out.println(this.getClass().getName().toString());
        Thread t=new Thread(this,"name");
        t.start();
        t=null;
        //System.out.println(this+"\n"+t);
    }

    

    public threadtest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[])
    {
        threadtest satheesh = new threadtest();    
         new threadtest(satheesh);
    }

}
