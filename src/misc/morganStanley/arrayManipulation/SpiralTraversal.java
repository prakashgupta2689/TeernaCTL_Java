package misc.morganStanley.arrayManipulation;

public class SpiralTraversal {

    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {11,12,13, 14},
                {21, 22, 23, 24},
                {31, 32, 33, 34},
                {41, 42, 43, 44}
        };

        spiralTraversal(arr);
    }

    private static void spiralTraversal(int[][] arr) {

        int minc = 0;
        int minr = 0;
        int maxc = arr[0].length - 1;
        int maxr = arr.length - 1;

        int nel = (maxc+1) * (maxr+1);
        int count = 0;

        while (count < nel) {
            //print the row keeping column constant
            //left wall
            for (int i = minr, j = minc; i <= maxr; i++) {
                System.out.print(arr[i][j] + " ");
                count++;
            }

            minc++;

            //print the bottom row keeping row constant and column variable
            //bottom wall
            for (int i = maxr, j = minc; j <= maxc; j++) {
                System.out.print(arr[i][j] + " ");
                count++;
            }
            maxr--;

            //print the right column keeping column constant
            //right wall
            for (int i = maxr, j = maxc; i >= minr; i--) {
                System.out.print(arr[i][j] + " ");
                count++;
            }
            maxc--;

            //print the top row keeping row constant
            //top wall
            for (int i = minr, j = maxc; j >= minc; j--) {
                System.out.print(arr[i][j] + " ");
                count++;
            }
            minr++;
        }
    }
}
