package misc.dp.knapsack;

/**
 * Equal sum partition tha ki sum1  == sum2 i.e. sum1 -sum2 = 0 tha
 * yaha par abs(sum1 -sum2) minimum ana chahiye
 * range = 0 to total sum
 * s2 = total sum - s1.-> yeh minimum hona chahiye. Agar middle wala sum mil gaya toh total sum - middle wala sum minimum hoga
 * s2 - s1 = total sum - s1 -s1 = total sum - 2s1. Hence, This should be minimum. maximum element in the s1 subset will give the minimum value.
 * */
public class MinimumSubsetSumDifference {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 6, 11, 5};

    }
}
