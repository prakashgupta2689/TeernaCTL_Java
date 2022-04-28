package basicCoding;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        String roman = "CCXXXIV";
        int result = 0;

        for (int i = 0; i < roman.length() - 1; i++){

            if(map.get(roman.charAt(i)) < map.get(roman.charAt(i+1)))
                result = result - map.get(roman.charAt(i));

            result = result + map.get(roman.charAt(i));
        }

        System.out.println(result + map.get(roman.charAt(roman.length() - 1)));
    }
}
