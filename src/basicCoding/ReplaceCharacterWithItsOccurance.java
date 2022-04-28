package basicCoding;

import java.util.Arrays;

/**
 * Input: OPENTEXT
 * Replace T with it's occurrences
 * Output: OPEN1EX2 -> 1 --- T's 1st occurrence, 2 --- T's 2nd occurrence
 * */
public class ReplaceCharacterWithItsOccurance {

    public static void main(String[] args) {

        String str = "Opentext";
        char stringToReplace = 't';

        //first check if the character is present in the string or not
        if(str.indexOf(stringToReplace) == -1){
            System.out.println("given character is not present in the string");
            System.exit(0);
        }

        //logic to replace the character with it's occurrence
        char[] chs = str.toCharArray();
        int count = 1;

        for(int i = 0; i < chs.length; i++){

            if(chs[i] == stringToReplace){
                //chs[i] = String.valueOf(count).charAt(0); //this logic won't work because if the count value is more than 10 is would only print the first character
                str = str.replaceFirst(String.valueOf(stringToReplace), String.valueOf(count)); //replaces the first substring of the string that matches the given
                // regular expression with the given replacement
                count++;
            }
        }
        System.out.println(str);
    }


}
