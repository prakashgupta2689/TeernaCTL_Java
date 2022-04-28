package misc.morganStanley.buySellStocks;

public class BestTimeToBuyAndSellStocksInfiniteTransactions {

    /**
     * we are required to find the maximum amount which can be obtained from selling stocks at different prices in infinite transactions. In this problem,
     *
     * 1. You are given a number n, representing the number of days.
     * 2. You are given n numbers, where ith number represents price of stock on ith day.
     * 3. You are required to print the maximum profit you can make if you are allowed infinite transactions.
     * Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy)
     * i.e. you cannot do BBSS (Buy-Buy-Sell-Sell). You need to sell one transaction before buying another
     *
     * Jitni baar lagatar upar jaa rha hai tab tak collect karna hai.
     * Buy is always at a dip and sell is always before a dip
     * jab dip ati hai toh collect the profit
     * jab tak dip ati rehti hai buy and sell dono move karte hai. jab increment ata hai tab sell move karta hai
     * */
    public static void main(String[] args) {

        int[] arr = new int[]{9, 11, 6, 7, 19, 4, 1, 6, 18, 4};
        bestTimeToBuyAndSellStocksWithInfiniteTransactions(arr);

    }

    private static void bestTimeToBuyAndSellStocksWithInfiniteTransactions(int[] arr) {

        int buyingDate = 0;
        int sellDate = 0;
        int profit = 0;

        for(int i = 1; i < arr.length; i++){

            if(arr[i] > arr[i-1]){
                sellDate++;
            }else{
                //collect profit
                profit = profit + arr[sellDate] - arr[buyingDate];
                //move the buying date and selling date to the dip
                buyingDate = i;
                sellDate = i;
            }
        }

        // at the end if the sell date ends in a high than buying date add that profit as well
        if(arr[sellDate] > arr[buyingDate]) {
            profit += arr[sellDate] - arr[buyingDate];
        }
            System.out.println(profit);
        }
    }

