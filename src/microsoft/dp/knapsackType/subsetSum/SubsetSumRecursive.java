package microsoft.dp.knapsackType.subsetSum;

public class SubsetSumRecursive {

    //find whether a subset exists in the array such that it's sum is equal to the given sum
    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 7, 8, 10};
        int sum = 11;

        boolean isSubsetSum = checkSubset(arr, sum, arr.length);
        System.out.println("isSubsetSum: "+ isSubsetSum);
    }

    private static boolean checkSubset(int[] arr, int sum, int n) {

        if(sum == 0 && n == 0)
            return true;

        if(sum == 0)
            return true;

        if(n == 0)
            return false;

        if(arr[n-1] <= sum){

            //including it, does the previous elements subsets give the result true for the rem sum?
            //excluding it, does the previous elements give the sum ?

            return checkSubset(arr, sum-arr[n-1], n-1) || checkSubset(arr, sum, n-1);
        }

        //if arr[n-1] > sum -> there is no choice but to exclude it
        return checkSubset(arr, sum, n-1);
    }
}
