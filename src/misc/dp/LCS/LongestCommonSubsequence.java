package misc.dp.LCS;

/**
 * humlogo ko last ka dekhna hai and then n-1 length wale array par recursive call karna hai
 * agar last ka equal hua toh 1 + dono array ka smaller length length -1 par call karna. (1 + kyu ? -> common character se length count ek badh jayega)
 * agar last match hua toh ek kar length - 1 and dusre ka length and vice versa par do calls karna
 * find the length of the longest common subsequence
 * */
public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String str1 = "abcdgh";
        String str2 = "abedfhr";

        int longestLength = findLengthOfLongestCommonSubsequence(str1, str2, str1.length(), str2.length());

        System.out.println(longestLength);

    }

    private static int findLengthOfLongestCommonSubsequence(String str1, String str2, int length1, int length2) {

        if(length1 == 0 || length2 == 0)
            return 0;

        if(str1.charAt(length1-1) == str2.charAt(length2-1))
            return 1 + findLengthOfLongestCommonSubsequence(str1, str2, length1-1, length2-1);
        else
            return Math.max(findLengthOfLongestCommonSubsequence(str1, str2, length1-1, length2), findLengthOfLongestCommonSubsequence(str1, str2, length1, length2-1));
    }
}
