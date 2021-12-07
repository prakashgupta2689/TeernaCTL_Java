package threads;

//interface T1 extends Thread{
//    public void run(){
//        System.out.println("1");
//        System.out.println("2");
//    }

public class Threads implements Runnable{

    public void run(){
       // System.out.println(obj1.getName());

    }

    public static void main(String[] args) {
        Threads run = new Threads();
        Thread obj1 = new Thread(run);
        Thread obj2 = new Thread(run);
       // obj1.setPriority(1);
        obj1.start();
        obj2.start();
      //  new Thread(Threads);

    }
}
