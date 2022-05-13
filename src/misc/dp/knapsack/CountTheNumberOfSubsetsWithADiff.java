package misc.dp.knapsack;

/**
 * Logic:
 * s1 - s2 = diff -(1)
 * s1 + s2 = sum - (2)
 * => 2s1 = diff + sum
 * => s1 = (diff + sum)/2 -> reduced to count subset sum problem
 * */
public class CountTheNumberOfSubsetsWithADiff {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 1, 2, 3};
        int diff = 1;

        int sum = 0;

        for (int j : arr) {
            sum = sum + j;
        }

        int target = (sum + diff)/2;

        int count = countNumberOfSubsets(arr, target, arr.length);
        System.out.println(count);
    }

    private static int countNumberOfSubsets(int[] arr, int target, int length) {

        if(target == 0)
            return 1;

        if(length == 0)
            return 0;

        if(arr[length-1] <= target){

            return countNumberOfSubsets(arr, target-arr[length-1], length-1) + countNumberOfSubsets(arr, target, length-1);
        }else{
            return countNumberOfSubsets(arr, target, length-1);
        }

    }
}
