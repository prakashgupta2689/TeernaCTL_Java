package misc.dp.knapsack;

/**
 * knapsack pattern:
 * ek array diya hoga, ek maximum value diya hoga, nikalna hoga possible hai ya nhi hai ya kaunse elements ko milake possible hai.
 * har ek element ke paas choice hoga ana hai ya nhi
 * */
public class ZeroOneKnapsackRec {

    public static void main(String[] args) {

        int[] profits = new int[]{60, 100, 120};
        int[] wts = new int[]{10, 20, 30};
        int W = 50;

        int maxProfit = knapsack(profits, wts, W, profits.length-1);
        System.out.println(maxProfit);
    }

    private static int knapsack(int[] profits, int[] wts, int w, int length) {

        //base condition
        if(length == 0 || w == 0)
            return 0;

        //choice diagram -> max of (included and excluded) if wts[i] < W else excluded

        if(wts[length] <= w){
            return Math.max(profits[length] + knapsack(profits, wts, w-wts[length], length-1), knapsack(profits, wts, w, length-1));
        }else
            return knapsack(profits, wts, w, length-1);
    }
}
