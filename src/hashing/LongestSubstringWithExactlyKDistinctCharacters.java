package hashing;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithExactlyKDistinctCharacters {
/**
 * 1. You are given a string(str) and a number K.
 * 2. You have to find length of the longest substring that has exactly k unique characters.
 * 3. If no such substring exists, print "-1".
 * */
    public static void main(String[] args) {

        String s1 = "aabcbcdbca";
        int k = 2;
        int result = longestSubstringWithExactlyKDistinctCharacters(s1, k);
        System.out.println(result);
    }

    private static int longestSubstringWithExactlyKDistinctCharacters(String s1, int k) {

        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        int maxLength = 0;

        while(true){
            boolean f1 = false;
            boolean f2 = false;

            int szOfSubstringWithKdistinctCharacters = 0;
            //keep on acquiring until the size of the hashmap is less than or equal to k

            while(i < s1.length() - 1){
                i++;
                map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0)+1);
                System.out.println("while acquiring before checking for size");
                printMap(map);
                if(map.size() > k){
                    if(maxLength < szOfSubstringWithKdistinctCharacters){
                        maxLength = szOfSubstringWithKdistinctCharacters;
                    }
                    break;
                }
                szOfSubstringWithKdistinctCharacters = i - j;
                f1 = true;
            }

            //release until the size becomes valid again
            while(j < i){
                j++;
                if(map.get(s1.charAt(j)) == 1){
                    map.remove(s1.charAt(j));
                }else {
                    map.put(s1.charAt(j), map.get(s1.charAt(j)) - 1);
                }

                System.out.println("after removing the elements from the map");
                printMap(map);

                if(map.size() == k){
                    break;
                }

                f2 = true;
            }

            if(f1 == false && f2 == false){
                break;
            }
        }
        return maxLength;
    }

    private static void printMap(HashMap<Character, Integer> map) {

        System.out.println(map.size());
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
