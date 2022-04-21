package threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPoolExecutor {

    private final BlockingQueue<Runnable> workerQueue;
    private final Thread[] workerThreads;

    public CustomThreadPoolExecutor(int numThreads){

        //creates n number of threads
        workerQueue = new LinkedBlockingQueue<>();
        workerThreads = new Thread[numThreads];
        int i = 0;
        for(Thread thread: workerThreads){
            thread = new Worker("Custom Pool Thread: "+ ++i);
            thread.start();
        }

    }

    //adds the task in the queue
    public void addTask(Runnable r){
        try {
            workerQueue.put(r);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    class Worker extends Thread{

        public Worker(String name){
            super(name);
        }

        //when thread.start() is called this run method executes
        public void run(){
            while (true){
                try {
                    workerQueue.take().run();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        CustomThreadPoolExecutor customThreadPoolExecutor = new CustomThreadPoolExecutor(10);
        customThreadPoolExecutor.addTask(() -> System.out.println("First Task"));
        customThreadPoolExecutor.addTask(() -> System.out.println("Second Task"));
    }
}
