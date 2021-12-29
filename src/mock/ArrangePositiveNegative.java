package mock;

import java.util.ArrayList;

public class ArrangePositiveNegative {

    public static void main(String[] args) {

        int[] arr = new int[]{-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};

        //code
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        //fill the respective arraylists
        for(int i  = 0; i < arr.length; i++){

            if(arr[i] >= 0) {
                pos.add(arr[i]);
            }
            else {
                neg.add(arr[i]);
            }
        }

        //merge the two arraylists
        int[] res = new int[arr.length];
        int index = 0;

        while(!pos.isEmpty() && !neg.isEmpty()){

            res[index] = pos.remove(0);
            index++;
            res[index] = neg.remove(0);
            index++;
        }

        while(!pos.isEmpty()){
            res[index] = pos.remove(0);
            index++;
        }

        while(!neg.isEmpty()){
            res[index] = neg.remove(0);
            index++;
        }

        //print the elements
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
    }
}
