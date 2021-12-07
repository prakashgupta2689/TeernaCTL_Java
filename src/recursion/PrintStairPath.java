package recursion;

public class PrintStairPath {

    public static void main(String[] args) {

        int stairs = 3;
         printStairPath(stairs, " ");
    }

    private static void printStairPath(int ques, String ans) {

        if(ques == 0){
            System.out.println(ans);
        }else if(ques <0){
            return;
        }

        printStairPath(ques-1,ans+"1");
        printStairPath(ques-2, ans+ "2");
        printStairPath(ques-3,ans+"3");
    }
}
