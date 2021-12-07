package recursion;

public class AllIndicesInArray {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,6,8,9,3,2,6,2,4};
        int[] allIndices = allIndicesOfArray(arr,0,2,0);
        for (int i = 0; i < allIndices.length; i++){
            System.out.print(allIndices[i] + " ");
        }
    }

    /**
     * aagey jate time if target == arr[i] hai toh foundSoFar ki value badhate jao and jab end tak pahuch jao tab foundSoFar ki
     * length ki array banake send karo and wapas aate time agar target aur arr[i] equal hai toh uss
     * array mein i fill kar do.
     * */
    private static int[] allIndicesOfArray(int[] arr, int i, int target, int foundSoFar) {
        if(i == arr.length){
            return new int[foundSoFar];
        }
        if(arr[i] == target){
            foundSoFar++;
        }
        int[] allIndices = allIndicesOfArray(arr,i+1,target,foundSoFar);
        if(arr[i] == target){
            allIndices[--foundSoFar] = i;
        }
        return  allIndices;
    }
}
