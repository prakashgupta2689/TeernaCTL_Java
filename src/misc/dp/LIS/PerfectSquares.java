package misc.dp.LIS;

/**
 * 1. You are given a number N.
 * 2. You have to find the minimum number of squares that sum to N.
 * 3. You can always represent a number as a sum of squares of other numbers.
 * For eg - In worst case N can be represented as (1*1) + (1*1) + (1*1)..... N times.
 *
 * Each cell says: iss number ko kitne minimum squares se represent kar sakte hai
 * 0 = 0
 * 1 = 1^2 = 1
 * 2 = 1^2 + 1^2  = 2
 *
 * Ex: 2 ko banane ke liye: 2 - 1^2 -> bacha 1 ^2. 1^2 1 se banta hai toh answer is 1^2 + 1^2 = 2
 * 3 ko banane ke liye 3 - 1^2 = 2 chahiye, 2 banane ke liye 2 lagta hai toh 1 + 2 = 3 squares lagega
 * 4 ko banane ke liye two options hai: 4 - 1^2 = 3 , 3 banane ke liye 3 squares chahiye.
 * second option 4 - 2^2 = 0 and 0 banane ke liye 0 squares chahiye. Toh 4 banane ke liye 1 square chahiye. Min = Min of(3, 1) = 3
 * Think of this at step problem. 4 se zero jane ke liye 4 se 1^2 ka step lo ya 2^2 ka step lo.
 * */
public class PerfectSquares {
}
