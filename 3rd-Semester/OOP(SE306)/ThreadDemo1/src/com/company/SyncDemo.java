package com.company;

class Count {
    private int count;

    public Count() {
        this.count = 0;
    }

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return this.count;
    }
}

public class SyncDemo {
    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++)
                    count.increment();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 10000; i++)
                    count.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count.getCount());
    }
}






















