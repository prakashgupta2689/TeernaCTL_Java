package basicCoding;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberOfOccurancesOfStringInAString {

    public static void main(String[] args) {

        String str = "I do not like cats but I like dogs";
        String strToMatch = "like";

        int count = 0;

        Matcher matcher = Pattern.compile(strToMatch).matcher(str);

        while(matcher.find()){
            count++;
        }
        System.out.println(count);
        //str.equals("Teerna");


    }
}
