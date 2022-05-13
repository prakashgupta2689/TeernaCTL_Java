package misc.binarySearch;

/**
 * nearly sorted means that an element which is supposed to be in the ith position can
 * either be in i-1 position, ith position or i+1th position
 * */
public class SearchInANearlySortedArray {

    public static void main(String[] args) {

        int[] arr = new int[]{5, 10, 30, 20, 40};
        int element = 10;

        int index = findElementInNearlySortedArray(arr, element);
        System.out.println(index);

    }

    private static int findElementInNearlySortedArray(int[] arr, int element) {

        int start = 0;
        int end = arr.length-1;

        while(start <= end){

            int mid = start + (end - start)/2;

            if(arr[mid] == element)
                return mid;
            else if((mid-1) >= start && arr[mid - 1] == element)
                return mid - 1;
            else if((mid + 1) <= end && arr[mid + 1] == element)
                return mid + 1;
            else if((mid - 2 ) >= start && element <= arr[mid - 2])
                end = mid - 2;
            else if((mid + 2) <= end && element >= arr[mid + 2])
                start = mid + 2;
        }
        return -1;
    }
}
