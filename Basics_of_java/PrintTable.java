import java.util.Scanner;

public class PrintTable {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number : ");

        int number =  sc.nextInt();

        for(int i = 1 ; i < 11  ; i++){
            System.out.print(i*number+" ");
        }
    }
    
}
