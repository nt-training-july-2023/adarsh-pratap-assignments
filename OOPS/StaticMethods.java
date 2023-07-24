package OOPS;

/**
 * static methods are generally 
 * used to create the utility class
 * like Math class in java we can use 
 * methods of Math.class directly by calling them 
 * without making its object (like : Math.min())
 * 
 * It is also used where we dont want to make the object of 
 * class to use some methods 
 */

public class StaticMethods {

    public static int add(int a , int b ){
        return a+b;
    }


    public static void main(String[] args) {
        System.out.println(StaticMethods.add(10, 10));
    }
    
}
