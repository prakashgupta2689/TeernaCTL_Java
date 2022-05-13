package misc.dp.unboundedKnapsack;

/**
 * Multiple occurrences of same item allowed hai.
 * knapsack mein kya hota hai ? Humare paas choice hai ki ya toh item ko include kare ya na kare
 * ek baar ek item par choice kar liya toh dobara usko ghum kar nhi dekhte
 * Unbounded mein kya hota hai ? hum baar baar ek item par choice kar sakte hai (par sirf wahi item ko baar baar le sakte hai jisko humne ek baar select kar liya hai. Jis item ko nhi lete hai uss ko dobara nhi dekhte)
 * kyuki multiple occurrences of same item allowed hai
 * */
public class UnboundedKnapsack {

    public static void main(String[] args) {

        int[] profits = new int[]{60, 100, 120};
        int[] wts = new int[]{10, 20, 30};
        int W = 50;

        int profit = unboundedKnapsack(profits, wts, W, profits.length);
        System.out.println(profit);
    }

    private static int unboundedKnapsack(int[] profits, int[] wts, int w, int length) {

        //base case unbounded and 0/1 knapsack ka same hai
        if(w == 0 || length == 0)
            return 0;

        if(wts[length-1] <= w){
            //jisko ek baar select kar liya usko baar baar select kar sakte hai. that's why length ka parameter 1 se decrease nhi ho rha.
            //jisko exclude kar liya usko hamesha exclude karenge. Hence, length ghat gaya
            return Math.max(profits[length-1] + unboundedKnapsack(profits, wts, w - wts[length-1], length), unboundedKnapsack(profits, wts, w, length-1));
        }else{
            return  unboundedKnapsack(profits, wts, w, length-1);
        }
    }
}
