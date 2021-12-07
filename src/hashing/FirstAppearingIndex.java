package hashing;

import java.util.HashMap;


/**
 * Given an array arr[] of size n, find the first repeating element.
 * The element should occurs more than once and the index of its first occurrence should be the smallest.
 *Input:
 * n = 7
 * arr[] = {1, 5, 3, 4, 3, 5, 6}
 * Output: 2
 * Explanation:
 * 5 is appearing twice and
 * its first appearance is at index 2
 * which is less than 3 whose first
 * occurring index is 3.
 *
 * */
public class FirstAppearingIndex {
    // Function to return the position of the first repeating element.
    public static int firstRepeated(int[] arr, int n) {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int firstAppearingIndex = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            if(map.containsKey(arr[i])){
                if(firstAppearingIndex > map.get(arr[i])){
                    firstAppearingIndex = map.get(arr[i]);
                }
            }else{
                map.put(arr[i],(i+1));
            }
        }
        if(firstAppearingIndex != Integer.MAX_VALUE){
            return firstAppearingIndex;
        }
        return -1;
    }
}
