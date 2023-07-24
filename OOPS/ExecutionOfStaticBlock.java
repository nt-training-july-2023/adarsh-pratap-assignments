package OOPS;

/**
 * The Static block is generally used 
 * when we need to define/asssign the 
 * values of variables when the class
 * is being called (at the very first 
 * execution of the class)
 */

public class ExecutionOfStaticBlock {
    static{
        System.out.println("Iam First Static Block !!");
    }

    static{
        System.out.println("Iam Second Static Block !!");
    }
    
    static{
        System.out.println("Iam Third Static Block !!");
    }

    public static void main(String[] args) {
        
        ExecutionOfStaticBlock executionOfStaticBlock;

    }
    
}
