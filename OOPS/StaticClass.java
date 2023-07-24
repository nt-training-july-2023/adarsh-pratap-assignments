package OOPS;

/**
 * We can use private data members of
 * outer class in static Inner Class 
 * but only static members because 
 * InnerClass is also static .
 * 
 * 
 */

public class StaticClass {

    private static int a = 10;


    static class InnerOne{

        void print(){
            System.out.println("Private outer class field value is : " + a);
        }

    }

    public static void main(String[] args) {
        
        StaticClass.InnerOne one  = new StaticClass.InnerOne();

        one.print();
    }
    
}
