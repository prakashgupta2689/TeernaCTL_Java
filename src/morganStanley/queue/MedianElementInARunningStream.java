package morganStanley.queue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianElementInARunningStream {

    public static void main(String[] args) {

        MyMedianPriorityQueue myQueue = new MyMedianPriorityQueue();
        myQueue.add(2);
        myQueue.add(1);
        System.out.println(myQueue.getMedian());
        myQueue.add(3);
        System.out.println(myQueue.getMedian());
        myQueue.add(6);
        myQueue.add(10);
        myQueue.add(4);
        System.out.println(myQueue.getMedian());
    }

}

class MyMedianPriorityQueue{

    PriorityQueue<Integer> maxPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> minPriorityQueue = new PriorityQueue<>();

    public void add(int data){

        //the maxPriorityQueue will contain numbers less than data.
        //the minPriorityQueue will contain numbers greater than data
        if(maxPriorityQueue.isEmpty() || data <= maxPriorityQueue.peek()){
            maxPriorityQueue.add(data);
        }else{
            minPriorityQueue.add(data);
        }

        //if difference between the size of max heap and min heap is more than 1, then move element
        //from max heap to min heap
        if(maxPriorityQueue.size() - minPriorityQueue.size() > 1){
            minPriorityQueue.add(maxPriorityQueue.poll());
        }else if(maxPriorityQueue.size() < minPriorityQueue.size()){
            maxPriorityQueue.add(minPriorityQueue.poll());
        }
    }

    public double getMedian(){

        if(maxPriorityQueue.size() == 0){
            return -1;
        }

        //if the size of max heap and min heap is equal then return the average of the peek of both heaps
        if(maxPriorityQueue.size() == minPriorityQueue.size()){
            return (maxPriorityQueue.peek() + minPriorityQueue.peek())/2.0;
        }
        return maxPriorityQueue.peek();
    }
}
