import java.util.Scanner;

public class SumOfN {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many numbers you want to add : ");

        int n = sc.nextInt();

        int sum = 0 ; 

        for(int i = 0 ; i  < n ; i++){

            System.out.print("Enter number : ");

            int number = sc.nextInt(); 

            sum += number;
        }
        System.out.print("Sum is : " + sum);
    }
    
}
