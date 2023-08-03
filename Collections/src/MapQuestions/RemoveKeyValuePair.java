package MapQuestions;

import java.util.HashMap;

public class RemoveKeyValuePair {

	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1 , "Adarsh");
		map.put(2, "Ashutosh");
		map.put(3, "Sachin");
		
		if(map.containsKey(1)) //removing the key value pair from the map if key is present 
			map.remove(1);

	}

}
