package hashing;

import java.util.HashMap;

public class LongestConsecutiveSequence {

    /**
     * consecutive sequences
     * 1,2,3
     * 5,6
     * 8,9,10,11,12
     * 15
     * longest sequence: 8,9,10,11,12
     * */
    public static void main(String[] args) {

        int[] arr = new int[]{10,5,9,1,11,8,6,15,3,12,2};
        longestConsecutiveSubsequence(arr);
    }

    private static void longestConsecutiveSubsequence(int[] arr) {

        HashMap<Integer, Boolean> map = new HashMap<>();
        for(int i: arr){
            map.put(i, true);
        }

        for(int i : arr){
            if(map.containsKey(i-1)){
                map.put(i, false);
            }
        }

        int maxLevel = 0;
        int maxStartPoint = 0;
        for(int i : arr){
            if(map.get(i)){
                int startPoint = i;
                int level = 1;
                while(map.containsKey(i+level)){
                    level++;
                }
                if(maxLevel < level){
                    maxLevel = level;
                    maxStartPoint = startPoint;
                }
            }
        }

        for(int i = 0; i < maxLevel; i++){
            System.out.print(maxStartPoint + i + " ");
        }
    }
}
