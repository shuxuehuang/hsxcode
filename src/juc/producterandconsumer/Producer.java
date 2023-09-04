package juc.producterandconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{
    private BlockingQueue<PCData> queue;
    private volatile boolean isRunning = true;

    private static final int SLEEPTIME = 1000;
    private static AtomicInteger count = new AtomicInteger();

    public Producer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Random r = new Random();
        try {
            while (isRunning){
                Thread.sleep(r.nextInt(SLEEPTIME));
                int data = count.incrementAndGet();
                PCData pcData = new PCData(data);
                queue.offer(pcData);
            }
        }catch (Exception e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }

    }
    public void stop(){
        isRunning = false;
    }
}
