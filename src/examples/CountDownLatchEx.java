package examples;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchEx {
    static CountDownLatch countDownLatch = new CountDownLatch(3);

    private static void comeAtWork() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Staff came at work");
        countDownLatch.countDown();
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }

    private static void prepareWorkPlace() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println("Everything is ready");
        countDownLatch.countDown();
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }

    private static void openMarket() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Marked is opened");
        countDownLatch.countDown();
        System.out.println("countDownLatch = " + countDownLatch.getCount());
    }

    public static void main(String[] args) throws InterruptedException {
        new Friend("Rose", countDownLatch);
        new Friend("Michael", countDownLatch);
        new Friend("Meredith", countDownLatch);
        new Friend("Nicola", countDownLatch);
        new Friend("Yohann", countDownLatch);

        comeAtWork();
        prepareWorkPlace();
        openMarket();
    }
}

class Friend extends Thread {
    String name;
    private CountDownLatch countDownLatch;

    public Friend(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
        this.start();
    }

    public void run() {
        try {
            countDownLatch.await();
            System.out.println(name + " is shopping");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
