package examples;

/**
 * wait and notify methods
 */

public class Example6 {
    public static void main(String[] args) {
        Market market = new Market();
        Producer producer = new Producer(market);
        Customer customer = new Customer(market);
        Thread thread1 = new Thread(producer);
        Thread thread2 = new Thread(customer);
        thread1.start();
        thread2.start();
    }
}

class Market {
    private int productCount = 0;

    public synchronized void getProduct() {
        while (productCount < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        productCount--;
        System.out.println("The customer bought 1 product");
        System.out.println("The amount of product remaining is " + productCount);
        notify();
    }

    public synchronized void addProduct() {
        while (productCount >= 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        productCount++;
        System.out.println("The producer added 1 product");
        System.out.println("The amount of product is " + productCount);
        notify();
    }
}

class Producer implements Runnable {
    Market market;

    public Producer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.addProduct();
        }
    }
}

class Customer implements Runnable {
    Market market;

    public Customer(Market market) {
        this.market = market;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            market.getProduct();
        }
    }
}
