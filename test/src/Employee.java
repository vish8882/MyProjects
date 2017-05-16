
public class Employee {
int id;
String name;
Address address;

public Employee (int id, String name, Address address)
{
	this.id = id;
	this.name = name;
	this.address= address;		
}

public void display()
{
	System.out.println(id +" " + name + " " + address.city + " "+address.state + " "+ address.street);
}

public static void main(String[] args) {
	Address addr1 = new Address("Hyd","Kondapur","Telangana");
	Address addr2 = new Address("Del","Kalkaji","Delhi");
	
	Employee emp1 = new Employee(1,"Vishal",addr1);
	Employee emp2 = new Employee(2,"Shubham",addr2);
	
	emp1.display();
	emp2.display();
}

}

