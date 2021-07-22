package examples;

/***
 * Methods sleep, join. Thread states
 */

public class Example2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new MyThread2());
        Thread thread2 = new Thread(new Example2());

        System.out.println(thread1.getState());

        thread1.start();
        thread2.start();

        System.out.println(thread1.getState());

        thread1.join();
        thread2.join();

        System.out.println(thread1.getState());

        System.out.println("The end");
    }
}

class MyThread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}
