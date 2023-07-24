package OOPS;

abstract class Adarsh{
    abstract void work();
}


public class AnonymousClass {

    public static void main(String[] args) {
        
        Adarsh ada = new Adarsh() {

            @Override
            void work() {
                
                System.out.println("Working at NucleusTeq as a Software Engineer !!");
            }
            
        };

        ada.work();

    }
    
}
