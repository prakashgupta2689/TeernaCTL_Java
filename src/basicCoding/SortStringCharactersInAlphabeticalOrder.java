package basicCoding;


import java.util.Arrays;

/**
 * 1. using sort method
 * 2. without using sort method
 * */
public class SortStringCharactersInAlphabeticalOrder {

    public static void main(String[] args) {

        String str = "rock";

        //without using sort method
        char[] arr = str.toCharArray();

        char temp;
        for(int i = 0; i < arr.length; i++){
            for(int j = i+1; j < arr.length; j++){
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

            }
        }

        //with sort method
        char[] ch = str.toCharArray();
        Arrays.sort(ch);
        System.out.println(new String(ch));
    }
}
