public class Factorial {

    public static void main(String[] args) {
        
        System.out.println("Factorial is : "+Factorial(5));
    }

    private static int  Factorial(int i) {
        
        if(i == 1) return 1;

        if(i==0) return 1;

        return i*Factorial(i-1);
    }
    
}
