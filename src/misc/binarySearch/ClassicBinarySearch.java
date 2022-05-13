package misc.binarySearch;

/**
 * find the index of the given element in the array
 * */
public class ClassicBinarySearch {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int element = 8;

        int index = binarySearch(arr, element);
        System.out.println(index);
    }

    private static int binarySearch(int[] arr, int element) {

        int start = 0;
        int end = arr.length - 1;

        while(start <= end){

            int mid = start + (end - start)/2; //to avoid int overflow

            if(element == arr[mid])
                return mid;
            else if(element < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;

        }
        return -1;
    }
}
