package threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Write the java program to open the file "numbers.txt" to check all the numbers are
 * exactly divisible by 7 or not using Thread-1. If that number is exactly divisible by 7,
 * check that number is armstrong number or not using Thread-2.
 * */
public class FileHandlingWithThreads {

    public static void main(String[] args) {

        //read numbers from numbers.txt --> misc.C:\Users\teern\Documents\GCP
        File file = new File("misc.C:\\Users\\teern\\Documents\\GCP\\numbers.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Integer> nums = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        Object lock = new Object();
        final boolean[] endOfFile = {false};

        while (sc.hasNextLine()) {
            nums.add(sc.nextInt());
        }

//        for(Integer num: nums){
//            System.out.println(num);
//        }

        Thread checkDivisible = new Thread(new Runnable() {
            @Override
            public void run() {
                    for (Integer num : nums) {
                        if (num % 7 == 0) {
                            synchronized (lock) {
                                q.add(num);
                                System.out.println("in thread 1: q.size: "+ q.size());
                                lock.notify();
                        }
                    }
                    endOfFile[0] = true;
                }
            }
        });

        Thread checkArmstrong = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (lock) {
                        System.out.println("in thread 2: q.size: "+ q.size());
                        if (q.isEmpty() && !endOfFile[0]) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            //check armstrong
                            if (!q.isEmpty()) {
                                int num = q.remove();
                                boolean isArmstrong = checkArmstrong(num);
                                if (isArmstrong) {
                                    System.out.println(num + " is an armstrong number which is divisible by 7");
                                }else{
                                    System.out.println(num + " is not an armstrong number which is divisible by 7");
                                }
                            }
                        }
                    }
                    if(endOfFile[0] && q.isEmpty())
                        break;
                }
            }
        });


        checkArmstrong.start();
        checkDivisible.start();

        try {
            checkDivisible.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            checkArmstrong.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkArmstrong(Integer x) {
        // Calling order function
        int n = order(x);
        int temp=x, sum=0;
        while (temp!=0)
        {
            int r = temp%10;
            sum = sum + power(r,n);
            temp = temp/10;
        }

        // If satisfies Armstrong condition
        return (sum == x);
    }

    private static int power(int x, int y) {
        if( y == 0)
            return 1;
        if (y%2 == 0)
            return power(x, y/2)*power(x, y/2);
        return x*power(x, y/2)*power(x, y/2);
    }

    private static int order(Integer x) {
        int n = 0;
        while (x != 0)
        {
            n++;
            x = x/10;
        }
        return n;
    }
}
