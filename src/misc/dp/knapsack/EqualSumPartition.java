package misc.dp.knapsack;

/**
 * kya ye array do subsets mein divide ho sakta hai jaise ki dono subsets ka sum barabar ho
 * agar total array ka sum odd hai toh equal subsets possible hi nhi hai.
 * agar sum even hai toh hi equal subsets possible hai
 *
 * logic is: agar array ka sum is x and subset of x/2 is present then the remaining x - x/2 will also be present.
 * hence, if we use subset sum to fine if x/2 is present then return true as answer
 * */
public class EqualSumPartition {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 11, 5};

        int sum = 0;
        boolean isPartitionPossible = false;

        for(int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
        }

        if(sum % 2 == 0) {
            isPartitionPossible = checkEqualSumPartition(arr, arr.length-1, sum/2);
        }
        System.out.println(isPartitionPossible);
    }

    private static boolean checkEqualSumPartition(int[] arr, int length, int sum) {

        if(sum == 0)
            return true;

        if(length == 0)
            return false;

        if(arr[length] <= sum){
            return checkEqualSumPartition(arr, length-1, sum - arr[length]) || (checkEqualSumPartition(arr, length-1, sum));
        }else{

            return checkEqualSumPartition(arr, length-1, sum);
        }
    }
}
