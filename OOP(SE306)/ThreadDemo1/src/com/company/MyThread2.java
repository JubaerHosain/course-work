package com.company;

public class MyThread2 extends Thread {
    @Override
    public void run() {
        int i = 0;
        while(i++ < 100) {
            System.out.println("Thread 2 is running");

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
