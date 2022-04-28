package stack;

import java.util.Stack;

public class Driver {

    public static void main(String[] args) {

        ThreadSafeStackImpl stack = new ThreadSafeStackImpl(10);

        stack.push(12);
        stack.push(14);

        System.out.println(stack.peek());
        stack.push(16);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        //stack using two queues

        StackUsingTwoQueues stackUsingTwoQueues = new StackUsingTwoQueues();
        StackUsingTwoQueues.push(1);
        StackUsingTwoQueues.push(2);
        StackUsingTwoQueues.push(5);

        System.out.println(StackUsingTwoQueues.pop());
        System.out.println(StackUsingTwoQueues.top());


    }
}
