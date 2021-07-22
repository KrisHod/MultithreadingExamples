package examples;

/***
 * Methods name, priority
 */

public class Example1 {
    public static void main(String[] args) {
       MyThread myThread = new MyThread();
       myThread.setName("The first thread");
       myThread.setPriority(Thread.NORM_PRIORITY);
       myThread.start();
        System.out.println("The priority is " + myThread.getPriority());
    }

}

class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("The name of thread is " + Thread.currentThread().getName());
    }
}
