public class AdditionOfMatrix {

    public static void main(String[] args) {
        int arr1[][] = {{1,2,3},
                        {4,5,6},
                        {7,8,9}};

        int arr2[][] = {{1,2,3},
                        {4,5,6},
                        {7,8,9}};

         AddTwoMatrix(arr1 , arr2);

        

        }

    private static void AddTwoMatrix(int[][] arr1, int[][] arr2) {

        for (int i = 0 ; i < arr1.length ; i++){
            
            for(int j = 0 ; j < arr1[0].length ; j++){

                arr1[i][j] += arr2[i][j];
                System.out.print(arr1[i][j]+" ");
            }
            System.out.println();
        }

        
    }
    }
    

