package recursion;

public class FirstIndexOfOccurance {

    public static void main(String[] args) {

        int[] arr = new int[]{2,3,6,9,8,3,2,6,2,4};
         int firstIndex = firstIndexOfArray(arr,0,3);
        System.out.println(firstIndex);
    }

    private static int firstIndexOfArray(int[] arr, int i, int target) {
        if(i == arr.length)
            return -1;

        int firstIndexip1 = firstIndexOfArray(arr,i+1,target);
        if(arr[i] == target)
            return i;
        else
            return firstIndexip1;
    }
}
