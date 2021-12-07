package hashing;

import java.util.HashMap;

public class GetCommonElement {

    public static void main(String[] args) {

        int[] arr1 = new int[]{1,1,2,3,2,5,4,8};
        int[] arr2 = new int[]{1,3,5,2,6,7};

        getCommonElement(arr1, arr2);
    }

    private static void getCommonElement(int[] arr1, int[] arr2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr1.length; i++){
            if(!map.containsKey(arr1[i])){
                map.put(arr1[i],1);
            }
        }

        for(int i = 0; i < arr2.length; i++){
            if(map.containsKey(arr2[i])){
                System.out.print(arr2[i] + " ");
            }
        }
    }

}
