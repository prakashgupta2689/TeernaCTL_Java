package hashing;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     *1. You are given a string.
     *2. You have to find the length of the longest substring of the given string that contains all non-repeating characters.
     * */
    public static void main(String[] args) {

        String s1 = "abbacbcdbadbdbbdcb";
        longestSubstringWithoutRepeatingCharacters(s1);
    }

    private static void longestSubstringWithoutRepeatingCharacters(String s1) {

        HashMap<Character,Integer> freqs = new HashMap<>();
        int i = -1;
        int j = -1;
        int maxLength = 0;
        String ans = "";

        while(true){

            boolean f1 = false;
            boolean f2 = false;

            int count = 0;
            //acquire till it becomes invalid that is if any character has frequency more than 1
            while(i < s1.length()-1){
                i++;
                freqs.put(s1.charAt(i), freqs.getOrDefault(s1.charAt(i), 0)+1);
                if(freqs.get(s1.charAt(i)) > 1){
                    if(count > maxLength)
                        maxLength = count;
                    break;
                }

                    count = i - j;
                    f1 = true;
                }
            //release until it becomes invalid i.e. if j becomes greater than i or count of a character becomes zero

            while(j < i){
                j++;
                String pans = s1.substring(j, i);

                System.out.println("pans: "+pans);
                if(ans.length() == 0 || ans.length() < pans.length()){
                    ans = pans;
                }

                System.out.println("ans: "+ans);
                freqs.put(s1.charAt(j), freqs.get(s1.charAt(j))-1);
                if(freqs.get(s1.charAt(j)) == 1)
                    break;
                f2 = true;
            }

            if(f1 == false && f2 == false){
                break;
            }
        }
        System.out.println(ans);
        System.out.println(maxLength);
    }
}
