package hashing;

import java.util.PriorityQueue;

public class SortAKSortedArray {

    /**
     * In a k-sorted array, every element can move up to k positions away from its sorted position in both left and right directions
     * 1. Since, the array is K sorted, we use a priority queue to store the first k+1 elements
     * 2. Now, remove the smallest element from the priority queue and add it to the sorted list
     * 3. Slide the queue and add one more element from the array to the queue and make it's size k+1
     * 4. Repeat steps 3 and 4 till the length of the array
     * */
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,3,5,4,6,8,7,9};
        int k = 2;

        int[] sortedArr = sortKSortedArray(arr, 2);
        for(int element: sortedArr){
            System.out.print(element + " ");
        }


    }

    private static int[] sortKSortedArray(int[] arr, int k) {

        int[] sortedArr = new int[arr.length];
        int j = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i <= k; i++){
            pq.add(arr[i]);
        }

        for(int i = k+1; i < arr.length; i++){
            sortedArr[j] = pq.remove();
            pq.add(arr[i]);
            j++;
        }
        while(pq.size() > 0){
            sortedArr[j] = pq.remove();
            j++;
        }
        return sortedArr;
    }
}
