package threads;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
public class PrintSequenceUsingMultipleThreads {

    private static final int TOTAL_NUMBER_OF_THREADS = 10;
    private static final int LIMIT = 100;
    private static int number = 0;
    private static int modCount = 0;

    static final Object lock = new Object();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(TOTAL_NUMBER_OF_THREADS);

        NumbersGenerator numbersGenerator = new NumbersGenerator(1, 3, 20);

//        executorService.submit(new SequenceGeneratorTask(numbersGenerator, 1));
//        executorService.submit(new SequenceGeneratorTask(numbersGenerator, 2));
//        executorService.submit(new SequenceGeneratorTask(numbersGenerator, 0));

        for (int i = 0; i < 10; i++){

            executorService.submit(new SequenceGeneratorTask(numbersGenerator, i));
        }
    }



}
