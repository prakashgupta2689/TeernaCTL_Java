package hashing;

import java.util.Collections;
import java.util.PriorityQueue;

public class IntroductionToPriorityQueue {

    public static void main(String[] args) {

        //this will store the elements in descending order. By default the order is ascending order
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int[] arr = new int[]{22,99,3,34,1,5};

        //storing the elements in priority queue. O(nlogn)
        for(int element: arr){
            priorityQueue.add(element); // O(logn)
        }

        //retrieving the elements in descending order
        while(priorityQueue.size() > 0){
            System.out.println(priorityQueue.peek());
            priorityQueue.remove();
        }
    }
}
