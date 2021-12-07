package hashing;

import java.util.PriorityQueue;

public class FindKLargestElementInArrayUsingPriorityQueue {

    public static void main(String[] args) {

        int[] arr = new int[]{2,10,5,17,7,18,6,4,15};
        //find the 3 largest element
        int k = 3;

        findKLargestElements(arr, k);
    }

    private static void findKLargestElements(int[] arr, int k) {

        /**we store first k elements in the priority queue. queue.peek() gives the lowest number as
         * the elements in the queue are stored in ascending order by default. If queue.peek() is less
         * than the current iterating number then remove the peek element and add the new element.
         * Idea is the weakest elements get eliminated and at a time only the k strongest elements
         * remain in the queue.
         */

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = 0; i < k ; i++){
            queue.add(arr[i]);
        }

        for(int i = k; i < arr.length; i++){
            if(queue.size() > 0) {
                if (queue.peek() < arr[i]) {
                    queue.remove();
                    queue.add(arr[i]);
                }
            }
        }

        while (queue.size() > 0){
            System.out.println(queue.peek());
            queue.remove();
        }
    }
}
