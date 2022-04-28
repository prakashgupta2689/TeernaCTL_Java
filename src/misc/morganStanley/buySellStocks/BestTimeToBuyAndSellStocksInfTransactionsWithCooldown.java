package misc.morganStanley.buySellStocks;

public class BestTimeToBuyAndSellStocksInfTransactionsWithCooldown {

    /**
     * we are required to find the maximum profit which can be obtained from buying and selling stocks with infinite transactions but with a cool down period between 2 transactions. In this problem,
     *
     * 1. You are given a number n, representing the number of days.
     * 2. You are given n numbers, where ith number represents price of stock on ith day.
     * 3. You are required to print the maximum profit you can make if you are allowed infinite transactions, but have to cooldown for 1 day after 1 transaction
     * i.e. you cannot buy on the next day after you sell, you have to cooldown for a day at-least before buying again.
     * Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy).
     * */
    public static void main(String[] args) {

        int[] arr = new int[]{9, 11, 6, 7, 19, 4, 1, 6, 18, 4};
        int cooldown = 1;
        bestTimeToBuyAndSellStocksWithCooldownAndInfTransactions(arr,cooldown);
    }

    private static void bestTimeToBuyAndSellStocksWithCooldownAndInfTransactions(int[] arr, int cooldown) {

        int oldBoughtState = - arr[0];
        int oldSoldState = 0;
        int oldCoolState = 0;

        for(int i = 1; i < arr.length; i++){

            int newBoughtState = 0;
            int newSoldState = 0;
            int newCoolState = 0;

            if(oldCoolState - arr[i] > oldBoughtState){
                newBoughtState = oldCoolState - arr[i];
            }else{
                newBoughtState = oldBoughtState;
            }

            if(arr[i] + oldBoughtState > oldSoldState){
                newSoldState = arr[i] + oldBoughtState;
            }else{
                newSoldState = oldSoldState;
            }

            if(oldSoldState > oldCoolState){
                newCoolState = oldSoldState;
            }else{
                newCoolState = oldCoolState;
            }

            oldBoughtState = newBoughtState;
            oldSoldState = newSoldState;
            oldCoolState = newCoolState;
        }

        System.out.println(oldSoldState);
    }
}
