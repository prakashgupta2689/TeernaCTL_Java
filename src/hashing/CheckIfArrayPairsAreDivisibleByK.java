package hashing;

import java.util.HashMap;
import java.util.Map;

public class CheckIfArrayPairsAreDivisibleByK {
    /**
     *
     1. You are given an array(arr) of integers and a number K.
     2. You have to find if the given array can be divided into pairs such that the sum of every pair is divisible by k.
     * */
    public static void main(String[] args) {
        int[] arr = new int[]{56, 22, 34, 12, 78, 11, 98, 69, 20, 30};
        boolean result = checkIfPairDivisibleByK(arr, 10);
        System.out.println(result);

    }

    private static Boolean checkIfPairDivisibleByK(int[] arr, int k) {
        //hash map to store the remainders and the frequency of the remainders
        HashMap<Integer, Integer> remFreq = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int rem = arr[i] % k;
            remFreq.put(rem,remFreq.getOrDefault(rem,0)+1);
        }

        for(Map.Entry<Integer, Integer> entry: remFreq.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        for(Integer rem: remFreq.keySet()){
            if(rem == 0){
                if(remFreq.get(rem) % 2 != 0) {
                    return false;
                }
            }
            if(rem % 2 == 0){
                if(remFreq.get(rem) % 2 != 0){
                    return false;
                }else{
                    return true;
                }
            }else if(!remFreq.get(rem).equals(remFreq.get(k - rem))){
                return false;
            }

        }
        return true;
    }
}
