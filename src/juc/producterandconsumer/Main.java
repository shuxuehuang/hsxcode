package juc.producterandconsumer;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<PCData> linkedBlockingDeque = new LinkedBlockingDeque<>();
        Producer producer1 = new Producer(linkedBlockingDeque);
        Producer producer2 = new Producer(linkedBlockingDeque);
        Consumer consumer1 = new Consumer(linkedBlockingDeque);
        Consumer consumer2 = new Consumer(linkedBlockingDeque);

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(producer1);
        service.execute(producer2);
        service.execute(consumer1);
        service.execute(consumer2);
        Thread.sleep(1000);
        producer1.stop();
        producer2.stop();
        Thread.sleep(1000);
        service.shutdown();
        System.out.println("程序结束");

    }
}
