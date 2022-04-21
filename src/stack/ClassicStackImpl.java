package stack;

public class ClassicStackImpl {

    private int[] array;
    private int capacity;
    private int top;

    public ClassicStackImpl(int capacity) {
        this.array = new int[capacity];
        this.capacity = capacity;
        this.top = -1;
    }

    //push
    public void push(int element){

        if(isFull()){
            throw new RuntimeException("Stack is full");
        }
        //increment the top before pushing the element
        array[++top] = element;
    }

    public int pop(){

        if(isEmpty()){
            throw new RuntimeException("Stack is empty");
        }
        //decrement the top after returning the element
        return array[top--];
    }

    public int peek(){

        return array[top];
    }

    public boolean isFull(){

        return top == capacity - 1;
    }

    public boolean isEmpty(){

        return top == -1;
    }
}
