package basicCoding;

/**
 * Do you assume only positive numbers?
 * the result should be the string ?
 * what's the range that you need to consider ?
 * what are the roman numerals ?
 * I - 1
 * V - 5
 * X - 10
 * L - 50
 * C - 100
 * D - 500
 * M - 1000
 * */
public class IntegerToRoman {

    public static void main(String[] args) {

        int n = 234;

        System.out.println(convertIntegerToRoman(n));
    }

    private static String convertIntegerToRoman(int n) {

        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "IL", "L", "LX", "LXX", "LXXX", "LC"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thousands = {"", "M", "MM", "MMM"};

        return thousands[(n%10000)/1000]+
                hundreds[(n%1000)/100]+
                tens[(n%100)/10]+
                units[n%10];



    }


}
