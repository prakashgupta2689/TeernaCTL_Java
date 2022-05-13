package misc.binarySearch;

/**
 * Given an array and it is not known that it is sorted in ascending order or sorted in descending order
 * You need to find the index of the element
 * */
public class OrderNotKnownSearch {

    public static void main(String[] args) {

        //int[] arr = new int[]{1, 2, 4, 6, 8, 10, 15, 19};
        int[] arr = new int[]{19, 15, 10, 8, 6, 4, 2, 1};
        int element = 4;

        int index = agnosticSearch(arr, element);
        System.out.println(index);
    }

    private static int agnosticSearch(int[] arr, int element) {

        if(arr[0] > arr[1])
            return descendingSearch(arr, element);

        return ascendingSearch(arr, element);
    }

    private static int ascendingSearch(int[] arr, int element) {

        int start = 0;
        int end = arr.length - 1;

        while(start <= end){

            int mid = start + (end - start)/2;

            if(element == arr[mid])
                return mid;

            else if(element < arr[mid])
                end = mid - 1;

            else
                start = mid + 1;
        }
        return -1;
    }

    private static int descendingSearch(int[] arr, int element) {

        int start = 0;
        int end = arr.length - 1;

        while(start <= end){

            int mid = start + (end - start)/2;

            if(element == arr[mid])
                return mid;

            else if(element < arr[mid])
                start = mid + 1;

            else
                end = mid - 1;
        }
        return -1;
    }
}
