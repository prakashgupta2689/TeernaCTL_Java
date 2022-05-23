package microsoft.string_arrays;

public class ReverseWordsInAStringII {

    public static void main(String[] args) {

        char[] str = new char[]{'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};

        reverseWords(str);
    }

    private static void reverseWords(char[] str) {

        //reverse the whole word
        rev(str, 0, str.length-1);

        //print
        for(int i = 0; i < str.length; i++){
            System.out.print(str[i] + " ");
        }
        System.out.println();

        int start = 0;
        //int end = str.length - 1;
        //reverse each word
        for(int i = 0; i < str.length; i++){
            if(str[i] == ' '){
                rev(str, start, i-1);
                start = i + 1;
            }
        }

        //reverse the last word
        rev(str, start, str.length-1);

        //print
        for(int i = 0; i < str.length; i++){
            System.out.print(str[i] + " ");
        }
        System.out.println();
    }

    private static void rev(char[] str, int start, int end) {

        while(start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
