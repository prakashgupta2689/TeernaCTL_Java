package threads;

public class NumbersGenerator {

    int number = 1;
    int numberOfThreads;
    int totalNumbersInSequence;

    public NumbersGenerator(int number, int numberOfThreads, int totalNumbersInSequence) {
        this.number = number;
        this.numberOfThreads = numberOfThreads;
        this.totalNumbersInSequence = totalNumbersInSequence;
    }

    public void printNumbers(int result){
        synchronized (this){
            while(number < totalNumbersInSequence -1){

                while(number % numberOfThreads != result){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName() + " " + number++);
                notifyAll();
            }
        }
    }
}
