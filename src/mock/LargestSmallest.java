package mock;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given an array arr[] and an integer K where K is smaller than size of array,
 * the task is to find the Kth smallest element in the given array.
 * It is given that all array elements are distinct.
 * */
public class LargestSmallest {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 5, 10, 4, 6};

        //smallest
        int min = Integer.MAX_VALUE;
        int k = 2;
       // Arrays.sort(arr); // nlogn
       // System.out.println(arr[k-1]);//1

        //max priority queue -- hold k largest elements

        Queue<Integer> q = new PriorityQueue<>();

        for(int i  = 0; i < k; i++){
            q.add(arr[i]);
        }

        for(int i = k; i < arr.length; i++){

            if(!q.isEmpty()) {
                if (q.peek() < arr[i]) {
                    q.remove();
                    q.add(arr[i]);
                }
            }else{
                break;
            }
        }

        System.out.println(q.peek());
    }
}
