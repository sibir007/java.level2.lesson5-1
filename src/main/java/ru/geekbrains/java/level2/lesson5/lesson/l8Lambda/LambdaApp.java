package ru.geekbrains.java.level2.lesson5.lesson.l8Lambda;

public class LambdaApp {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println(2);
        });

        Thread t3 = new Thread(() -> System.out.println(3));

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(4);
            }
        });

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }



}
