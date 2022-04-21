package threads;

import java.util.concurrent.Semaphore;

/**
 * Thread 1:    Thread 2:   Thread 3:
 * 1            2           3
 * 4            5           6
 * 7            8           9
 * 10
 *
 * 10%(num of threads) -> thread 1 elements would always give remainder 1
 * 10%(num of threads) -> thread 2 elements would always give remainder 2
 * 10%(num of threads) -> thread 3 elements would always give remainder 0
 * */
public class PrintingNumbersInSequenceWithSem {

    static Semaphore odd = new Semaphore(0);
    static Semaphore even = new Semaphore(1);

    public static void main(String[] args) {

        Thread even = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < 10; i+= 2){

                    printEven(i);
                }
            }
        });

        Thread odd = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i = 1; i < 10; i+= 2){

                    printOdd(i);
                }
            }
        });

        even.start();
        odd.start();

        try {
            even.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            odd.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printOdd(int num) {

        try {
            odd.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " " + num);
        even.release();
    }

    private static void printEven(int num) {

        try {
            even.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " " + num);
        odd.release();
    }
}
