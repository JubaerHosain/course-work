package producer_consumer1;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread{
    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int count = 0;
        while(true) {
            try {
                if(queue.size() >= 4) {
                    System.out.println("Queue is full.");
                    // Thread.sleep(1000);
                }
                queue.put(++count);
                System.out.println("Producer created cake: " + count);
                // Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
