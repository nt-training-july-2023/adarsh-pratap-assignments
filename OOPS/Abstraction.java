package OOPS;

abstract class abst1{

    public int a = 12;


    void run(){
        System.out.println("Running in the abstract classs");

    }

    abstract void breaking();
}


public class Abstraction extends abst1{


    void breaking(){
        System.out.println("Applying breaks!!");
    }

    public static void main(String[] args) {
        
        abst1 abstraction = new Abstraction();
        abstraction.run();
        abstraction.breaking();
        System.out.println(abstraction.a);
    }
    
}
