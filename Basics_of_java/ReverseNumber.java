public class ReverseNumber {

    public static void main(String[] args) {
        int n = 1234;

        int ans = Reverse(n);

        System.out.println("Reversed number is : " + ans);

    }

    private static int Reverse(int n) {

        int ans = 0 ;

        while(n>0){
            
            int rem = n%10;
            ans = ans*10 +rem;
            n = n/10;
        }

       
        return ans;
    }
    
}
