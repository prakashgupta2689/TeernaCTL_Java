package threads;


import java.util.Scanner;

class Sum implements Runnable{

    private int n;
    private int ch;

    public Sum(int n, int ch) {
        this.n = n;
        this.ch = ch;
    }

    @Override
    public void run() {
        if(ch == 0){
            System.out.println("Sum of Even nos");
        }else if (ch == 1){
            System.out.println("Sum of Odd nos");
        }else if(ch == 2){
            System.out.println("Sum of n nos");
        }
    }
}
public class ActivityWithThreads {

    public static void main(String[] args){

//        Sum sum = new Sum(5, 0);
//        Thread t1 = new Thread(sum);
//        t1.start();
//
//        Sum sum1 = new Sum(6, 1);
//        Thread t2 = new Thread(sum1);
//        t2.start();
//
//        Sum sum2 = new Sum(3, 2);
//        Thread t3 = new Thread(sum2);
//        t3.start();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

//        try {
//            t1.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            t2.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            t3.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        Thread evenThread =  new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Even sum");
            }
        });

        Thread oddThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Odd sum");
            }
        });

        Thread sumThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Sum of: "+ n);
            }
        });

        evenThread.start();
        oddThread.start();
        sumThread.start();

//        try {
//            evenThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            oddThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        try {
//            sumThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        System.out.println("End of main");
    }
}
