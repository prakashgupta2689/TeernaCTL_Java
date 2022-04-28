package misc.microsoft.dp.knapsackType.zeroOneknapsack;

public class ZeroOneKnapsackTabulation {

    static int[][] dp = new int[6][8];

    public static void main(String[] args) {
        int[] weights = new int[]{2, 5, 1, 3, 4};
        int[] profits = new int[]{15, 14, 10, 45, 30};
        int w = 7;

        int maxProfit = findMaxProfitTab(weights, profits, weights.length, w);
        System.out.println("max profit: "+ maxProfit);
    }

    private static int findMaxProfitTab(int[] weights, int[] profits, int n, int w) {

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){

                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }

                else if(j >= weights[i-1]){
                    dp[i][j] = Math.max(profits[i-1] + dp[i-1][j-weights[i-1]], dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][w];
    }
}
