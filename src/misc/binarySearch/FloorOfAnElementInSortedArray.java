package misc.binarySearch;

/**
 * If an element is present in the array return the index of the element
 * If an element is not present in the array return the floor of the element in the array
 * It is hence, defined as the greatest element smaller than 5 in this example
 * */
public class FloorOfAnElementInSortedArray {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 8, 10, 10, 12, 19};
        int element = 5;

        int floor = findFloor(arr, element);
        System.out.println(floor);
    }

    private static int findFloor(int[] arr, int element) {

        int start = 0;
        int end = arr.length - 1;
        int res = Integer.MIN_VALUE;

        while(start <= end){

            int mid = start + (end - start)/2;
            if(arr[mid] == element)
                return arr[mid];
            else if(element < arr[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
                res = Math.max(res, arr[mid]);
            }
        }
        return res;
    }
}
