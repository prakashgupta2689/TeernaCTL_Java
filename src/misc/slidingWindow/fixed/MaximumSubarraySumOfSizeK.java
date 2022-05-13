package misc.slidingWindow.fixed;

/**
 * among all the subarrays of size 3, return the sub array sum with the maximum sum
 * window size is end - start + 1
 * represent the window with two pointers
 * find start and end at the beginning of your code according to the window size and maintain it throughout your code
 * when end - start + 1 == k, do your calculations(find max here) and find out the sub array sum till j < k
 * move the window jab tak end < array length
 * */
public class MaximumSubarraySumOfSizeK {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 5, 1, 8, 2, 9, 1};
        int K = 3;

        int maxSubarraySum = findMaxSubarraySum(arr, K);
        System.out.println(maxSubarraySum);
    }

    private static int findMaxSubarraySum(int[] arr, int k) {

        int start = 0;
        int end  = 0;

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;

        while(end < arr.length){

            sum = sum + arr[end];

            if(end - start + 1 < k){
                end++;
            }else if(end - start + 1 == k){

                //find the max sum, move the window and adjust the sum
                maxSum = Math.max(maxSum, sum);
                sum = sum - arr[start];
                start++;
                end++;


            }

        }
        return maxSum;
    }
}
