package misc.dp.LCS;

/**
 * substring is continuous, subsequence is not continuous
 * we need to find out the length of longest common substring
 * */
public class LongestCommonSubstring {

    public static void main(String[] args) {

        String s1 = "abcde";
        String s2 = "abcdef";

        int lengthOfLongestCommonSubstring = longestCommonSubstringLength(s1, s2, s1.length()-1, s2.length()-1, 0);
        System.out.println(lengthOfLongestCommonSubstring);

    }

    private static int longestCommonSubstringLength(String s1, String s2, int length1, int length2, int count) {

        if(length1 == -1 || length2 == -1)
            return count;

        if(s1.charAt(length1) == s2.charAt(length2)){

            count  = longestCommonSubstringLength(s1, s2, length1-1, length2-1, count+1);
        }
        count = Math.max(count, Math.max(longestCommonSubstringLength(s1, s2, length1-1, length2, 0), longestCommonSubstringLength(s1, s2, length1, length2-1, 0)));
        return count;
    }
}
