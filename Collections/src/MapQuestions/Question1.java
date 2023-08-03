package MapQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		
		
		HashMap<Integer , String> map = new HashMap<>();
		
		insert(1, "Adarsh Singh Parihar" , map);
		insert(2, "Sachin" , map);
		insert(3, "Aayush" , map);
		insert(4, "Naveen",map);
		insert(5, "Sajal",map);
		insert(6 , "Prerna" , map);
		System.out.println("The given map is : "+map);
		
		
		printKey(map  );
		
	}

	private static void insert(int i, String string , Map<Integer , String> map) {
		 map.put(i , string);
		
	}

	private static void printKey(HashMap<Integer, String> map ) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the String to be search in the map : ");
		String value = sc.nextLine();
		 
		for(Entry<Integer, String> m : map.entrySet())
			if(m.getValue().equals(value))
				System.out.println("The key of the given value is : "+m.getKey());
		}

}
