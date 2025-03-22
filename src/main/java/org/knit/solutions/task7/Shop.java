package org.knit.solutions.task7;

import java.util.LinkedList;
import java.util.Queue;

public class Shop {
    private Queue<Integer> warehouse = new LinkedList<>();
    private final int maxProd = 5;

    public synchronized void produce(int prodNum) {
        try {
            while (warehouse.size() >= maxProd) {
                System.out.println("Производитель ожидает...");
                wait();
            }
            warehouse.add(prodNum);
            System.out.println("Производитель создал товар " + prodNum);
            notify();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void consume() {
        try {
            while (warehouse.isEmpty()) {
                System.out.println("Потребитель ожидает...");
                wait();
            }
            System.out.println("Потребитель забрал товар " + warehouse.poll());
            notify();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
