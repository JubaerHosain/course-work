package producer_consumer;

public class Producer extends Thread{
    private Utility utility;

    public Producer(Utility utility, String name) {
        super(name);
        this.utility = utility;
    }

    @Override
    public void run() {
        int i = 0;
        while(true) {
            try {
                utility.set(++i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
