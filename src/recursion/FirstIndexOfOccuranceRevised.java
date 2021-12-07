package recursion;

public class FirstIndexOfOccuranceRevised {
    public static void main(String[] args) {

        int[] arr = new int[]{2,3,6,9,8,3,2,6,2,4};
        int firstIndex = firstIndexOfArray(arr,0,3);
        System.out.println(firstIndex);
    }

    private static int firstIndexOfArray(int[] arr, int i, int target) {
        if(i == arr.length)
            return -1;

        if(arr[i] == target)
            return i;
        else {
            int firstIndexip1 = firstIndexOfArray(arr, i + 1, target);
            return firstIndexip1;
        }
    }
}
