package morganStanley.buySellStocks;

public class BestTimeToBuyAndSellStocksOneTransactionAllowed {

    /**
     * we are required to buy and sell stock with only one transaction such that maximum profit is obtained from the transaction. In this problem,
     *
     * 1. You are given a number n, representing the number of days.
     * 2. You are given n numbers, where ith number represents price of stock on ith day.
     * 3. You are required to print the maximum profit you can make if you are allowed a single transaction.
     *
     * Har day par ye calculate karna hai ki aaj sell karu toh maximum kitna fayada hoga
     * Iss din sell karu toh maximum fayada tab hoga jab issey pehle least price par khareeda jata.
     * For every potential selling day, maximum fayada tab hoga jab tumne issey pehle least price par khareeda hota
     * selling price hamesha zyada honi chahiye buying price se profit kamane ke liye
     *
     * Calculate profit if sold today with the minimum buying partner. Jiska profit if sold today maximum hai
     * wahi answer hai.
     * */
    public static void main(String[] args) {

        int[] arr = new int[]{9, 11, 6, 7, 19, 4, 1, 6, 18, 4};

        bestTimeToBuyAndSellStocks(arr);

    }

    private static void bestTimeToBuyAndSellStocks(int[] arr) {

        int profitIfSoldToday = 0;
        int leastBuy = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < leastBuy){
                leastBuy = arr[i];
            }

            profitIfSoldToday = arr[i] - leastBuy;
            if(maxProfit < profitIfSoldToday){
                maxProfit = profitIfSoldToday;
            }
        }

        System.out.println(maxProfit);
    }
}
