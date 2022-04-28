package basicCoding;

/**
 * using java 8
 * using loop and indexOf
 * using character array
 * using set interface methods
 * */
public class RemoveDuplicateCharacterInString {

    public static void main(String[] args) {

        String str = "I love India!";
        StringBuilder sb = new StringBuilder();
        str.chars()
                .distinct()
                .forEach(s -> sb.append(s));

        //using index of -> indexOf is used to search the position of first occurance of string from the ith position
        StringBuilder sb2 = new StringBuilder();
        for(int i = 0; i < str.length(); i++){

            char ch = str.charAt(i);
            int firstOccuranceOfCh = str.indexOf(ch, i+1);

            if(firstOccuranceOfCh == -1){
                //not repeated
                sb2.append(ch);
            }
        }
    }
}
