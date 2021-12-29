package microsoft.dp.knapsackType.equalSumPartition;

public class EqualSumPartitionMemoization {

    static int[][] dp = new int[5][12];

    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 11, 5};

        boolean canItBeEquallyPartitioned = canItBeEquallyPartitionedMemoization(arr);
        System.out.println("can it be equally partitioned? "+ canItBeEquallyPartitioned);
    }

    private static boolean canItBeEquallyPartitionedMemoization(int[] arr) {

        int sum = 0;
        //find the array sum
        for (int i : arr) {
            sum = sum + i;
        }

        if(sum % 2 != 0)
            return false;

        //initialization of dp array

        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        int existSubset = checkSubsetSum(arr, sum/2, arr.length);

        return existSubset == 1;
    }

    private static int checkSubsetSum(int[] arr, int sum, int n) {
        if(sum == 0 && n == 0)
            return 1;

        if(sum == 0)
            return 1;

        if(n == 0)
            return 0;

        if(dp[n][sum] != -1)
            return dp[n][sum];

        if(arr[n-1] <= sum){

            int ifIncluded = checkSubsetSum(arr, sum-arr[n-1], n-1);
            int ifExcluded = checkSubsetSum(arr, sum, n-1);

            return (ifIncluded == 1)? ifIncluded : ifExcluded;
        }

        return checkSubsetSum(arr, sum, n-1);
    }
}
