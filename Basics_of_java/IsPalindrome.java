public class IsPalindrome {

    public static void main(String[] args) {
        
        int n =  1221;

        int reverse = Reverse(n);

        if(n == reverse)
            System.out.println("Yes the given number is Palindrome");
        
        else
            System.out.println("No the given number is not palindrome");

    }

    private static int Reverse(int n) {

        int reverse = 0;

        while (n>0){
            int rem = n%10;

            reverse = reverse*10+rem;

            n = n/10;
        }

        return reverse;

       
    }
    
}
