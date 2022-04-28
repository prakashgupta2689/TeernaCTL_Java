package misc.morganStanley.stacks;

import java.util.Stack;

public class QueueUsingStacks {

    public static void main(String[] args) {

        MyQueue myqueue = new MyQueue();
        myqueue.add(2);
        myqueue.add(3);
        myqueue.add(5);
        myqueue.add(1);

        System.out.println(myqueue.top());
        myqueue.pop();
        System.out.println(myqueue.top());

        myqueue.pop();
        myqueue.pop();
        System.out.println(myqueue.top());

        myqueue.pop();
        System.out.println(myqueue.top());

    }


}

class MyQueue{

    Stack<Integer> inputStack = new Stack<>();
    Stack<Integer> outputStack = new Stack<>();

    public void add(int data) {
        inputStack.add(data);
    }

    public int top() {

        if(inputStack.empty() && outputStack.empty()){
            return -1;
        }
        if(outputStack.empty()){
            //transfer input stack to output stack
            while(!inputStack.empty()){
                outputStack.add(inputStack.pop());
            }
        }
        return outputStack.peek();
    }

    public void pop() {

        if(inputStack.empty() && outputStack.empty()){
            System.out.println(-1);
            return;
        }
        if(outputStack.empty()){
            //transfer input stack to output stack
            while(!inputStack.empty()){
                outputStack.add(inputStack.pop());
            }
        }
        outputStack.pop();

    }
}
