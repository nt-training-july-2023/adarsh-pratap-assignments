package CompareObjectData;

import java.util.ArrayList;
import java.util.Collections;

class Employee implements Comparable<Employee>{
	
	public int empId;
	
	public String name;
	
	public int age;
	
	public Employee(int empId , String name , int age) {
		
		this.empId = empId;
		this.name = name;
		this.age = age;
		
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Employee o) {
		
		return (this.age-o.age);
	}
	
}

public class ComparableDemo {

	public static void main(String[] args) {
		
		ArrayList<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee(1,"Adarsh Singh Parihar", 22));
		emp.add(new Employee(55,"Sachin Singh Rajput", 23));
		emp.add(new Employee(88,"Ashutosh Tigga", 44));
		emp.add(new Employee(2,"Ashish Baghel", 55));
		emp.add(new Employee(43,"Atul Singh Parihar", 28));
		
		Collections.sort(emp);
		
		for(Employee e : emp)
			System.out.println(e);
		

	}

}
