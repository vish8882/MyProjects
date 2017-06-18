package clone;

public class Clone{
public static void main(String[] args) {
	try{
	CloneTest c1 = new CloneTest(1,"Vishal");
	CloneTest c2=(CloneTest)c1.clone();
    c1.display();
    c2.display();
	}catch (CloneNotSupportedException e) {
		System.out.println("Cloning not supported");
	}
	finally {
		System.out.println("Finally");
	}
}
}	
class CloneTest implements Cloneable {
	int index;
	String name;
	
	CloneTest(int index, String name) {
		System.out.println("Clone class");
		this.index=index;
		this.name=name;
	}
	
	public void display()
	{
		System.out.println("Output:"+ index +" "+ name);
	}
	
	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}	
}

