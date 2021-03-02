package ru.geekbrains.java.level2.lesson5.lesson.l1;

public class MyApp {
    public static void main(String[] args) {
        MyThread mythread = new MyThread();
        mythread.start();
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
