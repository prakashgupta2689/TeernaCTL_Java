package basicCoding;

/**
 * Possible questions to ask interviewer:
 * do we have to tackle both signed and unsigned integers?
 * Mention in interviews how reversing the integer could possibly exceed the integer's MIN or MAX limit
 * to avoid take the type of your reversed integer as long
 * */
public class ReverseInteger {

    public static void main(String[] args) {

        int n = 54321;

        System.out.println(reversInteger(n));
    }

    private static int reversInteger(int n) {

        long reversed = 0;

        while(n > 0){

            reversed = reversed * 10 + n % 10;
            n = n/10;

            if(reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE)
                return 0;
        }

        return (int) reversed;
    }

}
