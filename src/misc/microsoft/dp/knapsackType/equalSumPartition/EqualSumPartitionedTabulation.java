package misc.microsoft.dp.knapsackType.equalSumPartition;

public class EqualSumPartitionedTabulation {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 11, 5};

        boolean canItEquallyPartitioned = canItBeEquallyPartitioned(arr);
        System.out.println("can it be equally partitioned? "+ canItEquallyPartitioned);
    }

    private static boolean canItBeEquallyPartitioned(int[] arr) {

        //calculate sum
        int sum = 0;
        int n=arr.length;
        for (int k : arr) {
            sum += k;
        }
        boolean[][] dp=new boolean[arr.length+1][(sum/2)+1];
        if(sum%2!=0)
        {
            return false;
        }
        else
        {
            for(int i=0;i<dp.length;i++) {
            for(int j=0;j<dp[0].length;j++) {
                if(i==0 && j==0)
                {
                    dp[i][j]=true;
                }
                else if(j==0)
                {
                    dp[i][j]=true;
                }
                else if(i==0)
                {
                    dp[i][j]=false;
                }
                else if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                }
                else
                {
                    dp[i][j]=dp[i-1][j];
                }
            }
            }
        }
        return dp[n][sum/2];
    }
}
