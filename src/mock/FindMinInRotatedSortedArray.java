package mock;

public class FindMinInRotatedSortedArray {

    public static void main(String[] args) {

        int[] arr = new int[]{10, 20, 30, 40, 50, 5, 7};

        int min =  findMin(arr);
        System.out.println(min);

        int minOpt = findMinOptimize(arr);
        System.out.println(minOpt);
    }

    private static int findMinOptimize(int[] arr) {

        int i = 0;
        int j = 1;

        while(j < arr.length){

            if(arr[i] > arr[j]){
                return arr[j];
            }
            i++;
            j++;
        }
        return 0;
    }

    private static int findMin(int[] arr) {

        //integer -> 36536
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){

            if(min > arr[i])
                min = arr[i];
        }
        return min;
    }
}
