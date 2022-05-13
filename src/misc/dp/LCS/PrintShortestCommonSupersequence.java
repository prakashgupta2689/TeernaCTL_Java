package misc.dp.LCS;

/**
 * 1. write the common character once
 * 2. write all the non common characters
 * */
public class PrintShortestCommonSupersequence {

    public static void main(String[] args) {

        String s1 = "abcde";
        String s2 = "abdef";

        int[][] res = new int[s1.length() + 1][s2.length() + 1];

        int lengthOfShortestCommonSupersequence = lengthOfShortesCommonSupersequence(s1, s2, res);
        System.out.println(lengthOfShortestCommonSupersequence);

        String supersequence = shortestSupersequence(s1, s2, res);
        System.out.println(supersequence);
    }

    private static String shortestSupersequence(String s1, String s2, int[][] res) {

        StringBuilder sb = new StringBuilder();
        int l = s1.length();
        int m = s2.length();

        while (l > 0 && m > 0) {

            if (s1.charAt(l - 1) == s2.charAt(m - 1)) {
                sb.append(s1.charAt(l - 1));
                l--;
                m--;
            } else {

                if (res[l - 1][m] < res[l][m - 1]) {
                    sb.append(s1.charAt(m-1));
                    m--;
                } else {
                    sb.append(s1.charAt(l-1));
                    l--;
                }
            }

        }

        //if s1 reaches it's end, put the remaining characters of s1 in the resultant string
        while(l > 0){

            sb.append(l-1);
            l--;
        }

        //if s2 reaches it's end, put the remaining characters of s2 in the resultant string
        while(m > 0){

            sb.append(m-1);
            m--;
        }

        return sb.reverse().toString();
    }

    private static int lengthOfShortesCommonSupersequence(String s1, String s2, int[][] res) {

        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 || j == 0) {
                    res[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    res[i][j] = 1 + res[i - 1][j - 1];
                } else {
                    res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
                }
            }

        }
        return s1.length() + s2.length() - res[res.length - 1][res[0].length - 1];
    }
}
