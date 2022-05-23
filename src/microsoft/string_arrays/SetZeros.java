package microsoft.string_arrays;

import java.util.ArrayList;
import java.util.List;

public class SetZeros {

    public static void main(String[] args) {

        int[][] arr = new int[][]{
                {0, 1, 2, 0},
                {3, 0, 5, 2},
                {1, 3, 1, 5}
        };

        setZeros(arr);

        //print the modified array
        for(int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    private static void setZeros(int[][] arr) {

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                List<Integer> tempList = new ArrayList<>();
                if(arr[i][j] == 0){
                    tempList.add(i);
                    tempList.add(j);
                    list.add(tempList);
                }
            }
        }

        //print the list
        for(List<Integer> i: list){
            System.out.println(i);
        }

        //set the row and column zero

        for(List<Integer> record: list){

            //set the row as zero -- vary column
            for(int i = 0; i < arr[0].length; i++){
                arr[record.get(0)][i] = 0;
            }

            //set the column as zero -- vary row
            for(int i = 0; i < arr.length; i++){
                arr[i][record.get(1)] = 0;
            }
        }
    }
}
