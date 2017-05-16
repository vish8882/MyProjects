package clone;

public class Clone implements Cloneable{
	int index;
	String name;
	
	Clone(int index, String name) {
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
public static void main(String[] args) {
	try{
	Clone c1 = new Clone(1,"Vishal");
	Clone c2=(Clone)c1.clone();
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
