package CompareObjectData;

public class StudentData {

	public int rollNo;
	
	public String name ;
	
	public int age;

	@Override
	public String toString() {
		return "StudentData [rollNo=" + rollNo + ", name=" + name + ", age=" + age + "]";
	}

	public StudentData(int rollNo, String name, int age) {
		
		this.rollNo = rollNo;
		this.name = name;
		this.age = age;
	}
	
	
	
}
