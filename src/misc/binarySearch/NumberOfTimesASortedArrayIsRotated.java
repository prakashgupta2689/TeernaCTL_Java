package misc.binarySearch;

/**
 * number of times array is rotated = index of the minimum element
 * so, we need to find the index of the minimum element
 * smallest element will be smaller than both of it's neighbours
 * after finding the mid index, compare with it's start and end to determine which side to go
 * compare the mid element with the start element and the end element. Find out which section is unsorted.
 * The minimum element will lie in the unsorted section
 * if start < mid -> sorted
 * if mid < end -> sorted
 * */
public class NumberOfTimesASortedArrayIsRotated {

    public static void main(String[] args) {

        int[] arr = new int[]{11, 12, 15, 18, 1, 5, 6, 8};

        int numberOfTimesRotated = findNumberOfTimesRotated(arr);
        System.out.println(numberOfTimesRotated);
    }

    private static int findNumberOfTimesRotated(int[] arr) {

        int start = 0;
        int end = arr.length - 1;
        int len = arr.length;

        //array is sorted
        if(arr[start] < arr[end])
            return 0;

        while(start <= end){

            int mid = start + (end - start)/2;
            int prev = (mid + len - 1)%len;
            int next = (mid + 1)%len;

            if(arr[mid] <= arr[next] && arr[mid] <= arr[prev])
                return mid;

            else if(arr[mid] <= arr[end])
                end = mid - 1;

            else
                start = mid + 1;

        }
        return -1;
    }
}
