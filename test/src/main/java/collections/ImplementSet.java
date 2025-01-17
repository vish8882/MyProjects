package collections;

import java.util.HashSet;

public class ImplementSet {
	
	public static void main(String[] args) {
		HashSet<Employee> set = new HashSet<Employee>();
		set.add(new Employee("Vishal", ""));
		System.out.println(set.add(new Employee("Vishal", "")));
		for(Employee e : set)
		{
			System.out.println(e.getName());
		}
	}

}

class Employee {
	private String name;
	private String mail;
	
	public int hashCode(){
		int result=17;
		result=result+ result* name.hashCode();
		result=result+ result* mail.hashCode();
		return result ;
	}
	
	public boolean equals(Object o){
		if(this==o)
			return true;
		if(!(o instanceof Employee))
			return false;
		Employee e= (Employee)o;
			if(e.name.equals(name))
				if(e.mail.equals(mail))
					return true;
			return false;
	}
	
	public Employee(String name, String mail){
		this.name=name;
		this.mail=mail;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
}