package ru.geekbrains.java.level2.lesson5.lesson.l10Sync1;

public class Counter {
    private int x;

    public int getX() {
        return x;
    }

    public synchronized void inc() {
        x++;
    }

    public synchronized void dec() {
        x--;
    }
}
