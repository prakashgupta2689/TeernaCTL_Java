package hashing;

import java.util.HashMap;

public class CountSubstringWithoutRepeatingCharacters {
/**
 * 1. You are given a string.
 * 2. You have to find the count of valid substrings of the given string.
 * 3. Valid substring is defined as a substring that has all unique characters.
 * */
    public static void main(String[] args) {

     String s1 = "aabcbcdbca";
     int result = countSubstringWithoutRepeatingCharacters(s1);
        System.out.println(result);
    }

    private static int countSubstringWithoutRepeatingCharacters(String s1) {

        int ans = 0;
        int i = -1;
        int j = -1;

        HashMap<Character, Integer> map = new HashMap<>();

        while(true){
            boolean f1 = false;
            boolean f2 = false;

            while(i < s1.length() - 1){
                i++;
                char ch = s1. charAt(i);
                map.put(ch, map.getOrDefault(ch, 0)+1);

                if(map.get(ch) == 2){
                    break;
                }else{
                    ans+= i - j;
                }
                f1 = true;
            }

            //release
            while(j < i){
                j++;
                char ch = s1.charAt(j);
                map.put(ch, map.get(ch) - 1);

                if(map.get(ch) == 1){
                    ans+= i - j;
                    break;
             }
                f2 = true;
            }

            if(f1 == false && f2 == false){
                break;
            }
        }
        return ans;
    }
}
