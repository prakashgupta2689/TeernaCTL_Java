package queue;

public class ClassicQueueImpl {

    private int front;
    private int rear;
    private int capacity;
    private int size;
    private int[] array;

    public ClassicQueueImpl(int capacity){

        this.capacity = capacity;
        this.front = 0;
        this.rear = capacity - 1;
        this.size = 0;
        this.array = new int[capacity];
    }

    public void enqueue(int element){

        if(isFull(this))
            throw new RuntimeException("Queue is full");

        //just like with top in stack, increment rear and insert element
        rear = (rear+1)%capacity;
        array[rear] = element;
        size++;

    }

    public int dequeue(){

        if(isEmpty(this))
            throw new RuntimeException("Queue is empty");

        //just like with top in stack, take out the element in front and then increment front.
        int element = array[front];
        front = (front+1)%capacity;
        size--;

        return element;
    }

    public boolean isFull(ClassicQueueImpl queue){

        return queue.size == queue.capacity;
    }

    public boolean isEmpty(ClassicQueueImpl queue){

        return queue.size == 0;
    }
}
