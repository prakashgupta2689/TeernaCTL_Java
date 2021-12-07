package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CountDistinctElementsInWindowOfSizeK {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 5, 6, 3, 2, 3, 2, 4, 5, 2, 2, 2, 2, 3, 6};
        int k = 4;

        countDistinctElementsInWindowsOfSizeK(arr, k);
    }

    private static void countDistinctElementsInWindowsOfSizeK(int[] arr, int k) {
        //put the first k elements in the map and print the number of distinct elements in it
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        ArrayList<Integer> distinctElements = new ArrayList<>();
        int j = -1;

        for(int i = 0; i < k; i++){
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0)+1);
        }

        System.out.println(freqMap.size());

        distinctElements.add(freqMap.size());

        //for k to the array length, acquire one element, add it to the map and release one element, remove
        //it from the map

        for(int i = k; i< arr.length; i++){
            //release element
            j++;
            if(freqMap.get(arr[j]) == 1) {
                //if the freq of the element is 1 then remove the element from the map
                freqMap.remove(arr[j]);
            }else if(freqMap.get(arr[j]) > 1){
                //if the frequency of the element is greater than 1 then just do -1 to that element's frequency
                freqMap.put(arr[j], freqMap.get(arr[j]) - 1);
            }

            //acquire element
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0)+1);

            //add the size to the arrayList
            distinctElements.add(freqMap.size());
        }

        for (Integer element: distinctElements){
            System.out.print(element + " ");
        }
    }
}
