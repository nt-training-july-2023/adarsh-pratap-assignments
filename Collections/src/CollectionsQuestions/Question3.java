package CollectionsQuestions;

import java.util.ArrayList;


public class Question3 {

	public static void main(String[] args) {
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for(int i = 40 ; i <= 60 ; i++)
			array.add(i);
		
		System.out.println("Array before updating the element by 5 which is greater than 50 : " + array);
		
		
		for(int i = 0 ; i < array.size(); i++)
			if(array.get(i)>50)
				array.set(i, array.get(i)+5);
		
		System.out.println("Array after updating the element by 5 which is greater than 50 : " + array);
		
	}

}
