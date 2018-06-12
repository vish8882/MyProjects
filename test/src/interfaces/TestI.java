package interfaces;

interface TestInterfaces {
	
	

	class testclass
	{
		int i =1;
		String name = "Vishal";
		void display1()
		{
			System.out.println("Output:" + i + name);
		}
	}	
}

 class TestI extends TestInterfaces.testclass implements TestInterfaces {
	 public static void main(String[] args) {
		 TestInterfaces.testclass t1 = new TestInterfaces.testclass();
		t1.display1();
	}


	/*public void display() {
		// TODO Auto-generated method stub
		
	}*/
	
}