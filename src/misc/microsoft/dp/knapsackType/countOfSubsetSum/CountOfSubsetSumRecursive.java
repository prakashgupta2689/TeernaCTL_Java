package misc.microsoft.dp.knapsackType.countOfSubsetSum;

public class CountOfSubsetSumRecursive {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 5, 8, 10};
        int sum = 10;

        int count = countSubsetSum(arr, sum, arr.length);
        System.out.println("count of subset sum: "+ count);
    }

    private static int countSubsetSum(int[] arr, int sum, int n) {

        if(n == 0 && sum == 0)
            return 1;

        if(n == 0)
            return 0;

        if(sum == 0)
            return 1;

        if(arr[n-1] <= sum){

            return countSubsetSum(arr, sum-arr[n-1], n-1) + countSubsetSum(arr, sum, n-1);
        }
        return countSubsetSum(arr, sum, n-1);
    }
}
