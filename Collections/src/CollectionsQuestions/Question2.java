package CollectionsQuestions;

import java.util.ArrayList;

import java.util.Collections;

public class Question2 {

	public static void main(String[] args) {
		 
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for(int i = 1 ; i <=20 ; i++)
			array.add(i);
		
		System.out.println("List before reversing : " + array);
		
		Collections.reverse(array);
		
		System.out.println("List after reversing : " + array);
		
		
		
		

	}

}
