package juc.producterandconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private BlockingQueue<PCData> queue;
    private static final int SLEEPTIME = 1000;
    public Consumer(BlockingQueue<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            System.out.println("start consumer id=" + Thread.currentThread().getId());
            Random r = new Random();

            while (true){
                PCData pcData = queue.poll();
                if (pcData != null){
                    int data = pcData.getIntData();
                    System.out.println(data + "的平方为：" + data * data);
                    Thread.sleep(r.nextInt(SLEEPTIME));
                }

            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
