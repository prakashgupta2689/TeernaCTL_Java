package morganStanley.strings;

public class CheckPalindrome {

    public static void main(String[] args) {

        String str = "abcbba";

        boolean isPalindrome = checkPalindrome(str);
        System.out.println(isPalindrome);
    }

    private static boolean checkPalindrome(String str) {

        int i = 0;
        while(i < str.length()/2){
            if(str.charAt(i) != str.charAt(str.length()-i-1)){
                return false;
            }
            i++;
        }
        return true;
    }
}
