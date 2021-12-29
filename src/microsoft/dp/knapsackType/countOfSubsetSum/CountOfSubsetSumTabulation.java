package microsoft.dp.knapsackType.countOfSubsetSum;

public class CountOfSubsetSumTabulation {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 5, 8, 10};
        int sum = 10;

        int[][]dp = new int[6][11];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){

                if(i == 0 && j == 0)
                    dp[i][j] = 1;

               else if(i == 0)
                    dp[i][j] = 0;

                else if(j == 0)
                    dp[i][j] = 1;

                else if(arr[i-1] <= j)
                    dp[i][j] = dp[i-1][j - arr[i-1]] + dp[i-1][j];

                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        System.out.println("count of subset sum: "+ dp[arr.length][sum]);
    }
}
