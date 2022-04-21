package misc;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ThreadExample {

    public static void main(String[] args) {


        Object lock = new Object();

        Thread even = new Thread(new Runnable() {
            @Override
            public void run() {


                synchronized (lock) {
                    for (int i = 0; i < 10; i += 2) {
                        System.out.println(i);
                        lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread odd = new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (lock) {
                    for (int i = 1; i < 10; i += 2) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println(i);
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

        List<Product> productList = new ArrayList<>();
        Product p1 = new Product("Red", 30, "A");
        Product p2 = new Product("Blue", 200, "B");
        Product p3 = new Product("Blue", 200, "A");

        productList.add(p1);
        productList.add(p2);

        List<String> list = productList.stream()
                .filter(product -> product.getBrand().equals("A"))
                .filter(product -> product.getPrice() >= 20 && product.getPrice() <= 50)
                .map(Product::getColour)
                .collect(Collectors.toList());

        System.out.println(list);
    }


}
