package hashing;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    /**
     * 1. You are given two strings s1 and s2 containing lowercase english alphabets.
     * 2. You have to find the smallest substring of s1 that contains all the characters of s2.
     * 3. If no such substring exists, print blank string("").
     * */
    public static void main(String[] args) {
        String s1 = "dbaecbbabdcaafbddcabgba";
        String s2 = "abbcdc";

        String ans = minimumWindowSubstring(s1, s2);
        System.out.println(ans);
    }

    private static String minimumWindowSubstring(String s1, String s2) {
        //store the frequency of each character of s2 in a map
        HashMap<Character, Integer> map2 = new HashMap<>();
        HashMap<Character, Integer> map1 = new HashMap<>();
        int match2 = 0;
        int match1 = 0;
        int index1 = 0;
        int index2 = 0;
        String ans = "";

        for(int i = 0; i < s2.length(); i++){
            map2.put(s2.charAt(i), map2.getOrDefault(s2.charAt(i), 0)+1);
        }

        for(Character ch : map2.keySet()){
            match2+= map2.get(ch);
        }
        System.out.println(match2);
        printMap(map2);

            while(true){

                boolean f1 = false;
                boolean f2 = false;

                //acquire: keep on adding elements of s1 in map1 and increment the match count. When the match
                //count becomes equal to the match count of map2 stop acquiring

                while(match1 != match2 && index1 < s1.length()){
                    if(map2.containsKey(s1.charAt(index1))){
                        map1.put(s1.charAt(index1), map1.getOrDefault(s1.charAt(index1), 0)+1);
                        if(map1.get(s1.charAt(index1)) <= map2.get(s1.charAt(index1))){
                            match1++;
                        }
                    }
                  //  ans += s1.charAt(index1);
                    index1++;
                    f1 = true;
                }

//                index1--;

                System.out.println("index1: "+ index1);
              //  System.out.println("ans after acquire: "+ans);

                //match1 == match2, store the result of the acquired string,
                // release chars and update the frequency map.
                // Keep on releasing until you release the char which makes match1 < match2
                while(match1 == match2 && index2 < index1){

                    String pans = s1.substring(index2, index1);
                    System.out.println("pans: "+ pans);
                    if(ans.length() == 0 || ans.length() > pans.length()){
                        ans = pans;
                    }
                    System.out.println("ans after each pans, ans comparison: "+ans);

                    if(map1.containsKey(s1.charAt(index2))){
                        if(map1.get(s1.charAt(index2)) == 1){
                            map1.remove(s1.charAt(index2));
                            match1--;
                        }else {
                            map1.put(s1.charAt(index2), map1.get(s1.charAt(index2)) - 1);
                            if(map1.get(s1.charAt(index2)) < map2.get(s1.charAt(index2))){
                                match1--;
                            }
                        }
                    }
                    System.out.println("match1: "+match1);
                    index2++;
                    System.out.println("index2 after + 1: "+ index2);
                    f2 = true;
                }

                if(f1 == false && f2 == false){
                    break;
                }
            }
            return ans;
    }

    public static void printMap(Map<Character, Integer> map){
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
