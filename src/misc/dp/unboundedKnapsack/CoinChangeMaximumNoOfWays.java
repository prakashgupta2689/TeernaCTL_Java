package misc.dp.unboundedKnapsack;

/**
 * coin ka array diya hua hai. sum diya hua hai.
 * Iss coin ka use karke humko chahiye sum = 5
 * Kitne tareeke ho sakte hai ki iss array ko use karke 5 mile
 * knapsack kyu hai ? --> apne paas har ek coin ko lene ka ya nhi lene ka choice hai
 * apne paas coins unlimited hai --> unbounded knapsack
 * similar to count subset sum --> kitne tareeke ho sakte hai ki sum x mile from a given array
 * */
public class CoinChangeMaximumNoOfWays {

    public static void main(String[] args) {

        int[] coins = new int[]{1, 2, 3}; //122, 113, 32, 11111, 1112
        int sum = 5;

        int noOfCombinationsPossible = coinChangeCombinations(coins, sum, coins.length);
        System.out.println(noOfCombinationsPossible);

    }

    private static int coinChangeCombinations(int[] coins, int sum, int length) {

        if(sum == 0)
            return 1;

        if(length == 0)
            return 0;

        if(coins[length-1] <= sum){

            return coinChangeCombinations(coins, sum - coins[length-1], length) + coinChangeCombinations(coins, sum, length-1);
        }else{
            return coinChangeCombinations(coins, sum, length-1);
        }
    }
}
