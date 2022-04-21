package stack;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeStackImpl {

    private int[] array;
    private int capacity;
    private int top;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();

    public ThreadSafeStackImpl(int capacity){

        this.capacity = capacity;
        this.array = new int[capacity];
        this.top = -1;
    }

    public void push(int element){

        //acquire the lock
        lock.writeLock().lock();

        //perform the push operation
        try{

            if(isFull())
                throw new RuntimeException("Stack is full");

            array[++top] = element;
        }finally {

            //release the lock
            lock.writeLock().unlock();
        }
    }

    public int pop(){

        //acquire the lock
        lock.writeLock().lock();

        try{

            if(isEmpty())
                throw new RuntimeException("Stack is empty");

            return array[top--];
        }finally {

            //release the lock
            lock.writeLock().unlock();
        }
    }

    public int peek(){

        lock.writeLock().lock();

        try{

            if(isEmpty())
                throw new RuntimeException("Stack is empty");
            return array[top];
        }finally {
            lock.writeLock().unlock();
        }
    }

    public boolean isFull(){

     return top == capacity-1;
    }

    public boolean isEmpty(){

        return top == -1;
    }
}
