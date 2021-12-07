package recursion;

public class PrintSubsequence {

    public static void main(String[] args) {

        String str = "abc";
        printSubsequence(str," ");
    }

    private static void printSubsequence(String ques, String ans) {

        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }

        char ch = ques.charAt(0);
        String remainingQuestion = ques.substring(1);

        printSubsequence(remainingQuestion,ans +" ");
        printSubsequence(remainingQuestion, ans + ch);

    }
}
