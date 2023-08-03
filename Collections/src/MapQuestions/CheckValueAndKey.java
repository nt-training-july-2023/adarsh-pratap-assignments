package MapQuestions;

import java.util.HashMap;

public class CheckValueAndKey {

	public static void main(String[] args) {
		
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		
		map.put(1 , "Adarsh");
		map.put(2, "Ashutosh");
		map.put(3, "Sachin");
		
		System.out.println("Given key is present ? : " + map.containsKey(2));
		System.out.println("Given value is present ? : " + map.containsValue("Adarsh"));

	}

}
