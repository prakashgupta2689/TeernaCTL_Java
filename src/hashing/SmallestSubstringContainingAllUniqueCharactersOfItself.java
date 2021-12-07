package hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class SmallestSubstringContainingAllUniqueCharactersOfItself {

    /**
     * 1. You are given a string str.
     * 2. You have to find the smallest window length that contains all the unique characters of the given string.
     * */
    public static void main(String[] args) {
        String s1 = "bbacacdcbbcaadcdca";
        int length = smallestSubstringContainingAllUniqueCharactersOfItself(s1);

        System.out.println(length);
    }

    private static int smallestSubstringContainingAllUniqueCharactersOfItself(String s1) {

        //add the elements in the hash set.This will therefore contain only the unique characters of the string
        HashSet<Character> uniqueChs = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        int len = 0;

        for(int k = 0; k < s1.length(); k++){
            uniqueChs.add(s1.charAt(k));
        }

        while(true){

            boolean f1 = false;
            boolean f2 = false;

            //acquire the elements till map.size() < set.size()
            while(i < s1.length()-1 && map.size() < uniqueChs.size()){
                i++;
                char ch = s1.charAt(i);
                map.put(ch, map.getOrDefault(s1.charAt(i), 0)+1);
                f1 = true;
            }

            //collect and release
            while(j < i && map.size() == uniqueChs.size()){
                int potentialAnsLen = i - j;
                if(len == 0 || potentialAnsLen < len){
                    len = potentialAnsLen;
                }
                j++;
                char ch = s1.charAt(j);
                if(map.get(ch) == 1){
                    map.remove(ch);
                }else{
                    map.put(ch, map.get(ch) -1 );
                }
                f2 = true;
            }

            if(f1 == false && f2 == false){
                break;
            }
        }
        return len;
    }
}
