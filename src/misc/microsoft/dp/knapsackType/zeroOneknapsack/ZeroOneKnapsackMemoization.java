package misc.microsoft.dp.knapsackType.zeroOneknapsack;

public class ZeroOneKnapsackMemoization {

    static int[][] dp = new int[6][8];

    public static void main(String[] args) {

        int[] weights = new int[]{2, 5, 1, 3, 4};
        int[] profits = new int[]{15, 14, 10, 45, 30};
        int w = 7;

        for(int i = 0; i <= weights.length; i++){
            for(int j = 0; j <= w; j++){
                dp[i][j] = -1;
            }
        }

        int maxProfit = findMaxProfitMemoized(weights, profits, weights.length, w);
        System.out.println("max profit: "+ maxProfit);
    }

    private static int findMaxProfitMemoized(int[] weights, int[] profits, int n, int w) {

        if(n == 0 || w == 0)
            return 0;

        //the dp array already contains the profit,
        // don't make any recursive calls and return the value in the array
        if(dp[n][w] != -1){
            return dp[n][w];
        }

        if(w >= weights[n-1]){
            dp[n][w] = Math.max( profits[n-1] + findMaxProfitMemoized(weights, profits, n-1, w-weights[n-1]),
                    findMaxProfitMemoized(weights, profits, n-1, w));

            return dp[n][w];
        }

        dp[n][w] = findMaxProfitMemoized(weights, profits, n-1, w);
        return dp[n][w];
    }
}
