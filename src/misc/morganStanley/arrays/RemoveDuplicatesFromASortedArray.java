package misc.morganStanley.arrays;

public class RemoveDuplicatesFromASortedArray {

    public static void main(String[] args) {

        int[] arr = new int[]{1,1,2,2,2,2,3,4,4,5};
        int index = removeDuplicates(arr);

        //printing the array without duplicates
        for(int i = 0; i <= index; i++){
            System.out.print(arr[i] + " ");
        }
    }

    private static int removeDuplicates(int[] arr) {

        int i = 0;
        int j = 1;

        while(j < arr.length){
            if(arr[i] != arr[j]){
                i++;
                swap(arr, i, j);
            }
            j++;
        }
        return i;
    }

    private static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
