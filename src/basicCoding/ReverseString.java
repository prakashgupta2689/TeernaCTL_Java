package basicCoding;

/**
 * ask the interviewer if string builder reverse api is fine or not.
 * else use the traditional approach
 * */
public class ReverseString {

    public static void main(String[] args) {

        String str = "I love India!";
        System.out.println(reverseStringUsingApis(str));

        System.out.println(reverseManually(str));

        //not an efficient approach as each time a new string object will be created. This creates a lot of unused strings.
        System.out.println(reverseWithoutStringBuilder(str));
    }

    private static String reverseWithoutStringBuilder(String str) {

        String reversedStr = "";
        for (int i = 0; i < str.length(); i++){

            reversedStr = str.charAt(i) + reversedStr;
        }
        return reversedStr;
    }


    private static String reverseManually(String str) {

        //create a string builder instance to hold the reversed string

        StringBuilder sb = new StringBuilder();

        for(int i = str.length()-1; i >= 0; i--){

            sb.append(str.charAt(i));


        }
        return sb.toString();
    }

    private static String reverseStringUsingApis(String str) {

        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();

    }


}
