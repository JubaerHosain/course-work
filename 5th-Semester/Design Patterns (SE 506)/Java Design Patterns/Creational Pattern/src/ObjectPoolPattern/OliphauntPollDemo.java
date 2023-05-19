package ObjectPoolPattern;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;


// Here's the basic Oliphaunt class. These giants are very expensive to create.
class Oliphaunt {

    private static final AtomicInteger counter = new AtomicInteger(0);

    private final int id;

    public Oliphaunt() {
        id = counter.incrementAndGet();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Oliphaunt id=%d", id);
    }
}

// Next we present the ObjectPool and more specifically OliphauntPool.
abstract class ObjectPool<T> {

    private final Set<T> available = new HashSet<>();
    private final Set<T> inUse = new HashSet<>();

    protected abstract T create();

    public synchronized T checkOut() {
        if (available.isEmpty()) {
            available.add(create());
        }
        T instance = available.iterator().next();
        available.remove(instance);
        inUse.add(instance);
        return instance;
    }

    public synchronized void checkIn(T instance) {
        inUse.remove(instance);
        available.add(instance);
    }

    @Override
    public synchronized String toString() {
        return String.format("Pool available=%d inUse=%d", available.size(), inUse.size());
    }
}

class OliphauntPool extends ObjectPool<Oliphaunt> {

    @Override
    protected Oliphaunt create() {
        return new Oliphaunt();
    }
}

public class OliphauntPollDemo {
    public static void main(String[] args) {
        OliphauntPool pool = new OliphauntPool();
        Oliphaunt oliphaunt1 = pool.checkOut();
        Oliphaunt oliphaunt2 = pool.checkOut();
        Oliphaunt oliphaunt3 = pool.checkOut();

        System.out.println(pool);

        pool.checkIn(oliphaunt1);
        pool.checkIn(oliphaunt2);

        System.out.println(pool);

        Oliphaunt oliphaunt4 = pool.checkOut();
        Oliphaunt oliphaunt5 = pool.checkOut();

        System.out.println(pool);
    }
}
