package misc.microsoft.string_arrays;


/**
 * Given an input string s, reverse the order of the words.
 *
 * misc.A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *
 * Return a string of the words in reverse order concatenated by a single space.
 *
 * Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 *Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * */
public class ReverseWordsInAString {

    //using stringBuilder and trim
    //work: do it without using string builder
    public static void main(String[] args) {

        String s = "the sky is blue";
        String reversedStr = reverseWords(s);
        System.out.println("reversed string: "+ reversedStr);
    }

    private static String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        int last = words.length;

        for(int i = 0; i < last; i++){

            if(!words[i].isEmpty()){
                sb.insert(0, words[i]);
                sb.insert(0, " ");
            }
        }

        return sb.toString().trim();
    }
}
