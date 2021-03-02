package ru.geekbrains.java.level2.lesson5.lesson.l3;

public class MyApp {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                }
            }
        });
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
