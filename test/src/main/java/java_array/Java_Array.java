package java_array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

import datastructures.tree.Tree;



class Java_Array {  
	
	
public static void main(String args[]){
	LinkedList list = new LinkedList();
	list.add(1);
	list.add(2);
	list.add(3);
	list.size();
	LinkedList list1 = new LinkedList(list);
	Iterator itr=list.iterator();
	while(itr.hasNext()){
		itr.next();
	}
	System.exit(0);
	String s6= "Good morning sunshine";
	Scanner in = new Scanner(s6);
	in.useDelimiter("\\s[s6]");
	int count=0;
	while(in.hasNext())
	{
		System.out.println(in.next());
		count++;
	}
	System.out.println(count);
	System.exit(0);
	
	
	
	Tree et = new Tree();
	Employee emp = new Employee("Vishal", "Kumar", "vishal@mail.com");
	Employee emp1 = new Employee("Atul", "Kumar", "atul@mail.com");
	Employee emp3 = new Employee("ViAtshal", "Kumar", "viAtshal@mail.com");

	HashMap<Employee,String> map= new HashMap<Employee,String>();

	map.put(emp, "first");
	map.put(emp1, "second");
	map.put(emp3, "third");
	emp1.setEmail("changed");
	
	
	System.out.println(map.get(emp));
	System.out.println(map.get(emp1));
	System.out.println(map.get(emp3));
	
	Set<Map.Entry<Employee, String>> set = map.entrySet();
	for(Map.Entry<Employee, String> e : set){
		System.out.println(e.getKey().getEmail());
	}
	
	HashMap<String,String> map1= new HashMap<String,String>();
	String s="one";
	String s2="second";
	String s3="third";
	
	map1.put(s,s);
	map1.put(s2,s2);
	map1.put(s3,s3);
	s2="changed";
	System.out.println(map1.get(s));
	System.out.println(map1.get("second"));
	System.out.println(map1.get(s3));
	
}


}

class Employee {
	private String name;
	private String phone;
	private String email;
	
	public Employee(){
		
	}
	
	public Employee(String name, String phone, String email){
		this.name=name;
		this.phone=phone;
		this.email=email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int hashCode()
	{ int result = 17;
	result=result+ result * name.hashCode()+31;
	result=result+ result * phone.hashCode()+31;
	result=result+ result * email.hashCode()+31;
	return result;
	}
	
	public boolean equals(Object o){
		if(!(o instanceof Employee))
			return false;
		if(o==this) return true;
		Employee e= (Employee) o;
		if(e.name.equalsIgnoreCase(name))
			if(e.phone.equalsIgnoreCase(phone))
				if(e.email.equalsIgnoreCase(email))
					return true;
		return false;
		
	}

	
}
