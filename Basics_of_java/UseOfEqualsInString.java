public class UseOfEqualsInString {

    public static void main(String[] args) {
        

        String str = "Adarsh";

        String str1 = "Adarsh";

        String str2 = new String("Adarsh");

        // str2 = "Adarsh";

        System.out.println("compare with == string making without new : " + (str == str1) );

        System.out.println("compare with == string making with new  and one without new : " + (str == str2) );

        System.out.println("When comparing the same variables with eqalsTo method : " + (str.equals(str2)));

    }
    
}
