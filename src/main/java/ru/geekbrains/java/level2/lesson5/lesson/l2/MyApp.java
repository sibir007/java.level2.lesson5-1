package ru.geekbrains.java.level2.lesson5.lesson.l2;

public class MyApp {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable());
        t.start();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
