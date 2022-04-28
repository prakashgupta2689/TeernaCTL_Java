package misc.morganStanley.arrays;

public class SortZerosOnesTwos {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 1, 2, 2, 0, 1, 2, 2, 1, 0, 1, 2, 0, 2, 1};
        sortZerosOnesTwos(arr);

        //print the result
        for(int i =0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

    private static void sortZerosOnesTwos(int[] arr) {
        /**
         * Idea is to divide the array into three parts
         * 0 - j-1 -> all 0s
         * j - i-1 -> all 1's
         * i - k-1 -> all unknowns
         * k-end -> all 2's
         * Initially, i = j = 0 and k = arr.length -1
         * Traverse i and if i is equal to 1, then do i++ but don't increase j as the region between 0 to
         * j-1 should be only 0s
         * Traverse i till it is less than or equal to k. If i == 2, swap with k and k--. You should not do
         * i++ because after swapping you don't know if the swapped value got at i is 0 or 1. But you should
         * do k-- because you are sure that the swapped value at k is 2.
         * Similarly, if you get a 0 at i, swap it with j and do j++ and i++. You should increment both because
         * you are sure that the swapped value which i got is 1 and the swapped value which j got is 0.
         * */
        int i = 0;
        int j = 0;
        int k = arr.length - 1;

        while(i <= k){

            if(arr[i] == 1){
                i++;
            }
            else if(arr[i] == 0){
                swap(arr, i, j);
                i++;
                j++;
            }
            else if(arr[i] == 2){
                swap(arr, i, k);
                k--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
