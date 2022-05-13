package misc.dp.LCS;

/**
 * merge two strings and form the shortest common string in such a way that all the characters of both the strings are present in the common string
 * Ex: s1 = geek
 * s2 = eke
 * res = geekeke or geeke -> the 2nd one is the shortest supersequence
 * the order should be maintained
 *
 * 1. find the length of the LCS of the two strings (this gives the common string)
 * 2. find the length of the remaining strings of s1 and s2 and add to the length of the LCS
 * how to do it ? s1 + s2 - LCS = length of the shortest common supersequence
 * */
public class ShortestCommonSupersequence {

    public static void main(String[] args) {

        String s1 = "geek";
        String s2 = "eke";

        int shortestSupersequenceLength = lengthOfShortestSupersequence(s1, s2);
        System.out.println(shortestSupersequenceLength);

    }

    private static int lengthOfShortestSupersequence(String s1, String s2) {

        int lcsLength = lengthOfCommonSubsequence(s1, s2, s1.length(), s2.length());

        return s1.length() + s2.length() - lcsLength;
    }

    private static int lengthOfCommonSubsequence(String s1, String s2, int length1, int length2) {

        if(length1 == 0 || length2 == 0)
            return 0;

        if(s1.charAt(length1-1) == s2.charAt(length2-1))
            return 1 + lengthOfCommonSubsequence(s1, s2, length1-1, length2-1);

        return Math.max(lengthOfCommonSubsequence(s1, s2, length1-1, length2), lengthOfCommonSubsequence(s1, s2, length1, length2-1));
    }
}
