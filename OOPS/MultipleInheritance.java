package OOPS;

interface inter1{
    void run();
}

interface inter2{
    void applyBreak();
}


public class MultipleInheritance implements inter1 , inter2{
    
    public static void main(String[] args) {

        MultipleInheritance multipleInheritance = new MultipleInheritance();
        multipleInheritance.applyBreak();
        multipleInheritance.run();
        
    }

    @Override
    public void applyBreak() {
        // TODO Auto-generated method stub
        System.out.println("Appling Break !!");
    }

    @Override
    public void run() {
        
        System.out.println("Running !!");
    }
}
