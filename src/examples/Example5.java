package examples;

/**
 * using one monitor for several methods
 */

public class Example5 {
        static final Object lock = new Object();

        public void mobileCall(){
            synchronized (lock) {
                System.out.println("Mobile call starts");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Mobile call ends");
            }
        }

        public  void skypeCall(){
            synchronized (lock) {
                System.out.println("Skype call starts");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Skype call ends");
            }
        }

        public  void whatsAppCall(){
            synchronized (lock) {
                System.out.println("WhatsApp call starts");
                try {
                    Thread.sleep(7000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("WhatsApp call ends");
            }
        }

        public static void main(String[] args) {
            Thread thread1 = new Thread(new MobileCall());
            Thread thread2 = new Thread(new SkypeCall());
            Thread thread3 = new Thread(new WhatsAppCall());

            thread1.start();
            thread2.start();
            thread3.start();
        }
    }

    class MobileCall implements Runnable{
        @Override
        public void run() {
            new Example5().mobileCall();
        }
    }

    class SkypeCall implements Runnable{
        @Override
        public void run() {
            new Example5().skypeCall();
        }
    }

    class WhatsAppCall implements Runnable{
        @Override
        public void run() {
            new Example5().whatsAppCall();
        }
    }

