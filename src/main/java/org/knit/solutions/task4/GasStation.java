package org.knit.solutions.task4;

import java.util.concurrent.Semaphore;

public class GasStation {
    final Semaphore semaphore;

    public GasStation(int count) {
        this.semaphore = new Semaphore(count);
    }

    public void Refuel(String carName) {
        try {
            System.out.println(carName + " ждет заправки");
            semaphore.acquire();
            Thread.sleep(2000);
            System.out.println(carName + " заправился");
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
    }
}
