package recursion;

public class PrintKeypadCombination {

    public static void main(String[] args) {

        String str = "462";
        String[] strArr = new String[]{"abc", "def", "ghi", "jkl","mnop", "qrst","uv","wxyz", ".;", "?!"};
        printKeypadCombination(str, strArr, " ");
    }

    private static void printKeypadCombination(String ques, String[] codeArr, String ans) {
        if(ques.length() == 0){
            System.out.print(ans + " ");
            return;
        }

        char ch = ques.charAt(0);
        String roq = ques.substring(1);

        for (int i = 0; i < codeArr[ch-'0'].length(); i++) {
            printKeypadCombination(roq, codeArr, ans + codeArr[ch - '0'].charAt(i));
        }
    }
}

