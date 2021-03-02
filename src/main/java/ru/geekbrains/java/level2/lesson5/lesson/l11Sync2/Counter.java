package ru.geekbrains.java.level2.lesson5.lesson.l11Sync2;

public class Counter {
    private int x;
    private int y;
    private Object monitorX = new Object();
    private Object monitorY = new Object();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void incX() {
        synchronized (monitorX) {
            x++;
        };

    }

    public void incY() {
        System.out.println(1);
        synchronized (monitorY) {
            y++;
        }
        System.out.println(2);

    }
}
