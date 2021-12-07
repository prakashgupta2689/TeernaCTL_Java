package hashing;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPriorityQueueImpl {
/**
 * 1.   You are required to complete the code of our MedianPriorityQueue class.
 * 1.1  The class should mimic the behaviour of a PriorityQueue and give highest priority to median of it's data.
 * 2.   Here is the list of functions that you are supposed to complete
 * 2.1. add -> Should accept new data.
 * 2.2. remove -> Should remove and return median value, if available or print "Underflow" otherwise and return -1
 * 2.3. peek -> Should return median value, if available or print "Underflow" otherwise and return -1
 * 2.4. size -> Should return the number of elements available
 * 3.   Input and Output is managed for you.
 *
 * Note -> If there are even number of elements in the MedianPriorityQueue, consider the smaller median as median value.
 * */
    public static void main(String[] args) {
        MedianPriorityQueue mpq = new MedianPriorityQueue();
        mpq.add(5);
        mpq.add(10);
        mpq.add(50);
        mpq.add(20);
        mpq.add(35);
        System.out.println(mpq.peek());

    }
}

class MedianPriorityQueue {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    MedianPriorityQueue(){
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void add(int val){

        //first insert element in the left queue
        //if the difference in size of left and right is more than 2 insert element in the right queue

        if(right.size() > 0 && val > right.peek()){
            right.add(val);
        }else {
            left.add(val);
        }
        if(left.size() - right.size() >= 2){
            right.add(left.remove());
        }
        if(right.size() - left.size() >= 2){
            left.add(right.remove());
        }
    }

    public int peek(){
        if(this.size() == 0){
            System.out.println("Underflow");
            return -1;
        }
        if(left.size() >= right.size()){
            return left.peek();
        }else {
            return right.peek();
        }
    }

    public int remove(){
        if(this.size() == 0){
            System.out.println("Underflow");
            return -1;
        }
        if(left.size() >= right.size()){
            return left.remove();
        }else {
            return right.remove();
        }
    }

    public int size(){
        return left.size() + right.size();
    }
}
