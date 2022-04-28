package misc.microsoft.dp.knapsackType.subsetSum;

public class SubsetSumMemoization {

    static int[][] dp = new int[6][12];

    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 7, 8, 10};
        int sum = 11;

        //initialize dp array
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 12; j++){
                dp[i][j] = -1;
            }
        }

        int isSubsetSum = checkSubsetSumMemoization(arr, sum, arr.length);
        System.out.println(isSubsetSum != 0);
    }

    private static int checkSubsetSumMemoization(int[] arr, int sum, int n) {

        if(n == 0 && sum == 0)
            return 1;

        if(n == 0)
            return 0;

        if(sum == 0)
            return 1;

        if(dp[n][sum] != -1)
            return dp[n][sum];

        if(arr[n-1] <= sum){

            int ifIncluded = checkSubsetSumMemoization(arr, sum-arr[n-1], n-1);
            int ifExcluded = checkSubsetSumMemoization(arr, sum, n-1);

            return ((ifIncluded == 1) ? ifIncluded : ifExcluded);
        }
        //if arr[n-1] > sum, there is no choice but to exclude it
        return checkSubsetSumMemoization(arr, sum, n-1);
    }
}
