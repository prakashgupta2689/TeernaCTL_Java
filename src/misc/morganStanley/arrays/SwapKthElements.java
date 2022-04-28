package misc.morganStanley.arrays;

public class SwapKthElements {

    /**
     * Given an array ‘ARR’ of size ‘N,’ swap the Kth element from beginning with the Kth element from the end.
     * */
    public static void main(String[] args) {

        int[] arr = new int[]{4, 3, -2, 6, -14, 7, -1, 4, 5, 7, -10, 2, 9, -10, -5, -9, 6};
        int k = 2;
        int[] swappedArr = swap(arr, k);

        for(Integer i: swappedArr){
            System.out.print(i + " ");
        }

    }

    private static int[] swap(int[] arr, int k) {

        int length = arr.length;
        int temp = arr[k-1];
        arr[k-1] = arr[length - k];
        arr[length - k] = temp;

        return arr;
    }
}
