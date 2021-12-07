package threads;

import java.util.ArrayList;
import java.util.Random;

public class ProducerConsumer {

    static int MAX_SIZE = 10;
    //2 products
    //n customers can consume either one or both products
    //producer will produce products
    //whenever customers are trying to buy two products at the same time, if both the products are available
    //he/she is allowed to buy the product. Otherwise consumer has to wait until producer produce both products
    public static void main(String[] args) {

        Object lock = new Object();
        ArrayList<Integer> list = new ArrayList<>();
        Random random = new Random();
        //producer
        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock) {
                        if (list.size() >= MAX_SIZE) {
                            try {
                                lock.notify();
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            int addedProduct = random.nextInt(2) + 1;
                            System.out.println(addedProduct);
                            list.add(addedProduct);
                            System.out.println("Producer added: " + addedProduct + " list.size(): " + list.size());
                        }
                    }
                }
            }
        });

        Thread consumerType1 = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock) {
                        if (list.contains(1) || list.contains(2)) {
                            int removedProduct = random.nextInt(2) + 1;
                            list.remove(Integer.valueOf(removedProduct));
                            System.out.println("consumer type 1 removed product: "+ removedProduct+ " from list: list.size(): "+ list.size() );

                        } else {
                            lock.notify();
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        Thread consumerType2 = new Thread(new Runnable() {
            @Override
            public void run() {


                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock) {
                        if (list.contains(1) && list.contains(2)) {
                            list.remove(Integer.valueOf(1));
                            list.remove(Integer.valueOf(2));
                            System.out.println("Consumer Type 2 removed product 1 and product 2 from list: list.size(): "+list.size());

                        } else {
                            lock.notify();
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        producer.start();
        consumerType1.start();
        consumerType2.start();

        try {
            producer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            consumerType1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            consumerType2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
