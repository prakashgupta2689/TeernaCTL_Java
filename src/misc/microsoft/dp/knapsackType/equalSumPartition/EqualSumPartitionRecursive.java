package misc.microsoft.dp.knapsackType.equalSumPartition;

//check if the array can be partitioned into two parts with each part having equal sum
public class EqualSumPartitionRecursive {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 11, 5};

        boolean canItBeEquallyPartitioned = canItBeEquallyPartitionedRecursive(arr);
        System.out.println("can it be equally partitioned: "+ canItBeEquallyPartitioned);
    }

    private static boolean canItBeEquallyPartitionedRecursive(int[] arr) {

        //find the arr sum
        int sum = 0;
        for (int i : arr) {
            sum = sum + i;
        }

        //if the array sum is odd, there is no way it can be equally partitioned, so return false
        if(sum % 2 != 0)
            return false;

        //if the array sum is even then you need to check if any subset exists with sum equal to sum/2.
        //if any subset exists with sum/2, then the remaining elements will obviously make another subset with sum/2
        return checkSubsetRecursive(arr, sum/2, arr.length);
    }

    private static boolean checkSubsetRecursive(int[] arr, int sum, int n) {

        if(sum == 0 && n == 0)
            return true;

        if(sum == 0)
            return true;

        if(n == 0)
            return false;

        if(arr[n-1] <= sum){
            return checkSubsetRecursive(arr, sum-arr[n-1], n-1) || checkSubsetRecursive(arr, sum, n-1);
        }
        return checkSubsetRecursive(arr, sum, n-1);
    }
}
