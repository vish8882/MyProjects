package test;

class CustomException extends Exception {
	public CustomException(String s) {
		// TODO Auto-generated constructor stub
		super(s);
	}
	
}

public class TestException {
	
	
	
	public void method1() throws CustomException{
		throw new CustomException("Invalid Exception");
	}
	
	public static void main(String[] args) {
		TestException test= new TestException();
		try{
		test.method1();
		}
		catch(CustomException e)
		{
			System.out.println(e);
		}
	}

}
