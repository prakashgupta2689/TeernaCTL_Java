package misc.binarySearch;

public class CeilOfAnElementInSortedArray {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 8, 10, 10, 12, 19};
        int element = 13;

        int ceil = findCeil(arr, element);
        System.out.println(ceil);
    }

    private static int findCeil(int[] arr, int element) {

        int start = 0;
        int end = arr.length - 1;
        int res = Integer.MAX_VALUE;

        while(start <= end){

            int mid = start + (end - start)/2;

            if(arr[mid] == element)
                return element;
            else if(element < arr[mid]){
                end = mid - 1;
                res = Math.min(res, arr[mid]);
            }else{
                start = mid + 1;
            }
        }
        return res;
    }
}
