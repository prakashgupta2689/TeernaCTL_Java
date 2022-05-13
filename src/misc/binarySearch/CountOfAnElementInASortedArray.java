package misc.binarySearch;

public class CountOfAnElementInASortedArray {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 4, 10, 10, 10, 19, 20};
        int element = 10;

        int countOfElement = countElement(arr, element, 0, arr.length - 1);
        System.out.println(countOfElement);

        //alternate way-- iterative approach -> indexOfLastOccurrence - indexOfFirstOccurrence + 1
    }

    private static int countElement(int[] arr, int element, int start, int end) {

        if(start > end)
            return 0;

        int mid = start + (end - start)/2;
        int count = 0;

        if(element == arr[mid])
            count++;

        //count + left part's count + right part's count
        return count + countElement(arr, element, start, mid - 1) + countElement(arr, element, mid + 1, end);

    }
}
