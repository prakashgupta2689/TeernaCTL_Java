package recursion;

public class LastIndexOfOccurance {

    public static void main(String[] args) {

        int[] arr = new int[]{2,3,6,9,8,3,2,6,2,4};
        int lastIndex = lastIndexOfOccurance(arr,0,9);
        System.out.println(lastIndex);
    }

    private static int lastIndexOfOccurance(int[] arr, int i, int target) {
        if(i == arr.length)
            return -1;

        int lastIndexip1 = lastIndexOfOccurance(arr,i+1,target);
        if(arr[i] == target && lastIndexip1 == -1)
            return i;
        else
            return lastIndexip1;
    }
}
