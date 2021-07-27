package examples;

/**
 * Thread pool, Executor Service
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Example10 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(5); //factory method of class Executors, created 5 threads
        ExecutorService executorService1 = Executors.newSingleThreadExecutor(); //created Thread pool with one thread
        for (int i = 0; i < 10; i++) {
            executorService.execute(new RunnableImpl());
        }
        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("Main ends");
    }
}

class RunnableImpl implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins to work");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " ends to work");
    }
}