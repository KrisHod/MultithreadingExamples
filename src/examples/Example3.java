package examples;

/***
 * volatile
 */
public class Example3 extends Thread{
    volatile boolean b = true;

    @Override
    public void run() {
        long counter = 0;
        while (b){
            counter++;
        }
        System.out.println("Loop is finished. Counter = " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        Example3 thread = new Example3();
        thread.start();
        Thread.sleep(3000);
        System.out.println("After 3 seconds it's time to wake up!!!");
        thread.b = false;
        thread.join();
        System.out.println("End of program");
    }
}
