package misc.dp.unboundedKnapsack;

/**
 * coins array diya hua hai, sum diya hua hau. Apne ko nikalne hai ki minimum number of coins jissey sum 5 aa jaye
 * arr[] = {1, 2, 3}, sum = 5
 * 1111
 * 1112
 * 113
 * 122
 * 23
 * inme se minimum number of coins jissey 5 aa jaye is 23 i.e. 2 coins (ek 2 ka coin and ek 3 ka coin chahiye)
 * coins = {} and sum = 1, minimum number of coin batao jissey sum 1 aa jaye. coin toh empty hai.
 * Mathematically, apne ko infinite coins chahiye. Infinite ko represent karne ke liye INT_MAX - 1 se represent karenge
 * coins = {} and sum = 0, number of minimum coins to have sum 0 is 0.
 * */
public class CoinChangeMinimumNumberOfCoins {

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 3};
        int sum = 5;

        int minCoins = findMinimumNumberOfCoins(coins, sum, coins.length);
        System.out.println(minCoins);
    }


    private static int findMinimumNumberOfCoins(int[] coins, int sum, int length) {

        if(sum == 0)
            return 0;

        if(length == 0)
            return Integer.MAX_VALUE-1;

        if(coins[length-1] <= sum){

            //+1 kiya hai kyuki including the coin toh count ek badh gayi
            return Math.min(1 + findMinimumNumberOfCoins(coins, sum - coins[length-1], length), findMinimumNumberOfCoins(coins, sum, length-1));
        }else{

            return findMinimumNumberOfCoins(coins, sum, length-1);
        }
    }
}
