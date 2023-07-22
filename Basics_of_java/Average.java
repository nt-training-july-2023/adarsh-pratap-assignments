public class Average {
    public static void main(String[] args) {
        int array[]  = {23,43,54,65,67,78,22,88,100,22};

        int size = array.length;

        float ans = findTheAverage(array , size);
        
        System.out.println( "Average of the array is : " + ans);
    }

    private static float findTheAverage(int[] array, int size) {
        
        int sum = 0;

        for(int i : array){
            sum += i;
        }
        
        float  ans = (float)sum/size;
        

        return ans;
    }
}
