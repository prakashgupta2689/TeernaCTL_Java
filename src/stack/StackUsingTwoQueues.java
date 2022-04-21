package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {

    private static Queue<Integer> q1 = new LinkedList<>();
    private static Queue<Integer> q2 = new LinkedList<>();

    static int currSize;

    public StackUsingTwoQueues(){
        currSize = 0;
    }

    static void push(int element){

        currSize++;

        //add the element to q2
        q2.add(element);

        //move all elements of q1 to q2
        while(!q1.isEmpty()){

            q2.add(q1.peek());
            q1.remove();
        }

        //swap the names of q2 and q1
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    static int pop(){

        if(q1.isEmpty())
            throw new RuntimeException("Stack is empty");

        int element = q1.remove();
        currSize--;

        return element;
    }

    static int top(){

        if(q1.isEmpty())
            throw new RuntimeException("Stack is empty");

        return q1.peek();
    }

    static int size(){

        return currSize;
    }

}
