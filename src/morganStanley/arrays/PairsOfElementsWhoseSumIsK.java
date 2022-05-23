package morganStanley.arrays;

/**
 * Given an array of N integers, and an integer K,
 * find the number of pairs of elements in the array whose sum is equal to K.
 * */
public class PairsOfElementsWhoseSumIsK {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 7, 1};
        int k = 6;

        int pairs = pairsOfElementsOfSumK(arr, k);
        System.out.println(pairs);

        //int pairCount = pairsOfElementsOfSumKOptimal(arr, k);

}

//    private static int pairsOfElementsOfSumKOptimal(int[] arr, int k) {
//
//
//    }

    private static int pairsOfElementsOfSumK(int[] arr, int k) {

        //count of pairs
        int count = 0;

        for(int i  = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                if(k - arr[i] == arr[j])
                    count++;
            }
        }
        return count;
    }
}
