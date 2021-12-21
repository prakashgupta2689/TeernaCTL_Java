package threads;

public class ManufactureAndSell {

    public static void main(String[] args) {

        int[] itemCount = new int[1];
        int limit = 10;
        Object lock = new Object();

        Thread producer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock) {
                        if (itemCount[0] == limit) {
                            try {
                                lock.notify();

                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            itemCount[0]++;
                            System.out.println("in producer: new itemCount: "+ itemCount[0]);
                        }
                    }
                }
            }
        });

        Thread consumer = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    synchronized (lock){
                        if(itemCount[0] == 0){
                            lock.notify();
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }else{
                            itemCount[0]--;
                            System.out.println("In consumer: new itemCount: "+ itemCount[0]);
                        }
                    }
                }

            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            consumer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
