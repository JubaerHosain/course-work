package producer_consumer;

public class Utility {
    private int value;
    boolean flag = false;

    public synchronized void set(int val) throws InterruptedException {
        while(flag) {
            wait();
        }
        this.value = val;
        this.flag = true;
        System.out.println("Producer set: " + val);
        notify();
    }

    public synchronized void get() throws InterruptedException {
        while(!flag) {
            wait();
        }
        this.flag = false;
        System.out.println("Consumer get: " + this.value);
        notify();
    }
}
