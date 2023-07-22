import java.util.Scanner;

public class QuadraticEquation {

    public static void main(String[] args) {
        

         Scanner sc = new Scanner(System.in);

        System.out.print("Enter a  : " );

        int a = sc.nextInt();

        System.out.println();

        System.out.print("Enter b : ");

        int b = sc.nextInt();

         System.out.println();

        System.out.print("Enter c : ");

        int c = sc.nextInt();

        double d = (b*b) - (4*a*c);

        double r1 = (-b + Math.sqrt(d)) / (2.0 * a);  
        
        double r2 = (-b - Math.sqrt(d))  / (2.0 * a);  

        System.out.println("Roots are : "+ r1 + " " + r2);
    }
    
}
