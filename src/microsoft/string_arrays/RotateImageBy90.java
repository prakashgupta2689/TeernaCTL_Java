package microsoft.string_arrays;

public class RotateImageBy90 {

    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        rotate(arr);

        //print
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    private static void rotate(int[][] arr) {

        //transpose
        for(int i = 0; i < arr.length; i++){
            for (int j = i; j < arr[0].length; j++){

                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;

            }
        }

        //swap the cols
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
