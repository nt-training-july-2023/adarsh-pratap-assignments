package OOPS;

class Parent {

    public String name = "Adarsh";

    public String fullName(){
        return "Adarsh Singh Parihar";
    }


}

public class SingleInheritance extends Parent{

    public String companyName(){
        return "NucleusTeq";
    }

    public static void main(String[] args) {
        
        SingleInheritance singleInheritance = new SingleInheritance();
        System.out.println("We can use the Property of Parent class from child Object : " + singleInheritance.name);
        
        System.out.println("We can use the method  of Parent class from child Object : " + singleInheritance.fullName());
        
        System.out.println("Using child class method : " + singleInheritance.companyName());
    }
    
}


