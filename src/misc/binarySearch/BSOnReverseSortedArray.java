package misc.binarySearch;

public class BSOnReverseSortedArray {

    public static void main(String[] args) {

        int[] arr = new int[]{20, 18, 17, 16, 12, 10, 8, 4, 3, 1};
        int element = 17;

        int index = searchElement(arr, element);
        System.out.println(index);
    }

    private static int searchElement(int[] arr, int element) {

        int start = 0;
        int end = arr.length - 1;

        while(start <= end){

            int mid = start + (end - start)/2;

            if(arr[mid] == element)
                return mid;

            else if(element < arr[mid])
                start = mid + 1;

            else
                end = mid - 1;
        }
        return -1;
    }
}
