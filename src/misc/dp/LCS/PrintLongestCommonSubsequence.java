package misc.dp.LCS;

/**
 * using dp
 * */
public class PrintLongestCommonSubsequence {

    public static void main(String[] args) {

        String s1 = "abcde";
        String s2 = "abdef";

        int[][] res = new int[s1.length()+1][s2.length()+1];

        int lengthOfLongestCommonSubsequence = lengthOfLongestCommonSubsequence(s1, s2, res);
        System.out.println(lengthOfLongestCommonSubsequence);

        String subsequence = longestSubsequence(s1, s2, res);
        System.out.println(subsequence);
    }

    private static String longestSubsequence(String s1, String s2, int[][] res) {

        StringBuilder sb = new StringBuilder();
        int l = s1.length();
        int m = s2.length();

        while(l > 0 && m > 0){

            if(s1.charAt(l-1) == s2.charAt(m-1)){
                sb.append(s1.charAt(l-1));
                l--;
                m--;
            }else{

                if(res[l-1][m] < res[l][m-1]){
                    m--;
                }else{
                    l--;
                }
            }

        }
        return sb.reverse().toString();
    }

    private static int lengthOfLongestCommonSubsequence(String s1, String s2, int[][] res) {

        for(int i = 0; i <= s1.length(); i++){
            for(int j = 0; j <= s2.length(); j++) {
                if(i == 0 || j == 0) {
                    res[i][j] = 0;
                }else if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    res[i][j] = 1 + res[i-1][j-1];
                }else{
                    res[i][j] = Math.max(res[i-1][j], res[i][j-1]);
                }
            }

        }
        return res[res.length-1][res[0].length-1];
    }
}
