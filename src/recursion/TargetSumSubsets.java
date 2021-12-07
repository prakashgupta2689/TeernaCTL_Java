package recursion;

public class TargetSumSubsets {

    public static void main(String[] args) {

        int[] arr = new int[]{10,20,30,50,40};
        targetSumSubsets(arr, " ", 60, 0, 0);
    }

    //sos -> sum of subset
    private static void targetSumSubsets(int[] ques, String ans, int target, int index, int sos) {

        if(index >= ques.length){
            if(sos == target){
                System.out.println(ans);
            }
            return;
        }
        //choose the element
        targetSumSubsets(ques, ans + ques[index] + ", ", target, index+1, sos + ques[index]);
        // don't choose the element
        targetSumSubsets(ques, ans, target, index+1, sos);

    }
}
