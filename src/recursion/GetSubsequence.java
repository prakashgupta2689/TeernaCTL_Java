package recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Subsequence of abc = {}, a, ab, ac, b, bc, c, abc
 * Every character has a choice - to come or to not come
 * */
public class GetSubsequence {

    public static void main(String[] args) {

        String str = "abc";
        ArrayList<String> stringList = getSubsequence(str);
        System.out.println(stringList);
    }

    private static ArrayList<String> getSubsequence(String str) {

       /**
        * agar str khali string hai toh uska ek subsequence banega.. i.e. empty string
        * */
        if(str.length() == 0){
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("");
            return arrayList;
        }

        /**
         * abc ka subsequence nikalne ke liye hume ye faith hai ki bc ka subsequence mil jayega
         * so, a ko alag kar do. Ab humare paas bc ka subsequence hai
         * bc ke subsequence se abc ka subsequence nikalna hai:
         * bc -> [--, -c, b-,bc]
         * abc -> a ko bc ke subsequence mein add karo + a ko bc ke subsequence mein add mat karo
         * i.e. abc -> [---, --c, -b-, -bc, a--, a-c, ab-, abc]
         * */

        char ch = str.charAt(0); // str[0] mil gaya
        String remainingSubstring = str.substring(1); //1 se end tak ka str ka substring

        ArrayList<String > substringOfRemainingStr = getSubsequence(remainingSubstring); //issey mujhe bc ka subsequence mil jayega
        //mujhe a ko add + a ko add nhi karna hai resultant subsequence milne ke liye
        ArrayList<String> resultList = new ArrayList<>();

        for(String s : substringOfRemainingStr){
            //a ko add mat karo
            resultList.add(" "+ s);
            //a ko add kar do
            resultList.add(ch + s);
        }
        System.out.println(resultList);
        return resultList;
    }
}
