public class MoreStringMethods {

    public static void main(String[] args) {
        
        String name ="Adarsh";

        System.out.println("isEmpty() function : " + name.isEmpty());

        System.out.println("Convert to Upper Case : " + name.toUpperCase());

        System.out.println("Compare string ignore case : " + name.equalsIgnoreCase("adarsh"));

        System.out.println("subString()  : " + name.substring(3, 5));

        System.out.println("contains Function : " + name.contains("rsh"));
    }
    
}
