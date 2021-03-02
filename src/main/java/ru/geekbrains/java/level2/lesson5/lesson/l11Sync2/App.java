package ru.geekbrains.java.level2.lesson5.lesson.l11Sync2;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread incThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incX();
            }
        });

        Thread decThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.incY();
            }
        });

        incThread.start();
        decThread.start();

        incThread.join();
        decThread.join();

        System.out.println(counter.getX());
        System.out.println(counter.getY());

    }
}
