package hashing;

import java.util.HashSet;

public class LengthOfLargestSubarrayWithContiguousElements {

    /**
     * 1. You are given an array(arr) of integers. Values may be duplicated.
     * 2. You have to find the length of the largest subarray with contiguous elements.
     * Note - The contiguous elements can be in any order(not necessarily in increasing order).
     * */

    public static void main(String[] args) {

        int[] arr = new int[]{9, 2, 7, 5, 6, 22, 24, 22, 23, 19, 17, 16, 18, 39, 0};

        lengthOfLargestSubarrayWithContiguousElements(arr);
    }

    private static void lengthOfLargestSubarrayWithContiguousElements(int[] arr) {

        int maxLength = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){

            int max = arr[i];
            int min = arr[i];
            HashSet<Integer> set = new HashSet<>();
            set.add(arr[i]);

            for(int j = i; j < arr.length; j++){
                if(!set.contains(arr[j])) {
                    set.add(arr[j]);
                    max = Math.max(max, arr[j]);
                    min = Math.min(min, arr[j]);

                    if ((max - min) == (j - i)) {
                        int length = j - i + 1;
                        if (maxLength < length) {
                            maxLength = length;
                        }
                    }
                }else{
                    break;
                }
            }
        }
    }
}
