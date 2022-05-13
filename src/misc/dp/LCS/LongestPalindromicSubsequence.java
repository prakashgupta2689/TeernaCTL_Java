package misc.dp.LCS;

/**
 * In LCS, we are given two strings
 * Here, we are given 1 string. We may be able to derive string b from string a
 * If we find the LCS between the string and the reverse of the string, we get the length of the longest palindromic subsequence
 * */
public class LongestPalindromicSubsequence {

    public static void main(String[] args) {

        String s1 = "agbcbh";

        int lengthOfLongestPalindromicSubsequence = lengthOfLongestPalindromicSubsequence(s1);
        System.out.println(lengthOfLongestPalindromicSubsequence);

    }

    private static int lengthOfLongestPalindromicSubsequence(String s1) {

        StringBuilder sb = new StringBuilder(s1);

        return lcsLength(s1, sb.reverse().toString(), s1.length(), s1.length());

    }

    private static int lcsLength(String s1, String s2, int length1, int length2) {

        if(length1 == 0 || length2 == 0)
            return 0;

        if(s1.charAt(length1-1) == s2.charAt(length2-1))
            return 1 + lcsLength(s1, s2, length1-1, length2-1);

        return Math.max(lcsLength(s1, s2, length1-1, length2), lcsLength(s1, s2, length1, length2-1));
    }
}
