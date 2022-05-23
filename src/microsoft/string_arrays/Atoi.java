package microsoft.string_arrays;

public class Atoi {

    public static void main(String[] args) {

        String s = "4193 with words";
        int num = myAtoi(s);
        System.out.println("Integer num: "+ num);
    }

    private static int myAtoi(String s) {
        long num = 0;
        int sign = 1;
        int i = 0;

        s = s.trim();

        //empty string
        if(s.equals(""))
            return 0;

        //remove leading spaces
        while(s.charAt(i) == ' ')
            i++;

        //sign value
        if(s.charAt(i) == '+' || s.charAt(i) == '-'){
            sign = (s.charAt(i) == '+' ? 1: -1);
            i++;
        }

        //convert number
        while(i < s.length()){

            if(!Character.isDigit(s.charAt(i)))
                return (int) num * sign;

            if(Character.isDigit(s.charAt(i))){

                num = num * 10 + s.charAt(i) - '0';
                if (sign == 1 && num > Integer.MAX_VALUE)
                    return Integer.MAX_VALUE;
                if (sign == -1 && (-1) * num < Integer.MIN_VALUE)
                    return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) num * sign;
    }
}
