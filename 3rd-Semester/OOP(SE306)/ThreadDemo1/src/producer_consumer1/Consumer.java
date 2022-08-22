package producer_consumer1;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread{
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                if(queue.size() == 0) {
                    System.out.println("Queue is empty.");
                    // Thread.sleep(1000);
                }
                System.out.println("Consumer consumed cake: " + queue.take());
                // Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
