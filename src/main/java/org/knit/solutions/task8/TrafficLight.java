package org.knit.solutions.task8;

public class TrafficLight implements Runnable {
    private final Crossroads crossroads;
    private final int lightTimesChanged;

    public TrafficLight(Crossroads crossroads, int lightTimesChanged) {
        this.crossroads = crossroads;
        this.lightTimesChanged = lightTimesChanged;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= lightTimesChanged; i++) {
                crossroads.trafficLight();
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
