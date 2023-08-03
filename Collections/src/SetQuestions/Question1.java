package SetQuestions;


import java.util.LinkedHashSet;

public class Question1 {

	public static void main(String[] args) {
		
		LinkedHashSet<String> set = new LinkedHashSet<String>();
		
		
		for(int i = 0 ; i < 20 ; i++)
			set.add("Adarsh"+i);
		
		System.out.println("20 elements added in the Collection and they are not reapeated and storing order is preserved ");
		
		System.out.println(set);
		
		//Methods of LinkedHashSet
		
		set.add("Adarsh122"); //Method to add new element in the set 
		
		set.remove("Adarsh122"); //Method to remove the element 
		
		System.out.println("Contains method to check the element is present in the set or not : "+set.contains("Adarsh1"));
		
		System.out.println("To check the set is empty or not : " + set.isEmpty());
		
		System.out.println("To get the size of the set is : " + set.size());
		
		set.clear(); //to clear the set data and make the set empty 
		
		System.out.println("size of the set after using clear() method : " + set.size());
	}

}
