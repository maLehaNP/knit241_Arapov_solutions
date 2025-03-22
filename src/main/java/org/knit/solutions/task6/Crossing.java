package org.knit.solutions.task6;

public class Crossing {
    private volatile boolean gate = false;

    public synchronized void car(int carNum) {
        try {
            System.out.println("Машина " + carNum + " прибыла.");
            while (gate) wait();
            Thread.sleep(400);
            System.out.println("Машина " + carNum + " проехала переезд.");
            notify();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void train(int trainNum) {
        System.out.println("Поезд № " + trainNum + " прибывает.");
        System.out.println("Шлагбаум закрыт.");
        gate = true;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Шлагбаум открыт.");
        gate = false;
        notifyAll();
    }
}
