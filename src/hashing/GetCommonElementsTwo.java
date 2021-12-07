package hashing;

import java.util.HashMap;

/**
 * arr1 = {1,1,2,2,2,3,5}
 * arr2 = {1,1,1,2,2,4,5}
 * result -> {1,1,2,2,5}
 * */
public class GetCommonElementsTwo {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1,1,2,2,2,3,3,5};
        int[] arr2 = new int[]{1,1,1,2,2,4,4,3};

        getCommonElementsTwo(arr1, arr2);
    }

    private static void getCommonElementsTwo(int[] arr1, int[] arr2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr1.length; i++){
            if(map.containsKey(arr1[i])){
                int freq = map.get(arr1[i])+1;
                map.put(arr1[i],freq);
            }else{
                map.put(arr1[i], 1);
            }
        }

        for(int i = 0; i < arr2.length; i++){
            if(map.containsKey(arr2[i])){
                System.out.print(arr2[i] + " ");
                int freq = map.get(arr2[i]) - 1;
                if(freq > 0) {
                    map.put(arr2[i], freq);
                }else{
                    map.remove(arr2[i]);
                }
            }
        }
        System.out.println(map);
    }
}
