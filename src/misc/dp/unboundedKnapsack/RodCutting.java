package misc.dp.unboundedKnapsack;

/**
 * ek rod de rakhi hai. Uss rod ki length de rakhi hai.
 * ek length ka array and price ka array de rakha hai. kitne length ki kitni price de rakhi hai
 * hume rod ko aise cut karna hai ki price maximum ho
 *
 * similar to knapsack problem. W => rod length, wt array => length array, price array => values array
 * baar baar same length wale rod ko repeat kar sakte hai. Toh repetitions possible hai. Hence, ye problem unbounded knapsack se similar hai
 * */
public class RodCutting {

    public static void main(String[] args) {

        int[] len = new int[]{1, 2, 3, 4};
        int[] prices = new int[]{5, 6, 7, 8};

        int length = 4;

        int profit = maxProfit(len, prices, length, len.length);
        System.out.println(profit);
    }

    private static int maxProfit(int[] len, int[] prices, int length, int size) {

        if(size == 0 || length == 0)
            return 0;

        if(len[size-1] <= length){

            return Math.max(prices[size-1] + maxProfit(len, prices, length - len[size-1], size), maxProfit(len, prices, length, size-1));
        }else{
            return maxProfit(len, prices, length, size-1);
        }
    }
}
