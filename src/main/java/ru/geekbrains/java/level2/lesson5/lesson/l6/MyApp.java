package ru.geekbrains.java.level2.lesson5.lesson.l6;

public class MyApp {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
            }
        });
        t1.start();
        t2.start();
    }
}
