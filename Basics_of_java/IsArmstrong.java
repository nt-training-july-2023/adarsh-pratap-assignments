public class IsArmstrong {

    public static void main(String[] args) {
        int number = 153;

        int size = sizeOfNumber(number);

        int duplicate = number;

        int armStrong = 0;

        while(number > 0){
            //System.out.println(number/10);
            armStrong += Math.pow(number%10, size);
            number = number/10;
        }

        System.out.println(armStrong == duplicate ); 
    }

    private static int sizeOfNumber(int number) {
        
        int  count =0;

        while(number > 0){

            count++;

            number = number/10;
        }
        return count;
    }
    
}
