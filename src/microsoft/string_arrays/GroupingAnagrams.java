package microsoft.string_arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupingAnagrams {

    public static void main(String[] args) {

        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> strList = groupAnagrams(strs);

        System.out.println(strList);
    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        Map<Map<Character, Integer>, List<String>> res = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            HashMap<Character, Integer> chFreq = new HashMap<>();

            for(int j = 0; j < str.length(); j++){
                chFreq.put(str.charAt(j), chFreq.getOrDefault(str.charAt(j), 0)+1);
            }

            if(res.containsKey(chFreq)){
                res.get(chFreq).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                res.put(chFreq, list);
            }
        }

        //print the hashmap
        for(Map<Character, Integer> entry: res.keySet()){
            System.out.println(entry + " " + res.get(entry));
        }

        return new ArrayList<>(res.values());
    }
}
