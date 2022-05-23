package morganStanley.arrayManipulation;

public class RotateBy90Degrees {

    /**
     * rotate a 2d array by 90 degree in clockwise direction
     * Ex:  misc.A[][]   a b c d  -----> m i e a
     *              e f g h         n j f b
     *              i j k l         o k g c
     *              m n o p         p l h d
     *
     *      approach: take transpose of misc.A[][]-> misc.A' = a e i m ---> reverse the each column to get rotate by 90
     *                                               b f j n
     *                                               c g k o
     *                                               d h l p
     *
     *       https://www.youtube.com/watch?v=SoxrXQbhCPI
     * */
    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {11,12,13, 14},
                {21, 22, 23, 24},
                {31, 32, 33, 34},
                {41, 42, 43, 44}
        };

        rotateBy90Degrees(arr);

        //displaying the rotated array
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    private static void rotateBy90Degrees(int[][] arr) {
        //create transpose of the array

        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr[0].length; j++){
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        //reverse the columns
        for(int i = 0; i < arr.length; i++){
            int li = 0;
            int ri = arr[i].length - 1;

            while(li < ri){
                int temp = arr[i][li];
                arr[i][li] = arr[i][ri];
                arr[i][ri] = temp;

                li++;
                ri--;
            }
        }
    }
}
