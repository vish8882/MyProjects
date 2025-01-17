package test;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Test3 implements Runnable
{
	
	public static void main(String[] args) throws Exception {
		int i =0;
		if( false&&true)
		{
			System.out.println("haha");
		}
		System.exit(0);
		Test3 thread= new Test3();
		Thread t= new Thread(thread);
		Test3 thread1= new Test3();
		Thread t1= new Thread(thread1);
		Test3 thread2= new Test3();
		Thread t2= new Thread(thread2);
		Test3 thread3= new Test3();
		Thread t3= new Thread(thread3);
		Test3 thread4= new Test3();
		Thread t4= new Thread(thread4);
		Test3 thread5= new Test3();
		Thread t5= new Thread(thread5);
		t.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		
		
	}


	public void run() {

		try{
		URL url =new URL("http://localhost:8080/BeerShop/Select.com");
		HttpURLConnection con= (HttpURLConnection) url.openConnection();
		con.setRequestMethod("POST");
		BufferedReader buff= new BufferedReader(new InputStreamReader(con.getInputStream()));
		StringWriter build= new StringWriter();
		String read="";
		while((read= buff.readLine())!=null)
		{
		build.append(read);
		}
		System.out.println(build.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}