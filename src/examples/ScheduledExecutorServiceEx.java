package examples;

/**
 * ScheduledExecutorService
 */

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceEx {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
//        scheduledExecutorService.schedule(new RunnableImpl(), 3, TimeUnit.SECONDS);

//        scheduledExecutorService.scheduleAtFixedRate(new RunnableImpl(), 3, 1, TimeUnit.SECONDS); //delay between starts of tasks

        scheduledExecutorService.scheduleWithFixedDelay(new RunnableImpl(), 3, 1, TimeUnit.SECONDS); // delay between end of the previous task and start of the next task
        Thread.sleep(20000);
        scheduledExecutorService.shutdown();
    }
}
