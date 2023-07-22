public class PrimitiveDataType {

    public static void main(String[] args) {
        
        int number = 10;
        
        float floatingNumber = 10.44f;
        
        double doubleNumber = 13.45666;

        char character = 'A';

        short shortNumber = 7454;

        byte byteType = 23; 

        System.out.println(number + " " + floatingNumber + "  " + doubleNumber + " " + character + " " + shortNumber + " " + byteType);

        //Converting int to float

        System.out.println("Converting int to float : " + (float)number);

        //Converting float to int 

        System.out.println("Converting float to int : " + (int)floatingNumber);

        //conveting float to double 

        System.out.println("Conveting float to double : " + (double)floatingNumber);



    }
    
}
