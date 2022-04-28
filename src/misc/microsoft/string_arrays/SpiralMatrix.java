package misc.microsoft.string_arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        List<Integer> result = spiralTraversal(arr);
        System.out.println(result);
    }

    private static List<Integer> spiralTraversal(int[][] arr) {

        List<Integer> result = new ArrayList<>();

        int rows = arr.length;
        int rowbmax = arr.length - 1;
        int rowbmin = 0;

        int cols = arr[0].length;
        int colbmax = arr[0].length - 1;
        int colbmin = 0;

        int numOfElements = (rows) * (cols);


        int count = 0;

        while(count < numOfElements){

            //print the top boundary
            for(int i = rowbmin, j = colbmin; j <= colbmax && result.size() < numOfElements; j++){
                System.out.print(arr[i][j] + " ");
                result.add(arr[i][j]);
                count++;
            }
            rowbmin++;

            //print the right boundary
            for(int i = rowbmin, j = colbmax; i <= rowbmax && result.size() < numOfElements; i++){
                System.out.print(arr[i][j] + " ");
                result.add(arr[i][j]);
                count++;
            }
            colbmax--;

            //print the bottom boundary
            for(int i = rowbmax, j = colbmax; j >= colbmin && result.size() < numOfElements; j--){
                System.out.print(arr[i][j] + " ");
                result.add(arr[i][j]);
                count++;
            }
            rowbmax--;
            //print the left boundary
            for(int i = rowbmax, j = colbmin; i >= rowbmin && result.size() < numOfElements; i--){
                System.out.print(arr[i][j] + " ");
                result.add(arr[i][j]);
                count++;
            }
            colbmin++;
        }
        return result;
    }
}
