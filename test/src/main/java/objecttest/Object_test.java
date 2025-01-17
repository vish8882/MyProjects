package objecttest;

class test3
{
	static int method(){
	int id =12;
	return id;
	}
}

public class Object_test {
	 int id;
	 public Object_test() {
	this(test3.method());
	}
	
	public Object_test(int method) {
		//this.id=method;// TODO Auto-generated constructor stub
	}
}

class test2 
{
	int  display (Object_test test)
	{
		System.out.println(test.id);
		return test.id;
	}
	
	public static void main(String[] args) {
		test2 t1 = new test2();
		int i = t1.display(new Object_test());
		System.out.println("Output = " +i);
	}
}