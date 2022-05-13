package misc.binarySearch;

public class FindAnElementInARotatedSortedArray {

    public static void main(String[] args) {

        int[] arr = new int[]{11, 12, 15, 27, 45, 66, 8};
        int element = 12;

        int index = findElement(arr, element);
        System.out.println(index);
    }

    private static int findElement(int[] arr, int element) {

        int indexOfMinElement = findMinElementIndex(arr);

        if(element == arr[indexOfMinElement])
            return indexOfMinElement;

        //find the element in the left half of the min element
        int indexLeft = findElementIdx(arr, element, 0, indexOfMinElement-1);
        //find element in the right half of the min element
        int indexRight = findElementIdx(arr, element, indexOfMinElement+1, arr.length-1);

        return (indexLeft == -1)? indexRight: indexLeft;
    }

    private static int findElementIdx(int[] arr, int element, int startIdx, int endIdx) {

        int start = startIdx;
        int end = endIdx;

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

    private static int findMinElementIndex(int[] arr) {

        int start = 0;
        int end = arr.length - 1;
        int len = arr.length;

        while(start <= end){

            int mid = start + (end - start)/len;
            int prev = (mid + len - 1)%len;
            int next = (mid + 1)%len;

            if(arr[mid] <= arr[prev] && arr[mid] <= arr[next])
                return mid;
            else if(arr[mid] <= arr[end])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }
}
