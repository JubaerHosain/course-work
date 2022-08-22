package com.company;

public class Main {


    public static void main(String[] args) {
        // extending thread class
//	    MyThread1 t1 = new MyThread1();
//        MyThread2 t2 = new MyThread2();
//
//        t1.start();
//        t2.start();

        ImplementRunnable1 bullet1 = new ImplementRunnable1();
        Thread gun1 = new Thread(bullet1);

        ImplementRunnable2 bullet2 = new ImplementRunnable2();
        Thread gun2 = new Thread(bullet2);


        gun1.start();
        gun2.start();

        System.out.println("Gun2 id: " + gun2.getId());
        System.out.println("Gun1 id: " + gun1.getId());
    }
}
