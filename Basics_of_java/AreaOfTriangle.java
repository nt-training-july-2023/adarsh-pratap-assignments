import java.util.Scanner;

public class AreaOfTriangle {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the height of Triangle : " );

        int height = sc.nextInt();

        System.out.println();

        System.out.print("Enter the base of Triangle : ");

        int base = sc.nextInt();

        System.out.println();


        float area = (base*height)/2;

        System.out.println("Area of Triangle : " + area);


    }
    
}
