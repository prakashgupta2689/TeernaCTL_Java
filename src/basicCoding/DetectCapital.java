package basicCoding;

/**
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 *
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Given a string word, return true if the usage of capitals in it is right.
 * */
public class DetectCapital {

    public static void main(String[] args) {

        //AAAA - valid
        //Aaaaa - valid
        //aaaaa - valid
        //AaaAaa - invalid
        //aaA - invalid

        //1. count the number of upper case letters
            //if the number of upper case letter is 0 then return true
            //if the number of upper case letter is length of the string, return true
            //if the number of upper case letter is 1, the first letter should be upper case
            //if the number of upper case letter is more than 1 then return false
            // drawback to this approach is we are not quitting as soon as we can. We are always traversing the full string

        //2. case 1: all capitals - AAAAAA - 1st letter is upper case and 2nd letter is upper case then check for the entire string should be upper case
             // case 2: all small - aaaa
            //case 3: first capital - Aaaa
        //we can simplify case 2 and case 3 by checking for all small from the 2nd letter onwards. It actually doesn't matter if the first letter is capital or small

    }

}
