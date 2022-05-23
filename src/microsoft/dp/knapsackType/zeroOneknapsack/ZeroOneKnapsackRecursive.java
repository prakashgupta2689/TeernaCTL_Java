package microsoft.dp.knapsackType.zeroOneknapsack;

public class ZeroOneKnapsackRecursive {

    public static void main(String[] args) {

        int[] weights = new int[]{2, 5, 1, 3, 4};
        int[] profits = new int[]{15, 14, 10, 45, 30};
        int w = 7;

        int maxProfit = findMaxProfit(weights, profits, weights.length, w);
        System.out.println("max profit: "+ maxProfit);
    }


    private static int findMaxProfit(int[] weights, int[] profits, int n, int w) {

        if(n == 0 || w == 0)
            return 0;

        //if w > weights[n] -> you can either choose to include the element or not.
        //if you include the element, add it's corresponding profit
        //the max of (included, not included will give the result
        if(w >= weights[n-1]){
            return Math.max(profits[n-1] + findMaxProfit(weights, profits, n-1, w-weights[n-1]),
                    findMaxProfit(weights,profits, n-1, w));

        }//if w < weights[n] -> don't include the element
        return findMaxProfit(weights, profits, n-1, w);
    }
}
