package hashing;

import java.util.HashMap;

public class CountSubstringWithKDistinctCharacters {

    /**
     * 1. You are given a string(str) and a number K.
     * 2. You have to find the count of valid substrings of the given string.
     * 3. Valid substring is defined as a substring that has exactly K unique characters
     * */
    public static void main(String[] args) {

        String str = "abcabdabbcfa";
        int k = 3;
        int result = countSubstringsWithKDistinctCharacters(str, k);
        System.out.println(result);
    }

    private static int countSubstringsWithKDistinctCharacters(String str, int k) {

        //take two hashmaps. mapb stores k characters and maps stores k-1 characters
        int ans = 0;
        HashMap<Character, Integer> mapb = new HashMap<>();
        HashMap<Character, Integer> maps = new HashMap<>();
        int ib = -1;
        int is = -1;
        int j = -1;

        while (true){

            boolean f1 = false;
            boolean f2 = false;
            boolean f3 = false;

            //pehle mapb ib se acquire karega and apne andar k characters rakhega
            while(ib < str.length() - 1){
                ib++;
                mapb.put(str.charAt(ib), mapb.getOrDefault(str.charAt(ib), 0) + 1);

                if(mapb.size() == k+1){
                    //aakhri character jo size ko badha rha hai usko mapb se hata do
                    removeInMap(mapb, str.charAt(ib));
                    ib--;
                    break;
                }
                f1 = true;
            }

            //maps ko acquire karenge
            while(is < ib){
                is++;
                maps.put(str.charAt(is), maps.getOrDefault(str.charAt(is), 0) + 1);
                //maps mein k-1 characters honge
                if(maps.size() == k){
                    //aakhri character jo size ko badha rha hai usko maps se hata do
                    removeInMap(maps, str.charAt(is));
                    is--;
                    break;
                }
                f2 = true;
            }

            //ab maps and mapb dono ko release karenge jab tak map valid hai
            while(j < is){

                if(mapb.size() == k && maps.size() == (k-1)){
                    ans+= ib-is;
                }
                j++;
                char ch = str.charAt(j);
                removeInMap(maps, ch);
                removeInMap(mapb,ch);

                if(maps.size() < k-1 || mapb.size() < k){
                    break;
                }
                f3 = true;
            }

            if(f1 == false && f2 == false && f3 == false){
                break;
            }
        }

        return ans;
    }

    private static void removeInMap(HashMap<Character, Integer> map, char ch) {

        if(map.get(ch) == 1){
            map.remove(ch);
        }else{
            map.put(ch, map.get(ch) - 1);
        }
    }
}
