public class StringMethods {

    public static void main(String[] args) {
        

        String str = "Adarsh";
        
        System.out.println("Length od the given String is : " + str.length());

        str =  str.concat("Singh");

        System.out.println("Concat a String : " + str);


        System.out.println("Get a character from 4th position :" + str.charAt(4));

        System.out.println("Check String starts with given string : " + str.startsWith("Ada"));

        System.out.println("Get the index of perticular char or substring : " + str.indexOf("Ada"));
        
        str = str.replace("Singh", "Parihar");

        System.out.println("Replace a char from the String : " + str );

    }
    
}
