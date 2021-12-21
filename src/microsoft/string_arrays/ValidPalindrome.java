package microsoft.string_arrays;

/**
* A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
* Given a string s, return true if it is a palindrome, or false otherwise.
* Input: s = "A man, a plan, a canal: Panama"
* Output: true
* Explanation: "amanaplanacanalpanama" is a palindrome.
**/

public class ValidPalindrome {

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";
        boolean isPalindrome = checkPalindrome(s);
        System.out.println("isPalindrome: "+ isPalindrome);
    }

    private static boolean checkPalindrome(String s) {

        int first = 0;
        int last = s.length()-1;

        if(s.equals(""))
            return true;

        while(first <= last){

            if(!Character.isLetterOrDigit(s.charAt(first)))
                first++;
            else if(!Character.isLetterOrDigit(s.charAt(last)))
                last--;
            else if(Character.isLetterOrDigit(s.charAt(last)) && Character.isLetterOrDigit(s.charAt(first)) && Character.toLowerCase(s.charAt(first)) == Character.toLowerCase(s.charAt(last))){
                first++;
                last--;
            }else if(Character.isLetterOrDigit(s.charAt(last)) && Character.isLetterOrDigit(s.charAt(first)) && Character.toLowerCase(s.charAt(first)) != Character.toLowerCase(s.charAt(last))){
                return false;
            }

        }
        return true;
    }
}
