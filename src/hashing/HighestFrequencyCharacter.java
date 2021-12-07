package hashing;

import java.util.HashMap;
import java.util.Set;

public class HighestFrequencyCharacter {

    public static void main(String[] args) {

        String str = "HeyThere!";
        highestFrequencyCharacter(str);
    }

    private static void highestFrequencyCharacter(String str) {

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            if(map.containsKey(str.charAt(i))){
                int freq = map.get(str.charAt(i)) + 1;
                map.put(str.charAt(i),freq);
            }else{
                map.put(str.charAt(i),1);
            }
        }

        int maxFreq = 0;
        char maxCh = ' ';
        Set<Character> characterSet = map.keySet();
        for(Character ch: characterSet){
            if(map.get(ch) > maxFreq){
                maxFreq = map.get(ch);
                maxCh = ch;
            }
        }
        System.out.println(maxCh);
    }
}
