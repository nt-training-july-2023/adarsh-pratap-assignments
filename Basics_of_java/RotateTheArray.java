import java.util.Scanner;

public class RotateTheArray {

    public static void main(String[] args) {
        
        int array[]  = {23,43,54,65,67,78,22,88,100,22};

        int size = array.length;

        System.out.print("Enter how many times you want to rotate the array : ");

        Scanner sc = new Scanner(System.in);

        int numberOfRotation = sc.nextInt();

        array = RotateArrayOmtimized(array , size , numberOfRotation);


        for(int i : array)
            System.out.print(i + " ");
    }

    //Complexity O(n2)
    private static int[] RotateArray(int[] array, int size , int numberOfRotation) {

        while(numberOfRotation > 0){
            
            int temp = array[0];

            for(int i = 1 ; i < size ; i++){
                int innertemp = array[i];

                array[i] = temp;

                temp = innertemp;
            }

            array[0] = temp;

            
            numberOfRotation--;

        }
        return array;
    }


    //Complexity is O(N)
    public static int[] RotateArrayOmtimized(int array[] , int size , int numberOfRotation){
        
        int[] array1 = new int[numberOfRotation];

        int[] array2 = new int[size-numberOfRotation];

        for(int i = 0 ; i < size-numberOfRotation ; i++){
            array2[i] = array[i];
        }

        for(int i = size-numberOfRotation; i < size ; i++){
            array1[(i-(size-numberOfRotation))] = array[i];

            // System.out.println("index:" + i  + " " + (i-(size-numberOfRotation)));
        }

        
        for(int i = 0 ; i  < array1.length ; i++){
            array[i] = array1[i];
        }

        for(int i = 0 ; i < array2.length ; i++){
            array[array1.length+i] = array2[i];
        }

        
        return array;
    }
    
}
