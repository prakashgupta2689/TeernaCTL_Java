package misc.dp;

/**
 * Make 20 A's by using minimum number of Copy and Paste Operations
 * 1 copy + 1 paste  = 2 operations
 * if n = 1, no of operations  = 0
 * if n = 2, CP -> A (c)(p) A = 2 encodings
 * if n = 3, CPP = 3 encodings
 * if n = 4, CPPP/CPCP
 * if n = 5, CPPPP = 5 encodings
 * is n is a prime number then it would have n encodings
 *
 * Observations: For prime numbers - 1 C and (n-1) P's
 * If you are diving suppose 4 by 2, then 2 repeated 2 times makes 4
 * Ex: 6 = 2*3 i.e. CP*CPP = CPCPPP
 * Find the number in terms of prime number multiples i.e. find the prime factors of a number
 * 6 = 2 + 3
 * 18 = 2*2*2*3*3 -> no. of encodings is 2 + 2 + 2 + 3 + 3
 *  */
public class TwoKeysKeyboard {
}
