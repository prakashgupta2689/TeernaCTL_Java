package misc.morganStanley.dynamic;

public class ZeroOneKnapsack {

    public static void main(String[] args) {
        int target = 7;
        int[] weights = new int[]{2,5,1,3,4};
        int[] profits = new int[]{15, 14, 10, 45, 30};
        int[][] dp = new int[weights.length+1][target+1];
        int maxProfitForTargetWeight = findMaxProfitForTargetWeight(weights, profits, dp);
        System.out.println(maxProfitForTargetWeight);

    }

    private static int findMaxProfitForTargetWeight(int[] weights, int[] profits, int[][] dp) {

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){

                //first column and first row would be zero
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else{
                    if(weights[i-1] > j){
                        dp[i][j] = dp[i-1][j];
                    }else if(weights[i-1] < j){
                        dp[i][j] = Math.max(dp[i-1][j], profits[i-1]+dp[i-1][j - weights[i-1]]);
                    }
                }
            }
        }

        //printing the dp array
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println(" ");
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
