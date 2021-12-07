package morganStanley.buySellStocks;

public class BuySellStocksWithInfTransactionsAndTransactionFee {

    /**
     * we are required to obtain the maximum profit from buying and selling stocks where each transaction involves a fee.In this problem,
     *
     * 1. You are given a number n, representing the number of days.
     * 2. You are given n numbers, where ith number represents price of stock on ith day.
     * 3. You are required to print the maximum profit you can make if you are allowed infinite transactions.
     * Note - There can be no overlapping transaction. One transaction needs to be closed (a buy followed by a sell) before opening another transaction (another buy)
     * */
    public static void main(String[] args) {

        int[] arr = new int[]{9, 11, 6, 7, 19, 4, 1, 6, 18, 4};
        int fee = 3;
        buySellStocksWithInfTransactionsAndTransactionFee(arr, fee);

    }

    private static void buySellStocksWithInfTransactionsAndTransactionFee(int[] arr, int fee) {

        int oldBoughtState = -arr[0];
        int oldSoldState = 0;

        for(int i = 1; i < arr.length; i++){

            int newBoughtState = 0;
            int newSoldState = 0;

            //agar purani bought state se nayi bought state behtar hai toh newBoughtState = purani sold state - current share price
            if(oldSoldState - arr[i] > oldBoughtState){ //comparing negatives. kam negative is zyada lol
                newBoughtState = oldSoldState - arr[i];
            }else{
                newBoughtState = oldBoughtState;
            }

            //agar oldBoughtState par current share sell karke zyada profit ho rha hai toh nayiSold state = current share - purani bought state + fee
            if(arr[i] + oldBoughtState - fee > oldSoldState){ //again yaad rakho ki boughtState negative mein hai
                newSoldState = arr[i] + oldBoughtState - fee;
            }else{
                newSoldState = oldSoldState;
            }

            oldBoughtState = newBoughtState;
            oldSoldState = newSoldState;
        }
        System.out.println(oldSoldState);
    }
}
