package MapQuestions;

import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CrudOperationOnMap {

	public static void main(String[] args) {
		
		//Operations on hash map 
		Map<Integer , String > hashmap = new HashMap<>(); //no ordering is present 
		
		add(1, "Adarsh" , hashmap); //Adding the key value pair on Hash Map 
		add(2 , "Sachin" , hashmap);
		
		remove(2,hashmap); //removing the key 2 pair 
		
		update(hashmap); //updating the hashmap
		
		get( 1 , hashmap); //Getting the value By its key
		
		
		//Operations on Tree Map
		
		Map<Integer , String > treemap = new TreeMap<>(); //sorted by key
		
		add(2 , "Sachin" , treemap);
		add(1, "Adarsh" , treemap); //Adding the key value pair on Tree Map 
		
		
		remove(2,treemap); //removing the key 2 pair 
		
		update(treemap); //updating the TreeMap
		
		get( 1 , treemap); //Getting the value By its key
		
		//Operations on Linked Map
		
		Map<Integer , String > linkedmap = new LinkedHashMap<>(); //insertion order is preserved
		
		add(2 , "Sachin" , linkedmap);
		add(1, "Adarsh" , linkedmap); //Adding the key value pair on linked Map 
		
		
		remove(2,linkedmap); //removing the key 2 pair 
		
		update(linkedmap); //updating the linkedmap
		
		get( 1 , linkedmap); //Getting the value By its key
		
		
		
	}

	private static void get( int i , Map<Integer, String> map) {
		if(map.containsKey(i))
			System.out.println("Value of given key is : " + map.get(i));
		else
			System.out.println("Not present!!");
	}

	private static void remove(int i, Map<Integer, String> map) {
		map.remove(i);
		System.out.println("After removing pair of value "+i+" : " + map);
		
	}

	private static void add(int i, String string, Map<Integer, String> map) {
		map.put(i, string);
		System.out.println("Pairs of map are : " + map);
		
	}

	private static void update(Map<Integer, String> map) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the key to be updated : ");
		int key = sc.nextInt();
		
		sc.nextLine();
		System.out.println("Enter the value to be updated regarding to the key :" );
		String value = sc.nextLine();
		
		if(map.containsKey(key))
			map.put(key, value);
		else
			System.out.println("Given key is not present!!! ");
		
		System.out.println("HashMap After updation : " + map);
	}

}
