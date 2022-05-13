package misc.dp.LCS;

/**
 * humko ek string diya hua hai. Uss string mein minimum number of deletions karke usko palindrome banana hai
 * 1. hum kya kar sakte hai ? we can find the longest palindromic subsequence
 * 2. uss palindromic subsequence ke length ko string ke length se subtract kar diya toh minimum deletions mil jayega
 * think about it for a second. Agar length of Palindromic subsequence max hoga tabhi deletions min milega
 *
 * number of deletions is also equal to number of insertions to make a string to a palindrome.
 * */
public class MinimumNumberOfDeletionsToMakePalindrome {

    public static void main(String[] args) {

        String s1 = "agbcbc";

        int minimumDeletions = minimumNumberOfDeletions(s1);
        System.out.println(minimumDeletions);
    }

    private static int minimumNumberOfDeletions(String s1) {

        return s1.length() - lengthOfPalindromicSubsequence(s1);
    }

    private static int lengthOfPalindromicSubsequence(String s1) {

        StringBuilder sb = new StringBuilder(s1);

        return lcsLength(s1, sb.reverse().toString(), s1.length(), s1.length());
    }

    private static int lcsLength(String s1, String s2, int length1, int length2) {

        if(length1 == 0 || length2 == 0)
            return 0;

        if(s1.charAt(length1-1) == s2.charAt(length2-1))
            return 1 + lcsLength(s1, s2, length1 - 1, length2 - 1);

        return Math.max(lcsLength(s1, s2, length1-1, length2), lcsLength(s1, s2, length1, length2-1));
    }
}
