package recursion;

import java.util.ArrayList;
import java.util.List;

public class GetKeypadCombination {

    public static void main(String[] args) {

        String str = "573";
        String[] strArr = new String[]{"abc", "def", "ghi", "jkl","mnop", "qrst","uv","wxyz", ".;", "?!"};
        ArrayList<String> keypadCombinations = getKeypadCombination(str, strArr);
        System.out.println(keypadCombinations);
    }

    /**
     * 5 + 73 combinations
     * 3 -> ghi
     * 73 -> ug, uh, ui, vg, vh, vi
     * 573 -> mug, muh, mui, nug, nuh, nui, oug, ouh, oui,
     * */
    private static ArrayList<String> getKeypadCombination(String str, String[] strArr) {


        //base case
        if(str.length() == 0){
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(" ");
            return arrayList;
        }

        char ch = str.charAt(0); //maine 5 ko nikal liya 573 se
        String remainingSubstring = str.substring(1); //baki bache 73

        //mujhe ye faith hai ki 73 ka keypadCombination mujhe mil jayega
        List<String> keypadCombinationOfRemainingStr = getKeypadCombination(remainingSubstring,strArr);
        ArrayList<String> resultantList = new ArrayList<>();;

        //strArr ki ch wali index ki string length nikal lo. Ab ch Character type ka hai toh usko Integer mein convert karke nikalna hoga
        int length = strArr[ch-'0'].length();

        for (int i = 0; i < length; i++){
            //strArr ki ch wali index ki string nikal lo. Ab ch Character type ka hai toh usko Integer mein convert karke nikalna hoga
            String strAtCh = strArr[ch-'0'];
        for (String s : keypadCombinationOfRemainingStr){
            //73 ke result se 5 ke cartesian karne se apne ko result mil jayega
                resultantList.add(strAtCh.charAt(i)+s);
            }
        }
        return resultantList;
    }
}
