package CollectionsQuestions;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Question4 {

	public static void main(String[] args) {
		
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		
		for(int i = 40 ; i <= 80 ; i++)
			array.add(i);
		
		
		System.out.println("Array before Filtering : " + array);
		array = (ArrayList<Integer>) array.stream().filter(x->x<60).collect(Collectors.toList());
		
		System.out.println("Array after Filtering : " + array);

	}

}
