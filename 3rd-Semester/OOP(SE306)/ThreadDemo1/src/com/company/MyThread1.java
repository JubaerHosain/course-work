package com.company;

public class MyThread1 extends Thread {
    @Override
    public void run() {
        int i = 0;
        while(i++ < 100) {
            System.out.println("Thread 1 is running");

            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
