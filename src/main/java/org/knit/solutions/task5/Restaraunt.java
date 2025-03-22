package org.knit.solutions.task5;

import java.util.LinkedList;
import java.util.Queue;

public class Restaraunt {
    private final int capacity = 3;
    private Queue<Integer> mealsQueue = new LinkedList<>();

    public synchronized void cook(int dishNum) {
        while (mealsQueue.size() >= capacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        mealsQueue.add(dishNum);
        System.out.println("Повар приготовил блюдо " + dishNum);
        notify();
    }

    public synchronized void serve() {
        while (mealsQueue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Официант подал блюдо " + mealsQueue.poll());
        notify();
    }
}
