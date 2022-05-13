package misc.dp.knapsack;

/**
 * Humko har element ke agey choice hai ki +/- assign kare in such a way that sum = given x aa jaye
 * aise itne combinations ke count return karne hai
 *
 * Logic:
 * saare +ve ko ek saath karo and saare -ve ko ek saath karo. This problems then reduces to s1-s2 = diff. This diff is sum in this question
 * */
public class TargetSum {

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 3};
        int reqSum = 1;

        int sum = 0;

        for (int j : arr) {

            sum = sum + j;
        }

        int target = (reqSum + sum)/2;

        int count = targetSubsetSum(arr, target, arr.length);
        System.out.println(count);
    }

    private static int targetSubsetSum(int[] arr, int target, int length) {

        if(target == 0)
            return 1;

        if(length == 0)
            return 0;

        if(arr[length-1] <= target){
            return targetSubsetSum(arr, target-arr[length-1], length-1) + targetSubsetSum(arr, target, length-1);
        }else{
            return targetSubsetSum(arr, target, length-1);
        }
    }
}
