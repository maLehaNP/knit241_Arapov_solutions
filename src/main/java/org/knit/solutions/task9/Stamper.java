package org.knit.solutions.task9;

import java.util.concurrent.BlockingQueue;

public class Stamper implements Runnable {
    private final BlockingQueue<Detail> stampingQueue;
    private int lastDetailId = 1;
    private final int maxDetails;

    public Stamper(BlockingQueue<Detail> stampingQueue, int maxDetails) {
        this.stampingQueue = stampingQueue;
        this.maxDetails = maxDetails;
    }

    @Override
    public void run() {
        try {
            while (lastDetailId <= maxDetails) {
                stampingQueue.add(new Detail(lastDetailId));
                System.out.printf("Штамповщик: Заготовка %d создана%n", lastDetailId);
                Thread.sleep(1000);
                lastDetailId++;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
