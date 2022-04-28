package misc.morganStanley.arrayManipulation;

public class RotateArrayByKPositions {

    public static void main(String[] args) {

        int[] arr = new int[]{9, 8, 7, 6, 4, 2, 1, 3};
        int k = 2;

        int[] res = rotateArrayClockwise(arr, k);

        //print
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }

    private static int[] rotateArrayClockwise(int[] arr, int k) {

        int len = arr.length;
        int[] res = new int[len];
        k = k % len;

        for(int i = 0; i < arr.length; i++){

            res[(i + k)%len] = arr[i];
        }
        return res;
    }
}
