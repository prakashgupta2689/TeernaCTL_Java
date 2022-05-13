package misc.dp.knapsack;

/**
 * kitne aise subsets hai ek array mein jiska sum equal to sum = x hai
 * */
public class CountOfSubsetSum {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 5, 6, 8, 10};
        int sum = 10;

        int numOfSubsets = countSubsets(arr, sum, arr.length);
        System.out.println(numOfSubsets);


    }

    private static int countSubsets(int[] arr, int sum, int length) {

        if(sum == 0)
            return 1;

        if(length == 0)
            return 0;

        //number of subsets including the element + number of subsets excluding the element
        if(arr[length-1] <= sum){

            return countSubsets(arr, sum - arr[length-1], length-1) + countSubsets(arr, sum, length-1);

        }else{
            return countSubsets(arr, sum, length-1);
        }
    }
}
