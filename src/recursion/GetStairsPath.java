package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Number of jumps that can be made: [1,2,3]
 * */
public class GetStairsPath {

    public static void main(String[] args) {
        ArrayList<String> result = getStairsPath(4);
        System.out.println(result);
    }

    private static ArrayList<String> getStairsPath(int stairs) {

        if(stairs == 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(" ");
            return arrayList;
        }else if(stairs < 0){
            return new ArrayList<>();
        }

        ArrayList<String> pathsnm1 = getStairsPath(stairs-1);
        ArrayList<String> pathsnm2 = getStairsPath(stairs-2);
        ArrayList<String> pathsnm3 = getStairsPath(stairs-3);

        ArrayList<String> resultantList = new ArrayList<>();

        System.out.println(pathsnm1);
        System.out.println(pathsnm2);
        System.out.println(pathsnm3);

        //n-1 se jitne bhi paths mile unke saamne 1 laga do toh n se end tak saare paths mil jayenge
        for (String s: pathsnm1){
            resultantList.add("1" + s);
        }

        //n-2 se jitne bhi paths mile unke saamne 2 laga do toh n se end tak saare paths mil jayenge
        for (String s: pathsnm2){
            resultantList.add("2"+s);
        }

        //n-3 se jitne bhi paths mile unke saamne 3 laga do toh n se end tak saare paths mil jayenge
        for (String s: pathsnm3){
            resultantList.add("3"+s);
        }
        return resultantList;
    }
}
