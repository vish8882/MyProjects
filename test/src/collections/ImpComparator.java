package collections;


import java.util.*;

class Employees implements Comparable{

	private int id;
	private String name;
	private int number;
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNumber() {
		return number;
	}


	public void setNumber(int number) {
		this.number = number;
	}


	public Employees(int id, String name, int number){
		this.id=id;
		this.name=name;
		this.number=number;
	}
	
	
	public int compareTo(Object o) {
		Employees e = (Employees) o;
		if(id-e.id==0)
			if(name.compareTo(e.name)==0)
				return number-e.number;
			else
				return name.compareTo(e.name);
		else
			return id-e.id;
			
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
}

public class ImpComparator {

	public static void main(String[] args) {
		Employees e1 = new Employees(10, "Vishal", 1000);
		Employees e2 = new Employees(30, "Atul", 3000 );
		Employees e3 = new Employees(20, "Stud", 2000);
		Employees e4 = new Employees(50, "", 5000);
		Employees e5 = new Employees(30, "Atul", 3100);
		Employees e6 = new Employees(10, "Atul" , 1000);
		
		List<Employees> list = new ArrayList<Employees>();
		//Vector v = new Vector();
		list.add(e1);
		list.add(e2);
		list.add(e3);
		list.add(e4);
		list.add(e5);
		list.add(e6);
		Collections.sort(list, new CompareId());
		Iterator<Employees> itr= list.iterator();
		while(itr.hasNext()){
			Employees e= itr.next();
			System.out.println(e.getId() + " " + e.getName()+ " "+ e.getNumber());
		}
	}
}

class CompareId implements Comparator<Employees> {

	@Override
	public int compare(Employees o1, Employees o2) {
		// TODO Auto-generated method stub
		return o1.getId()-o2.getId();
	}
	
}

class CompareName implements Comparator<Employees> {

	@Override
	public int compare(Employees o1, Employees o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}
	
}