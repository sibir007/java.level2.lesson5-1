package ru.geekbrains.java.level2.lesson5.task;

import java.util.Arrays;

public class TwoMethods {
    private static final int SIZE = 10_000_000;
    private static final int HALF = SIZE / 2;

    /**
     * последовательный
     */
    private static void method1() {
        float[] arr = new float[SIZE];
        fillOne(arr);
        long a = System.currentTimeMillis();
        fillNewValue(arr);
        System.out.println("Последовательный метод: " + (System.currentTimeMillis() - a) + "ms");
    }

    /**
     * паралельный
     */
    private static void method2() {
        float[] arr = new float[SIZE];
        float[] a1 = new float[HALF];
        float[] a2 = new float[HALF];
        fillOne(arr);
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, a1, 0, HALF);
        System.arraycopy(arr, 0, a2, 0, HALF);
        Thread t1 = new Thread(() -> fillNewValue(a1));
        Thread t2 = new Thread(() -> fillNewValue(a2));
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(a1,0, arr, 0, HALF);
        System.arraycopy(a1,0, arr, HALF - 1, HALF);
        System.out.println("Параллельный метод: " + (System.currentTimeMillis() - a) + "ms");
    }

    /**
     * заполнение массива 1
     */
    private static void fillOne(float[] arr) {
        Arrays.fill(arr, 1f);
    }
    /**
     * заполняет массив новыми значениями
     */
    private static void fillNewValue(float[] arr){
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] *
                    Math.sin(0.2f + i / 5) *
                    Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i /2));
        }
    }

    public static void main(String[] args) {
        new Thread(() -> method1()).start();
        new Thread(() -> method2()).start();

    }
}
