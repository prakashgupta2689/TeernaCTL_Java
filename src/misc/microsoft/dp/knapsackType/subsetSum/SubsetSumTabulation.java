package misc.microsoft.dp.knapsackType.subsetSum;

public class SubsetSumTabulation {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 7, 8, 10};
        int sum = 11;

        boolean[][] dp = new boolean[arr.length+1][sum+1];

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){

                if(i == 0 && j == 0)
                    dp[i][j] = true;

                else if(i == 0)
                    dp[i][j] = false;

                else if(j == 0)
                    dp[i][j] = true;

                else if(arr[i-1] <= j){

                    dp[i][j] = dp[i-1][j - arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println("is subset sum: "+ dp[arr.length][sum]);
    }
}
