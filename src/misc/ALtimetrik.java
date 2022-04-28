package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ALtimetrik {

    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>(List.of(1, 2, 14, 15, 4));

        integerList.stream()
                .filter(p -> p.toString().startsWith("1"))
                .forEach(p -> System.out.println(p));

        String s1 = "SILENT";
        String s2 = "LISTEN";

        System.out.println(checkAnagrams(s1, s2));
    }

    private static boolean checkAnagrams(String s1, String s2) {

        if(s1.length() != s2.length())
            return false;

        Map<Character, Integer> fmap1 = new HashMap<>();
        Map<Character, Integer> fmap2 = new HashMap<>();

        for(int i = 0; i < s1.length(); i++){

            fmap1.put(s1.charAt(i), fmap1.getOrDefault(s1.charAt(i), 1)+1);
            fmap2.put(s2.charAt(i), fmap2.getOrDefault(s2.charAt(i), 1)+1);

        }

        return fmap1.equals(fmap2);

    }
}
