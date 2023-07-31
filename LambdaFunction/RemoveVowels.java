package LambdaFunction;

import java.util.Scanner;

interface Test{
	String removeVowels(String st);
}

public class RemoveVowels {

	public static void main(String[] args) {
		
		System.out.print("Enter string to replace vowels with # : ");
		Scanner sc = new Scanner(System.in);
		String st = sc.next();
		
		
		st = st.toLowerCase();
		Test test = (s)->{
			for(int i = 0 ; i < s.length() ; i++) {
				
				if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i)=='o' || s.charAt(i) == 'u') {
					s = s.replace(s.charAt(i) , '#');
				}
			}
			return  s;
		};
		
		System.out.println(test.removeVowels(st));

	}

}
