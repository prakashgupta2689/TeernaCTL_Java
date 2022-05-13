package misc.dp.LIS;


/**
 * . You are given a number n, representing the number of elements.
 * 2. You are given n numbers, representing the contents of array of length n.
 * 3. You are required to print the length of longest bitonic subsequence of array.
 * Note - Bitonic subsequences begin with elements in increasing order, followed by elements in decreasing order.
 * i.e. increasing then decreasing
 *
 * We will use the Longest Increasing Subsequence method -- left se right travel karke har ek element par khatam hone wala longest increasing subsequence nikalenge
 * fir right se left travel karenge and har ek point pe khatam hone wala longest increasing subsequence nikalenge. (matlab current element should be greater than the element to it's right)
 *
 * then we get -- har point par khatam hone wala LIS hai and har point par decrease hone wala LDS pada hai
 * add both of them - 1 and find the maximum sum for the array
 * */
public class LongestBitonicSubsequence {


}
