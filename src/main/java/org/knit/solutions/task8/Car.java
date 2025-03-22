package org.knit.solutions.task8;

public class Car implements Runnable {
    private final Crossroads crossroads;
    private final int carCount;

    public Car(Crossroads crossroads, int carCount) {
        this.crossroads = crossroads;
        this.carCount = carCount;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= carCount; i++) {
                crossroads.car(i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
