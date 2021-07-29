package examples;

/**
 * Callable and Future interfaces
 */

import java.util.concurrent.*;

public class Example12 {
    static int factorialResult;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Factorial factorial = new Factorial(5);
        Future<Integer> future = executorService.submit(factorial);
        try {
            System.out.println(future.isDone());
            factorialResult = future.get(); // get() blocks main thread util task(factorial) will be executed, so we don't need awaitTermination()
            System.out.println(future.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            System.out.println(e.getCause());
        } finally {
            executorService.shutdown();
        }

        System.out.println(factorialResult);
    }
}

class Factorial implements Callable<Integer> { //Unlike Runnable Callable can throw Exception and return value
    int f;

    public Factorial(int f) {
        this.f = f;
    }

    @Override
    public Integer call() throws Exception {
        if (f <= 0) {
            throw new Exception("Wrong number");
        }
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result *= i;
        }
        return result;
    }
}
