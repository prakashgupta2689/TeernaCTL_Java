package recursion;

public class PrintMazePaths {

    public static void main(String[] args) {
        int dr = 3;
        int dc = 3;

        printMazePaths(1,1,dr, dc, " ");
    }

    private static void printMazePaths(int sr, int sc, int dr, int dc, String ans) {

        if(sc == dc && sr == dr){
            System.out.println(ans);
        }
        if(sc < dc){
            printMazePaths(sr, sc+1, dr, dc, ans+"h");
        }
        if(sr < dr){
            printMazePaths(sr+1, sc, dr, dc, ans+"v");
        }
    }
}
