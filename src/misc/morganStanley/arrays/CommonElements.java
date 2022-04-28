package misc.morganStanley.arrays;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
 * Note: can you take care of the duplicates without using any additional Data Structure?
 *
 * Example 1:
 *
 * Input:
 * n1 = 6; misc.A = {1, 5, 10, 20, 40, 80}
 * n2 = 5; misc.B = {6, 7, 20, 80, 100}
 * n3 = 8; misc.C = {3, 4, 15, 20, 30, 70, 80, 120}
 * Output: 20 80
 * Explanation: 20 and 80 are the only
 * common elements in misc.A, misc.B and misc.C.
 *
 *
 * You don't need to read input or print anything. Your task is to complete the function commonElements() which take the 3 arrays misc.A[], misc.B[], misc.C[] and their respective sizes n1, n2 and n3 as inputs and returns an array containing the common element present in all the 3 arrays in sorted order.
 * If there are no such elements return an empty array. In this case the output will be printed as -1
 * */
public class CommonElements {

    public static void main(String[] args) {

        int[] arr1 = new int[]{1, 5, 10, 20, 40, 80, 100};
        int[] arr2 = new int[]{6, 7, 20, 80, 100};
        int[] arr3 = new int[]{3, 4, 15, 20, 30, 70, 80, 100, 120};

        ArrayList<Integer> res = findCommon(arr1, arr2, arr3);
        if(res.size() > 0)
            System.out.println(res);
        else
            System.out.println("-1");

        ArrayList<Integer> resWithoutExtraMemory = findCommonWithoutExtraMemory(arr1, arr2, arr3);
        if(resWithoutExtraMemory.size() > 0)
            System.out.println(resWithoutExtraMemory);
        else
            System.out.println("-1");
    }

    private static ArrayList<Integer> findCommonWithoutExtraMemory(int[] arr1, int[] arr2, int[] arr3) {

        ArrayList<Integer> result = new ArrayList<>();

        int i = 0;
        int j = 0;
        int k = 0;

        while(i < arr1.length && j < arr2.length && k < arr3.length){

            //idea is that: given all the arrays are sorted in ascending orders
            //if arr1[i] < arr2[j] && arr1[i] < arr3[j] -> we are sure that arr1[i] will not be present in arr2 and arr3.so, increment i
            if(arr1[i] == arr2[j] && arr1[i] == arr3[k]){
                result.add(arr1[i]);
                i++;
                continue;
            }
            if(arr1[i] > arr2[j]){
                j++;
            }
            if (arr1[i] > arr3[k]){
                k++;
            }else{
                i++;
            }
        }
        return result;
    }

    private static ArrayList<Integer> findCommon(int[] arr1, int[] arr2, int[] arr3) {
        //result array
        ArrayList<Integer> result = new ArrayList<>();

        //put arr2 in a hashmap
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int i = 0; i < arr2.length; i++){
            map2.put(arr2[i], map2.getOrDefault(arr2[i],0)+1);
        }

        //put arr3 in a hashmap
        HashMap<Integer, Integer> map3 = new HashMap<>();
        for(int i = 0; i < arr3.length; i++){
            map3.put(arr3[i], map3.getOrDefault(arr3[i], 0)+1);
        }

        //iterate through the first array and check if the others contain the elements
        for(int i = 0; i < arr1.length; i++){

            if(map2.containsKey(arr1[i]) && map3.containsKey(arr1[i])){
                result.add(arr1[i]);
            }
        }
        return result;
    }
}
