package OOPS;

public class Polymorphism {

    //Overloading 
    int add(int a , int b){
        return a+b;

    }

    String add(String a , String b){
        return a.concat(b);
    }

    public static void main(String[] args) {

        Polymorphism polymorphism = new Polymorphism();

        System.out.println("Addition of Numbers : " + polymorphism.add(10 , 20));

        System.out.println("Addition of Strings : "+polymorphism.add("Adarsh " , "Singh"));
        
    }
    
}
