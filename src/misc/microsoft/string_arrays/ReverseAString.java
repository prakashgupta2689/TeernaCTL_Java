package misc.microsoft.string_arrays;

public class ReverseAString {

    public static void main(String[] args) {

        char[] ch = new char[]{'h','e','l', 'l', 'o'};

        reverse(ch);

        //print string
        for(int i = 0; i < ch.length; i++){
            System.out.print(ch[i] + " ");
        }
    }

    private static void reverse(char[] s) {


        int first = 0;
        int last = s.length - 1;

        while(first < last){

            char temp = s[first];
            s[first] = s[last];
            s[last] = temp;

            first++;
            last--;
        }
    }
}
