package producer_consumer;

public class Consumer extends Thread{
    private Utility utility;

    public Consumer(Utility utility, String name) {
        super(name);
        this.utility = utility;
    }

    @Override
    public void run() {
        while(true) {
            try {
                utility.get();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
