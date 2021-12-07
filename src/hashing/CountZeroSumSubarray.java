package hashing;

import java.util.HashMap;

public class CountZeroSumSubarray {

    /**
     *
     1. You are given an array(arr) of integers.
     2. You have to find the count of all subarrays with sum 0.
     * */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 8, -3, -5, 2, -4, 6, 1, 2, 1, -3, 4, -1, -3};

        countZeroSumSubarray(arr);
    }

    private static void countZeroSumSubarray(int[] arr) {

        HashMap<Integer, Integer> sumFreq = new HashMap<>();
        int sum = 0;
        sumFreq.put(sum, 1);
        int countSubarray = 0;

        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
            if(sumFreq.containsKey(sum)){
                countSubarray+= sumFreq.get(sum);
                sumFreq.put(sum, sumFreq.get(sum)+1);
            }else{
                sumFreq.put(sum, 1);
            }
        }
        System.out.println(countSubarray);
    }
}
