package CompareObjectData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class CompareName implements Comparator<StudentData>{

	@Override
	public int compare(StudentData o1, StudentData o2) {
		// TODO Auto-generated method stub
		return o1.name.compareTo(o2.name);
	}
	
}

public class UsingComparator implements Comparator<StudentData>{

	public static void main(String[] args) {
		ArrayList<StudentData> arr = new ArrayList<>();
		
		arr.add(new StudentData(1, "Lalit Patel", 34));
		arr.add(new StudentData(34,"Twinkle khan", 54));
		arr.add(new StudentData(23, "Sachin ", 32));
		arr.add(new StudentData(65,"Ayushi Choure", 29));
		
		Collections.sort(arr , new UsingComparator());
		
		System.out.println("---------------------------Sorting by age-------------------------------");
		for(StudentData st : arr)
			System.out.println(st);
		
		Collections.sort(arr , new CompareName());
		
		System.out.println();
		System.out.println();
		System.out.println("---------------------------Sorting by name-------------------------------");
		for(StudentData st : arr)
			System.out.println(st);
		
	}

	@Override
	public int compare(StudentData o1, StudentData o2) {
		// TODO Auto-generated method stub
		return o1.age-o2.age;
	}

}
