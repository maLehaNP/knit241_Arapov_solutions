package org.knit.solutions.task8;

public class Crossroads {
    private volatile String traffecLightColor = "green";

    public synchronized void trafficLight() {
        try {
            System.out.println("Красный.");
            traffecLightColor = "red";
            Thread.sleep(2000);
            System.out.println("Зеленый.");
            traffecLightColor = "green";
            notifyAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void car(int carNum) {
        try {
            System.out.println("Машина " + carNum + " прибыла.");
            while (traffecLightColor.equals("red")) {
                wait();
            }
            Thread.sleep(200);
            System.out.println("Машина " + carNum + " проехала.");
            notify();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
