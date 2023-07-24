package OOPS;

public class Overriding {

    void print(){
        System.out.println("This is a Parent class");
    }
    public static void main(String[] args) {

        ChildClass childClass = new ChildClass();

        childClass.print();

        Overriding overriding = new Overriding();
        
        overriding.print();
        
    }
}
class ChildClass extends Overriding{

    @Override
    void print(){
        System.out.println("This is a child class ");
    }
}
