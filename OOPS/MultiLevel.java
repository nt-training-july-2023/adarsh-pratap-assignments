package OOPS;

class Class1{

    public void printFirstName(){
        System.out.println("Adarsh");
    }

}

class Class2 extends Class1{

    public void printMiddleName(){
        System.out.println("Singh");
    }
}

public class MultiLevel extends Class2 {

    public void printLastName(){
        System.out.println("Parihar");
    }

    public static void main(String[] args) {
        MultiLevel multiLevel = new MultiLevel();

        multiLevel.printFirstName();
        multiLevel.printMiddleName();
        multiLevel.printLastName();
    }
    
}
