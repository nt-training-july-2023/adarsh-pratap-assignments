class LargestInArray{

    public static void main(String[] args) {
        int array[]  = {23,43,54,65,67,78,22,88,100,23};

        int size = array.length;

        int ans = findTheLargest(array , size);

        System.out.println("Largest Number in the array is : " + ans);
    }

    private static int findTheLargest(int[] array, int size) {

        int ans = array[0];
        for(int i = 1 ; i <  size ;  i ++){
            ans = Math.max(ans, array[i]);
        }

        return ans;
    }
}