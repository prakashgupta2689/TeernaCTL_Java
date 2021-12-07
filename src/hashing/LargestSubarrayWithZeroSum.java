package hashing;

import java.util.HashMap;

public class LargestSubarrayWithZeroSum {
    /**
     * 1. You are given an array(arr) of integers.
     * 2. You have to find the length of the largest subarray with sum 0.
     * */
    public static void main(String[] args) {

        int[] arr = new int[]{2, 8, -3, -5, 2, -4, 6, 1, 2, 1, -3, 4};
        largestSubarrayWithZeroSum(arr);
    }

    private static void largestSubarrayWithZeroSum(int[] arr) {
        int maxLength = Integer.MIN_VALUE;
        HashMap<Integer, Integer> sums = new HashMap<>();
        int sum = 0;
        sums.put(sum, -1);

        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
            if(sums.containsKey(sum)){
                int length = i - sums.get(sum);
                if(maxLength < length){
                    maxLength = length;
                }
            }else{
                sums.put(sum, i);
            }
        }
        System.out.println(maxLength);
    }
}
