package MapQuestions;

import java.util.HashMap;
import java.util.Map.Entry;

public class PrintKeyAndValue {

	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1 , "Adarsh");
		map.put(2, "Ashutosh");
		map.put(3, "Sachin");
		
		print(map);

	}

	private static void print(HashMap<Integer, String> map) {
		
		for(Entry<Integer , String> m : map.entrySet())
			System.out.println(m.getKey()+" -> "+m.getValue());
		
	}

}
