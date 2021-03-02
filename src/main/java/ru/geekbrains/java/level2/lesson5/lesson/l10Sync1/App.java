package ru.geekbrains.java.level2.lesson5.lesson.l10Sync1;

public class App {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread incThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.inc();
            }
        });

        Thread decThread = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.dec();
            }
        });

        incThread.start();
        decThread.start();

        incThread.join();
        decThread.join();

        System.out.println(counter.getX());

    }
}
