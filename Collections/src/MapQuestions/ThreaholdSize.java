package MapQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ThreaholdSize {

	public static void main(String[] args) {
		
		int threshold;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the threshold size : " );
		 threshold = sc.nextInt();
		
		Map<Integer , Integer> square = new HashMap<>();
		
		insert(1 , 1 , square);
		insert(2, 4 ,square);
		insert(3 , 9 , square);
		insert(4, 16 , square);
		insert(5 , 25 ,square);
		insert(6, 36 ,square);
		
		printAndClear(threshold , square);
		System.out.println("size of map : " + square.size());
		
		
	}

	private static void insert(int i, int j, Map<Integer, Integer> square) {
		square.put(i , j);
	}

	private static void printAndClear(int threshold, Map<Integer, Integer> square) {
		
		for(Entry<Integer , Integer> m : square.entrySet())
			System.out.println(m.getKey() + " -> " + m.getValue());
		
		if(threshold <= square.size()) {
			System.out.println("Size of map exceed the threshold size ");
			square.clear();
		}
	}

}
