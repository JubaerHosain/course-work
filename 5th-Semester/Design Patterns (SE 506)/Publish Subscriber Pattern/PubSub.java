import java.util.ArrayList;
import java.util.List;

// Interface for the Subscriber
interface Subscriber {
    void receiveMessage(String message);
}

// Publisher (Subject) class
class Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void publishMessage(String message) {
        for (Subscriber subscriber : subscribers) {
            subscriber.receiveMessage(message);
        }
    }
}

// Subscriber implementation
class MessageSubscriber implements Subscriber {
    private String name;

    public MessageSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void receiveMessage(String message) {
        System.out.println(name + " received message: " + message);
    }
}

public class PubSubExample {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();

        // Create subscribers
        Subscriber subscriber1 = new MessageSubscriber("Subscriber 1");
        Subscriber subscriber2 = new MessageSubscriber("Subscriber 2");

        // Subscribe subscribers to the publisher
        publisher.subscribe(subscriber1);
        publisher.subscribe(subscriber2);

        // Publish a message
        publisher.publishMessage("Hello, Pub/Sub pattern in Java!");

        // Unsubscribe a subscriber
        publisher.unsubscribe(subscriber2);

        // Publish another message, only subscriber1 should receive it
        publisher.publishMessage("This message will be received by Subscriber 1 only.");
    }
}

