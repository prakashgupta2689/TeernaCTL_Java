package microsoft.dp.knapsackType.countOfSubsetSum;

public class CountOfSubsetSumMemoization {

    static int[][] dp = new int[6][11];
    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 5, 8, 10};
        int sum = 10;

        //dp initialization
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }

        int count = countOfSubsetSumMemoized(arr, sum, arr.length);
        System.out.println("count: "+ count);

    }

    private static int countOfSubsetSumMemoized(int[] arr, int sum, int n) {

        if(n == 0 && sum == 0)
            return 1;

        if(n == 0)
            return 0;

        if(sum == 0)
            return 1;

        if(dp[n][sum] != -1)
            return dp[n][sum];

        if(arr[n-1] <= sum){

            dp[n][sum] = countOfSubsetSumMemoized(arr, sum-arr[n-1], n-1) +
                    countOfSubsetSumMemoized(arr, sum, n-1);
            return dp[n][sum];
        }
        dp[n][sum] = countOfSubsetSumMemoized(arr, sum, n-1);
        return dp[n][sum];
    }
}
