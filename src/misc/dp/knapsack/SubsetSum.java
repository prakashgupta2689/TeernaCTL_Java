package misc.dp.knapsack;

/**
 * kya iss array mein ek aisa subset present hai ki jiska sum 11 ho?
 * */
public class SubsetSum {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 7, 8, 10};
        int sum = 25;

        boolean isPresent = checkSubsetSum(arr, sum, arr.length-1);
        System.out.println(isPresent);
    }

    private static boolean checkSubsetSum(int[] arr, int sum, int length) {

        //base condition
        //if sum == 0, then there is always empty subset to make sum = 0. Hence, return true
        if(sum == 0)
            return true;

        //if empty array and sum is not zero, then there is no chance that subset of sum non zero would be present. Hence, return false
        if(length == 0)
            return false;

        //include or exclude the element. If you get true either by including or excluding then true

        if(arr[length] <= sum){
                    //include                                                   //exclude
            return checkSubsetSum(arr, sum-arr[length], length-1) || checkSubsetSum(arr, sum, length-1);

        }else{
            return checkSubsetSum(arr, sum, length-1);
        }

    }
}
