package examples;

/***
 * Data race. Synchronized methods
 */

public class Example4 {
    volatile static int counter = 0;

    public static synchronized void increment() { //here we use the monitor of class Example4 because the method is static otherwise we use the monitor of Object
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyTread3());
        Thread thread2 = new Thread(new MyTread3());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(counter);
    }
}

class MyTread3 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Example4.increment();
        }
    }
}
