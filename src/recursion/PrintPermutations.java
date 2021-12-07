package recursion;

public class PrintPermutations {

    public static void main(String[] args) {
        String str = "abc";
        printPermutations(str, " ");
    }

    private static void printPermutations(String ques, String ans) {

        if(ques.length() == 0){
            System.out.println(ans);
        }

        for(int i = 0; i < ques.length(); i++){
            char ch = ques.charAt(i);
            String leftSS = ques.substring(0, i);
            String rightSS = ques.substring(i+1);
            String roq = leftSS + rightSS;

            printPermutations(roq, ans + ch);
        }
    }
}
