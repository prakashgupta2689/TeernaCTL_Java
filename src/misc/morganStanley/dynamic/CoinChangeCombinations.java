package misc.morganStanley.dynamic;

public class CoinChangeCombinations {

    public static void main(String[] args) {

        int target = 7;
        int[] arr = new int[]{2,3,5,6};
        int[] dp = new int[target + 1];

        int noOfCoinChangeCombinationsForTarget = findNoOfCoinChangeCombinationsForTarget(arr, dp, target);
    }

    private static int findNoOfCoinChangeCombinationsForTarget(int[] arr, int[] dp, int target) {

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < dp.length; j++){

                if(j == 0){//first cell one combination to get zero
                    dp[j] = 1;
                }else{//not first cell
                    if(arr[i] <= j){//if target is greater than the array element
                        dp[j] = dp[j] + dp[j - arr[i]];
                    }
                }
                //if target is less than the array element, do nothing
            }
        }
        //print the dp array
        for(int i = 0; i < dp.length; i++){
            System.out.print(dp[i] + " ");
        }
        System.out.println(" ");

        return dp[dp.length-1];
    }
}
