package threads;

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
public class PrintingNumbersInSequence {

    static int limit = 10;
    static int number = 0;
    static final Object lock = new Object();

    public static void main(String[] args) {



        Thread even = new Thread(new Runnable() {
            @Override
            public void run() {

                    while (number < limit) {
                        synchronized (lock) {
                            while (number % 2 == 1) {

                                try {
                                    lock.wait();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                            System.out.println(Thread.currentThread().getName() + " " + number++);
                            lock.notify();
                    }
                }
            }
        });

        Thread odd = new Thread(new Runnable() {
            @Override
            public void run() {

                while(number < limit){

                    synchronized (lock){

                        while (number % 2 == 0){

                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        System.out.println(Thread.currentThread().getName() + " " + number++);
                        lock.notify();
                    }
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


}
