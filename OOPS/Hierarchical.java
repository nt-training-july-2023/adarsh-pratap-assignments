package OOPS;

class Parent121 {

    public void printParent(){
        System.out.println("Iam Parent Class");
    }

}

class Child121 extends Parent121 {
    void print(){
        System.out.println("Iam Child class 1");
    }

}

class Child212 extends Parent121 {

    void print(){
        System.out.println("Iam Child class 2");
    }
}

public class Hierarchical extends Parent{

    public static void main(String[] args) {

        Child121 child1 = new Child121();
        child1.printParent();
        child1.print();

        Child212 child2 = new Child212();
        child2.printParent();
        child2.print();
    }
    
}
