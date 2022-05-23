package morganStanley.arrays;

public class MaximumSumSubarray {

    /**
     * 1. You are given an array(arr) of integers.
     * 2. You have to find maximum subarray sum in the given array.
     * 3. The subarray must have at least one element.
     * */
    public static void main(String[] args) {

        int[] arr = new int[]{4, 3, -2, 6, -14, 7, -1, 4, 5, 7, -10, 2, 9, -10, -5, -9, 6, 1};

        maximumSumSubarray(arr);
    }

    private static void maximumSumSubarray(int[] arr) {

        int currentSum = arr[0];
        int bestSum = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(currentSum < 0){ //agar peeche se sum -ve aa rha hai toh arr[i] train mein shamil nhi hota hai
                currentSum = arr[i];
            }else { // agar peeche se sum +ve ata hai toh arr[i] usme shamil ho jata hai
                currentSum += arr[i];
            }
            if(currentSum > bestSum){
                bestSum = currentSum;
            }
        }
        System.out.println(bestSum);
    }
}
