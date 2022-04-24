package producer_consumer;

public class ProducerConsumer {
    public static void main(String[] args) {
        Utility utility = new Utility();

        Producer producer = new Producer(utility, "Producer");
        Consumer consumer = new Consumer(utility, "Consumer");

        producer.start();
        consumer.start();


    }
}
